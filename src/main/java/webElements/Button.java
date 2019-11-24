package webElements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class Button extends BaseElement {

    public Button(By locator) {
        super(locator);
    }

    public Button(SelenideElement element) {
        super(element);
    }

    public void click() {
        log.info(String.format("click on the button: %s", element.getText()));
        element.click();
    }

    public Boolean isDisable() {
        log.info("check is button disable");
        return element.is(Condition.disabled);
    }
}
