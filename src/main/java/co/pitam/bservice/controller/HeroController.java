package co.pitam.bservice.controller;

import co.pitam.bservice.model.Hero;
import co.pitam.bservice.service.PtmAsynService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class HeroController {
    private final PtmAsynService ptmAsynService;

    @GetMapping
    public Hero getHero(){
        Faker faker = new Faker();
        Hero hero = Hero.builder()
                .name(faker.name().fullName())
                .power(faker.job().title())
                .build();
        log.info("returning hero: {}", hero);
        ptmAsynService.runLog();
        return hero;
    }
}
