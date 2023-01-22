package steps;

import io.cucumber.java.AfterAll;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static steps.web.pages.Base.driver;


@RunWith(Cucumber.class)
@CucumberOptions (
        plugin = { "pretty","json:target/cucumber-report/result.json",
                "junit:target/cucumber-report/result.xml",
                "html:target/cucumber-report/result.html"},
        glue = {"steps"},
        features = "src/test/features"
)
public class RunCucumberTest {
}

