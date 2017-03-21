package testing.features;

/**
 * Created by SESA453099 on 21-Mar-17.
 */

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/testing/features/",
        glue = "testing/steps",
        plugin = {"pretty", "html:target/cucumber"} )

public class runTest {
}
