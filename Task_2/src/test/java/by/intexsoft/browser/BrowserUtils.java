package by.intexsoft.browser;

import org.openqa.selenium.WebDriver;
import java.util.Set;


public class BrowserUtils {

    public void switchTab (WebDriver driver){
        Set<String> handles = driver.getWindowHandles();
        for(String actual : handles){
            if(!actual.equalsIgnoreCase(driver.getCurrentUrl())){
                driver.switchTo().window(actual);
            }
        }
    }
}
