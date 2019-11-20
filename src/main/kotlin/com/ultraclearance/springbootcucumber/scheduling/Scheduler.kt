package com.ultraclearance.springbootcucumber.scheduling

import com.ultraclearance.springbootcucumber.events.MyEventPublisher
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class Scheduler(val myEventPublisher: MyEventPublisher) {

    @Scheduled(fixedDelayString = "\${scheduling.fixedDelayInMilliseconds}")
    fun scheduleSomething() {
        val randomText = if (Math.random() > 0.5) {
            "Hello"
        } else {
            "Howdy"
        }myEventPublisher.publishEvent(randomText)
    }
}