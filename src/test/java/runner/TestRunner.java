package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * TestRunner class which triggers the execution of features files.
 * 
 * @author Thiru
 */
@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src/test/resources/features"},
		glue={"steps"},
		plugin ={"pretty" , "html:src/test/resources/reports"},
		dryRun = true
		)
public class TestRunner {

}
