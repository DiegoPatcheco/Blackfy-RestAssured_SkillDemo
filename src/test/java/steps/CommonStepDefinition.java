package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.RequestManager;
import utilities.ResponseManager;

public class CommonStepDefinition {
    private final RequestManager requestManager = new RequestManager();

    @Then("The user verifies that the status code matches {int}")
    public void verifyStatusCode(int statusCode) {
        ResponseManager.verifyStatusCode(statusCode);
    }

    @And("The user verifies that the response time is less than {int} ms")
    public void verifyResponseTime(int time) {
        ResponseManager.verifyResponseTime(time);
    }

    @Given("The user gets authenticated with the server")
    public void initAuth() {
        requestManager.initAuth();
    }
}
