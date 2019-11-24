package signInTests;

import common.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pageObjects.LogInPage;
import pageObjects.MainPage;
import pageObjects.ProfilePage;

public class SignInPosTests extends BaseTest {

    @ParameterizedTest(name = "Sign in positive test #{0}")
    @CsvSource({
            "1, 'englishchenglish@gmail.com', 'testMenu777'",
            "2, 'geraseva@tut.by', 'vfhf1234'"
    })
    @Step("sign in positive test started")
    @Description("test checks sign in as a restaurant owner with valid credentials")
    public void signInPosTests(int testId, String email, String password) {
        MainPage mainPage = new MainPage();
        mainPage.open();
        assertions.url(mainPage.getExpectedUrl());
        LogInPage logInPage = mainPage.clickLogInButton();
        assertions.url(logInPage.getExpectedUrl());
        ProfilePage profilePage = logInPage.logInAsOwner(email, password);
        assertions.url(profilePage.getExpectedUrl());
    }
}
