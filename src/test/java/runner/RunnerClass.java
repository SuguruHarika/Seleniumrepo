package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(features = {"src/test/java/features/login.feature"},
                 glue ={"stepDefinitions"})

public class RunnerClass extends AbstractTestNGCucumberTests {
}
