package EnrichAppLogin;

import io.appium.java_client.android.AndroidDriver;

public class Card_to_Card_Transfer extends Base_Login{
    public Card_to_Card_Transfer(AndroidDriver androidDriver) {
        super(androidDriver);
    }
    String Amount = "//android.widget.EditText[@index = '2']";
    public void enterAmount(String amount){
        sendText(Amount,amount);
    }
    public void select100(){clickButton("100");}
    public void select200(){clickButton("200");}
    public void select300(){clickButton("300");}
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
    public void selectContact(){
        clickButton("Select Contact");
    }
    public void clickYes(){
        clickButton("YES");
    }
    public void clickNo(){
        clickButton("NO");
    }
    public void selectUser(String name){
        if(findElement(name))
            clickButton(name);
    }
    public void clickContinue(){
        Boolean val = findElement("Continue");
        if(val.equals(true))
            clickButton("Continue");
    }
    public void clickConfirm(){
        clickButton("Confirm");
    }
    public void clickAddToFavourite(){
        clickButton("Add to Favourite");
    }
    public void clickDone(){
        clickButton("Got It");
    }

}
