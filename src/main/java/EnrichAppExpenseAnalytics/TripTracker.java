package EnrichAppExpenseAnalytics;

import EnrichAppLogin.Base_Login;
import io.appium.java_client.android.AndroidDriver;

public class TripTracker extends Base_Login {
    public TripTracker(AndroidDriver androidDriver) {
        super(androidDriver);
    }
    String startDate = "//android.view.View[@text = 'Start Date']";
    String endDate = "//android.view.View[@text = 'End Date']";
    String Amount = "//android.widget.EditText[@text = 'Enter Amount MYR']";
    public void clickActive(){
        clickButton("Active\nTab 1 of 2");
    }
    public void clickPast(){
        clickButton("Past\nTab 2 of 2");
    }
    public void clickAddNewTrip(){
        clickButton("Add New Trip");
    }



    public void enterPlanName(String planName){
        sendText("//android.widget.EditText[@text = 'Your Plan']",planName);
    }
    public void sendDate(String StartDate, String EndDate) throws InterruptedException {
        enterDate(startDate,StartDate);
        Thread.sleep(3000);
        enterDate(endDate,EndDate);
    }
    public void enterAmount(String amt){
        sendText(Amount,amt);
    }
    public void enterAmount(int amt){
        String Amt = String.valueOf(Random(amt));
        sendText(Amount,Amt);
    }
    public void clickSave(){
        clickButton("Save");
    }
}
