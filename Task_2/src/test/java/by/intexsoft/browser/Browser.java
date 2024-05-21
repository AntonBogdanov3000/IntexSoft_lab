package by.intexsoft.browser;

import by.intexsoft.constants.Urls;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;


public class Browser {
    private static int DEFAULT_WAIT_IN_SECONDS = 10;
    private static WebDriver webDriver;

    public static WebDriver getWebDriver(){
        if(webDriver == null) {
            init();
        }
        return webDriver;
    }

    public static void init(){
        webDriver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver","/Users/Nastya/tools/chromedriver-mac-x64");
        webDriver.get(Urls.BASE_URL.getTitle());
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(DEFAULT_WAIT_IN_SECONDS));
        webDriver.manage().window().maximize();
    }

    public static void close(){
        if (webDriver != null){
            webDriver.quit();
            webDriver = null;
        }
    }
}
