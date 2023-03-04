package cucumberOptions;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        glue = "stepdifinition",
        plugin = {"pretty"},
        features = "src/test/resources/features",
        tags = "@tc1"
)
public class RunTest {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setupClass(){
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
    @Test(groups = "cucumber", dataProvider = "scenarios")
    public void runScenario(PickleWrapper picke, FeatureWrapper cucumberFeature){
        testNGCucumberRunner.runScenario(picke.getPickle());
    }

    @DataProvider
    public Object[][] scenarios(){
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass(){
        testNGCucumberRunner.finish();
    }
}