package by.intexsoft.page;

import by.intexsoft.page.locators.MainPageLocators;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class MainPage extends BasePage{


    public MainPage(Page page) {
        super(page);
    }

    public boolean isOpened() {
        Locator mainPage = page.locator(MainPageLocators.MAIN_PAGE_LOCATOR);
        return mainPage.isVisible();
   }

    public void clickOnListItem(String listItem) {
        Locator textElement = page.locator(String.format(MainPageLocators.ITEMS_TEXT_LIST_LOCATOR, listItem));
        textElement.click();
    }
}
