package tests;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import constants.Messages;
import constants.Params;
import constants.ParamsData;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.Order;
import models.OrderList;
import models.ResponseJson;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


public class GetOrdersTest extends BaseTest{

    @Test
    public void test_1_GetOrdersList(){
        OrderList orderList = given().get(baseURI + orders).body().as(OrderList.class);
        System.out.println(orderList.getOrders().length);
        Assert.assertNotNull(orderList);
    }

    @Test
    public void test_2_GetOrderByTrack(){
        RequestSpecification request = given();
        Response response = request.queryParam(Params.T, Order.createdOrderTrack).get(baseURI + ordersTrack);
        JsonObject jsonObject = JsonParser.parseString(response.body().asPrettyString()).getAsJsonObject();
        Order order = gson.fromJson(jsonObject.get(Params.ORDER), Order.class);
        Order.createdOrderId = order.getId();
        Assert.assertEquals(order.getTrack() , Order.createdOrderTrack);
    }

    @Test
    public void test_3_GetOrderWithoutTrack(){
        RequestSpecification request = given();
        Response response = request.queryParam(Params.T, ParamsData.emptyTrack).get(baseURI + ordersTrack);
        ResponseJson responseJson = gson.fromJson(response.body().asPrettyString(), ResponseJson.class);
        Assert.assertEquals(responseJson.getMessage() , Messages.LESS_DATA_FOR_SEARCH);
    }

    @Test
    public void test_4_GetOrderWithIncorrectTrack(){
        RequestSpecification request = given();
        Response response = request.queryParam(Params.T, ParamsData.incorrectOrderTrack).get(baseURI + ordersTrack);
        ResponseJson responseJson = gson.fromJson(response.body().asPrettyString(), ResponseJson.class);
        Assert.assertEquals(responseJson.getMessage() , Messages.ORDER_NOT_FOUND);
    }
}
