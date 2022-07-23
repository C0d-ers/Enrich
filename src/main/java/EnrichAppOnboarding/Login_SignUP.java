package EnrichAppOnboarding;

import io.appium.java_client.android.AndroidDriver;

public class Login_SignUP extends AppBase {
    public Login_SignUP(AndroidDriver androidDriver) {
        super(androidDriver);
    }
    String logIn = "//android.widget.Button[@content-desc='Login']";
    String PhoneNumber = "//android.widget.EditText[@text='Phone Number']";
    String statusPopUp = "//android.view.View[@index='1']";
    public void enterPhoneNumber(String phoneNumber){
        sendText(PhoneNumber,phoneNumber);
    }
    public void enterPhoneNumberLgn(String phoneNumber){
        sendText(PhoneNumber,phoneNumber);
    }
    public void clickLogin(){
        clickButton(logIn);
    }
    public void clickSignUp(){
        continueButton();
    }
    public void printnumStatus() {
        System.out.println(getAttribute(statusPopUp,"text"));
    }
    public void selectCountry(String country) throws InterruptedException {
        clickButton("+60");
        int i;
        for(i=0;i<7;i++){
            if(findElement(country)) {
                clickButton(country);
                break;
            }
            swipeVertically(0.8F, 0.4F);
            if(i==6){
                System.out.println(country + " not found");
            }
        }
    }
    public void DeviceBindingYes() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElementByAccessibilityId("Yes").click();
        Thread.sleep(3000);
        driver.findElementByAccessibilityId("Continue").click();
    }
}
