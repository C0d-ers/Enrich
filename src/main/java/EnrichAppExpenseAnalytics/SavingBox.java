package EnrichAppExpenseAnalytics;

import EnrichAppLogin.Base_Login;
import io.appium.java_client.android.AndroidDriver;

public class SavingBox extends Base_Login {
    public SavingBox(AndroidDriver androidDriver) {
        super(androidDriver);
    }
    String Travel = "//android.view.View[@bounds = '[78,476][516,914]']";
    String Emergency = "//android.view.View[@bounds = '[564,476][1002,914]']";
    String Family = "//android.view.View[@bounds = '[78,962][516,1400]']";
    String Shopping = "//android.view.View[@bounds = '[564,962][1002,1400]']";
    String Other = "//android.view.View[@bounds = '[78,1448][516,1886]']";

//    String TravelSavingBox = "Add Travel Savings Box";
//    String EmergencySavingBox = "Add Emergency Savings Box";
//    String FamilySavingBox = "Add Family Savings Box";
//    String ShoppingSavingBox = "Add Shopping Savings Box";
//    String OtherSavingBox = "Add Others Savings Box";
    String backButton = "//android.widget.Button[@index ='0']";

    String savingName = "//android.widget.EditText[@text = 'Your Saving Name']";
    String savingAmount = "//android.widget.EditText[@text = 'Enter Amount']";
    String checkBox = "//android.widget.CheckBox[@index = '2']";
    String startDate = "//android.view.View[@text = 'Start Date']";
    String endDate = "//android.view.View[@index= '8']";
    String dateField = "//android.widget.EditText[@index ='1']";
    public void scrollClick(String id) throws InterruptedException {
        if(findElement(id))
            clickButton(id);
        else{
            Thread.sleep(3000);
            swipeVertically(0.8F, 0.2F);
            scrollClick(id);
        }

    }
    public void clickTravel() throws InterruptedException {
        clickButton(Travel);
    }
    public void clickEmergency() throws InterruptedException {
        clickButton(Emergency);
    }
    public void clickFamily() throws InterruptedException {
        clickButton(Family);
    }
    public void clickShopping() throws InterruptedException {
        clickButton(Shopping);
    }
    public void clickOther() throws InterruptedException {
        clickButton(Other);
    }
    public void addSavingBox(String type,String SavingName,String firstDate,String lastDate) throws InterruptedException {
        int amt = Random(9900) + 100;
        scrollClick("Add " + type + " Savings Box");
        //clickButton("Add Others Savings Box");
        sendText(savingName,SavingName);
        sendText(savingAmount, String.valueOf(amt));
        enterDate(startDate,firstDate);
        enterDate(endDate,lastDate);
        if(Random(2) == 1)
            clickButton("Weekly");
        else
            clickButton("Monthly");
        clickButton("Continue");
        clickButton(checkBox);
        clickButton("Continue");
        clickButton("Confirm");
        clickButton("Ok");
        clickButton(backButton);
    }

    public void clicktype(String type){
        if(type.equals("Travel"))
            clickButton(Travel);
        else if(type.equals("Emergency"))
            clickButton(Emergency);
        else if(type.equals("Family"))
            clickButton(Family);
        else if(type.equals("Shopping"))
            clickButton(Shopping);
        else
            clickButton(Other);

    }
}
