package by.intexsoft.tests;

import by.intexsoft.browser.Browser;
import by.intexsoft.browser.BrowserUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;


public class BaseTest {

    WebDriver driver;
    BrowserUtils browserUtils;

    @Before
    @BeforeEach
    public void init(){
        browserUtils = new BrowserUtils();
        driver = Browser.getWebDriver();
    }

    @After
    @AfterEach
    public void closeBrowser()
    {
        Browser.close();
    }
}
