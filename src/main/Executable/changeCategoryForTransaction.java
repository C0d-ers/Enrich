import EnrichAppExpenseAnalytics.EditTransactionDetails;
import EnrichAppExpenseAnalytics.Manage_Categories;
import EnrichAppExpenseAnalytics.Overview;
import EnrichAppLogin.Home_Page;
import ExpenseAnalytics.categorylistDate;
import Onboarding.basePage;
import org.junit.Before;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class changeCategoryForTransaction extends basePage {
    Overview overview;
    Home_Page homePage;
    EditTransactionDetails editTrnsDetails;
    @BeforeTest
    public void beforeTest() throws IOException {
        setupDevice();
        homePage = new Home_Page(driver);
        overview = new Overview(driver);
        editTrnsDetails = new EditTransactionDetails(driver);
    }
    @Test()
    public void test() throws IOException, InterruptedException {
        homePage.clickExpenses();
        Thread.sleep(5000);

        homePage.swipeVertically(0.8f,0.3f);    //managing level for Xpath to work properly

        for(int i = 3;i<8;i++){
            editTrnsDetails.changeCategory(i);
            editTrnsDetails.clickEditTransaction();
            randomCategory(i);
            editTrnsDetails.clickSaveChanges();
        }
    }
    public void randomCategory(int i){
       String cat1 = "Education";
       String subCat1 = "Dance class";
        String cat2 = "Entertainment";
        String subCat2 = "Gaming";
        String cat3 = "Food & Beverage";
        String subCat3 = "Bakery";
        String cat4 = "Health & Beauty";
        String subCat4 = "Body massage";
        String cat5 = "Medical & Medicines";
        String subCat5 = "Dental";
        if(i == 1)
            editTrnsDetails.enterCategoryChange(cat1, subCat1);
        else if(i == 2)
            editTrnsDetails.enterCategoryChange(cat2, subCat2);
        else if(i == 3)
            editTrnsDetails.enterCategoryChange(cat3, subCat3);
        else if(i == 4)
            editTrnsDetails.enterCategoryChange(cat4, subCat4);
        else
            editTrnsDetails.enterCategoryChange(cat5, subCat5);
    }

}
