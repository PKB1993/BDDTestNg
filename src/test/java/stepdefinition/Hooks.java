package stepdefinition;

import org.apache.log4j.Logger;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import testRunner.CucumberRunner;

public class Hooks extends CucumberRunner{
	
	private Logger log = Logger.getLogger(Hooks.class.getName());
	
	/**This methods sets up browser opening configuration before each scenario**/
	@Before
	public void beforeMethod() {
		log.info("Before Scenario Execution");
		openBrowser();
	}
	
	
	/**This methods sets up tear down configuration before each scenario**/
	@After
	public void afterMethod(Scenario scenario) {
		log.info("After Scenario Execution");
		attachScreen(scenario);
		if (scenario.isFailed()) {
		takeScreenShot(scenario);
		}
		quit();
	}
	
}
