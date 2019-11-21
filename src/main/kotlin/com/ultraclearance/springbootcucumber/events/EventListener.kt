package com.ultraclearance.springbootcucumber.events

import org.slf4j.LoggerFactory
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

private var LOGGER = LoggerFactory.getLogger(EventListener::class.java)

@Component
class EventListener {

    @EventListener(condition = "#myCustomEvent.isHowdy()")
    fun handleEvent(myCustomEvent: MyCustomEvent) {
        LOGGER.info("EventHandler picked up ${myCustomEvent.message}")
    }
}
