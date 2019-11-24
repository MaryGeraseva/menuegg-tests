package signInTests;

import common.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pageObjects.LogInPage;

public class SignInNegTests extends BaseTest {

    @ParameterizedTest(name = "Sign in invalid credentials test #{0}")
    @MethodSource("testsData.DataProvider#")
    @Step("sign in negative test with invalid credentials started")
    @Description("test checks sign in as a restaurant owner with invalid credentials")
    public void signInPosTests(int testId, String email, String password, String expectedAlertMessage) {
        LogInPage logInPage = new LogInPage();
        logInPage.open();
        assertions.url(logInPage.getExpectedUrl());
        LogInPage newLoginPage = logInPage.logInWithInvalidCredentials(email, password);
        assertions.checkAlertMessage(newLoginPage.getAlertMessage(), expectedAlertMessage);
    }
}
