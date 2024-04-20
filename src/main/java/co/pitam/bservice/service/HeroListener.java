package co.pitam.bservice.service;


import co.pitam.bservice.model.Hero;
import io.micrometer.tracing.Tracer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Slf4j
@Configuration
public class HeroListener {

    @Bean
    public Consumer<Hero> input(Tracer tracer) {
        return i -> {
            log.info("input sqs: {}", i);
            log.info("<ACCEPTANCE_TEST> <TRACE:{}> Hello from consumer",
                    tracer.currentSpan().context().traceId());
        };
    }
}
