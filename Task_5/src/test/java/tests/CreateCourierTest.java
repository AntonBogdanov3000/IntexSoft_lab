package tests;

import constants.Messages;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.ResponseJson;
import org.apache.http.HttpStatus;
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
        Assert.assertEquals(HttpStatus.SC_CREATED , response.getStatusCode());
        ResponseJson responseJson = response.as(ResponseJson.class);
        Assert.assertTrue(responseJson.isOk());
    }

    @Test
    public void test_2_CreateCourierWithoutOneParameter(){
        Response response = given().contentType(ContentType.JSON)
                .body(FileUtil.getInvalidUserFile()).post(baseURI + courier);
        Assert.assertEquals(response.getStatusCode() , HttpStatus.SC_BAD_REQUEST);
        ResponseJson responseJson = response.as(ResponseJson.class);
        Assert.assertEquals(responseJson.getMessage() , Messages.LESS_DATA_TO_CREATE);
    }

    @Test
    public void test_3_CreateCourierWithExistLogin(){
        Response response = given().contentType(ContentType.JSON)
                .body(FileUtil.getValidUserFile()).post(baseURI + courier);
        Assert.assertEquals(response.getStatusCode() , HttpStatus.SC_CONFLICT);
        ResponseJson responseJson = response.as(ResponseJson.class);
        Assert.assertEquals(responseJson.getMessage() , Messages.EXIST_LOGIN);
    }
}
