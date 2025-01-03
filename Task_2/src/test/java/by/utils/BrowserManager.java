package by.utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Playwright;
import static by.config.ConfigurationManager.config;

public class BrowserManager {


    public static Browser getBrowser(final Playwright playwright) {
        return BrowserFactory.valueOf(config().browser().toUpperCase()).createInstance(playwright);
    }


}
