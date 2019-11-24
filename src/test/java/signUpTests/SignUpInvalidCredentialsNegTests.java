package signUpTests;

import common.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pageObjects.RegisterPage;

public class SignUpInvalidCredentialsNegTests extends BaseTest {

    @ParameterizedTest(name = "Sign Up invalid credentials test #{0}")
    @MethodSource("testsData.DataProvider#signUpInvalidCredentialsNegTest")
    @Step("sign up negative test with invalid credentials started")
    @Description("test checks registration as a restaurant owner with invalid credentials and accepting the terms")
    public void signUpInvalidCredentialsNegTests(int testId, String email, String password, String confirmPassword,
                                                 String promoCode, String expectedAlertMessage) {
        RegisterPage registerPage = new RegisterPage();
        registerPage.open();
        assertions.url(registerPage.getExpectedUrl());
        registerPage.continueAsOwner();
        RegisterPage newRegisterPage = registerPage.doInvalidRegistration(email, password, confirmPassword, promoCode);
        assertions.checkAlertMessage(newRegisterPage.getAlertMessage(), expectedAlertMessage);
    }

}
