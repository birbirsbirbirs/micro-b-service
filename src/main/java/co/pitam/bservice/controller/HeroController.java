package co.pitam.bservice.controller;

import co.pitam.bservice.model.Hero;
import io.micrometer.observation.annotation.Observed;
import io.micrometer.tracing.Span;
import io.micrometer.tracing.Tracer;
import io.opentelemetry.api.baggage.Baggage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class HeroController {

    private final Tracer tracer;

@Observed(
        name = "demoService"
)
    @GetMapping
    public Hero getHero(@RequestHeader HttpHeaders headers){
    Span span = tracer.currentSpan();
    List<String> power = headers.get("power");
    Faker faker = new Faker();
        Hero hero = Hero.builder()
                .name(faker.name().fullName())
                .power(faker.job().title())
                .build();
        log.info("returning hero: {}", hero);
        Baggage currentBaggage = Baggage.current();
        return hero;
    }
}
