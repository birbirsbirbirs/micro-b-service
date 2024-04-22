package co.pitam.bservice.ptmSQS;


import co.pitam.bservice.model.Hero;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Slf4j
@Configuration
public class HeroListener {
    @Bean
    public Consumer<Hero> ptmsqs() {
        return i -> log.info("{}", i);
    }
}
