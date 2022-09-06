package runner;



import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)

@CucumberOptions(
		features= "src/test/java/features", 
        glue= ("steps"),
        publish = true,
        plugin = {"pretty", "html:target/html-reports/report.html"},
        monochrome = true
        
        
)

public class Testrunner  {

}
