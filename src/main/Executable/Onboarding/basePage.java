package Onboarding;

import EnrichAppOnboarding.enterOTP;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Random;

public class basePage {
    protected AndroidDriver driver;
    protected ChromeDriver chromeDriver;
    protected EdgeDriver edgeDriver;
    enterOTP OTP;
    String appPackage = "com.malaysiaairlines.enrichprepaidcard.dev";
    DesiredCapabilities cap = new DesiredCapabilities();
    public void setupDevice() throws MalformedURLException {
        cap.setCapability("platformName","Android");
        cap.setCapability("automationName","UiAutomator2");
        cap.setCapability("appium:platformVersion","11.0");
        cap.setCapability("appium:deviceName","OPPO CPH2061");  //Xiaomi Redmi K20 Pro   OPPO CPH2061   Android Emulator
        cap.setCapability("noReset", "true");
        cap.setCapability("appium:appPackage","com.malaysiaairlines.enrichprepaidcard.dev");
        cap.setCapability("appium:appActivity","com.malaysiaairlines.enrichprepaidcard.MainActivity");
        cap.setCapability("autoGrantPermissions", "true");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
    }
    public void setupEmulator() throws MalformedURLException {
        cap.setCapability("platformName","Android");
        cap.setCapability("automationName","UiAutomator2");
        cap.setCapability("platformVersion","12.0");
        cap.setCapability("deviceName","Android Emulator");  //Xiaomi Redmi K20 Pro   OPPO CPH2061   Android Emulator
        cap.setCapability("noReset", "true");
        cap.setCapability("appPackage",appPackage);
        cap.setCapability("appActivity","com.malaysiaairlines.enrichprepaidcard.MainActivity");
        cap.setCapability("autoGrantPermissions", "true");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
    }
    public void chromeSetup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
        chromeDriver = new ChromeDriver();
    }
    public void edgeSetup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Driver\\msedgedriver.exe");
        chromeDriver = new ChromeDriver();
    }
    public void touch(TouchAction<?> action) throws InterruptedException {
        Thread.sleep(2000);
        action.tap(PointOption.point(50, 50)).perform();
    }
    public void tearDown(){
            chromeDriver.quit();
            driver.quit();
    }
    public void continousTouch(TouchAction<?> action) throws InterruptedException {
        for(int i=0;i<=9;i++) {
            Thread.sleep(10000);
            action.tap(PointOption.point(50, 50)).perform();
        }
    }
    public static void scroll(AndroidDriver<MobileElement> driver, TouchAction<?> action, float bottom, float top) throws InterruptedException {
        Dimension dimension = driver.manage().window().getSize();
        int start_x = (int) ((dimension.width) * 0.5);
        int start_y = (int) ((dimension.height) * bottom);
        int end_x = (int) (dimension.width * 0.5);
        int end_y = (int) (dimension.height * top);
        Thread.sleep(2000);
        action.press(PointOption.point(start_x,start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(end_x,end_y)).release().perform();
    }
    public void randomScroll(int range,TouchAction<?> action) throws InterruptedException {
        Random random = new Random();
        int num = random.nextInt(range);
        Thread.sleep(2000);
        if(num != 0) {
            for(int i=0;i<num;i++)
                scroll(driver, action, (float) 0.8, (float) 0.4);
        }
    }
    public String dateForPhrase(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MMMM0dd");
        return formatter.format(date);
    }
    public void enterOTP(String otp) throws InterruptedException {
        OTP = new enterOTP(driver);
        if(otp.length()!=6){
            System.out.println("Sorry invalid OTP provided \t length : " + otp.length() + " -> " + otp);
            tearDown();
        }
        else
            OTP.typeOTP(otp," ");
    }
}
