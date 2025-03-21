package stepDefinitions;

import httpRequest.BaseRequest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserLoginSteps {

    public static RequestSpecification requestSpecs;
    static Response response;

    private static BaseRequest login;
    private static BaseRequest getlogin;

    @Given("{string} creates request with {string}")
    public void creates_request_with(String string, String string2) {

    }

    @When("{string} call {string} Request with {string}")
    public void call_request_with(String string, String string2, String string3) {

    }

    @Then("User receives {int} Status with response body")
    public void user_receives_status_with_response_body(Integer int1) {

    }
}
