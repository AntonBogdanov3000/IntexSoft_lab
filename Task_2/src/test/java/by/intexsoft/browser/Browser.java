package by.intexsoft.browser;

import by.intexsoft.constants.UrlConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Browser {

    private static WebDriver webDriver;


    public static WebDriver getWebDriver(){
        if(webDriver == null) {
            init();
        }
        return webDriver;
    }

    public static void init(){
        webDriver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver","/Users/Nastya/tools/chromedriver-mac-x64");
        webDriver.get(UrlConstants.BASE_URL);
        webDriver.manage().window().maximize();
    }

    public static void close(){
        if (webDriver != null){
            webDriver.quit();
            webDriver = null;
        }
    }
}
