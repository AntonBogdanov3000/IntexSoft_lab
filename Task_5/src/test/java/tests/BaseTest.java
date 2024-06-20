package tests;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;


public class BaseTest {

    Gson gson;
    protected String courier = "/api/v1/courier";
    protected String courierDelete = "/api/v1/courier/";
    protected String loginCourier = "/api/v1/courier/login";
    protected String orders = "/api/v1/orders";
    protected String ordersTrack = "/api/v1/orders/track";
    protected String orderAccept = "/api/v1/orders/accept/";

    @BeforeClass
    public void start(){
        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru";
        gson = new Gson();
    }
}
