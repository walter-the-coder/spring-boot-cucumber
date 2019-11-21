package feature

import com.ultraclearance.springbootcucumber.SpringBootCucumberApplication
import com.ultraclearance.springbootcucumber.events.MyEventPublisher
import io.cucumber.java.Before
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration

private var LOGGER = LoggerFactory.getLogger(SpringSetup::class.java)

@ActiveProfiles("test")
@SpringBootTest(
        classes = [SpringBootCucumberApplication::class],
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
@ContextConfiguration(classes = [TestConfig::class])
@DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
class SpringSetup {

    @Autowired
    private lateinit var myEventPublisher: MyEventPublisher

    @Before
    fun setup() {
        // This one is necessary in order to pull up the spring context
        LOGGER.info("Started the application")
    }
}
