import EnrichAppOnboarding.enterOTP;
import Onboarding.basePage;
import chrome.finexusOTP;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class testOTP extends basePage {
    @Test
    public void finexusOTP() throws InterruptedException, MalformedURLException {
        setupDevice();
        Thread.sleep(12000);
        String otp = "111111";
        char[] ch = new char[6];
        String element;
        int i = 0;
        Thread.sleep(2000);
       driver.findElementByAccessibilityId("1").click();
        driver.findElementByAccessibilityId("2").click();
        driver.findElementByXPath("//android.widget.ImageView[@index = '19']").click();
        driver.findElementByAccessibilityId("1").click();
        driver.findElementByAccessibilityId("1").click();
        driver.findElementByAccessibilityId("1").click();
        driver.findElementByAccessibilityId("1").click();
        driver.findElementByAccessibilityId("1").click();
        System.out.println("asdf");

//        while (i < otp.length()) {
//            ch[i] = otp.charAt(i);
//            Thread.sleep(3000);
//            aClass(String.valueOf(ch[i]));
//            System.out.println(ch[i]);
//            System.out.println("tt");
//            i++;
//        }
        Thread.sleep(10000);
        driver.quit();
    }
    public void aClass(String ch){
        String element = "//android.view.View[@content-desc='" + ch + "']";
        driver.findElementByXPath(element).click();
    }
}
