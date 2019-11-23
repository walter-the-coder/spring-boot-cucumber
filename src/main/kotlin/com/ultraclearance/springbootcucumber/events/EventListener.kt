package com.ultraclearance.springbootcucumber.events

import mu.KotlinLogging
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

private val LOGGER = KotlinLogging.logger {}

@Component
class EventListener {

    @EventListener(condition = "#myCustomEvent.isHowdy()")
    fun handleEvent(myCustomEvent: MyCustomEvent) {
        LOGGER.info("EventHandler picked up ${myCustomEvent.message}")
    }
}
