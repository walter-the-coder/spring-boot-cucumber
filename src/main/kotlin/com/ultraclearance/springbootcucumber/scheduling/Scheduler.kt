package com.ultraclearance.springbootcucumber.scheduling

import com.ultraclearance.springbootcucumber.events.MyEventPublisher
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

private var LOGGER = LoggerFactory.getLogger(Scheduler::class.java)

@Component
class Scheduler(val myEventPublisher: MyEventPublisher) {
    var counter = 0

    @Scheduled(fixedDelayString = "\${scheduling.fixedDelayInMilliseconds}")
    fun scheduleSomething() {
        val message = everySecondTimeHowdyOrHello()
        LOGGER.info("Publishing event with message $message")
        myEventPublisher.publishEvent(message)
    }

    private fun everySecondTimeHowdyOrHello(): String {
        counter += 1
        return if (counter % 2 == 1) { "Hello" } else { "Howdy" }
    }
}