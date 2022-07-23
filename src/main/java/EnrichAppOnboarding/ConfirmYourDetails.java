package EnrichAppOnboarding;

import io.appium.java_client.android.AndroidDriver;

public class ConfirmYourDetails extends AppBase{
    public ConfirmYourDetails(AndroidDriver androidDriver) {
        super(androidDriver);
    }
    String productDisclosure = ":id/productDisclosureCheckBox";
    String termsAndCondition = ":id/termsAndConditionCheckBox";
    String personalData = ":id/personalDataCheckBox";
    String editInfo = ":id/editInfoTextView";
    public void clickProductDisclosure(){
        clickButton(productDisclosure);
    }
    public void clickTermsAndCondition(){
        clickButton(termsAndCondition);
    }
    public void clickPersonalData(){
        clickButton(personalData);
    }
    public void clickEditInfo(){
        clickButton(editInfo);
    }

}
