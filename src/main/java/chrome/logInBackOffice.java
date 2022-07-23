package chrome;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class logInBackOffice extends baseChrome{
    public logInBackOffice(ChromeDriver driver) {
        super(driver);
    }
    By userName = By.xpath("//input[@placeholder='Username']");
    By passWord = By.xpath("//input[@placeholder='Password']");
    By userManagement = By.xpath("//a[normalize-space()='User Management']");
    By logIn = By.cssSelector("button[name='submit']");
    By Menu =By.cssSelector("button[class='navbar-toggler d-lg-none']");
    public void visitBO(){
        chromeDriver.get("https://enrichuat.mtradeasia.com:8443/dashboard");
    }
    public void enterUserName(String UserName){
        enter(userName,UserName);
    }
    public void enterPassword(String Password){
        enter(passWord,Password);
    }
    public void clickLogIn(){
        click(logIn);
    }
    public void clickUserManagement(){
        click(Menu);
        click(userManagement);
    }
}
