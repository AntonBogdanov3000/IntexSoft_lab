package by.intexsoft.page;

import by.intexsoft.page.locators.OrderStatusPageLocators;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class OrderStatusPage extends BasePage{


    public OrderStatusPage(Page page) {
        super(page);
    }

    public boolean isOpened() {
        Locator wrongSign = page.locator(OrderStatusPageLocators.WRONG_ORDER_PAGE_LOCATOR);
        return wrongSign.isVisible();
    }
}
