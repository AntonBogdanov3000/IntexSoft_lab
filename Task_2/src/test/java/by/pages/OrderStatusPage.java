package by.pages;

import by.pages.locators.OrderStatusPageLocators;
import com.microsoft.playwright.Locator;

public class OrderStatusPage extends BasePage {


    public Locator orderNotFound() {
        return page.locator(OrderStatusPageLocators.WRONG_ORDER_PAGE_LOCATOR);
    }

}
