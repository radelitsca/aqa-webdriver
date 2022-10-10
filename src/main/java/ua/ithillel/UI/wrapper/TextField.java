package ua.ithillel.UI.wrapper;

import org.openqa.selenium.WebElement;

public class TextField {

    private WebElement element;

    public TextField(WebElement element) {
        this.element = element;
    }

    public String getValue() {
        return element.getAttribute("value");
    }

    public void setValue(String value) {
        element.clear();
        element.sendKeys(value);
    }
}
