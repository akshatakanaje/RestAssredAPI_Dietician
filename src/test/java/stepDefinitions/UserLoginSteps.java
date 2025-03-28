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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;

public class UserLoginSteps {
    private static final Logger logger = LoggerFactory.getLogger(UserLoginSteps.class);

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
            logger.info("Executing setup code...");

            // Set the flag to true after execution
            isAuthTokenGenerated = true;
        }
    }

    @BeforeMethod
    public void scenario(Scenario scenario) {
        logger.info(scenario.getSourceTagNames() + " : " + scenario.getName());
        logger.info(
                "-----------------------------------------------------------------------------------------------");
    }

    @Given("{string} creates request with {string}")
    public void creates_request_with(String string, String string2) {
        if (isAuthTokenGenerated == true) {
            logger.info("User is authenticated!!!");
        } else {
            logger.warn("Unauthorized User warning!!!");
        }
    }
    @When("{string} call {string} Request with {string}")
    public void call_request_with(String string, String string2, String string3) {
        getlogin = UserLoginActions.validLogin(getlogin);
        requestSpecs = getlogin.buildRequest();
        response = requestSpecs.post(getlogin.getServiceUrl());
    }

    @Then("User receives {int} Status code")
    public void user_receives_status_code(Integer int1) {
        restUtil.validateStatusCode(response, int1);
    }

    @Given("{string} creates invalid request with {string}")
    public void creates_invalid_request_with(String string, String string2) {
        getlogin = UserLoginActions.invalidLogin(getlogin);
        requestSpecs = getlogin.buildRequest();
        response = requestSpecs.post(getlogin.getServiceUrl());
    }

    @When("User calls {string} request on {string} with invalid dat")
    public void user_calls_request_on_with_invalid_dat(String string, String string2) {
    }

    @Then("User receives status")
    public void user_receives_status() {
    }

}
