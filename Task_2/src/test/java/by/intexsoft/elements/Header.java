package by.intexsoft.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Header {


    public Page page;

    private static final String ORDER_BUTTON_LOCATOR = "//div[contains(@class, 'Header_Nav')]/button[1]";
    private static final String SCOOTER_SIGN_LOCATOR = "//a[contains(@class, 'Header_LogoScooter')]";
    private static final String YANDEX_SIGN_LOCATOR = "//a[contains(@class, 'Header_LogoYandex')]";
    private static final String ORDER_STATUS_BUTTON_LOCATOR = "//div[contains(@class, 'Header_Nav')]/button[2]";
    private static final String ORDER_ID_INPUT_LOCATOR = "//div[contains(@class, 'Input_InputContainer')]/input";
    private static final String GO_BUTTON_LOCATOR = "//div/button[contains(@class, 'Header_Button')]";

    public Header(Page page) {
        this.page = page;
    }

    public void clickOnOrderButton() {
        Locator topMenuItem = page.locator(ORDER_BUTTON_LOCATOR);
        topMenuItem.click();
    }

    public static void clickOnScooterLogo(Page page) {
        Locator logoLocator = page.locator(SCOOTER_SIGN_LOCATOR);
        logoLocator.click();
    }

    public void clickOnYandexLogo() {
        Locator yandexLogo = page.locator(YANDEX_SIGN_LOCATOR);
        yandexLogo.click();
    }

    public void clickOnOrderStatusButton() {
        Locator statusButton = page.locator(ORDER_STATUS_BUTTON_LOCATOR);
        statusButton.click();
    }

    public void inputOrderId(String id) {
        Locator orderIdInput = page.locator(ORDER_ID_INPUT_LOCATOR);
        orderIdInput.fill(id);
    }

    public void clickGoButton() {
        Locator goButton = page.locator(GO_BUTTON_LOCATOR);
        goButton.click();
    }
}
