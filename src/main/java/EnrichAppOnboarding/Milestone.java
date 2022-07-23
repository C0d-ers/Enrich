package EnrichAppOnboarding;

import io.appium.java_client.android.AndroidDriver;

public class Milestone extends AppBase{
    public Milestone(AndroidDriver androidDriver) {
        super(androidDriver);
    }
    String gotIt = ":id/btnLetsBegin";

    public void GotIt(){
        clickButton(gotIt);
    }
}
