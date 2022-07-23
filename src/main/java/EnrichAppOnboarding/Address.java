package EnrichAppOnboarding;

import io.appium.java_client.android.AndroidDriver;

public class Address extends AppBase{
    public Address(AndroidDriver androidDriver) {
        super(androidDriver);
    }
    String address1 = "//android.widget.EditText[@text='Address Line 1']";
    String address2 = "//android.widget.EditText[@text='Address Line 2']";
    String postalcode = "//android.widget.EditText[@text='Postcode']";
    String toggle = ":id/sameAddressSwitch";
    public void enterAddress1(String streetAddress){
        sendText(address1,streetAddress);
    }
    public void enterAddress2(String secondaryAddress){
        sendText(address2,secondaryAddress);
    }
    public void postalCode(){
        sendText(postalcode,postalCodes());
    }
    public void mailingSameAsResidential(){
        clickButton(toggle);
    }
}