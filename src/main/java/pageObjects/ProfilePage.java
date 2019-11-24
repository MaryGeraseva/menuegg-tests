package pageObjects;

import pageObjects.common.BasePageObject;
import pageObjects.common.Urls;

public class ProfilePage extends BasePageObject {

    public ProfilePage() {
        super(Urls.PROFILE_PAGE.getUrl());
    }
}
