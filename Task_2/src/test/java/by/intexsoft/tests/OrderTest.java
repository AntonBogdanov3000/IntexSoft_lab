package by.intexsoft.tests;

import by.intexsoft.page.MainPage;
import by.intexsoft.page.OrderPage;
import by.intexsoft.page.OrderStatusPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


public class OrderTest extends BaseTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/orderTestData.csv")
    public void testOrder(String name, String surname, String address, String metro, String phone,
                          int dayOfMonth, String period, String color, String expected) throws InterruptedException {

        OrderPage orderPage = new OrderPage(driver);
        orderPage.openPage();
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
    public void testCheckUnexistOrder(String orderId){
        MainPage mainPage = new MainPage(driver);
        OrderStatusPage orderStatusPage = new OrderStatusPage(driver);
        mainPage.header.clickOnOrderStatusButton();
        mainPage.header.inputOrderId(orderId);
        mainPage.header.clickGoButton();
        Assertions.assertTrue(orderStatusPage.isOpened(), "Result is not equals expected");
    }
}
