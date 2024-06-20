package tests;

import constants.Messages;
import constants.StatusCode;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.Courier;
import models.ResponseJson;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.FileUtil;
import static io.restassured.RestAssured.*;


public class LoginCourierTest extends BaseTest {

    @Test
    public void test_1_LoginCourier(){
        Response response = given().contentType(ContentType.JSON)
                .body(FileUtil.getValidUserFile()).post(baseURI + loginCourier);
        Assert.assertEquals(response.getStatusCode(), StatusCode.CODE_200);
        Courier courier = gson.fromJson(response.body().asPrettyString(), Courier.class);
        Courier.createdCourierId = String.valueOf(courier.getId());
        org.testng.Assert.assertTrue(courier.getId() != 0);
    }

    @Test
    public void test_2_LoginNonexistentCourier(){
        Response response = given().contentType(ContentType.JSON)
                .body(FileUtil.getNonexistentLoginFile()).post(baseURI + loginCourier);
        Assert.assertEquals(response.getStatusCode(), StatusCode.CODE_404);
        ResponseJson responseJson = gson.fromJson(response.body().asPrettyString(), ResponseJson.class);
        Assert.assertEquals(responseJson.getMessage() , Messages.LOGIN_NOT_FOUND);
    }

    @Test
    public void test_3_LoginIncorrectCourier(){
        Response response = given().contentType(ContentType.JSON)
                .body(FileUtil.getIncorrectLoginFile()).post(baseURI + loginCourier);
        Assert.assertEquals(response.getStatusCode(), StatusCode.CODE_500);
    }

    @Test
    public void getLoginWithoutOneParameter(){
        RequestSpecification request = given().contentType(ContentType.JSON);
        Response response = request.body(FileUtil.getOnlyPasswordFile()).post(baseURI + loginCourier);
        ResponseJson responseJson = gson.fromJson(response.body().asPrettyString(), ResponseJson.class);
        Assert.assertEquals(responseJson.getMessage() , Messages.LESS_DATA_TO_ENTER);
    }
}
