package EnrichAppExpenseAnalytics;

import EnrichAppLogin.Base_Login;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;

public class Manage_Categories extends Base_Login {
    public Manage_Categories(AndroidDriver androidDriver) {
        super(androidDriver);
    }
    String Name = "//android.widget.EditText[@text = 'Name']";
    String backButton = "(//android.widget.Button[@index = '0']) [1]";
    public void editSubCategory(String mainCategory) throws IOException, InterruptedException {
        clickButton(mainCategory);
        String edit = "(//android.widget.Button[@content-desc='Edit'])[1]";
        String name = "//android.widget.EditText[@index ='3']";
        for(int i =0;i<10;i++){
            if(i==0)
                saveScreenShot("Current",mainCategory);
            if(!findelement(edit)) {
                saveScreenShot("Updated-",mainCategory);
                clickButton(backButton);
                break;
            }
            clickButton(edit);
            String eachCategoryValue = getAttribute(name,"Text");
            System.out.println(eachCategoryValue);
            deleteSubCategory();
        }
        if(mainCategory.equals("Leisure & Sports") || mainCategory.equals("Services"))
            swipeVertically(0.8F,0.5F);
    }
    public void updateSubCategory(String editedName,String name){
        String icon = "//android.widget.Button[@index='4']";
        clearField(name);
        sendText(name,editedName);
        clickButton(icon);
        clickButton("//android.widget.Button[@index = '" + Random(16) + "']");
        clickButton("Save");
        clickButton("Ok");
    }
    public void deleteSubCategory(){
        String delete = "//android.widget.Button[@index = '5']";
        clickButton(delete);
        clickButton("Confirm");
        clickButton("Ok");
    }
    public void createSubCategory(String mainCategory,String categoryName) throws IOException, InterruptedException {
        clickButton(mainCategory);
        //saveScreenShot(categoryName,mainCategory);
        clickButton("New " + mainCategory);
        sendText(Name,categoryName);
        clickButton("Icon");
        clickButton("//android.widget.Button[@index = '" + Random(16) + "']");
        //saveScreenShot(categoryName + " 0",mainCategory);
        clickButton("Save");
        clickButton("Ok");
        clickButton(backButton);
        if(mainCategory.equals("Leisure & Sports") || mainCategory.equals("Services"))
            swipeVertically(0.8F,0.5F);
    }
}
