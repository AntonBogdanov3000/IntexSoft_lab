package tests;

import constants.Messages;
import constants.Params;
import constants.ParamsData;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.Courier;
import models.Order;
import models.ResponseJson;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


public class AcceptOrderTest extends BaseTest{

    @Test
    public void test_1_acceptOrder(){
        RequestSpecification request = given();
        Response response = request.queryParam(Params.COURIER_ID, Courier.createdCourierId)
                .put(baseURI + orderAccept + Order.createdOrderId);
        ResponseJson responseJson = response.as(ResponseJson.class);
        Assert.assertTrue(responseJson.isOk());
    }

    @Test
    public void test_2_acceptOrderWithIncorrectCourierId(){
        RequestSpecification request = given();
        Response response = request.queryParam(Params.COURIER_ID, ParamsData.incorrectCourierId)
                .put(baseURI + orderAccept + Order.createdOrderId);
        ResponseJson responseJson = response.as(ResponseJson.class);
        Assert.assertEquals(responseJson.getMessage() , Messages.COURIER_WITH_ID_NOT_EXIST);
    }

    @Test
    public void test_3_acceptOrderWithoutCourierId(){
        RequestSpecification request = given();
        Response response = request.put(baseURI + orderAccept + Order.createdOrderId);
        ResponseJson responseJson = response.as(ResponseJson.class);
        Assert.assertEquals(responseJson.getMessage() , Messages.LESS_DATA_FOR_SEARCH);
    }

    @Test
    public void test_4_acceptOrderWithIncorrectOrderId(){
        RequestSpecification request = given();
        Response response = request.queryParam(Params.COURIER_ID, Courier.createdCourierId)
                .put(baseURI + orderAccept + ParamsData.incorrectOrderId);
        ResponseJson responseJson = response.as(ResponseJson.class);
        Assert.assertEquals(responseJson.getMessage() , Messages.ORDER_NOT_EXIST);
    }

    @Test
    public void test_5_acceptOrderWithoutOrderId(){
        RequestSpecification request = given();
        Response response = request.put(baseURI + orderAccept + "courier=" + Courier.createdCourierId);
        ResponseJson responseJson = response.as(ResponseJson.class);
        Assert.assertEquals(responseJson.getMessage() , Messages.LESS_DATA_FOR_SEARCH);
    }
}
