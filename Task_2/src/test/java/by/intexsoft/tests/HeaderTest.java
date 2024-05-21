package by.intexsoft.tests;

import by.intexsoft.constants.Urls;
import by.intexsoft.page.MainPage;
import by.intexsoft.page.OrderPage;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class HeaderTest extends BaseTest{

    // Проходит на Chrome
    // Падает на FireFox

    @Test
    public void testHeaderLogos(){
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        orderPage.openPage();
        orderPage.header.clickOnScooterLogo();
        Assertions.assertTrue(mainPage.isOpened(), "Actual result is not equals expected");
        orderPage.header.clickOnYandexLogo();
        browserUtils.switchTab(driver);
        Assertions.assertTrue(driver.getCurrentUrl().contains(Urls.YANDEX_URL.getTitle()),"Actual result is not equals expected");
    }
}
