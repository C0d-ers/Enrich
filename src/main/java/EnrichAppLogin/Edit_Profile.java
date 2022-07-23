package EnrichAppLogin;

import io.appium.java_client.android.AndroidDriver;

public class Edit_Profile extends Base_Login{
    public Edit_Profile(AndroidDriver androidDriver) {
        super(androidDriver);
    }
    public void clickSignOut(){
        clickButton("Sign Out");
    }
    public void clickAddSecondaryNumber(){
        clickButton("Add Secondary Number");
    }
}
