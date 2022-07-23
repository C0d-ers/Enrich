package EnrichAppLogin;

import io.appium.java_client.android.AndroidDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Home_Page extends Base_Login{
    public Home_Page(AndroidDriver androidDriver) {
        super(androidDriver);
    }
    String eye = "//android.widget.Button[@index='2']";
    String money = "(//android.view.View[@index='3'])[1]";
    String C2C = "//android.view.View[@content-desc= 'Card to Card']";
    String RequestMoney = "//android.view.View[@content-desc='Request Money']";
    String SplitBill = "//android.view.View[@content-desc='Split Bill']";
    public void clickEye(){
        clickButton(eye);
    }
    public String checkMoney(){
        String value  ="";
        String MyString = getAttribute(money,"text");
        MyString = MyString.replace(" ", "");
        MyString = MyString.replace(",", "");
        MyString = MyString.replace(".", "");
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(MyString);
        while (m.find())
            value = m.group();
        return value;
    }
    public void clickAddMoney(){
        clickButton("Top-Up Money");
    }
    public void clickCurrency(){
        clickButton("Currency");
    }
    public void clickWallet(){
        clickButton("Wallet\nTab 1 of 5");
    }
    public void clickTransactions(){
        clickButton("Transactions\nTab 2 of 5");
    }
    public void clickRewards(){
        clickButton("Rewards\nTab 4 of 5");
    }
    public void clickSettings(){
        clickButton("Settings\nTab 5 of 5");
    }
    public void clickExpenses() {
        clickButton("Expenses");
    }
    public void clickSavings(){
        clickButton("Savings");
    }
    public void clickSend(){clickButton("Send");}
    public void cardToCard(){clickButton(C2C);}
    public void clickRequestMoney(){
        clickButton(RequestMoney);
    }
    public void clickSplitBill(){
        clickButton(SplitBill);
    }
}
