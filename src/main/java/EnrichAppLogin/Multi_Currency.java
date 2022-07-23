package EnrichAppLogin;

import io.appium.java_client.android.AndroidDriver;

public class Multi_Currency extends Base_Login{
    public Multi_Currency(AndroidDriver androidDriver) {
        super(androidDriver);
    }
    String USD = "(//android.view.View[@index = '1'])[3]";
    String SGD = "(//android.view.View[@index = '2'])[2]";
    public void clickUSD(){
        System.out.println("");
        clickButton(USD);
    }
    public void clickSGD(){clickButton(SGD);}
    public void otherCurrency(int i){
        clickButton("//android.view.View[@index = '" + i + "']");
    }
}
