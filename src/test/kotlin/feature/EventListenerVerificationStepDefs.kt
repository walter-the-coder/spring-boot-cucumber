package feature

import feature.spies.MyEventPublisherSpyStore
import io.cucumber.java8.En
import org.slf4j.LoggerFactory

private var LOGGER = LoggerFactory.getLogger(EventListenerVerificationStepDefs::class.java)

class EventListenerVerificationStepDefs : En {

    init {
        When("an event with message {string} is published") { string: String ->
            LOGGER.info(string)
            Thread.sleep(1500)
            LOGGER.info("We have send ${MyEventPublisherSpyStore.publishedEvents.size} messages")
        }

        Then("our event listener should receive and event with message {string}") { string: String ->
            LOGGER.info(string)
        }
    }
}
