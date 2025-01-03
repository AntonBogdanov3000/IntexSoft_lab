package by.pages;

import by.pages.locators.OrderPageLocators;
import com.microsoft.playwright.Locator;
import java.util.List;

public class OrderPage extends BasePage {


    public Locator isOpened() {
        return page.locator(OrderPageLocators.ORDER_PAGE_LOCATOR);
    }

    public void acceptCookies() {
        page.locator(OrderPageLocators.ACCEPT_COOKIES_BUTTON_LOCATOR).click();
    }

    public void enterData(String name, String surname, String address, String metro, String phone) {
        Locator nameInput = page.locator(OrderPageLocators.NAME_INPUT_LOCATOR);
        Locator surnameInput = page.locator(OrderPageLocators.SURNAME_INPUT_LOCATOR);
        Locator addressInput = page.locator(OrderPageLocators.ADDRESS_INPUT_LOCATOR);
        Locator metroInput = page.locator(OrderPageLocators.METRO_INPUT_LOCATOR);
        Locator phoneInput = page.locator(OrderPageLocators.PHONE_INPUT_LOCATOR);

        nameInput.fill(name);
        surnameInput.fill(surname);
        addressInput.fill(address);
        metroInput.click();

        List<Locator> metroList = page.locator(OrderPageLocators.METRO_DROPDOWN_LIST_LOCATOR).all();
        for (Locator element : metroList){
            if(element.textContent().equals(metro)){
                element.click();
                break;
            }
        }
        phoneInput.fill(phone);
    }

    public void selectDate(int dayOfMonth) {
        Locator dateInput = page.locator(OrderPageLocators.DATE_SELECTOR_LOCATOR);
        dateInput.click();
        String dayOfMonthPattern = String.format("//div[text()=%d]",dayOfMonth);
        Locator day = page.locator(dayOfMonthPattern);
        day.click();
    }

    public void enterPeriod(String period) {
        Locator orderTime = page.locator(OrderPageLocators.ORDER_TIME_LOCATOR);
        orderTime.click();
        List<Locator> dropDown = page.locator(OrderPageLocators.ORDER_DROPDOWN_LOCATOR).all();
        for(Locator element : dropDown){
            if(element.textContent().equals(period)){
                element.click();
                break;
            }
        }
    }

    public void selectColor(String color) {
        List<Locator> colorList = page.locator(OrderPageLocators.CHECKBOXES_COLOR_LOCATOR).all();
        for(Locator element : colorList){
            if(element.textContent().equals(color)){
                element.click();
                break;
            }
        }
    }

    public void completeTheOrder() {
        Locator orderButton = page.locator(OrderPageLocators.ORDER_BUTTON_LOCATOR);
        orderButton.click();
        Locator confirm = page.locator(OrderPageLocators.CONFIRM_ORDER_BUTTON_LOCATOR);
        confirm.click();
    }

    public void clickOnNextButton() {
        Locator nextButton = page.locator(OrderPageLocators.NEXT_BUTTON_LOCATOR);
        nextButton.click();
    }

    public String getCreatedOrderStatus() {
        Locator text = page.locator(OrderPageLocators.CREATED_ORDER_STATUS_LOCATOR);
        return text.textContent();
    }

}
