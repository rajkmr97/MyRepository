package TestRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

		@CucumberOptions(features= {"C:\\Users\\RAJKUMAR\\eclipse-workspace\\Cucumber\\Myntra_BDD\\Myntra_BDD\\features\\login.feature"
		,"C:\\Users\\RAJKUMAR\\eclipse-workspace\\Cucumber\\Myntra_BDD\\Myntra_BDD\\features\\signup.feature"
		,"C:\\Users\\RAJKUMAR\\eclipse-workspace\\Cucumber\\Myntra_BDD\\Myntra_BDD\\features\\payment.feature"
		,"C:\\Users\\RAJKUMAR\\eclipse-workspace\\Cucumber\\Myntra_BDD\\Myntra_BDD\\features\\excelwrite.feature"
		},glue= {"StepDefinition"},
		plugin= {"html:target/cucumber-html-report"
		,"json:target/cucumber/cucumber.json"}
		,dryRun=false)

public class Runner {
	
	private TestNGCucumberRunner testNGCucumberRunner;
	   @BeforeClass(alwaysRun = true)
	   public void setUpClass() throws Exception {    	
	       testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	   }
	   @Test(groups="cucumber scenarios", description="Runs CucumberScenarios", dataProvider = "scenarios")    
	   public void feature(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {
	   	//testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	   	testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());
	   }
	   @DataProvider//(parallel=true)
	   public Object[][] scenarios() {
	      // return testNGCucumberRunner.provideFeatures();    	
	   	return testNGCucumberRunner.provideScenarios();
	   }
	   @AfterClass(alwaysRun = true)
	   public void tearDownClass() throws Exception {    	
	       testNGCucumberRunner.finish();        
	   }
}

		