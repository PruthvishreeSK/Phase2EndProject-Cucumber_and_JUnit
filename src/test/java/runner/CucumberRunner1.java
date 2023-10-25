package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "C:\\Users\\HP\\eclipse-workspace\\PhaseEndProject2\\src\\test\\java\\features\\starHealth.feature",
	glue = {"steps"},
	plugin = {"pretty",
			  "html:target/report1.html",
			  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
			  "timeline:test-output-thread/"	
			  }
		)

public class CucumberRunner1 {

}
