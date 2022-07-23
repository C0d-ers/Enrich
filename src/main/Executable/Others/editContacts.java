package Others;

import Onboarding.basePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class editContacts extends basePage {
    Contacts one ;
    DesiredCapabilities capabilities = new DesiredCapabilities();
    @BeforeTest
    public void burn() throws MalformedURLException {

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("automationName","UiAutomator2");
        capabilities.setCapability("platformVersion","11.0");
        capabilities.setCapability("deviceName","OPPO CPH2061");  //Xiaomi Redmi K20 Pro   OPPO CPH2061   Android Emulator
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("appPackage","com.google.android.contacts");
        capabilities.setCapability("appActivity","com.android.contacts.activities.PeopleActivity");
        capabilities.setCapability("autoGrantPermissions", "true");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        one = new Contacts(driver);
    }

    @Test(dataProviderClass = data.class, dataProvider = "My Contacts")
    public void start(String name, String num) throws MalformedURLException, InterruptedException {
        //one.deleteAll();
        one.addcontacts(name,num);
    }
}
