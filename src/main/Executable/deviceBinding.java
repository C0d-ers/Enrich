import EnrichAppLogin.Pass_Code;
import EnrichAppLogin.Security_Phrase;
import EnrichAppOnboarding.LandingPage;
import EnrichAppOnboarding.Login_SignUP;
import EnrichAppOnboarding.enterOTP;
import chrome.smsForBOUser;
import Onboarding.basePage;
import io.appium.java_client.TouchAction;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class deviceBinding extends basePage {
    @Test
    public void getDevieBinded() {
        String otp = "";
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher("Confidential! Never share your OTP. You are about to switch new Mobile Device, Code 147376. Expires 09 08 20:45:58");
        while (m.find()) {
            String one = m.group();
            System.out.println(one);
            if(one.length() > 5)
                break;
        }
    }

}
