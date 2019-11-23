package features

import com.ultraclearance.springbootcucumber.events.EventListener
import com.ultraclearance.springbootcucumber.events.EventPublisher
import com.ultraclearance.springbootcucumber.events.MyCustomEvent
import features.spies.SpyStore
import io.mockk.every
import io.mockk.spyk
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary

@TestConfiguration
class TestConfig {

    @Primary
    @Bean
    fun eventPublisherSpy(applicationEventPublisher: ApplicationEventPublisher): EventPublisher {
        val eventPublisher = EventPublisher(applicationEventPublisher)
        val spy = spyk(eventPublisher)
        every { spy.publishEvent(any()) } answers { args ->
            val message = args.invocation.args[0] as String
            SpyStore.publishedEvents.add(message)
            args.invocation.originalCall()
        }
        return spy
    }

    @Primary
    @Bean
    fun eventListenerSpy(): EventListener {
        val eventListener = EventListener()
        val spy = spyk(eventListener)
        every { spy.handleEvent(any()) } answers { args ->
            val event = args.invocation.args[0] as MyCustomEvent
            SpyStore.receivedEvents.add(event.message)
            args.invocation.originalCall()
        }
        return spy
    }
}
