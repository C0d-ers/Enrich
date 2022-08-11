package EnrichAppExpenseAnalytics;

import EnrichAppLogin.Base_Login;
import io.appium.java_client.android.AndroidDriver;

public class EditTransactionDetails extends Base_Login {

    public EditTransactionDetails(AndroidDriver androidDriver) {
        super(androidDriver);
    }
    String categoryBox = "//android.widget.Button[@index='2']";
    String notes = "//android.widget.EditText[@text = 'Add Notes']";

    public void changeCategory(int i){
        clickButton("//android.view.View[@index='" + i + "']");
    }
    public void clickEditTransaction(){
        clickButton("Edit Transaction");
    }
    public void enterCategoryChange(String mainCategory,String categoryName){
        clickButton(categoryBox);
        clickButton(mainCategory);
        clickButton(categoryName);
    }
    public void enterNotes(String text){
        sendText(notes,text);
    }
    public void clickSaveChanges(){
        clickButton("Save Changes");
    }

}
