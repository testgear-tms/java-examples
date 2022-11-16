package io.test_gear.samples;

import io.cucumber.junit.platform.engine.Cucumber;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;


@Suite
@SelectClasspathResource("io/test_gear/samples")
public class CucumberTest {
}
