package EnrichAppOnboarding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
public class AppBase {
     AndroidDriver driver;
    public static final long WAIT = 40;
    public AppBase(AndroidDriver androidDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        driver = androidDriver;
    }
    public MobileElement waitForVisibility(String id){
        WebDriverWait wait = new WebDriverWait(driver,WAIT);
        String prefixPackage = "com.malaysiaairlines.enrichprepaidcard.dev";
        char ch = id.charAt(0);
        String c = "/";
        String d = "(";
        MobileElement element;
        if(ch == c.charAt(0) || ch == d.charAt(0)) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(id)));
            element = (MobileElement) driver.findElementByXPath(id);
        }
        else if(id.equals("android:id/button1")){
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
            element = (MobileElement) driver.findElementById(id);
        }
        else {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id( prefixPackage + id)));
            element = (MobileElement) driver.findElementById( prefixPackage + id );
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
        String id = ":id/btnContinue";
        clickButton(id);
    }
    public void pressInbuiltButton(String otp,String decide) throws InterruptedException {
        Thread.sleep(2500);
        char[] ch = new char[otp.length()];
        String element;
        for (int i = 0; i < otp.length(); i++) {
            ch[i] = otp.charAt(i);
            if(decide == "SignUp")
                element = "//android.widget.TextView[@text='" + ch[i] + "']";
            else
                element = "//android.view.View[@content-desc='" + ch[i] + "']";
            clickButton(element);
        }
    }
    public void tearDown(){
        if(null!=driver) {
            driver.quit();
        }
    }
    public static String DOB(int start, int end,String nation) {

        Random random = new Random();
        int minDay = (int) LocalDate.of(start, 1, 1).toEpochDay();
        //LocalDateTime maxDay = LocalDateTime.now();
        int maxDay = (int) LocalDate.of(end,1,1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);

        LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
        DateTimeFormatter myFormatObj;
        if(nation.equals("Malaysia"))
            myFormatObj= DateTimeFormatter.ofPattern("yyMMdd");
        else
            myFormatObj = DateTimeFormatter.ofPattern("yyyy");
        return randomBirthDate.format(myFormatObj);
    }
    public void date_Picker(String element,String year, int toEnter){
        clickButton(element);
        clickButton(year);
        driver.getKeyboard().pressKey(""+toEnter);
    }
    public static int Random(int range){
        Random random = new Random();
        return random.nextInt(range);
    }
    public static String postalCodes(){
        String[] postcodes = {"01500","05500","10500","15500","20500","25500","30500","40500","70500","75500","80500","88500","93500"};
        int i = Random(13);
        System.out.print("postCodes -> " + postcodes[i]);
        return postcodes[i];
    }
    public String decideGender(int random){
        if(random==3){
            int i = Random(4);
            System.out.println("3rd Gender -> " + i);
            if(i%2==0)
                return "Male";
            else
                return "Female";
        }
        else if(random == 1)
            return "Male";
        else
            return "Female";
    }
    public boolean findElement(String id){
        try{
            Thread.sleep(2000);
            driver.findElement(By.id(id)).isDisplayed();
            return true;
        }catch(Exception e){
            return false;
        }
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
}


