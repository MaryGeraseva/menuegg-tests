package pageObjects.examples;

import common.BaseTest;
import reporting.ReplaceCamelCase;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

@DisplayNameGeneration(ReplaceCamelCase.class)
public class Test1 extends BaseTest {

//    @ParameterizedTest(name = "Pet endpoint GET positive test #{0}")
//    @ValueSource(ints = {1, 2, 3})
//    @Step("Pet endpoint GET positive test started")
//    @Description(value = "test checks GET request with valid id, " +
//            "expected response status code 200 and and well-formed json with test data")
//    public void PetGetPositiveTest200(int testId) {
//
//    }


    @ParameterizedTest(name = "test1 #{0}")
    @CsvSource({
            "1",
            "2",
            "3"
    })
    public void test1(int testId) {
        open("https://google.com/ncr");
        $(By.name("q")).val("selenide").pressEnter();
        $$("#res .g").shouldHave(sizeGreaterThan(6));
        $("#res .g").shouldHave(text("selenide.org"));
    }
}
