package co.pitam.bservice.ptmSQS;


import co.pitam.bservice.model.Hero;
import co.pitam.bservice.service.PtmAsynService;
import io.micrometer.tracing.Tracer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class HeroListener {
    private final PtmAsynService ptmAsynService;
    private final Tracer tracer;

    @Bean
    public Consumer<Hero> ptmsqs() {
        return i -> {
            log.info("{}", i);
            ptmAsynService.runLog();
        };
    }
}
