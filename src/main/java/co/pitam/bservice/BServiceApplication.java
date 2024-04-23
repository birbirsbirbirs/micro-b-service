package co.pitam.bservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class BServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BServiceApplication.class, args);
    }

}
