package by.intexsoft.tests;

import by.intexsoft.constants.UrlConstants;
import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DropdownListTest extends BaseTest {


    @ParameterizedTest
    @CsvFileSource(resources = "/dropdownListTestData.csv")
    public void testDropDownListItem(String text, String expected) {
        page.navigate(UrlConstants.BASE_URL);
        Assertions.assertTrue(mainPage.isOpened());
        mainPage.clickOnListItem(text);
        Locator result = page.getByText(expected);
        assertThat(result).isVisible();
    }
}
