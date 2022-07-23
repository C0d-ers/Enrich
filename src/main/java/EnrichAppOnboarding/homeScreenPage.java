package EnrichAppOnboarding;

import io.appium.java_client.android.AndroidDriver;

public class homeScreenPage extends AppBase{
    public homeScreenPage(AndroidDriver androidDriver) {
        super(androidDriver);
    }
    String settings = ":id/fragmentSettingsEnrich";
    String editProfile = ":id/contactName";
    String signOut = ":id/signOutView";
    public void logOut(){
        clickButton(settings);
        clickButton(editProfile);
        clickButton(signOut);
    }
}
