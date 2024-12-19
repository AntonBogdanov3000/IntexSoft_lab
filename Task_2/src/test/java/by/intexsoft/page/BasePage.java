package by.intexsoft.page;

import by.intexsoft.elements.Header;
import com.microsoft.playwright.Page;

public abstract class BasePage {


    public Page page;
    public Header header;

    public BasePage(Page page) {
        this.page = page;
        this.header = new Header(page);
    }

   public abstract boolean isOpened();
}
