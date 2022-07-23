package EnrichAppOnboarding;

import io.appium.java_client.android.AndroidDriver;

public class ruEnrich extends AppBase{
    public ruEnrich(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    String No = ":id/btnNo";
    String Yes = ":id/btnYes";
    String Cancel = ":id/btnNegative";
    String Ok = ":id/btnPositive";

    public void notMember(){
        clickButton(No);
        clickButton(Ok);
    }
    public void yesMember(){
        clickButton(Yes);
    }


}
