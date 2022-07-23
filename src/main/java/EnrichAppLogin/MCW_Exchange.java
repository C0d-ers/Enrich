package EnrichAppLogin;

import io.appium.java_client.android.AndroidDriver;

public class MCW_Exchange extends Base_Login{
    public MCW_Exchange(AndroidDriver androidDriver) {
        super(androidDriver);
    }
    String EnterAmount = "//android.widget.EditText[@index = '2']";
    public void clickBuy(){
        clickButton("BUY");
    }
    public void clickSell(){
        clickButton("SELL");
    }
    public void clickCONFIRM(){
        clickButton("CONFIRM");
    }
    public void enterAmount(String amount){
        sendText(EnterAmount, amount);
    }
    public void clickConfirm(){
        clickButton("Confirm");
    }
    public void clickCancel(){
        clickButton("Cancel");
    }
    public void clickDone(){
        clickButton("Done");
    }
}
