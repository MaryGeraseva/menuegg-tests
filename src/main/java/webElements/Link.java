package webElements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class Link extends BaseElement{

    public Link(By locator) {
        super(locator);
    }

    public Link(SelenideElement element) {
        super(element);
    }

    public void click() {
        log.info(String.format("click on the link: %s", element.getText()));
        element.click();
    }
}
