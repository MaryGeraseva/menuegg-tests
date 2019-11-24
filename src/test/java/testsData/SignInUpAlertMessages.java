package testsData;

public enum SignInUpAlertMessages {

    EMAIL_INVALID("The email address is badly formatted."),
    PASSWORD_NOT_MATCH("Passwords do not match"),
    PROMOCODE_INVALID("This promocode is not valid");

    private String message;

    SignInUpAlertMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
