package by.tests;

import by.pages.OrderStatusPage;
import by.pages.OrderPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class OrderTest extends BaseTest {


    @ParameterizedTest
    @CsvFileSource(resources = "/orderTestData.csv")
    public void testOrder(String name, String surname, String address, String metro, String phone,
                          int dayOfMonth, String period, String color, String expected) {
        mainPage.open();
        OrderPage orderPage = mainPage.clickOnOrder();
        Assertions.assertTrue(orderPage.isOpened().isVisible());
        orderPage.acceptCookies();
        orderPage.enterData(name, surname, address, metro, phone);
        orderPage.clickOnNextButton();
        orderPage.selectDate(dayOfMonth);
        orderPage.enterPeriod(period);
        orderPage.selectColor(color);
        orderPage.completeTheOrder();
        Assertions.assertTrue(orderPage.getCreatedOrderStatus().contains(expected),"Result is not equals expected");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/wrongOrderId.csv")
    public void testCheckUnExistOrder(String orderId) {
        mainPage.open();
        mainPage.clickOnOrderStatus();
        mainPage.inputOrderId(orderId);
        OrderStatusPage orderStatusPage = mainPage.clickOnGo();
        Assertions.assertTrue(orderStatusPage.orderNotFound().isVisible(), "Result is not equals expected");
    }

}
