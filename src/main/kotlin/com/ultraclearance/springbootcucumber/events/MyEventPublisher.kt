package com.ultraclearance.springbootcucumber.events

import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

@Component
class MyEventPublisher(var applicationEventPublisher: ApplicationEventPublisher) {

    fun publishEvent(message: String) {
        applicationEventPublisher.publishEvent(
                MyCustomEvent(this, message)
        )
    }
}
