package by.intexsoft.page;

import by.intexsoft.elements.Header;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected WebDriver driver;
    public Header header;

    public BasePage(WebDriver webDriver){
        this.driver = webDriver;
        this.header = new Header(webDriver);
    }
    public abstract boolean isOpened();
}
