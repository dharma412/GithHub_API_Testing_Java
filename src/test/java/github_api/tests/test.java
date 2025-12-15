package github_api.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import github_api.utility.RestClient;
import github_api.endpoints.Routes;
import github_api.utility.CommonUtility;

import java.util.HashMap;
import java.util.Map;

import static github_api.utility.CommonUtility.generatePathParams;

public class test
{
    public static Map<String, String> pathParams;
    public static String owner;
    @Test
    public void fetchrepo()
    {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put("owner", "dharma412");
        Response response = RestClient.sendGetRequest(Routes.FETCH_REPO_LIST, pathParams);
        assert response.statusCode() == 200;

    }
}