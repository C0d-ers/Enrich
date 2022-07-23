package EnrichAppExpenseAnalytics;

import EnrichAppLogin.Base_Login;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;

public class Overview extends Base_Login {
    public Overview(AndroidDriver androidDriver) {
        super(androidDriver);
    }
    String CategoryList = "//android.widget.Button[@index='8']";
    public void clickCategoryList(){
        clickButton(CategoryList);
    }
    public void clickViewTransactions(){
        clickButton("View Transaction");
    }
    public void checkCategories() throws IOException, InterruptedException {
        repeat("Education");
        repeat("Entertainment");
        repeat("Food & Beverage");
        swipeHorizontally(0.8F, 0.4F,0.7F);
        repeat("Health & Beauty");
        repeat("Insurance");
        repeat("Leisure & Sports");
        swipeHorizontally(0.8F, 0.4F,0.7F);
        repeat("Local councils");
        repeat("Medical & Medicines");
        repeat("Money Transfer");
        swipeHorizontally(0.8F, 0.4F,0.7F);
        repeat("Others");
        repeat("Services");
        repeat("Shopping");
        swipeHorizontally(0.8F, 0.4F,0.7F);
        repeat("Telecommunications");
        repeat("Transportation");
        repeat("Travel");
        swipeHorizontally(0.8F, 0.6F,0.7F);
        repeat("Utilities");
    }
    public void repeat(String value) throws IOException, InterruptedException {
        clickButton(value);
        Thread.sleep(4000);
        saveScreenShot(value,"Overview\\Category");
        clickButton("//android.widget.Button[@index='0']");
    }
    public void clickSavingBox() throws InterruptedException {
        Thread.sleep(3000);
        swipeHorizontally(0.8F, 0.4F,0.15F);
        clickButton("Saving Box");
    }
    public void clickTripTracker() throws InterruptedException {
        Thread.sleep(3000);
        swipeHorizontally(0.8F, 0.4F,0.15F);
        clickButton("Trip Tracker");
    }

}
