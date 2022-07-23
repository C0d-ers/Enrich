package EnrichAppLogin;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;
public class Base_Login {
    AndroidDriver driver;
    String devPackage = "com.malaysiaairlines.enrichprepaidcard.dev";
    public static final long WAIT = 40;
    public Base_Login(AndroidDriver androidDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        driver = androidDriver;
    }
    public MobileElement waitForVisibility(String id){
        WebDriverWait wait = new WebDriverWait(driver,WAIT);
        char ch = id.charAt(0);
        String c = "/";
        String d = "(";
        MobileElement element;
        if(ch == c.charAt(0) || ch == d.charAt(0)) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(id)));
            element = (MobileElement) driver.findElementByXPath(id);
        }
        else {
            wait.until(ExpectedConditions.visibilityOfElementLocated(new MobileBy.ByAccessibilityId(id)));
            element = (MobileElement) driver.findElementByAccessibilityId(id);
        }
        return element;
    }
    public void sendText(String id, String text){
        clickButton(id);
        driver.getKeyboard().sendKeys(text);;
        driver.hideKeyboard();
    }
    public void clickButton(String id){
        MobileElement element = waitForVisibility(id);
        element.click();
    }
    public String getAttribute(String id, String attribute){
        MobileElement element = waitForVisibility(id);
        return element.getAttribute(attribute);
    }
    public void continueButton(){
        String id = devPackage + ":id/btnContinue";
        clickButton(id);
    }
    public void pressInbuiltButton(String otp) throws InterruptedException {
        Thread.sleep(2500);
        char[] ch = new char[otp.length()];
        String element;
        for (int i = 0; i < otp.length(); i++) {
            ch[i] = otp.charAt(i);
            clickButton(String.valueOf(ch[i]));
        }
    }
    public void tearDown(){
        if(null!=driver) {
            driver.quit();
        }
    }
    public static int Random(int range){
        Random random = new Random();
        return random.nextInt(range);
    }
    public boolean findElement(String id){
        try{
            char ch = id.charAt(0);
            String c = "/";
            String d = "(";
            Thread.sleep(2000);
            MobileElement element;
            if(ch == c.charAt(0) || ch == d.charAt(0))
                driver.findElement(new By.ByXPath(id)).isDisplayed();
            else
                driver.findElementByAccessibilityId(id).isDisplayed();
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public void saveScreenShot(String photoName,String folder) throws IOException {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("Screenshots//"+ folder + "//" +photoName+".jpg"));
    }
    public void swipeHorizontally(float right, float left,float Yaxis) throws InterruptedException {
        TouchAction<?> action = new TouchAction<>(driver);
        Dimension dimension = driver.manage().window().getSize();
        int start_x = (int) ((dimension.width) * right);
        int start_y = (int) ((dimension.height) * Yaxis);
        int end_x = (int) (dimension.width * left);
        int end_y = (int) (dimension.height * Yaxis);
        Thread.sleep(2000);
        action.press(PointOption.point(start_x,start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(end_x,end_y)).release().perform();
    }
    public void swipeVertically(float bottom, float top) throws InterruptedException {
        TouchAction<?> action = new TouchAction<>(driver);
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
    public void clearField(String id){
        waitForVisibility(id).clear();
    }
    public void backSendText(String id,String text){
        clickButton(id);
        driver.getKeyboard().sendKeys(text);;
        driver.navigate().back();
    }
    public void clickBack(){
        clickButton("Back");
    }
    public void clickHelp(){
        clickButton("Help");
    }
    public void clickGotIt(){
        clickButton("Got It");
    }
    public float randomDecimalAmount(){
        float postfix = (float)(Random(100) * 0.01);
        System.out.println(postfix);
        return postfix;
    }
    public void enterDate(String id, String Date) throws InterruptedException {
        clickButton(id);
        clickButton("Switch to input");
        clearField("//android.widget.EditText[@index ='1']");
        backSendText("//android.widget.EditText[@index ='1']",Date);
        Thread.sleep(2000);
        clickButton("OK");
    }
}


