package EnrichAppOnboarding;

import io.appium.java_client.android.AndroidDriver;

public class reloadYourCardInitial extends AppBase{
    public reloadYourCardInitial(AndroidDriver androidDriver) {
        super(androidDriver);
    }
    String amt = ":id/amountEditText";
    String amt100 = "//android.widget.TextView[@text = '100']";
    String amt200 = "//android.widget.TextView[@text = '200']";
    String amt300 = "//android.widget.TextView[@text = '300']";
    String topupMethodDropDown = ":id/topUpMethodSpinner";
    String onlineBank = "//android.widget.TextView[@text = 'Online Banking']";
    String debitCard = "//android.widget.TextView[@text = 'Debit Card']";
    String bankAccount = ":id/onlineBankSpinner";
    String selectSBIBank = "//android.widget.TextView[@text = 'SBI Bank A']";
    String cancelButton = ":id/btnNegative";
    String confirmButton = ":id/btnPositive";

    public void enterAmount(String amount){
        sendText(amt,amount);
        System.out.println("Topup : " + amount);
    }
    public void select100(){
        clickButton(amt100);
        System.out.println("Topup : 100");
    }
    public void select200(){
        clickButton(amt200);
        System.out.println("Topup : 200");
    }
    public void select300(){
        clickButton(amt300);
        System.out.println("Topup : 300");
    }
    public void topUpMethod(){
        clickButton(topupMethodDropDown);
    }
    public void selectOnlineBank(){
        clickButton(onlineBank);
    }
    public void selectDebitCard(){
        clickButton(debitCard);
    }
    public void bankDropDown(){
        clickButton(bankAccount);
    }
    public void selectBank() throws InterruptedException {
        clickButton(selectSBIBank);
        Thread.sleep(3000);
        continueButton();
    }
    public void cancel(){
        clickButton(cancelButton);
    }
    public void confirm(){
        clickButton(confirmButton);
    }
    public void randomAmount(String amount){
        int decide = Random(4);
        if(decide == 0)
            enterAmount(amount);
        else if (decide == 1)
            select100();
        else if(decide == 2)
            select200();
        else
            select300();
    }
    public void clickDone(){
        continueButton();
        continueButton();
    }
}
