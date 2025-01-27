package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",
				//tags = "@InvalidEmailPasswordCombination",
				glue = {"stepdefinations"},
				plugin = {"pretty",
						"html:target/Cucumberreports/HtmlReport/HTMLreport.html", 
						"json:target/Cucumberreports/Cucumber.json"},
				monochrome = true,
				publish = true)
public class TestRunner extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios(){
		return super.scenarios();
		
	}
	

}
