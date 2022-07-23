package EnrichAppLogin;

import io.appium.java_client.android.AndroidDriver;

public class Card_Setting extends Base_Login{
    public Card_Setting(AndroidDriver androidDriver) {
        super(androidDriver);
    }
    String CardActivation = "//android.view.View[@bounds = '[60,956][1020,1178]']";
    String BlockCard = "//android.view.View[@bounds = '[60,689][1020,956]']";
    String ChangeCardPin = "//android.view.View[@bounds = '[60,467][1020,689]']";
    public void clickCardActivation(){
        clickButton(CardActivation);
    }
    public void clickBlockCard(){
        clickButton(BlockCard);
    }
    public void clickChangeCardPin(){
        clickButton(ChangeCardPin);
    }
}
