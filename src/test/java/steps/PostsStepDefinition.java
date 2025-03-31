package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import models.post.PartialPost;
import models.post.Post;
import requests.PostRequest;
import utilities.ResponseManager;

import java.util.Map;

public class PostsStepDefinition {
    private final PostRequest postRequest = new PostRequest();
    private Map<String, String> queryParamMap;
    private Post post;
    private PartialPost partialPost;

    @When("The user calls the Get All Posts request")
    public void callGetAllPostsRequest() {
        postRequest.getAllPosts();
    }

    @When("The user calls the Get Single Post request with {int} id")
    public void callGetSinglePostRequest(int id) {
        postRequest.getSinglePost(id);
    }

    @And("The user verifies the Post schema response body")
    public void verifyPostSchemaResponseBody() {
        ResponseManager.doSchemaValidation("src/test/resources/schemas/Post/GetSinglePost.json");
    }

    @When("The user calls the Delete Single Post request with {int} id")
    public void callDeleteSinglePostRequest(int id) {
        postRequest.deleteSinglePost(id);
    }

    @Given("The user sorts the Posts by {string} value and {string} order")
    public void sortPostsByValueAndOrder(String key, String value) {
        queryParamMap = Map.of(
                "sortBy", key,
                "order", value
        );
    }

    @When("The user calls the Sort Posts request")
    public void callSortPostsRequest() {
        postRequest.sortPosts(queryParamMap);
    }

    @Given("The user search the Post that contains {string}")
    public void searchPostContaining(String value) {
        queryParamMap = Map.of(
                "q", value
        );
    }

    @When("The user calls the Search Single Post request")
    public void callSearchSinglePostRequest() {
        postRequest.searchPosts(queryParamMap);
    }

    @Given("The user generates a Post request body")
    public void generatePostRequestBody() {
        post = Post.generateRandomPost();
    }

    @When("The user calls the Create Single Post")
    public void callCreateSinglePost() {
        postRequest.createPost(post);
    }

    @When("The user calls the Update Single Post request with {int} id")
    public void callUpdateSinglePostRequest(int id) {
        postRequest.updatePost(id, post);
    }

    @Given("The user generates a Partial Post request body")
    public void generatePartialPostRequestBody() {
        partialPost = PartialPost.generateRandomPartialPost();
    }

    @When("The user calls the Partial Update Single Post request with {int} id")
    public void callPartialUpdateSinglePostRequest(int id) {
        postRequest.partialUpdatePost(id, partialPost);
    }
}
