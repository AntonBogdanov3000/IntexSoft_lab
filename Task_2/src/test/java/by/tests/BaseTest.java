package by.tests;

import by.pages.BasePage;
import by.pages.MainPage;
import by.utils.BasePageFactory;
import by.utils.BrowserManager;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class BaseTest {


    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;
    protected MainPage mainPage;

    protected <T extends BasePage> T createInstance(Class<T> basePage) {
        return BasePageFactory.createInstance(page, basePage);
    }

    @BeforeAll
    public void initBrowser() {
        playwright = Playwright.create();
        browser = BrowserManager.getBrowser(playwright);
    }

    @BeforeEach
    public void startBrowser() {
        context = browser.newContext();
        page = context.newPage();
        mainPage = createInstance(MainPage.class);
    }

    @AfterEach
    public void closeBrowser() {
        context.close();
    }

    @AfterAll
    public void close() {
        browser.close();
        playwright.close();
    }
}
