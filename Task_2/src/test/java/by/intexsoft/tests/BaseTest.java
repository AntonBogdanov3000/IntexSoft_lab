package by.intexsoft.tests;

import by.intexsoft.browser.BrowserMain;
import by.intexsoft.constants.UrlConstants;
import by.intexsoft.page.MainPage;
import by.intexsoft.page.OrderPage;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {


    public Page page;
    public Browser browser;
    public BrowserContext context;

    MainPage mainPage;
    OrderPage orderPage;

    @BeforeEach
    public void startBrowser() {
        BrowserMain.initBrowser();
        BrowserMain.initContext();
        BrowserMain.initPage();

        browser = BrowserMain.browser;
        context = BrowserMain.context;
        page = BrowserMain.page;

        mainPage = new MainPage(page);
        orderPage = new OrderPage(page);
        page.navigate(UrlConstants.BASE_URL);
    }

    @AfterEach
    public void closeBrowser() {
        BrowserMain.close();
    }
}
