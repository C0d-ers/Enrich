package EnrichAppLogin;

import io.appium.java_client.android.AndroidDriver;

public class Local_Bank_Transfer extends Base_Login{
    public Local_Bank_Transfer(AndroidDriver androidDriver) {
        super(androidDriver);
    }
    String Amount = "//android.widget.EditText[@index = '2']";
    String BankDropDown = "//android.view.View[@index = '5']";
    String AccountNumber = "//android.widget.EditText[@index = '6']";
    String ReceipientRef = "//android.widget.EditText[@index = '7']";
    String Other = "//android.widget.EditText[@index = '8']";
    String toggle = "//android.widget.Switch[@index = '16']";

    public void newTransfer(){
        clickButton("New Transfer");
    }
    public void select100(){clickButton("100");}
    public void select200(){clickButton("200");}
    public void select300(){clickButton("300");}
    public void enterAmount(String amount){
        sendText(Amount,amount);
    }
    public void randomAmount(String amount){
        int decide = Random(6);
        if(decide == 0){
            select100();
            System.out.println("100");
        }
        else if (decide == 1) {
            select200();
            System.out.println("200");
        }
        else if(decide == 2) {
            select300();
            System.out.println("300");
        }
        else {
            enterAmount(amount);
            System.out.println(amount);
        }
    }
    public void openBankList(){clickButton(BankDropDown);}
    public void selectBank(){
        clickButton("AMBANK MALAYSIA BERHAD");
    }
    public void enterAccountNum(String AccNum){
        sendText(AccountNumber,AccNum);
    }
    public void enterReceipientRef(String text){
        sendText(ReceipientRef,text);
    }
    public void enterOther(String text){
        sendText(Other,text);
    }
    public void clickContinue(){clickButton("Continue");}
    public void favouriteToogle(){clickButton(toggle);}
    public void clickConfirm(){clickButton("Confirm");}
    public void clickDone(){clickButton("Done");}



}
