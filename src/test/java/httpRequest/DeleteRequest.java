package httpRequest;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class DeleteRequest extends BaseRequest{

    @Override
    public RequestSpecification buildRequest() {

        if (baseUrl == null|| token == null) {
            System.out.println("baseUrl in getrequest : "+baseUrl);
            System.out.println("Token in getrequest : "+token);
            throw new IllegalStateException("Required fields are not set.");
        }
        return RestAssured.given()
                .baseUri(baseUrl)
                .filters(new RequestLoggingFilter(LogDetail.ALL, getLogPrintStream()), // Ensure logging to the same PrintStream
                        new ResponseLoggingFilter(LogDetail.BODY, getLogPrintStream())) // Log response body
                .header("Content-Type",acceptHeader)
                .header("Authorization","Bearer "+token);



    }
}
