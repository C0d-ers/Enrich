package EnrichAppOnboarding;

import io.appium.java_client.android.AndroidDriver;

public class PersonalDetails extends AppBase{
    public PersonalDetails(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    String titleDropdown = ":id/designationSpinner";
    String title = "//android.widget.TextView[@index='0']";
    String fullName = ":id/yourNameEditText";
    String appName = ":id/displayInCardEditText";
    String dateOfBirth = "//android.widget.EditText[@text='Date Of Birth']";
    String year = "//android.widget.EditText[@text='2010']";
    String mothermaidenname = ":id/motherMaidenNameEditText";
    String Ok = "android:id/button1";
    String promocode = "//android.widget.EditText[@text = 'Referral / Promo code (Optional)']";

    public void selectTitle(){
        for(int i =0; i<4;i++) {
            try {
                clickButton(titleDropdown);
                break;
            } catch (Exception e) {
                System.out.println(i + " Time");
            }
        }
        String Title = "//android.widget.TextView[@index='" + Random(4) + "']";
        clickButton(Title);
    }
    public void nameAsPerIC(){
        clickButton(fullName);
    }
    public void preferredName(){
        clickButton(appName);
    }
    public void enterDOB(int BirthDate){
        date_Picker(dateOfBirth,year, BirthDate);
        clickButton(Ok);
    }
    public void gender(){
        String gender = decideGender(4);
        String xender = "//android.widget.TextView[@text='"+ gender +"']";
        clickButton(xender);
    }
    public void motherMaidenName(String motherMaidName){
        sendText(mothermaidenname,motherMaidName);
    }
    public void promoCode(String Code){
        sendText(promocode,Code);
        continueButton();
    }

}
