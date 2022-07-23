package EnrichAppLogin;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TopUp extends Base_Login {
    String amt = "//android.widget.EditText[@index='3']";
    String amtLeft = "//android.view.View[@index='5']";
    public TopUp(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    public void enterAmount(String amount){
        sendText(amt,amount);
        System.out.println("Topup : " + amount);
    }
    /*public void bankDropDown(){
            clickButton(bankAccount);
        }

     */
    public void bankDropDown(){
        clickButton("Select Bank");
    }
    public void selectBank(){
        clickButton("SBI Bank A");
    }
    public void cancel(){
        clickButton("Cancel");
    }
    public void confirm(){
        clickButton("Confirm");
    }
    public void done(){
        clickButton("Done");
    }
    public void clickLoad(){
        clickButton("Load");
    }
    public String ammountLeftForReload(){
        return getAttribute(amtLeft,"Text");
    }
    public  void clickDone(){
        clickButton("Done");
    }
}
