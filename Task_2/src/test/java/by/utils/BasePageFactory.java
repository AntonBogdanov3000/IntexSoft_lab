package by.utils;

import by.pages.BasePage;
import com.microsoft.playwright.Page;


public class BasePageFactory {


    public static <T extends BasePage> T createInstance (final Page page, final Class<T> clazz) {
        try {
            BasePage instance = clazz.getDeclaredConstructor().newInstance();
            instance.setAndConfigurePage(page);
            instance.initComponents();
            return clazz.cast(instance);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        throw new NullPointerException("Error");
    }

}
