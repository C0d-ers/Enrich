package ExpenseAnalytics;

import EnrichAppExpenseAnalytics.Manage_Categories;
import EnrichAppExpenseAnalytics.Overview;
import EnrichAppLogin.Home_Page;
import LoginModules.Base_Page;
import com.github.javafaker.Faker;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Locale;

public class overView extends Base_Page {
    Overview overview;
    Home_Page homePage;
    Manage_Categories manageCategories;
    @BeforeTest
    public void beforeTest() throws IOException, InterruptedException {
        setupDevice();
        //chromeSetup();
        //log_In("5010150055");
        homePage = new Home_Page(driver);
        overview = new Overview(driver);
        manageCategories = new Manage_Categories(driver);
    }
    @Test(priority = 1)
    public void test() throws IOException, InterruptedException {
        //homePage.pressInbuiltButton("123456");
        homePage.swipeVertically(0.5f,0.2f);
        homePage.clickExpenses();
        //overview.checkCategories();
        overview.clickCategoryList();

    }
    @Test(priority = 2, dataProvider = "Custom Category Name",dataProviderClass = categorylistDate.class)
    public void subCategory(String mainCategory, String categoryName) throws IOException, InterruptedException {
        Faker faker = new Faker();

        manageCategories.createSubCategory(mainCategory,faker.witcher().monster());
        //manageCategories.editSubCategory(mainCategory);
    }

    //@AfterTest
    public void afterTest(){
        //sign_out();
        driver.quit();
    }
}
