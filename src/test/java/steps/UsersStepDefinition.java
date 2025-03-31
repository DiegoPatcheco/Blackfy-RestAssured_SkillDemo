package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import models.user.PartialUser;
import models.user.User;
import requests.UserRequest;
import utilities.ResponseManager;

import java.util.Map;

public class UsersStepDefinition {
    private final UserRequest userRequest = new UserRequest();
    private Map<String, String> queryParamMap;
    private User user;
    private PartialUser partialUser;

    @When("The user calls the Get All Users request")
    public void callGetAllUsersRequest() {
        userRequest.getAllUsers();
    }

    @When("The user calls the Get Single User request with {int} id")
    public void callGetSingleUserRequest(int id) {
        userRequest.getSingleUser(id);
    }

    @And("The user verifies the User schema response body")
    public void verifyUserSchemaResponseBody() {
        ResponseManager.doSchemaValidation("src/test/resources/schemas/User/GetSingleUser.json");
    }

    @When("The user calls the Delete Single User request with {int} id")
    public void callDeleteSingleUserRequest(int id) {
        userRequest.deleteSingleUser(id);
    }

    @Given("The user sorts the Users by {string} value and {string} order")
    public void sortUsersByValueAndOrder(String key, String value) {
        queryParamMap = Map.of(
                "sortBy", key,
                "order", value
        );
    }

    @When("The user calls the Sort Users request")
    public void callSortUsersRequest() {
        userRequest.sortUsers(queryParamMap);
    }

    @Given("The user filters the User by {string} value and {string} city")
    public void searchUserContaining(String key, String value) {
        queryParamMap = Map.of(
                "key", key,
                "value", value
        );
    }

    @When("The user calls the Search Single User request")
    public void callSearchSingleUserRequest() {
        userRequest.filterUsers(queryParamMap);
    }

    @Given("The user generates a User request body")
    public void generateUserRequestBody() {
        user = User.generateRandomUser();
    }

    @When("The user calls the Create Single User")
    public void callCreateSingleUser() {
        userRequest.createUser(user);
    }

    @When("The user calls the Update Single User request with {int} id")
    public void callUpdateSingleUserRequest(int id) {
        userRequest.updateUser(id, user);
    }

    @Given("The user generates a Partial User request body")
    public void generatePartialUserRequestBody() {
        partialUser = PartialUser.generateRandomPartialUser();
    }

    @When("The user calls the Partial Update Single User request with {int} id")
    public void callPartialUpdateSingleUserRequest(int id) {
        userRequest.partialUpdateUser(id, partialUser);
    }
}
