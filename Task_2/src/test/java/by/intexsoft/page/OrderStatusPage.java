package by.intexsoft.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class OrderStatusPage extends BasePage{

    public OrderStatusPage(WebDriver webDriver) {
        super(webDriver);
    }
    private static final By WRONG_ORDER_PAGE_LOCATOR = By.xpath("//div[@class='Track_NotFound__6oaoY']");

    @Override
    public boolean isOpened() {
        WebElement wrongSign = driver.findElement(WRONG_ORDER_PAGE_LOCATOR);
        return wrongSign.isDisplayed();
    }
}
