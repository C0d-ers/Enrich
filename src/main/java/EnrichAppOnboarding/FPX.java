package EnrichAppOnboarding;

import io.appium.java_client.android.AndroidDriver;

public class FPX extends AppBase{
    public FPX(AndroidDriver androidDriver) {
        super(androidDriver);
    }
    String userId = "//android.widget.EditText[@index = '2']";
    String password = "//android.widget.EditText[@index = '5']";
    String signIn = "//android.widget.Button[@index = '6']";
    String cancel = "//android.widget.Button[@index = '7']";
    String confirm = "//android.widget.Button[@text = 'Confirm']";

    public void clickUserID() throws InterruptedException {
        clickButton(userId);
        driver.getKeyboard().sendKeys("1");
        Thread.sleep(2000);
        driver.getKeyboard().sendKeys("2");
        Thread.sleep(2000);
        driver.getKeyboard().sendKeys("3");
        Thread.sleep(2000);
        driver.getKeyboard().sendKeys("4");

    }
    public void clickPassword() throws InterruptedException {
        clickButton(password);
        driver.getKeyboard().sendKeys("1");
        Thread.sleep(2000);
        driver.getKeyboard().sendKeys("2");
        Thread.sleep(2000);
        driver.getKeyboard().sendKeys("3");
        Thread.sleep(2000);
        driver.getKeyboard().sendKeys("4");
    }
    public void clickSignIn(){
        clickButton(signIn);
    }
    public void clickCancel(){
        clickButton(cancel);
    }
    public void clickConfirm(){
        clickButton(confirm);
    }
}
