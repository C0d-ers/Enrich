package EnrichAppLogin;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Online_TopUp extends Base_Login {
    String amt = "//android.widget.EditText[@index='4']";
    String amtLeft = "//android.view.View[@index='5']";
    String bankAccount = "//android.widget.Button[@bounds= '[75,1586][1005,1730]' ]";
    String topupMethodDropDown = "//android.widget.Button[@index='7']";
String onlineBank = "//android.widget.Button[@index='9']";
    public Online_TopUp(AndroidDriver<MobileElement> androidDriver) {
        super(androidDriver);
    }
    public void enterAmount(String amount){
        sendText(amt,amount);
        System.out.println("Topup : " + amount);
    }
    public void select100(){
            clickButton("100");
        System.out.println("Topup : 100");
        }
    public void select200(){
            clickButton("200");
        System.out.println("Topup : 200");
        }
    public void select300(){
            clickButton("300");
        System.out.println("Topup : 300");
        }
    public void topUpMethod(){
            clickButton(topupMethodDropDown);
        }
    public void selectOnlineBank(){
            clickButton("Online Banking");
        }
    public void selectDebitCard(){
            clickButton("Debit Card");
        }
    /*public void bankDropDown(){
            clickButton(bankAccount);
        }

     */
    public void bankDropDown(){
        clickButton(onlineBank);
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
    public void gotIt(){clickButton("Ok, Got It!");}
    public void randomAmount(String amount) {
      int decide = Random(4);
         if (decide == 0)
             enterAmount(amount);
            else if (decide == 1)
                select100();
            else if (decide == 2)
                select200();
            else
                select300();
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
    public void clickOkGotIt(){
        clickButton("Ok, Got It!");
    }
}
