package tests;

import constants.Messages;
import constants.ParamsData;
import io.restassured.response.Response;
import models.Courier;
import models.ResponseJson;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


public class DeleteCourierTest extends BaseTest{

    @Test
    public void test_1_DeleteCourier(){
        Response response = given().delete(baseURI + courierDelete + Courier.createdCourierId);
        response.prettyPrint();
        ResponseJson responseJson = response.as(ResponseJson.class);
        Assert.assertTrue(responseJson.isOk());
    }

    @Test
    public void test_2_DeleteCourierWithIncorrectId(){
        Response response = given().delete(baseURI + courierDelete + ParamsData.incorrectCourierId);
        ResponseJson responseJson = response.as(ResponseJson.class);
        Assert.assertEquals(responseJson.getMessage() , Messages.COURIER_NOT_EXIST);
    }

    @Test
    public void test_3_DeleteCourierWithoutId(){
        Response response = given().delete(baseURI + courierDelete);
        ResponseJson responseJson = response.as(ResponseJson.class);
        Assert.assertEquals(responseJson.getCode() , HttpStatus.SC_NOT_FOUND);
    }
}
