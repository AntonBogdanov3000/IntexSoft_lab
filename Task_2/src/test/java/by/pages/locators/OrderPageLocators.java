package by.pages.locators;

public class OrderPageLocators {


    public final static String ORDER_PAGE_LOCATOR = "//div[starts-with(@class, 'Order_Form')]";
    public final static String NAME_INPUT_LOCATOR = "//div[contains(@class, 'Order_Form')]/div[1]/input";
    public final static String SURNAME_INPUT_LOCATOR = "//div[contains(@class, 'Order_Form')]/div[2]/input";
    public final static String ADDRESS_INPUT_LOCATOR = "//div[contains(@class, 'Order_Form')]/div[3]/input";
    public final static String METRO_INPUT_LOCATOR ="//input[@class='select-search__input']";
    public final static String PHONE_INPUT_LOCATOR = "//div[contains(@class, 'Order_Form')]/div[5]/input";
    public final static String DATE_SELECTOR_LOCATOR = "//div[1]/input[contains(@class, 'Input_Responsible')]";
    public final static String NEXT_BUTTON_LOCATOR = "//div[contains(@class, 'Order_NextButton')]/*";
    public final static String ACCEPT_COOKIES_BUTTON_LOCATOR = "//button[contains(@class,'App_CookieButton')]";
    public final static String ORDER_TIME_LOCATOR = "//div[@class='Dropdown-control']";
    public final static String ORDER_DROPDOWN_LOCATOR = "//div[@class='Dropdown-option']";
    public final static String CHECKBOXES_COLOR_LOCATOR = "//label[contains(@class, 'Checkbox_Label')]";
    public final static String ORDER_BUTTON_LOCATOR = "//div[contains(@class, 'Order_Buttons')]/button[2]";
    public final static String CONFIRM_ORDER_BUTTON_LOCATOR = "//div[contains(@class, 'Order_Modal')]/div[2]/button[2]";
    public final static String CREATED_ORDER_STATUS_LOCATOR = "//div[contains(@class, 'Order_ModalHeader')]";
    public final static String METRO_DROPDOWN_LIST_LOCATOR = "//div[contains(@class, 'Order_Text')]";

}
