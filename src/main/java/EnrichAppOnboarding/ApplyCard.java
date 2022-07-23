package EnrichAppOnboarding;

import io.appium.java_client.android.AndroidDriver;

public class ApplyCard extends AppBase{

    public ApplyCard(AndroidDriver androidDriver) {
        super(androidDriver);
    }
    String checkBox1 = "(//android.widget.CheckBox[@index = '0']) [1]";
    String checkBox2 = "(//android.widget.CheckBox[@index = '0']) [2]";
    String next = ":id/btnNext";
    String confirm = ":id/btnPositive";
    String cancel = ":id/btnNegative";

    public void apply(){
        clickButton(checkBox1);
        clickButton(checkBox2);
        clickButton(next);
        clickButton(confirm);
    }
}
