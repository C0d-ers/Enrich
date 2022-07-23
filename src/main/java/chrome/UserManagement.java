package chrome;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserManagement extends baseChrome{
    public UserManagement(ChromeDriver driver) {
        super(driver);
    }
    By Customer = By.cssSelector("a[class='nav-link'] i[class='fa fa-cog text-success']");
    By PhoneNumber = By.cssSelector("input[aria-label='Mobile Filter']");
    By Edit = By.cssSelector(".fa.fa-edit");
    By CardNumberText = By.xpath("//customer-card-detail//div[1]//div[2]");
    By IDNumberText = By.xpath("//input[@name='vModelIdentifcationNumber']");
    public void clickCustomer(){
        chromeDriver.get("https://enrichuat.mtradeasia.com:8443/usermanagement/customer");
    }
    public void searchPhoneNumber(String phoneNumber) throws InterruptedException {
        Thread.sleep(3000);
        enter(PhoneNumber,phoneNumber);
        Thread.sleep(3000);
    }
    public void clickEdit(){
        click(Edit);
    }
    public String getCardN0(){
        return String_to_Number(getText(CardNumberText));
    }
    public String getID(){
        //return getText(IDNumberText).substring(getText(IDNumberText).length() - 4);
        return getText(IDNumberText);
    }
}
