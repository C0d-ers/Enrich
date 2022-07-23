package EnrichAppOnboarding;

import io.appium.java_client.android.AndroidDriver;

public class BankOccupation extends AppBase{
    public BankOccupation(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    String banklistdropdown = ":id/bankNameSpinner";
    String banknone = "//android.widget.TextView[@text='NONE']";
    String bankAMbank = "//android.widget.TextView[@text='AMBANK']";
    String accountnumber = ":id/editText";
    String occupationlist = ":id/occupationSpinner";
    String businessList = ":id/natureOfBusinessSpinner";
    String companyName = "//android.widget.EditText[@text='Company Name']";
    String sourceOfFund = ":id/sourceOfFundSpinner";


    public void openBankList(){
        clickButton(banklistdropdown);
    }
    public void selectbankNone(){
        clickButton(banknone);
    }
    public void selectAMBank(){
        clickButton(bankAMbank);
    }
    public void enterAccountNumber(String accountNumber){
        sendText(accountnumber, accountNumber);
    }
    public void openOccupationList(){
        clickButton(occupationlist);
    }
    public void selectOccupation(){
        String occupation = "//android.widget.TextView[@index='" + Random(11) + "']";
        clickButton(occupation);
    }
    public Boolean openBusinessList(){
        if(findElement(businessList)) {
            clickButton(businessList);
            System.out.println("True");
            return true;
        }
        else {
            System.out.println("False");
            return false;
        }
    }
    public void selectBusiness(){
            String business = "//android.widget.TextView[@index='" + Random(11) + "']";
            clickButton(business);
    }
    public void enterCompany(String company_Name){
            sendText(companyName,company_Name);
    }
    public void openFundList(){
        clickButton(sourceOfFund);
    }
    public  void selectFund(){
        String source_of_Fund = "//android.widget.TextView[@index='" + Random(9) + "']";
        clickButton(source_of_Fund);
    }


}
