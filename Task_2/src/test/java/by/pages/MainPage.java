package by.pages;

import by.components.Header;
import by.pages.locators.MainPageLocators;
import by.utils.BasePageFactory;
import com.microsoft.playwright.Locator;
import io.qameta.allure.Step;
import static by.config.ConfigurationManager.config;

public class MainPage extends BasePage {


    private Header header;

    @Override
    public void initComponents() {
        this.header = new Header(page);
    }

    @Step("Navigate to the main page")
    public MainPage open() {
        page.navigate(config().baseUrl());
        return this;
    }

    @Step("Check for element with text:  <text>")
    public MainPage selectListItem(String listItem) {
        page.locator(MainPageLocators.ITEMS_TEXT_LIST_LOCATOR).getByText(listItem).click();
        return this;
    }

    public OrderPage clickOnOrder() {
        header.clickOnOrderButton();
        return BasePageFactory.createInstance(page, OrderPage.class);
    }

    public OrderStatusPage clickOnGo() {
        header.clickGoButton();
        return BasePageFactory.createInstance(page, OrderStatusPage.class);
    }

    public void clickOnOrderStatus() {
        header.clickOnOrderStatusButton();
    }

    public void inputOrderId(String id) {
        header.inputOrderId(id);
    }

    public void clickOnYandex() {
        header.clickOnYandexLogo();
    }

    public Locator checkText(String text) {
        return page.getByText(text);
    }

}
