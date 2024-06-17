package by.intexsoft.tests;

import by.intexsoft.page.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


public class DropdownListTest extends BaseTest {


    @ParameterizedTest
    @CsvFileSource(resources = "/dropdownListTestData.csv")
    public void testDropDownListItem(String listItem, String expected){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnListItem(listItem);
        Assertions.assertEquals(expected, mainPage.getText(), "Result is not equals expected");
    }
}
