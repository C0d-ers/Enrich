package EnrichAppLogin;

import io.appium.java_client.android.AndroidDriver;

public class New_Card_Activation extends Base_Login{
    public New_Card_Activation(AndroidDriver androidDriver) {
        super(androidDriver);
    }
    String CardNumber = "//android.widget.EditText[@index='3']";
    String IdNumber = "//android.widget.EditText[@index='5']";
    public void enterCardNumber (String Cardnum){
        sendText(CardNumber,Cardnum);
    }
    public void enterIdNumber(String IDnum){
        sendText(IdNumber,IDnum);
    }
    public void clickActiveCardNow(){
        clickButton("Active Card Now");
    }
    public void clickDone(){
        clickButton("Done");
    }
}
