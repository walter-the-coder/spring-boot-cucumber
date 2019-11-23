package com.ultraclearance.springbootcucumber

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class SpringBootCucumberApplication

fun main(args: Array<String>) {
    runApplication<SpringBootCucumberApplication>(*args)
}
