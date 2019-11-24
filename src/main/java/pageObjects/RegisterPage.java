package pageObjects;

import io.qameta.allure.Step;
import pageObjects.common.BasePageObject;
import pageObjects.common.Urls;
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
    private TextField alertMessage = new TextField($("div.alert.alert-danger"));
    private InputField emailField = new InputField(byId("registerEmail"));
    private InputField passwordField = new InputField(byId("registerPassword"));
    private InputField confirmPasswordField = new InputField(byId("registerConfirmPassword"));
    private InputField promoCodeField = new InputField(byXpath("//input[@placeholder='Input your promocode']"));
    private Checkbox acceptTermsCheckbox = new Checkbox(byName("acceptTerms"));

    public String selectRoleText = "Which one are you?";
    public String signUpTabText = "Sign Up";
    public String registerFormText = "Create the New Account";


    public RegisterPage() {
        super(Urls.REGISTER_PAGE.getUrl());
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
        log.info(String.format("confirmed password %s", password));
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

    @Step("register new user")
    public RegisterPage doInvalidRegistration(String email, String password, String confPassword, String promoCode) {
        typeEmail(email);
        typePassword(password);
        confirmPassword(confPassword);
        acceptTerms();
        typePromoCode(promoCode);
        clickSubmitButton();
        log.info("invalid registration complete");
        return new RegisterPage();
    }

    @Step("register new user")
    public RegisterPage registerNewUserWithoutTerms(String email, String password, String confPassword, String promoCode) {
        typeEmail(email);
        typePassword(password);
        confirmPassword(confPassword);
        typePromoCode(promoCode);
        clickSubmitButton();
        log.info("invalid registration complete");
        return new RegisterPage();
    }

    @Step("choose signIn tab")
    public LogInPage clickSignInTab() {
        signInTab.click();
        return new LogInPage();
    }

    public String getAlertMessage() {
        return alertMessage.getText();
    }

    public Button getSubmitButton() {
        return submitButton;
    }
}
