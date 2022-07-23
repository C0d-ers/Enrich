package chrome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class baseChrome {
    ChromeDriver chromeDriver;

    public static final long WAIT = 40;
    public baseChrome(ChromeDriver driver){
        this.chromeDriver =driver;
    }
    public void waitForVisibility(By by){
        WebDriverWait wait = new WebDriverWait(chromeDriver,WAIT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public void click(By by){
        waitForVisibility(by);
        chromeDriver.findElement(by).click();
    }
    public void enter(By by,String data){
        waitForVisibility(by);
        chromeDriver.findElement(by).sendKeys(data);
    }
    public String getText(By by){
        waitForVisibility(by);
        return chromeDriver.findElement(by).getText();
    }
    public String Email_Otp (By by,String dummy_email) {
        click(By.xpath("//strong[normalize-space()='"+ dummy_email +"']"));
        return String_to_Number(getText(by));
    }
    public String Email_Otp_mail7 (By by) throws InterruptedException {
        click(By.xpath("//b[normalize-space()='Malaysia Airlines account email verification code']"));
        Thread.sleep(3000);
        chromeDriver.switchTo().frame(0);
        return String_to_Number(getText(by));
    }
    public static String String_to_Number(String temp_otp) {
        String otp = "";
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(temp_otp);
        while (m.find()) {
            otp = m.group();
        }
        return otp;
    }
    public String fetchOTP(String num,String countryCode){
        WebElement element;
        String BO_number;
        String otp = "";
        for (int i = 1; i < 10; i++) {
            BO_number = getText(By.cssSelector("#mobile-"+i));
            if(("60"+num).equals(BO_number)) {
                String temp_otp = getText(By.cssSelector("#otp-" + i));
                otp = String_to_Number(temp_otp);
                return otp;
            }
            else if((countryCode+num).equals(BO_number)) {
                String temp_otp = getText(By.cssSelector("#otp-" + i));
                otp = String_to_Number(temp_otp);
                return otp;
            }
            System.out.println("Number is : " + BO_number + " and i is : "+ i);
        }
        return  "Number not found";
    }
    public String getotp( String phoneNumber,String countryCode) {
        chromeDriver.navigate().refresh();
        String otp = fetchOTP(phoneNumber,countryCode);
        return otp;
    }
    public String fetchOTPFinexus(String num,String phone,String otpExprsn){
        WebElement element;
        String BO_number;
        String otp = "";
        for (int i = 1; i < 10; i++) {
            BO_number = getText(By.xpath(phone));
            if(("60"+num).equals(BO_number)) {
                String temp_otp = getText(By.xpath(otpExprsn));
                otp = String_to_Number(temp_otp);
                return otp;
            }
            System.out.println("Number is : " + BO_number + " and i is : "+ i);
        }
        return  "Number not found";
    }
    public String getotpFinexus( String phoneNumber,String phone, String otpExprsn) {
        chromeDriver.navigate().refresh();
        String otp = fetchOTPFinexus(phoneNumber,phone,otpExprsn);
        return otp;
    }
}
