package EdgyEyes;

import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.edge.EdgeDriver;

public class baseEdge {
    EdgeDriver Edgedriver;
    Eyes eyes;
    public static final long WAIT = 40;
    public baseEdge(EdgeDriver driver){
        this.Edgedriver = driver ;
    }
    public void setUpEdgeForEyes(){
        System.setProperty("webdriver.edge.driver", "C:\\EdgeDriver\\msedgedriver.exe");
        Edgedriver = new EdgeDriver();
        Edgedriver.get("http://10.10.24.200:8080/");
        Dimension newDimension = new Dimension(500, 1020);
        Edgedriver.manage().window().setSize(newDimension);

        eyes = new Eyes();
        eyes.setApiKey("vhjhWeEI105QWgMhyN8VTMy8GbRvRA2WSq1Sn3hyGPPMQ110");
    }
    public void captureScreen(String appName,String testName){
        eyes.open(Edgedriver,appName, testName);
        eyes.checkWindow();
        eyes.close();
    }
}
