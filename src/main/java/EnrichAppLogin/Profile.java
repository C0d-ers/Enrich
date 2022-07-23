package EnrichAppLogin;

import io.appium.java_client.android.AndroidDriver;

public class Profile extends Base_Login{
    public Profile(AndroidDriver androidDriver) {
        super(androidDriver);
    }
    public void clickSignOut(){
        clickButton("Sign Out");
    }
    public void clickYes(){
        clickButton("Yes");
    }
}
