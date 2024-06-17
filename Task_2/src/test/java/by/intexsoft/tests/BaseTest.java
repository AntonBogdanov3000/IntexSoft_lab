package by.intexsoft.tests;

import by.intexsoft.browser.Browser;
import by.intexsoft.browser.BrowserUtils;
import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;


public class BaseTest {

    WebDriver driver = Browser.getWebDriver();
    BrowserUtils browserUtils = new BrowserUtils();

    @After
    @AfterEach
    public void closeBrowser()
    {
        Browser.close();
    }
}
