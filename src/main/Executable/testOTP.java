import EnrichAppOnboarding.enterOTP;
import Onboarding.basePage;
import chrome.finexusOTP;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class testOTP extends basePage {
    @Test
    public void finexusOTP(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }

}
