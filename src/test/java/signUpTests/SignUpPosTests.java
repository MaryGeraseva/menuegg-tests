package signUpTests;

import assertions.ExtendedAssertions;
import common.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pageObjects.MainPage;
import pageObjects.ProfilePage;
import pageObjects.RegisterPage;

@DisplayName("O#1#A sign Up positive test")
public class SignUpPosTests extends BaseTest {

    @ParameterizedTest(name = "Sign Up positive test #{0}")
    @MethodSource("testsData.DataProvider#signUpPositiveTest")
    @Step("sign up positive test started")
    @Description("test checks registration as a restaurant owner with valid credentials and accepting the terms")
    public void signUpPositiveTest(int testId, String email, String password, String promoCode) {
        MainPage mainPage = new MainPage();
        mainPage.open();
        assertions.url(mainPage.getExpectedUrl());
        RegisterPage registerPage = mainPage.clickRegisterButton();
        assertions.url(registerPage.getExpectedUrl());
        registerPage.continueAsOwner();
        ProfilePage profilePage = registerPage.registerNewUser(email, password, password, promoCode);
        assertions.url(profilePage.getExpectedUrl());
    }
}
