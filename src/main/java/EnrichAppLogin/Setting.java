package EnrichAppLogin;

import io.appium.java_client.android.AndroidDriver;

public class Setting extends Base_Login{
    public Setting(AndroidDriver androidDriver) {
        super(androidDriver);
    }
    public void clickEditProfile(){
        clickButton("Edit Profile\nChange personal info");
    }
    public void clickCardSetting(){
        clickButton("Card Settings");
    }
}
