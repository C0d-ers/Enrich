package EnrichAppOnboarding;

import io.appium.java_client.android.AndroidDriver;

public class enterOTP extends AppBase {
    public enterOTP(AndroidDriver androidDriver) {
        super(androidDriver);
    }
    public void typeOTP(String otp,String decide) throws InterruptedException {
        if (otp.length() != 6) {
            System.out.println("Sorry invalid OTP provided \t length : " + otp.length() + " -> " + otp);
            tearDown();
        }
        else
            pressInbuiltButton(otp, decide);
    }
    String resendCode = ":id/resendOTPTextView";
    public void resendOTP(){
        clickButton(resendCode);
    }
}
