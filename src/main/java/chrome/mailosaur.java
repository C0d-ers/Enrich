package chrome;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class mailosaur extends baseChrome{
    public mailosaur(ChromeDriver driver) {
        super(driver);
    }
    By Email = By.cssSelector("#email");
    By Password = By.cssSelector("#password");
    By Submit = By.xpath("//button[@type='submit']");
    By Server = By.cssSelector(".link-cell");
    By codeIs = By.cssSelector("#BodyPlaceholder_UserVerificationEmailBodySentence2");

    public void startMailosaurForOTP(){
        chromeDriver.get("https://mailosaur.com/app/");
    }
    public void logIn(String email, String password){
        chromeDriver.get("https://mailosaur.com/app/");
        enter(Email, email);
        click(Submit);
        enter(Password, password);
        click(Submit);
    }
    public String findOTP(String dummy_Email) {
        return Email_Otp(codeIs,dummy_Email);
    }
}
