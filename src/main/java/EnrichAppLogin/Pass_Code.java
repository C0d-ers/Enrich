package EnrichAppLogin;

import io.appium.java_client.android.AndroidDriver;

public class Pass_Code extends Base_Login {
    public Pass_Code(AndroidDriver androidDriver) {
        super(androidDriver);
    }
    public void enterPasscode(String password) throws InterruptedException {
        pressInbuiltButton(password);
    }
}
