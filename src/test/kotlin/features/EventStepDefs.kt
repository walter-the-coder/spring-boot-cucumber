package features

import features.spies.SpyStore
import io.cucumber.java8.En
import io.kotlintest.matchers.shouldBe
import mu.KotlinLogging

private val LOGGER = KotlinLogging.logger {}

class EventStepDefs : En {

    init {
        When("an event with message {string} is published") { message: String ->
            waitForMessageToBePublished(message) shouldBe true
            LOGGER.info("We have sent ${SpyStore.publishedEvents.size} messages")
        }

        Then("our event listener should receive and event with message {string}") { message: String ->
            LOGGER.info("We have received ${SpyStore.publishedEvents.size} messages")
            SpyStore.receivedEvents.contains(message) shouldBe true
        }
    }

    private fun waitForMessageToBePublished(message: String): Boolean {
        var messagePublished = false
        var maxWaitTime = 150

        LOGGER.info("Waiting up to $maxWaitTime milliseconds for event with message=$message to be published")

        while(!messagePublished && maxWaitTime > 0) {
            messagePublished = SpyStore.publishedEvents.contains(message)

            if (!messagePublished) {
                Thread.sleep(50)
                maxWaitTime -= 50
            }
        }
        return messagePublished
    }
}
