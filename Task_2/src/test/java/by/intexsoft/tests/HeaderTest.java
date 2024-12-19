package by.intexsoft.tests;

import by.intexsoft.constants.UrlConstants;
import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HeaderTest extends BaseTest{


    @Test
    public void testHeaderLogos() {
        page = context.waitForPage(() -> orderPage.header.clickOnYandexLogo());
        Locator closeButton = page.locator("//span[@tabindex='0']");
        context.waitForCondition(closeButton::isVisible);
        closeButton.click();
        assertThat(closeButton).not().isVisible();
        Assertions.assertTrue(page.url().contains(UrlConstants.YANDEX_URL));
    }
}
