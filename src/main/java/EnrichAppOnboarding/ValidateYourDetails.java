package EnrichAppOnboarding;

import io.appium.java_client.android.AndroidDriver;

public class ValidateYourDetails extends AppBase{
    public ValidateYourDetails(AndroidDriver androidDriver) {
        super(androidDriver);
    }
    String productDisclosure = ":id/productDisclosureCheckBox";
    String termsAndCondition = ":id/termsAndConditionCheckBox";
    String personalData = ":id/personalDataCheckBox";
    public void clickProductDisclosure(){
        clickButton(productDisclosure);
    }
    public void clickTermsAndCondition(){
        clickButton(termsAndCondition);
    }
    public void clickPersonalData(){
        clickButton(personalData);
    }

}
