package generics;

import static org.hamcrest.Matchers.lessThan;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import apiConfig.EnvVariables;
import io.restassured.response.Response;

public class ApiUtils {

    private static final Logger logger = LoggerFactory.getLogger(ApiUtils.class);

    /* Reusable code for extracting particular given string value from response */
    public static String extractFromResponse(Response response, String req) {
        String responseBody = response.getBody().asString();
        logger.info("Response Body: " + responseBody);
        System.out.println("Response Body: " + response.getBody().asString());
        return responseBody;
    }

    public static void setAuth(Response response) {
        // Check if status code is 200 OK
        if (response.getStatusCode() == 200) {
            String token = extractFromResponse(response, "token");
            if (token != null) {
                EnvVariables.token = token;
                logger.info("Token extracted: " + token);
            } else {
                logger.error("Token is missing in the response.");
            }
        } else {
            logger.error("Login failed with status code: " + response.getStatusCode());
        }
    }

    /*==============================Code for validations============================================ */

    // Verify status code and responseTime altogether
    public void validateStatusCode_responseTime(Response response, int expectedStatusCode) {
        logger.info("Actual status code : "+response.getStatusCode());
        response.then().assertThat().statusCode(expectedStatusCode).and()
                .time(lessThan(700L), TimeUnit.MILLISECONDS);

    }
    // Verify status code
    public void validateStatusCode(Response response, int status_Code) {
        int statusCode = response.getStatusCode();
        logger.info("Actual Status Code: " + statusCode);
        Assert.assertEquals(response.getStatusCode(), status_Code);

    }

    public void extractRes(Response response) {
        String res = response.getBody().asString();
        logger.info("Response body : "+res);
    }

    // Verify status message
    public void validateStatusMessage(Response response, String status_Message) {
        int statusCode = response.getStatusCode();
        String statusText = getHttpStatusText(statusCode);
        logger.info("Actual Status Code: " + statusCode);
        logger.info("Mapped Status Text: " + statusText);
        Assert.assertEquals(statusText, status_Message);

    }

    private String getHttpStatusText(int statusCode) {
        switch (statusCode) {
            case 200:return "OK";
            case 201:return "Created";
            case 204:return "No Content";
            case 400:return "Bad Request";
            case 401:return "Unauthorized";
            case 403:return "Forbidden";
            case 404:return "Not Found";
            case 405:return "Method Not Allowed";
            case 500:return "Internal Server Error";
            default:return "Unknown Status";
        }
    }
}
