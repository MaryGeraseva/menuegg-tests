package pageObjects;

import io.qameta.allure.Step;
import webElements.*;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class LogInPage extends BasePageObject {

    private Button logInButton = new Button(byId("log"));
    private Button registerButton = new Button(byId("reg"));
    private Button signInButton = new Button(byXpath("//div[@class='form-group']/button"));
    private Link logoLink = new Link(byXpath("//div[@class='logo']//a"));
    private Link homeLink = new Link($("#navbar").$(withText("Home")));
    private Link signInTab = new Link($("#link1"));
    private Link signUpTab = new Link($("#link2"));
    private Link forgetPasswordLink = new Link(byXpath("//div[@class='form-group']/a"));
    private TextField singInTabTitle = new TextField($("#link1").$(withText("Sign In")));
    private TextField singUpTabTitle = new TextField($("#link2").$(withText("Sign Up")));
    private TextField registerFormTitle = new TextField($(withText("Create the New Account")));
    private TextField logInFormTitle = new TextField($(withText("Sign In to your Account")));
    private TextField alert = new TextField(byClassName("alert alert-danger"));
    private InputField emailField = new InputField(byId("loginEmail"));
    private InputField passwordField = new InputField(byId("loginPassword"));
    private Checkbox rememberCheckbox = new Checkbox(byName("persistence"));

    public String signInTabText = "Sign In";
    public String logInFormText = "Sign In to your Account";


    public LogInPage() {
        super("https://menuegg-stage.web.app/auth/login");
    }

    @Step("type email")
    private LogInPage typeEmail(String email) {
        emailField.type(email);
        log.info(String.format("typed email %s", email));
        return this;
    }

    @Step("type password")
    private LogInPage typePassword(String password) {
        passwordField.type(password);
        log.info(String.format("typed password %s", password));
        return this;
    }

    @Step("logIn as restaurant owner")
    public ProfilePage logInAsOwner(String email, String password) {
        typeEmail(email);
        typePassword(password);
        signInButton.click();
        return new ProfilePage();
    }

    @Step("logIn as restaurant owner and stay authorised")
    public ProfilePage logInAsOwnerAndStayAuthorised(String email, String password) {
        typeEmail(email);
        typePassword(password);
        rememberCheckbox.select();
        signInButton.click();
        return new ProfilePage();
    }

    @Step("click forget password link")
    public LogInPage clickForgetPasswordLink() {
        forgetPasswordLink.click();
        return this;
    }
}
