package utilities;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.io.File;

public class ResponseManager {
    private static Response response;

    public static void verifyStatusCode(int expectedStatusCode) {
        Assertions.assertEquals(response.getStatusCode(), expectedStatusCode);
    }

    public static void verifyResponseTime(int expectedResponseTime) {
        Assertions.assertTrue(response.getTime() < expectedResponseTime);
    }

    public static void doSchemaValidation(String schemaFilePath) {
        response
                .then()
                .body(JsonSchemaValidator.matchesJsonSchema(new File(schemaFilePath)));
    }

    public static <T> T getResponseBody(Class<T> clazz) {
        return response.body().as(clazz);
    }

    public static String getPathAsString(String path) {
        return response.path(path).toString();
    }

    public static void setResponse(Response response) {
        ResponseManager.response = response;
    }
}
