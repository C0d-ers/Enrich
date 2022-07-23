package chrome;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class mail7 extends baseChrome{
    public mail7(ChromeDriver driver) {
        super(driver);
    }
    By Email = By.xpath("//section[@class='hero my-72 text-center']//input[@name='username']");
    By Submit = By.xpath("//input[@class='button is-primary w-50']");
    By codeIs = By.cssSelector("#BodyPlaceholder_UserVerificationEmailBodySentence2");
    public void createEmail(String email){
        chromeDriver.get("https://mail7.io/");
        enter(Email, email);
        click(Submit);
    }
    public String findOTP() throws InterruptedException {
        return Email_Otp_mail7(codeIs);
    }
}
