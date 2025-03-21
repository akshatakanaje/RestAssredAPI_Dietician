package stepDefinitions;

import apiActions.UserLoginActions;
import generics.ApiUtils;
import generics.LoggerLoad;
import httpRequest.BaseRequest;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class UserLoginSteps {

    public static RequestSpecification requestSpecs;
    static Response response;

    private static BaseRequest login;
    private static BaseRequest getlogin;

    ApiUtils restUtil = new ApiUtils();
    static String requestBody = "";

    static String updatedRequestBody = "";

    private static boolean isAuthTokenGenerated = false;
    public static String token;

    @BeforeAll
    public static void setup() {
        if (!isAuthTokenGenerated) {

            login = UserLoginActions.validLogin(login);
            requestSpecs = login.buildRequest();
            response = requestSpecs.post(login.getServiceUrl());
            ApiUtils.setAuth(response);
            LoggerLoad.info("Executing setup code...");

            // Set the flag to true after execution
            isAuthTokenGenerated = true;
        }
    }

    @BeforeMethod
    public void scenario(Scenario scenario) {
        LoggerLoad.info(
                "===============================================================================================");
        LoggerLoad.info(scenario.getSourceTagNames() + " : " + scenario.getName());
        LoggerLoad.info(
                "-----------------------------------------------------------------------------------------------");

    }

    @Given("creates login request with valid credentials")
    public void creates_request_with(String string, String string2) {
        LoggerLoad.info("Executing some precondition step => Check authentication details");
        if (isAuthTokenGenerated == true) {
            LoggerLoad.info("User is authenticated!!!");
        } else {
            LoggerLoad.info("Unauthorized User warning!!!");
        }

    }

    @When("user call Post Request with valid endpoint login")
    public void call_request_with(String string, String string2, String string3) {
        getlogin = UserLoginActions.validLogin(getlogin);
        requestSpecs = getlogin.buildRequest();
        response = requestSpecs.post(getlogin.getServiceUrl());
    }

    @Then("User receives {int} Status with response body")
    public void user_receives_status_with_response_body(Integer int1) {
        restUtil.validateStatusCode(response, int1);
    }


    @Given("{string} creates invalid request with {string}")
    public void creates_invalid_request_with(String string, String string2) {

    }

    @When("User calls {string} request on {string} with invalid dat")
    public void user_calls_request_on_with_invalid_dat(String string, String string2) {

    }

    @Then("User receives status")
    public void user_receives_status() {

    }

}
