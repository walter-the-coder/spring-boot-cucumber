package feature

import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(
        strict = true,
        glue = ["feature"],
        stepNotifications = true,
        features = ["src/test/resources/feature"],
        plugin = ["pretty"]
)
class RunCucumberTest
