package httpRequest;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class PostRequest extends BaseRequest{

    @Override
    public RequestSpecification buildRequest() {


        if (baseUrl == null) {
            throw new IllegalStateException("Required fields are not set.");
        }

        RestAssured.config().logConfig(new LogConfig().defaultStream(getLogPrintStream()));

        return RestAssured.given()
                .baseUri(baseUrl)
                .filters(new RequestLoggingFilter(LogDetail.ALL, getLogPrintStream()), // Ensure logging to the same PrintStream
                        new ResponseLoggingFilter(LogDetail.BODY, getLogPrintStream())) // Log response body
                .header("Content-Type",acceptHeader)
                .header("Accept",acceptHeader)
                .header("Authorization","Bearer "+token)
                .body(requestBody);


    }
}
