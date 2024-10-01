package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
                    glue = {"stepsdefinition"},
                    plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber.jason"},
                    monochrome = true,
                    publish = true
)
public class TestRunner{

}
