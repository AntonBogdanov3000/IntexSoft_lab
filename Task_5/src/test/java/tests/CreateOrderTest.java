package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.Order;
import models.ResponseJson;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.FileUtil;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


public class CreateOrderTest extends BaseTest{

    @Test
    public void testCreateOrder(){
        Response response = given().contentType(ContentType.JSON)
                .body(FileUtil.getOrderFile()).post(baseURI + orders);
        ResponseJson responseJson = response.as(ResponseJson.class);
        Order.createdOrderTrack = responseJson.getTrack();
        Assert.assertNotEquals(responseJson.getTrack() , 0);
    }
}
