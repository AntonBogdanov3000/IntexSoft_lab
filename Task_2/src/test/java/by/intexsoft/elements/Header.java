package by.intexsoft.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Header {

    private WebDriver webDriver;

    public Header(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    private static final By ORDER_BUTTON_LOCATOR = By.xpath("//button[contains( text(), 'Заказать')]");
    private static final By SCOOTER_SIGN_LOCATOR = By.xpath("//a[@class='Header_LogoScooter__3lsAR']");
    private static final By YANDEX_SIGN_LOCATOR = By.xpath("//a[@class='Header_LogoYandex__3TSOI']");
    private static final By ORDER_STATUS_BUTTON_LOCATOR = By.xpath("//button[text()='Статус заказа']");
    private static final By ORDER_ID_INPUT_LOCATOR = By.xpath("//input[@class='Input_Input__1iN_Z Header_Input__xIoUq']");
    private static final By GO_BUTTON_LOCATOR = By.xpath("//button[@class='Button_Button__ra12g Header_Button__28dPO']");

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
        orderIdInput.sendKeys(id);
    }

    public void clickGoButton(){
        WebElement goButton = webDriver.findElement(GO_BUTTON_LOCATOR);
        goButton.click();
    }
}
