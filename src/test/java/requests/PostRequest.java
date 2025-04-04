package requests;

import io.restassured.http.Method;
import models.post.PartialPost;
import models.post.Post;
import utilities.BaseRequest;
import utilities.Logs;
import utilities.ResponseManager;

import java.util.Map;

public class PostRequest extends BaseRequest {
    public void getAllPosts() {
        Logs.info("(GET) Get all posts Request");

        final var response = getRequest()
                .basePath("posts")
                .request(Method.GET);

        ResponseManager.setResponse(response);
    }

    public void getSinglePost(int id) {
        Logs.info("(GET) Get single post Request");

        final var response = getRequest()
                .basePath("posts/{id}")
                .pathParam("id", id)
                .request(Method.GET);

        ResponseManager.setResponse(response);
    }

    public void deleteSinglePost(int id) {
        Logs.info("(Delete) Delete single post Request");

        final var response = getRequest()
                .basePath("posts/{id}")
                .pathParam("id", id)
                .request(Method.DELETE);

        ResponseManager.setResponse(response);
    }

    public void sortPosts(Map<String, String> queryMap) {
        Logs.info("(GET) Sort posts Request");

        final var response = getRequest()
                .basePath("posts")
                .queryParams(queryMap)
                .request(Method.GET);

        ResponseManager.setResponse(response);
    }

    public void searchPosts(Map<String, String> queryMap) {
        Logs.info("(GET) Search posts Request");

        final var response = getRequest()
                .basePath("posts/search")
                .queryParams(queryMap)
                .request(Method.GET);

        ResponseManager.setResponse(response);
    }

    public void createPost(Post post) {
        Logs.info("(POST) Create post Request");

        final var response = getRequest()
                .basePath("posts/add")
                .header("Content-Type", "application/json")
                .body(post)
                .request(Method.POST);

        ResponseManager.setResponse(response);
    }

    public void updatePost(int id, Post post) {
        Logs.info("(PUT) Update post Request");

        final var response = getRequest()
                .basePath("posts/{id}")
                .pathParam("id", id)
                .header("Content-Type", "application/json")
                .body(post)
                .request(Method.PUT);

        ResponseManager.setResponse(response);
    }

    public void partialUpdatePost(int id, PartialPost partialPost) {
        Logs.info("(PATCH) Partial update post Request");

        final var response = getRequest()
                .basePath("posts/{id}")
                .pathParam("id", id)
                .header("Content-Type", "application/json")
                .body(partialPost)
                .request(Method.PATCH);

        ResponseManager.setResponse(response);
    }
}
