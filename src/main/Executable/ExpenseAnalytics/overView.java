package ExpenseAnalytics;

import EnrichAppExpenseAnalytics.Manage_Categories;
import EnrichAppExpenseAnalytics.Overview;
import EnrichAppLogin.Home_Page;
import LoginModules.Base_Page;
import com.github.javafaker.Faker;
import org.testng.annotations.AfterTest;
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
        setupEmulator();
        homePage = new Home_Page(driver);
        overview = new Overview(driver);
        manageCategories = new Manage_Categories(driver);
    }
    @Test(priority = 1)
    public void openCategoryList() throws IOException, InterruptedException {
        homePage.pressInbuiltButton("123456");
        homePage.swipeVertically(0.5f,0.2f);
        homePage.clickExpenses();
        overview.clickCategoryList();
    }
    @Test(priority = 2, dataProvider = "Custom Category Name",dataProviderClass = categorylistDate.class)
    public void createSubCategory(String mainCategory, String categoryName) throws IOException, InterruptedException {
        Faker faker = new Faker();
        manageCategories.createSubCategory(mainCategory,faker.starTrek().specie(),8);   //1 - for random icon
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
        //sign_out();
        //driver.quit();
    }
}
