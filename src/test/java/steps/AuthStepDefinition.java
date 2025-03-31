package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import models.login.LoginResponse;
import org.junit.jupiter.api.Assertions;
import requests.AuthRequest;
import utilities.ResponseManager;

public class AuthStepDefinition {
    private final AuthRequest authRequest = new AuthRequest();
    private String requestBodyPath;
    private LoginResponse loginResponse;

    @Given("The user gets the {string} credentials Login request body")
    public void getLoginRequestBody(String credentialsType) {
        final var path = "src/test/resources/payloads/%s.json";
        final var jsonName = switch (credentialsType) {
            case "valid" -> "login";
            case "invalid" -> "invalidCredentials";
            case "empty" -> "emptyCredentials";
            default -> "";
        };
        requestBodyPath = String.format(path, jsonName);
    }

    @When("The user calls the Login request")
    public void callLoginRequest() {
        authRequest.login(requestBodyPath);
    }

    @And("The user gets the Login response body")
    public void getLoginResponseBody() {
        loginResponse = ResponseManager.getResponseBody(LoginResponse.class);
    }

    @And("The user verifies that the id is positive")
    public void verifyIdIsPositive() {
        Assertions.assertTrue(loginResponse.id() > 0);
    }

    @And("The user verifies that both Access Token and Refresh Token length matches {int} characters")
    public void verifyBothTokenLength(int length) {
        final var accessToken = loginResponse.accessToken();
        final var refreshToken = loginResponse.refreshToken();

        Assertions.assertAll(
                () -> Assertions.assertEquals(length, accessToken.length()),
                () -> Assertions.assertEquals(length, refreshToken.length())
        );
    }
}
