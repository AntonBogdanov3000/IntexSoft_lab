package by.components;

import com.microsoft.playwright.Page;

public class Header extends BaseComponent{

    public Header(Page page) {
        super(page);
    }

    public void clickOnYandexLogo() {
        page.click("//a[contains(@class, 'Header_LogoYandex')]");
    }

    public void clickOnOrderButton() {
        page.click("//div[contains(@class, 'Header_Nav')]/button[1]");
    }

    public void clickOnOrderStatusButton() {
        page.click("//div[contains(@class, 'Header_Nav')]/button[2]");
    }

    public void inputOrderId(String id) {
        page.locator("//div[contains(@class, 'Input_InputContainer')]/input").fill(id);
    }

    public void clickGoButton() {
        page.locator("//div/button[contains(@class, 'Header_Button')]").click();
    }
}
