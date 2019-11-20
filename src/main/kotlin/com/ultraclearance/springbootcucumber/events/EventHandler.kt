package com.ultraclearance.springbootcucumber.events

import org.slf4j.LoggerFactory
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

private var LOGGER = LoggerFactory.getLogger(EventHandler::class.java)

@Component
class EventHandler {

    @EventListener(condition = "#myCustomEvent.isHowdy()")
    fun handleEvent(myCustomEvent: MyCustomEvent) {
        LOGGER.info(myCustomEvent.message)
    }
}