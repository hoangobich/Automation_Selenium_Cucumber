package stepdifinition;

import common.DriverBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class ServiceHook {
    DriverBase driverBase = new DriverBase();
    @Before
    public void initTest() {
        driverBase.setup();
    }

    @After
    public void afterHooks(Scenario scenario){
        if(scenario.isFailed()){
            scenario.attach(((TakesScreenshot) DriverBase.driver).getScreenshotAs(OutputType.BYTES),
                    "image/png","image");
        }
        driverBase.tearDown();
    }
}