package pageObjects;

import pageObjects.common.BasePageObject;
import pageObjects.common.Urls;

public class AppStorePage extends BasePageObject {

    public AppStorePage() {
        super(Urls.APP_STORE_PAGE.getUrl());
    }
}
