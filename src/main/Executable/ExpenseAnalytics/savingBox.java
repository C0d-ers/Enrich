package ExpenseAnalytics;

import EnrichAppExpenseAnalytics.Overview;
import EnrichAppExpenseAnalytics.SavingBox;
import EnrichAppLogin.Home_Page;
import LoginModules.Base_Page;
import com.github.javafaker.Faker;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class savingBox extends Base_Page {
    Home_Page homePage;
    Overview overview;
    SavingBox savingbox;
    @BeforeTest
    public void beforeTest() throws IOException, InterruptedException {
        setupEmulator();
        //chromeSetup();
        //log_In();
        homePage = new Home_Page(driver);
        overview = new Overview(driver);
        savingbox = new SavingBox(driver);
        homePage.pressInbuiltButton("123456");
        homePage.clickTransactions();
        overview.clickSavingBox();
    }
    @Test(priority = 1, dataProvider = "Saving Box Details",dataProviderClass = categorylistDate.class)
    public void start(String type, String month, String StartDate, String EndDate) throws InterruptedException {
        Faker faker = new Faker();
        String saveName = type + " : " + faker.harryPotter().spell();
        String startDate = month + "/"+StartDate+"/2022";
        String endDate = month + "/"+EndDate+"/2022";

        homePage.clickSavings();
        savingbox.clicktype(type);
        savingbox.addSavingBox(type,saveName,startDate,endDate);
        System.out.println(saveName + "\n" + startDate + " - " + endDate);
    }
}
