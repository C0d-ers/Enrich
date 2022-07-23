package EnrichAppLogin;

import io.appium.java_client.android.AndroidDriver;

public class TopUp_Money extends Base_Login{
    public TopUp_Money(AndroidDriver androidDriver) {
        super(androidDriver);
    }
    public void clickOnlineTopUp (){
        clickButton("Online Top-Up");
    }
}
