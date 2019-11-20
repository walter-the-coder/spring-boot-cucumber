package com.ultraclearance.springbootcucumber.events

import org.springframework.context.ApplicationEvent

class MyCustomEvent(source: Any, val message: String) : ApplicationEvent(source) {
    fun isHowdy() = (message == "Howdy")
}
