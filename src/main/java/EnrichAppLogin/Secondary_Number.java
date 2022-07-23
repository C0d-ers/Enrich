package EnrichAppLogin;

import io.appium.java_client.android.AndroidDriver;

public class Secondary_Number extends Base_Login{

    public Secondary_Number(AndroidDriver androidDriver) {
        super(androidDriver);
    }
    String enterNumber = "//android.view.View[@content-desc=\"Select Country\"]/android.widget.EditText";
    String activationCalendar = "//android.view.View[@text = 'Select Activation Date']";
    public void selectCountry(String country) throws InterruptedException {
        clickButton("Andorra");
        int i;
        for(i=0;i<8;i++){
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
    public void enterNumber(String Num){
        sendText(enterNumber,Num);
    }
    public void enterActivationDate(){
        clickButton("//android.view.View[@text = 'Select Activation Date']");
        clickButton("OK");
    }
    public void clickContinue(){
        clickButton("Continue");
    }
    public void clickConfirm(){
        clickButton("Confirm");
    }
    public void enterOTP(String otp) throws InterruptedException {
        pressInbuiltButton(otp);
    }
    public void clickGotIt(){
        clickButton("Got It");
    }
}
