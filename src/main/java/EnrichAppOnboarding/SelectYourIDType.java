package EnrichAppOnboarding;

import io.appium.java_client.android.AndroidDriver;

public class SelectYourIDType extends AppBase {
    public SelectYourIDType(AndroidDriver androidDriver) {
        super(androidDriver);
    }
    String NewIC = ":id/idTypeTextView";
    String ICNumber = ":id/editText";
    String countryDropdown = ":id/countrySpinner";
    String countryTextbox = ":id/edtDialogSearch";
    String selectResult = "//android.widget.TextView[@text='NEPAL']";
    String selectPassport = "//android.widget.TextView[@text='Passport']";
    String Idnumber = "//android.widget.EditText[@text='Identification Number']";
    String issuedCountry = ":id/issueCountrySpinner";
    String year = "//android.widget.EditText[@text='2022']";
    String issueDate = "//android.widget.EditText[@text ='Passport Issue Date']";
    String expiryDate = "//android.widget.EditText[@text ='Passport Expiry Date']";
    String Ok = "android:id/button1";
    public void selectMalaysia(String ICnum,String type){
        String DOB;
        clickButton(NewIC);
        if(type.equals("Minor"))
            DOB = DOB(2004,2010,"Malaysia");
        else
            DOB = DOB(1950,2004,"Malaysia");
        sendText(ICNumber,DOB + ICnum);
        continueButton();
    }
    public void selectNepal(String passport,String type){
        clickButton(countryDropdown);
        sendText(countryTextbox,"Nepal");
        clickButton(selectResult);
        clickButton(selectPassport);

        if(type.equals("Minor"))
            sendText(Idnumber,"mID" + passport);
        else
            sendText(Idnumber,"ID" + passport);

        clickButton(issuedCountry);
        sendText(countryTextbox,"Nepal");
        clickButton(selectResult);
        date_Picker( issueDate,  year, Integer.parseInt(DOB(2019,2022,"")));
        clickButton(Ok);
        date_Picker( expiryDate,  year, Integer.parseInt(DOB(2023,2025,"")));
        clickButton(Ok);
        continueButton();
    }

}
