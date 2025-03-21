package generics;

import static org.hamcrest.Matchers.lessThan;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import apiConfig.EnvVariables;
import io.restassured.response.Response;

public class ApiUtils {

    /* Reusable code for extracting particular given string value from response */

    public static String extractFromResponse(Response response, String req) {
        String reqString = response.jsonPath().getString(req).trim();
        return reqString;
    }

    public static void setAuth(Response response) {
        String token = extractFromResponse(response, "token");
        EnvVariables.token = token;
    }

    /*==============================Code for validations============================================ */

    // Verify status code and responseTime altogether
    public void validateStatusCode_responseTime(Response response, int expectedStatusCode) {
        LoggerLoad.info("Actual status code : "+response.getStatusCode());
        response.then().assertThat().statusCode(expectedStatusCode).and()
                .time(lessThan(700L), TimeUnit.MILLISECONDS);

    }
    // Verify status code
    public void validateStatusCode(Response response, int status_Code) {
        Assert.assertEquals(response.getStatusCode(), status_Code);

    }

    public void extractRes(Response response) {
        String res = response.getBody().asString();
        LoggerLoad.info("Response body : "+res);
    }

    // Verify status message
    public void validateStatusMessage(Response response, String status_Message) {
        int statusCode = response.getStatusCode();
        String statusText = getHttpStatusText(statusCode);
        LoggerLoad.info("Actual Status Code: " + statusCode);
        LoggerLoad.info("Mapped Status Text: " + statusText);
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
