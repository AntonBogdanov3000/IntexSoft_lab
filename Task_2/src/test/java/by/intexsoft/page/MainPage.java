package by.intexsoft.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


public class MainPage extends BasePage{

    private final static By MAIN_PAGE_LOCATOR = By.xpath("//div[contains(@class, 'Home_Header')]");
    private final static By ITEMS_TEXT_LIST_LOCATOR = By.xpath("//div[@class='accordion__heading']");
    private final static By INNER_TEXT_ITEMS_LIST_LOCATOR = By.xpath("//div[@class='accordion__heading']/following::div[@class='accordion__panel']");
    private String innerText;
    public String getText(){
        return innerText;
    }
    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public boolean isOpened(){
        WebElement mainPage = driver.findElement(MAIN_PAGE_LOCATOR);
        return mainPage.isDisplayed();
    }

    public void clickOnListItem(String listItem){
        List<WebElement> textElements = driver.findElements(ITEMS_TEXT_LIST_LOCATOR);
        List<WebElement> innerElements = driver.findElements(INNER_TEXT_ITEMS_LIST_LOCATOR);
        for(int i=0; i < textElements.size(); i++){
            if(textElements.get(i).getText().equals(listItem)){
                ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", textElements.get(i));
                textElements.get(i).click();
                innerText = innerElements.get(i).getText();
            }
        }
    }
}
