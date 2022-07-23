package chrome;

import org.openqa.selenium.chrome.ChromeDriver;

public class smsForBOUser extends baseChrome{
    public smsForBOUser(ChromeDriver driver) {
        super(driver);
    }
    public String findOTP(String number){
        String country = "";
        chromeDriver.get("https://enrichuat.mtradeasia.com:8443/smsforbouser");
        System.out.println("Provided Number is : " + number);
        return getotp(number,country);
    }
    public String findOTP(String number,String country){
        chromeDriver.get("https://enrichuat.mtradeasia.com:8443/smsforbouser");
        System.out.println("Provided Number is : " + number);
        return getotp(number,country);
    }
}
