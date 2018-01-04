package pl.sarseth.lotrchallanger.web.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringConfig {

    public static void main(String... args) {
        SpringApplication.run(ScenarioWebController.class, args);
    }

}
