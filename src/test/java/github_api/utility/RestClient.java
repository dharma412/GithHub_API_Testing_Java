package github_api.utility;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestClient
{
    static RequestSpecification reqSpec;

    public static RequestSpecification  getRequestSpecification()
    {
        RequestSpecBuilder  requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://api.github.com");
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.setAccept(ContentType.JSON);
        RequestSpecification reqSpec = requestSpecBuilder.build();
        System.out.printf("end of getRequestSpecification");
        return reqSpec;
    }

    public static Response sendPostRequest(String endPoint, Object requestPayload, Map<String, String> pathParams) {

        reqSpec = getRequestSpecification();
        RequestSpecification request = given().spec(reqSpec).pathParams(pathParams).body(requestPayload);
        return request.when().post(endPoint).then().extract().response();
    }

    public static Response sendGetRequest(String endPoint, Map<String, String> pathParams) {
        reqSpec = getRequestSpecification();
        RequestSpecification request = given().spec(reqSpec).pathParams(pathParams);
        return request.when().get(endPoint).then().extract().response();
    }

    public static Response sendDeleteRequest(String endPoint, Map<String, String> pathParams) {
        reqSpec = getRequestSpecification();
        RequestSpecification request = given().spec(reqSpec).pathParams(pathParams);
        return request.when().delete(endPoint).then().extract().response();
    }
}
