package stepDefinitions;

import generics.ApiUtils;
import httpRequest.BaseRequest;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DietitianSteps {

    private static final Logger logger = LoggerFactory.getLogger(DietitianSteps .class);

    public static RequestSpecification requestSpecs;
    static Response response;

    private static BaseRequest login;

    private static BaseRequest getDietitian;
    private static BaseRequest postDietitian;
    private static BaseRequest putDietitian;
    private static BaseRequest deleteDietitian;

    ApiUtils restUtil = new ApiUtils();
    static String requestBody = "";

    private static boolean isAuthTokenGenerated = false;
    public static String token;

    static String updatedRequestBody = "";

}
