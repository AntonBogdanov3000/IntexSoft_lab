package by.intexsoft.browser;

import by.intexsoft.constants.UrlConstants;
import com.microsoft.playwright.*;

public class BrowserMain {


    public static Playwright playwright;
    public static Page page;
    public static Browser browser;
    public static BrowserContext context;

    public static void initBrowser() {
        playwright = Playwright.create();
        browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    public static void initContext() {
        context = browser.newContext();
    }

    public static Page initPage() {
        page = context.newPage();
        page.navigate(UrlConstants.BASE_URL);
        return page;
    }

    public static void close() {
        browser.close();
    }
}
