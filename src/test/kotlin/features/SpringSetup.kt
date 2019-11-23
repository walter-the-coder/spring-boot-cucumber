package features

import com.ultraclearance.springbootcucumber.SpringBootCucumberApplication
import io.cucumber.java.Before
import mu.KotlinLogging
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration

private val LOGGER = KotlinLogging.logger {}

@ActiveProfiles("test")
@SpringBootTest(
        classes = [SpringBootCucumberApplication::class],
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
@ContextConfiguration(classes = [TestConfig::class])
class SpringSetup {

    @Before
    fun setup() {
        // This one is necessary in order to pull up the spring context
        LOGGER.info("Started the application")
    }
}
