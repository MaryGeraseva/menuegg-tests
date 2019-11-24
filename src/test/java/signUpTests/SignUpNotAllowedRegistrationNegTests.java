package signUpTests;

import common.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import pageObjects.RegisterPage;

public class SignUpNotAllowedRegistrationNegTests extends BaseTest {

    @ParameterizedTest(name = "Sign Up not allowed registration test #{0}")
    @MethodSource("testsData.DataProvider#signUpNotAllowedRegistrationTest")
    @Step("sign up negative test started")
    @Description("test checks registration as a restaurant owner with accepting the terms " +
            "and without filling out all required fields ")
    public void signUpWithoutRequiredFieldsNegTests(int testId, String email, String password, String confirmPassword,
                                                 String promoCode) {
        RegisterPage registerPage = new RegisterPage();
        registerPage.open();
        assertions.url(registerPage.getExpectedUrl());
        registerPage.continueAsOwner();
        RegisterPage newRegisterPage = registerPage.doInvalidRegistration(email, password, confirmPassword, promoCode);
        Assertions.assertTrue(newRegisterPage.getSubmitButton().isDisable());
    }

    @ParameterizedTest(name = "Sign Up without terms test #{0}")
    @CsvSource({
            "1, 'eggMenuTest@gmail.com', 'testMenu777'",
            "2, 'geraseva@tut.by', 'testMenu777'"
    })
    @Step("sign up negative test without accepting the terms started")
    @Description("test checks registration as a restaurant owner without accepting the terms " +
            "and with valid credentials ")
    public void signUpWithoutAcceptingTermsNegTests(int testId, String email, String password) {
        RegisterPage registerPage = new RegisterPage();
        registerPage.open();
        assertions.url(registerPage.getExpectedUrl());
        registerPage.continueAsOwner();
        RegisterPage newRegisterPage = registerPage.registerNewUserWithoutTerms(email, password, password, "");
        Assertions.assertTrue(newRegisterPage.getSubmitButton().isDisable());
    }
}
