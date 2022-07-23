package Others;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Contacts {
    long WAIT = 10;
    AndroidDriver driver;
    public Contacts(AndroidDriver androidDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        driver = androidDriver;
    }
    public void addcontacts(String name, String phoneNumber) throws InterruptedException {
        clickButton("Create contact");

        addNumber(name,"First name");
        addNumber(phoneNumber,"Phone");

        driver.findElementById("com.google.android.contacts:id/toolbar_button").click();
        clickButton("Navigate up");

    }
    public void deleteAll() throws InterruptedException {
        clickButton("More options");
        clickButton("//android.widget.TextView[@text='Select all']");
        clickButton("Delete");
        if(!ifElementExist())
            clickButton("//android.widget.Button[@text = 'Move to Trash']");
        else
            clickButton("//android.widget.Button[@text = 'Delete']");

    }
    public void deleteParticulat(String name,String num) throws InterruptedException {
        clickButton("More options");
        clickButton("//android.widget.TextView[@text='Select']");
        clickButton(name);
        if(!ifElementExist())
            clickButton("//android.widget.Button[@text = 'Move to Trash']");
        else
            clickButton("//android.widget.Button[@text = 'Delete']");

    }
    public void addNumber(String data, String type){
        clickButton("//android.widget.EditText[@text = '" + type + "']");
        driver.getKeyboard().sendKeys(data);
        driver.hideKeyboard();
    }

    public MobileElement waitForVisibility(String id){
        WebDriverWait wait = new WebDriverWait(driver,WAIT);
        char ch = id.charAt(0);
        String c = "/";
        MobileElement element;
        if(ch == c.charAt(0)) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(id)));
            element = (MobileElement) driver.findElementByXPath(id);
        }
        else {
            wait.until(ExpectedConditions.visibilityOfElementLocated(new MobileBy.ByAccessibilityId(id)));
            element = (MobileElement) driver.findElementByAccessibilityId(id);
        }
        return element;
    }
    public void clickButton(String id){
        MobileElement element = waitForVisibility(id);
        element.click();
    }
    public Boolean ifElementExist() throws InterruptedException {
        try{
            Thread.sleep(4000);
            driver.findElementByXPath("//android.widget.Button[@text = 'Delete']");
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }

    }
}
