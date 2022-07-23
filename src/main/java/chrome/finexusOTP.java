package chrome;

import org.openqa.selenium.chrome.ChromeDriver;

public class finexusOTP extends baseChrome{
    public finexusOTP(ChromeDriver driver) {
        super(driver);
    }
    String PhoneNumber = "//tbody/tr[1]/td[4]";
    String Otp = "//tbody/tr[1]/td[5]";

    public String findOTP(String number){
        chromeDriver.get("https://dev.finexusgroup.com:4023/mta/uat/cwws/showotp.jsp");
        return getotpFinexus(number,PhoneNumber,Otp);
    }

}
