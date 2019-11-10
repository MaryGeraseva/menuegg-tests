package signUpTests;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Sign Up positive test")
public class SignUpPositiveTest {

    @ParameterizedTest(name = "O#1#A sign up positive test")
    @CsvSource({
        "1, 'tomsmith', 'SuperSecretPassword!'",
                "2, 'user', 'password'"
    })
    @Step("sign up positive test started")
    @Description("test checks registration as a restaurant owner with valid credentials and accept the terms")
    public void signUpPositiveTest() {

    }
}
