package tests;

import constants.Messages;
import constants.StatusCode;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.ResponseJson;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.FileUtil;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


public class CreateCourierTest extends BaseTest{

    @Test
    public void test_1_CreateCourier(){
        Response response = given().contentType(ContentType.JSON)
             .body(FileUtil.getValidUserFile()).post(baseURI + courier);
        Assert.assertEquals(StatusCode.CODE_201, response.getStatusCode());
        ResponseJson responseJson = gson.fromJson(response.body().asPrettyString(), ResponseJson.class);
        Assert.assertTrue(responseJson.isOk());
    }

    @Test
    public void test_2_CreateCourierWithoutOneParameter(){
        Response response = given().contentType(ContentType.JSON)
                .body(FileUtil.getInvalidUserFile()).post(baseURI + courier);
        Assert.assertEquals(response.getStatusCode(), StatusCode.CODE_400);
        ResponseJson responseJson = gson.fromJson(response.body().asPrettyString(), ResponseJson.class);
        Assert.assertEquals(responseJson.getMessage() , Messages.LESS_DATA_TO_CREATE);
    }

    @Test
    public void test_3_CreateCourierWithExistLogin(){
        Response response = given().contentType(ContentType.JSON)
                .body(FileUtil.getValidUserFile()).post(baseURI + courier);
        Assert.assertEquals(response.getStatusCode(), StatusCode.CODE_409);
        ResponseJson responseJson = gson.fromJson(response.body().asPrettyString(), ResponseJson.class);
        Assert.assertEquals(responseJson.getMessage() , Messages.EXIST_LOGIN);
    }
}
