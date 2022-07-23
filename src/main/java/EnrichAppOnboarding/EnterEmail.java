package EnrichAppOnboarding;

import io.appium.java_client.android.AndroidDriver;

public class EnterEmail extends AppBase{
    public EnterEmail(AndroidDriver androidDriver) {
        super(androidDriver);
    }
    String emailAddress = "//android.widget.EditText[@index='2']";

    String sendVerification = "//android.widget.Button[@text='Send verification code']";

    public void enterEmail(String dummyEmail){
         sendText(emailAddress,dummyEmail);
        clickButton(sendVerification);
    }
}
