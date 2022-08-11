package EnrichAppLogin;

import io.appium.java_client.android.AndroidDriver;

public class Device_Binding extends Base_Login{
    public Device_Binding(AndroidDriver androidDriver) {
        super(androidDriver);
    }
    public void deviceBindingPopUp(){
        findelement("You are about to switch your device.");
    }
    public void clickYes(){
        clickButton("Yes");
    }
    public void clickContinue(){
        clickButton("Continue");
    }
    public void clickOk(){
        clickButton("Ok");
    }
}
