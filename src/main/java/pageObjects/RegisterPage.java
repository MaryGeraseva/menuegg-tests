package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import webElements.*;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class RegisterPage extends BasePageObject {

    private Button logInButton = new Button(byId("log"));
    private Button registerButton = new Button(byId("reg"));
    private Button customerButton = new Button($(withText("Customer")));
    private Button ownerButton = new Button($(withText("Restaurant owner")));
    private Button submitButton = new Button($(withText("Submit")));
    private Link logoLink = new Link(byXpath("//div[@class='logo']//a"));
    private Link homeLink = new Link($("#navbar").$(withText("Home")));
    private Link signInTab = new Link($("#link1"));
    private Link signUpTab = new Link($("#link2"));
    private TextField selectRoleTitle = new TextField($(withText("Which one")));
    private TextField singInTabTitle = new TextField($("#link1").$(withText("Sign In")));
    private TextField singUpTabTitle = new TextField($("#link2").$(withText("Sign Up")));
    private TextField registerFormTitle = new TextField($(withText("Create the New Account")));
    private InputField emailField = new InputField(By.id("registerEmail"));
    private InputField passwordField = new InputField(By.id("registerPassword"));
    private InputField confirmPasswordField = new InputField(By.id("registerConfirmPassword"));
//    private InputField promoCodeField = new InputField(byClassName("form-control promocode-input ng-pristine ng-valid ng-touched"));
    private InputField promoCodeField = new InputField(byXpath("//input[@placeholder='Input your promocode']"));
    private Checkbox acceptTermsCheckbox = new Checkbox(byName("acceptTerms"));

    public String selectRoleText = "Which one are you?";
    public String signUpTabText = "Sign Up";
    public String registerFormText = "Create the New Account";


    public RegisterPage() {
        super("https://menuegg-stage.web.app/auth/register");
    }

    @Step("type email")
    private RegisterPage typeEmail(String email) {
        emailField.type(email);
        log.info(String.format("typed email %s", email));
        return this;
    }

    @Step("type password")
    private RegisterPage typePassword(String password) {
        passwordField.type(password);
        log.info(String.format("typed password %s", password));
        return this;
    }

    @Step("confirm password")
    private RegisterPage confirmPassword(String password) {
        confirmPasswordField.type(password);
        log.info(String.format("typed password %s", password));
        return this;
    }

    @Step("select checkbox accept terms")
    private RegisterPage acceptTerms() {
        acceptTermsCheckbox.select();
        return this;
    }

    @Step("type promoCode")
    private RegisterPage typePromoCode(String promoCode) {
        promoCodeField.type(promoCode);
        log.info(String.format("typed promoCode %s", promoCode));
        return this;
    }

    @Step("click submit button")
    private ProfilePage clickSubmitButton() {
        submitButton.click();
        return new ProfilePage();
    }

    @Step("continue as restaurant owner")
    public RegisterPage continueAsOwner() {
        ownerButton.click();
        return this;
    }

    @Step("continue as customer")
    public AppStorePage continueAsCustomer() {
        customerButton.click();
        return new AppStorePage();
    }

    @Step("register new user")
    public ProfilePage registerNewUser(String email, String password, String confPassword, String promoCode) {
        typeEmail(email);
        typePassword(password);
        confirmPassword(confPassword);
        acceptTerms();
        typePromoCode(promoCode);
        clickSubmitButton();
        log.info("registration complete");
        return new ProfilePage();
    }

    @Step("choose signIn tab")
    public LogInPage clickSignInTab() {
        signInTab.click();
        return new LogInPage();
    }
}
