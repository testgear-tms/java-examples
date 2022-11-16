package io.test_gear.samples;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        plugin = {
                "io.test_gear.listener.BaseCucumber6Listener",
                "progress",
                "summary"
        }
)
public class CucumberTest {
}
