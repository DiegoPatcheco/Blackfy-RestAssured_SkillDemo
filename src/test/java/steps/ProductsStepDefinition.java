package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import models.product.PartialProduct;
import models.product.Product;
import requests.ProductRequest;
import utilities.ResponseManager;

import java.util.Map;

public class ProductsStepDefinition {
    private final ProductRequest productRequest = new ProductRequest();
    private Map<String, String> queryParamMap;
    private Product product;
    private PartialProduct partialProduct;

    @When("The user calls the Get All Products request")
    public void callGetAllProductsRequest() {
        productRequest.getAllProducts();
    }

    @When("The user calls the Get Single Product request with {int} id")
    public void callGetSingleProductRequest(int id) {
        productRequest.getSingleProduct(id);
    }

    @And("The user verifies the Product schema response body")
    public void verifyProductSchemaResponseBody() {
        ResponseManager.doSchemaValidation("src/test/resources/schemas/product/GetSingleProduct.json");
    }

    @When("The user calls the Delete Single Product request with {int} id")
    public void callDeleteSingleProductRequest(int id) {
        productRequest.deleteSingleProduct(id);
    }

    @Given("The user sorts the Products by {string} value and {string} order")
    public void sortProductsByValueAndOrder(String key, String value) {
        queryParamMap = Map.of(
                "sortBy", key,
                "order", value
        );
    }

    @When("The user calls the Sort Products request")
    public void callSortProductsRequest() {
        productRequest.sortProducts(queryParamMap);
    }

    @Given("The user search the Product that contains {string}")
    public void searchProductContaining(String value) {
        queryParamMap = Map.of(
                "q", value
        );
    }

    @When("The user calls the Search Single Product request")
    public void callSearchSingleProductRequest() {
        productRequest.searchProducts(queryParamMap);
    }

    @Given("The user generates a Product request body")
    public void generateProductRequestBody() {
        product = Product.generateRandomProduct();
    }

    @When("The user calls the Create Single Product")
    public void callCreateSingleProduct() {
        productRequest.createProduct(product);
    }

    @When("The user calls the Update Single Product request with {int} id")
    public void callUpdateSingleProductRequest(int id) {
        productRequest.updateProduct(id, product);
    }

    @Given("The user generates a Partial Product request body")
    public void generatePartialProductRequestBody() {
        partialProduct = PartialProduct.generateRandomPartialProduct();
    }

    @When("The user calls the Partial Update Single Product request with {int} id")
    public void callPartialUpdateSingleProductRequest(int id) {
        productRequest.partialUpdateProduct(id, partialProduct);
    }
}
