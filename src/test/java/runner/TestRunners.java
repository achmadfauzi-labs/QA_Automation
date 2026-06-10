package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@SuppressWarnings("deprecation")
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps", "hooks"},
        plugin = {
            "pretty",
            "html:target/cucumber-reports.html",
            "json:target/cucumber-reports.json"
        },
        monochrome = true
        // Uncomment to run only specific tags:
        // tags = "@smoke"
        // tags = "@regression"
)
public class TestRunners {
}
