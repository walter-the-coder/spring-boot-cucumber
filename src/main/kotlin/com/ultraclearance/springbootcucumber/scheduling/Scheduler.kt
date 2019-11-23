package com.ultraclearance.springbootcucumber.scheduling

import com.ultraclearance.springbootcucumber.events.EventPublisher
import mu.KotlinLogging
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

private val LOGGER = KotlinLogging.logger {}

@Component
class Scheduler(val eventPublisher: EventPublisher) {
    var counter = 0

    @Scheduled(fixedDelayString = "\${scheduling.fixedDelayInMilliseconds}")
    fun scheduleSomething() {
        val message = everySecondTimeHowdyOrHello()
        LOGGER.info("Publishing event with message $message")
        eventPublisher.publishEvent(message)
    }

    private fun everySecondTimeHowdyOrHello(): String {
        counter += 1
        return if (counter % 2 == 1) {
            "Hello"
        } else {
            "Howdy"
        }
    }
}
