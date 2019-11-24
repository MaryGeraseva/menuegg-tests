package webElements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class TextField extends BaseElement {

    public TextField(By locator) {
        super(locator);
    }

    public TextField(SelenideElement element) {
        super(element);
    }

    public String getText() {
        String text = element.shouldBe(Condition.exist).getText();
        log.info(String.format("got text field value: %s", text));
        return text;
    }
}
