package EnrichAppOnboarding;

import io.appium.java_client.android.AndroidDriver;

public class GuardianPage extends AppBase{
    public GuardianPage(AndroidDriver androidDriver) {
        super(androidDriver);
    }
    String relationshipDropDown = ":id/relationShipSpinner";
    String guardianName = ":id/yourNameInputField";
    String nationalityDropDown = ":id/nationalitySpinner";
    String searchBox = ":id/edtDialogSearch";
    String country = ":id/search_list_item_text_view";
    String IDTypeDropDown = ":id/idTypeSpinner";
    String NewIC = "//android.widget.TextView[@text = 'New IC']";
    String idNumber = ":id/idNumberInputField";
    String Passport = "//android.widget.TextView[@text = 'Passport']";
    String CountryOfIssue = ":id/issueCountrySpinner";
    String year = "//android.widget.EditText[@text='2022']";
    String DOByear = "//android.widget.EditText[@text='2004']";
    String issueDate = ":id/issueDateField";
    String expiryDate = ":id/expireDateField";
    String Ok = "android:id/button1";
    String DateOfBirth = ":id/dobInputField";
    String PhoneNumber = ":id/phoneNoEditText";
    String Cancel = ":id/btnNo";
    String Send = ":id/btnYes";
    String Message = ":id/dialogFooter";
    String Message1 = "Send push notification now";
    String Message2 = "Click Share to invite.";
    public void selectRelationship(){
        clickButton(relationshipDropDown);
        String relation = "//android.widget.TextView[@index = '" + Random(10)+ "']" ;
        clickButton(relation);
    }
    public void enterGuardianName(String GuardianName){
        clickButton(guardianName);
        driver.getKeyboard().sendKeys(GuardianName);
        driver.hideKeyboard();
    }
    public void selectMalaysia(String ICnum){
        clickButton(nationalityDropDown);
        sendText(searchBox, "Malaysia");
        clickButton(country);
        clickButton(IDTypeDropDown);
        clickButton(NewIC);
        sendText(idNumber, ICnum);
    }
    public void selectNepal(String passport){
        clickButton(nationalityDropDown);
        sendText(searchBox, "Nepal");
        clickButton(country);
        clickButton(IDTypeDropDown);
        clickButton(Passport);
        sendText(idNumber, passport);
        sendText(CountryOfIssue,"Nepal");
        clickButton(country);

        date_Picker( issueDate,  year, Integer.parseInt(DOB(2019,2022,"")));
        clickButton(Ok);
        date_Picker( expiryDate,  year, Integer.parseInt(DOB(2023,2025,"")));
        clickButton(Ok);
        date_Picker( DateOfBirth, DOByear, Integer.parseInt(DOB(1950,2004,"")));
        clickButton(Ok);
    }
    public void enterNumber(String phoneNum){
        sendText(PhoneNumber,phoneNum);
        continueButton();
    }
    public void clickYes(String popUpMessage){
        System.out.println(popUpMessage);
        clickButton(Send);
    }
    public void clickNo(){
        clickButton(Cancel);
    }
    public void decide(){
        String message = getAttribute(Message,"text");
        if(message.equals(Message1))
            clickYes(Message1);
        else if(message.equals(Message2))
            clickYes(Message2);
        else
            System.out.println("Unknown guardian details entered");
    }
}
