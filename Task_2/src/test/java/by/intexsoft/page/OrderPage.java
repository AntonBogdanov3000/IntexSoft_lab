package by.intexsoft.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


public class OrderPage extends BasePage{

    private final static By NAME_INPUT_LOCATOR = By.xpath("//input[@placeholder='* Имя']");
    private final static By SURNAME_INPUT_LOCATOR = By.xpath("//input[@placeholder='* Фамилия']");
    private final static By ADDRESS_INPUT_LOCATOR = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private final static By METRO_INPUT_LOCATOR = By.xpath("//input[@placeholder='* Станция метро']");
    private final static By PHONE_INPUT_LOCATOR = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final static By DATE_SELECTOR_LOCATOR = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private final static By NEXT_BUTTON_LOCATOR = By.xpath("//button[text()='Далее']");
    private final static By ACCEPT_COOKIES_BUTTON_LOCATOR = By.xpath("//button[@class='App_CookieButton__3cvqF']");
    private final static By ORDER_TIME_LOCATOR = By.xpath("//div[@class='Dropdown-control']");
    private final static By ORDER_DROPDOWN_LOCATOR = By.xpath("//div[@class='Dropdown-option']");
    private final static By CHECKBOXES_COLOR_LOCATOR = By.xpath("//label[@class='Checkbox_Label__3wxSf']");
    private final static By ORDER_BUTTON_LOCATOR = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final static By CONFIRM_ORDER_BUTTON_LOCATOR = By.xpath("//button[text()='Да']");
    private final static By CREATED_ORDER_STATUS_LOCATOR = By.xpath("//div[@class='Order_ModalHeader__3FDaJ']");
    private final static By METRO_DROPDOWN_LIST_LOCATOR = By.xpath("//div[@class='Order_Text__2broi']");

    public OrderPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public boolean isOpened() {
        return false;
    }

    public void openPage(){
        header.clickOnOrderButton();
    }

    public void acceptCookies(){
        WebElement acceptCookieButton = driver.findElement(ACCEPT_COOKIES_BUTTON_LOCATOR);
        acceptCookieButton.click();
    }

    public void enterData(String name, String surname, String address, String metro, String phone){
        WebElement nameInput = driver.findElement(NAME_INPUT_LOCATOR);
        WebElement surnameInput = driver.findElement(SURNAME_INPUT_LOCATOR);
        WebElement addressInput = driver.findElement(ADDRESS_INPUT_LOCATOR);
        WebElement metroInput = driver.findElement(METRO_INPUT_LOCATOR);

        WebElement phoneInput = driver.findElement(PHONE_INPUT_LOCATOR);

        nameInput.sendKeys(name);
        surnameInput.sendKeys(surname);
        addressInput.sendKeys(address);
        metroInput.click();

        List<WebElement> metroList = driver.findElements(METRO_DROPDOWN_LIST_LOCATOR);
        for (WebElement element : metroList){
            if(element.getText().equals(metro)){
                element.click();
                break;
            }
        }
        phoneInput.sendKeys(phone);
    }

    public void selectDate(int dayOfMonth){
        WebElement dateInput = driver.findElement(DATE_SELECTOR_LOCATOR);
        dateInput.click();
        String dayOfMonthPattern = String.format("//div[text()=%d]",dayOfMonth);
        WebElement day = driver.findElement(By.xpath(dayOfMonthPattern));
        day.click();
    }

    public void enterPeriod(String period){
        WebElement orderTime = driver.findElement(ORDER_TIME_LOCATOR);
        orderTime.click();
        List<WebElement> dropDown = driver.findElements(ORDER_DROPDOWN_LOCATOR);
        for(WebElement element : dropDown){
            if(element.getText().equals(period)){
                element.click();
                break;
            }
        }
    }

    public void selectColor(String color){
        List<WebElement> colorList = driver.findElements(CHECKBOXES_COLOR_LOCATOR);
        for(WebElement element : colorList){
            if(element.getText().equals(color)){
                element.click();
                break;
            }
        }
    }

    public void completeTheOrder(){
        WebElement orderButton = driver.findElement(ORDER_BUTTON_LOCATOR);
        orderButton.click();
        WebElement confirm = driver.findElement(CONFIRM_ORDER_BUTTON_LOCATOR);
        confirm.click();
    }

    public void clickOnNextButton(){
        WebElement nextButton = driver.findElement(NEXT_BUTTON_LOCATOR);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", nextButton);
        nextButton.click();
    }

    public String getCreatedOrderStatus(){
        WebElement text = driver.findElement(CREATED_ORDER_STATUS_LOCATOR);
        return text.getText();
    }
}
