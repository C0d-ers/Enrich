package EnrichAppOnboarding;

import io.appium.java_client.android.AndroidDriver;

public class LandingPage extends AppBase {
    public LandingPage(AndroidDriver androidDriver){
        super(androidDriver);
    }
    String Login = "//android.widget.Button[@content-desc='Login']";
    String signUp = "//android.widget.Button[@content-desc='Sign up']";
    public void logIn(){
        clickButton(Login);
    }
    public void signUp(){
        clickButton(signUp);
    }

}
