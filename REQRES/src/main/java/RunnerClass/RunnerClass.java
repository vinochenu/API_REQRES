package RunnerClass;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="FeatureFiles",glue="classpath:StepDefinition_api",
dryRun=false,
monochrome=true,
tags= {"@reqres_API", "@REGISTER_SUCCESS"}
)

public class RunnerClass {

}
