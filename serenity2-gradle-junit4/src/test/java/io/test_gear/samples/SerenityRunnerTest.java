package io.test_gear.samples;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {
                "io.test_gear.listener.BaseCucumber6Listener",
                "progress",
                "summary"
        },
        features = "src/test/resources/features"
)
public class SerenityRunnerTest {
}