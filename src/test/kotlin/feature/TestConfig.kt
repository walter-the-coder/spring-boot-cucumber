package feature

import com.ultraclearance.springbootcucumber.events.MyEventPublisher
import feature.spies.MyEventPublisherSpyStore
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
    fun myEventPublisher(applicationEventPublisher: ApplicationEventPublisher): MyEventPublisher {
        val myEventPublisher = MyEventPublisher(applicationEventPublisher)
        val spy = spyk(myEventPublisher)
        every { spy.publishEvent(any()) } answers {args ->
            MyEventPublisherSpyStore.publishedEvents.add(args.toString())
            args.invocation.originalCall()
        }
        return spy
    }
}
