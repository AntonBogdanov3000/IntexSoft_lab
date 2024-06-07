package by.intexsoft.elements;

import by.intexsoft.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Header {

    private WebDriver webDriver;

    public Header(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    private static final By ORDER_BUTTON_LOCATOR = By.xpath("//div[contains(@class, 'Header_Nav')]/button[1]");
    private static final By SCOOTER_SIGN_LOCATOR = By.xpath("//a[contains(@class, 'Header_LogoScooter')]");
    private static final By YANDEX_SIGN_LOCATOR = By.xpath("//a[contains(@class, 'Header_LogoYandex')]");
    private static final By ORDER_STATUS_BUTTON_LOCATOR = By.xpath("//div[contains(@class, 'Header_Nav')]/button[2]");
    private static final By ORDER_ID_INPUT_LOCATOR = By.xpath("//div[contains(@class, 'Input_InputContainer')]/input");
    private static final By GO_BUTTON_LOCATOR = By.xpath("//div/button[contains(@class, 'Header_Button')]");

    public void clickOnOrderButton(){
        WebElement topMenuItem = webDriver.findElement(ORDER_BUTTON_LOCATOR);
        topMenuItem.click();
    }

    public void clickOnScooterLogo(){
        WebElement scooterLogo = webDriver.findElement(SCOOTER_SIGN_LOCATOR);
        scooterLogo.click();
    }

    public void clickOnYandexLogo(){
        WebElement yandexLogo = webDriver.findElement(YANDEX_SIGN_LOCATOR);
        yandexLogo.click();
    }

    public void clickOnOrderStatusButton(){
        WebElement statusButton = webDriver.findElement(ORDER_STATUS_BUTTON_LOCATOR);
        statusButton.click();
    }

    public void inputOrderId(String id){
        WebElement orderIdInput = webDriver.findElement(ORDER_ID_INPUT_LOCATOR);
        WaitUtil.waitForElementVisibility(orderIdInput,3, webDriver);
        orderIdInput.sendKeys(id);
    }

    public void clickGoButton(){
        WebElement goButton = webDriver.findElement(GO_BUTTON_LOCATOR);
        goButton.click();
    }
}
