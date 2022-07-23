package EnrichAppLogin;

import io.appium.java_client.android.AndroidDriver;

public class Security_Phrase extends Base_Login {
    public Security_Phrase(AndroidDriver androidDriver) {
        super(androidDriver);
    }
    String phraseBox = "//android.widget.EditText[@text='Add your phrase here']";
    /*String Continue = "//android.widget.Button[@content-desc='Continue']";
    String yes = "//android.widget.Button[@content-desc='Yes']";
    String no = "//android.widget.Button[@content-desc='No']";

     */
    public void enterSecurityPhrase(String phrase) {
        sendText(phraseBox,phrase);
    }
    public void clickContinue(){
        clickButton("Continue");
    }
    public void clickYes(){
        clickButton("Yes");
    }
    public void clickNo(){
        clickButton("No");
    }
}