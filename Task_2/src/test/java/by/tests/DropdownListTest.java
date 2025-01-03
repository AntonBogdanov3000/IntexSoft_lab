package by.tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DropdownListTest extends BaseTest {


    @ParameterizedTest
    @CsvFileSource(resources = "/dropdownListTestData.csv")
    public void testDropDownListItem(String text, String expected) {
        mainPage.setAndConfigurePage(page);
        mainPage.open();
        mainPage.selectListItem(text);
        assertThat(mainPage.checkText(expected)).isVisible();
    }

}
