package EnrichAppOnboarding;

import io.appium.java_client.android.AndroidDriver;

public class yourAccountIsNowActive extends AppBase {
    String editAddress = ":id/editAddressTextView";

    public yourAccountIsNowActive(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    public void clickEditAddress(){
        clickButton(editAddress);
    }
}
