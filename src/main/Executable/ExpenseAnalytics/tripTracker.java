package ExpenseAnalytics;

import EnrichAppExpenseAnalytics.Overview;
import EnrichAppExpenseAnalytics.TripTracker;
import EnrichAppLogin.Home_Page;
import LoginModules.Base_Page;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.Random;

public class tripTracker extends Base_Page {
    Home_Page homePage;
    Overview overview;
    TripTracker tripTracker;
    @Test(priority = 1)
    public void openApp() throws MalformedURLException, InterruptedException {
        setupDevice();

        homePage = new Home_Page(driver);
        overview = new Overview(driver);
        tripTracker = new TripTracker(driver);

        homePage.clickExpenses();
        overview.clickTripTracker();
    }
    @Test(priority = 2,dataProvider = "TripTrackerDetails",dataProviderClass = categorylistDate.class)
    public void startTripTracker(String start, String end) throws IOException, InterruptedException {
        FileInputStream input = new FileInputStream("src/main/Resource/Resource.properties");
        Properties properties = new Properties();
        properties.load(input);

        String startDate =  "07/"+ start +"/2022";
        String endDate = "07/"+ end +"/2022";
        String amt = properties.getProperty("TripTrackerAmount");

        tripTracker.clickAddNewTrip();
        tripTracker.enterPlanName(startPrinting());
        System.out.println(startDate + " - " + endDate);
        tripTracker.sendDate(startDate,endDate);
        if(amt.length()!=0)
            tripTracker.enterAmount(amt);               //providing String value uses exact provided value
        else
            tripTracker.enterAmount(3000);          //providing int value triggers random value of that range
        tripTracker.clickSave();

    }

    public String startPrinting (){
        Random random = new Random();
        int val = random.nextInt(4);
        String tripTracker = "";
        System.out.println(val);
        if(val==0)
            tripTracker = ("Trip to " + randomLocation());
        else if (val == 1)
            tripTracker = ("Hike towards " + randomLocation());
        else if (val == 2)
            tripTracker = ("Travelling in " + randomLocation());
        else
            tripTracker = ("Dream place " + randomLocation());
        System.out.println(tripTracker);
        return tripTracker;
    }
    public String randomLocation(){
        Faker faker = new Faker();
        String location = "";
        Random random = new Random();
        int val = random.nextInt(4);
        if(val==0)
            location = faker.harryPotter().location();
        else if (val == 1)
            location = (faker.leagueOfLegends().location());
        else if (val == 2)
            location = (faker.witcher().location());
        else
            location = (faker.starTrek().location());

        return location;
    }
}
