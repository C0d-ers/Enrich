package EnrichAppOnboarding;

import io.appium.java_client.android.AndroidDriver;

public class EmailVerification extends AppBase{
    public EmailVerification(AndroidDriver androidDriver) {
        super(androidDriver);
    }
    String codeTextBox = "//android.widget.EditText[@index='5']";
    String verifyCode = "//android.widget.Button[@text='Verify code']";
    String sendNewCode = "//android.widget.Button[@text= 'Send new code']";
    String changemail = "//android.widget.Button[@text= '']";
    String cnt = "//android.widget.Button[@text='Continue']";

    public void VerifyEmailCode(String emailOTP){
        sendText(codeTextBox, emailOTP);
        clickButton(verifyCode);
    }
    public void verify(){
        clickButton(verifyCode);
    }
    public void resendCode(){
        clickButton(sendNewCode);
    }
    public void changeEmail(){
        clickButton(changemail);
    }
    public void clickContinue(){
        clickButton(cnt);
    }
}
