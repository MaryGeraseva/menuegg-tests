package pageObjects.common;

public enum Urls {
    MAIN_PAGE("https://menuegg-stage.web.app/"),
    REGISTER_PAGE("https://menuegg-stage.web.app/auth/register"),
    LOGIN_PAGE("https://menuegg-stage.web.app/auth/login"),
    PROFILE_PAGE("https://menuegg-stage.web.app/profile/restaurant-info"),
    APP_STORE_PAGE("https://www.google.com/gmail/about/");

    private String url;

    Urls (String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
