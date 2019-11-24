package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pageObjects.common.BasePageObject;
import pageObjects.common.Urls;
import webElements.Button;

public class MainPage extends BasePageObject {

    private Button logInButton = new Button(By.id("log"));
    private Button registerButton = new Button(By.id("reg"));

    public MainPage() {
        super(Urls.MAIN_PAGE.getUrl());
    }

    @Step("click register button")
    public RegisterPage clickRegisterButton() {
        registerButton.click();
        return new RegisterPage();
    }

    @Step("click logIn button")
    public LogInPage clickLogInButton() {
        logInButton.click();
        return new LogInPage();
    }

}
