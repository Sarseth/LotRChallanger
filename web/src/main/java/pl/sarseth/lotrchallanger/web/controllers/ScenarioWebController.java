package pl.sarseth.lotrchallanger.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.sarseth.lotrchallanger.model.game.scenario.Scenario;
import pl.sarseth.lotrchallanger.repository.data.providers.scenario.ScenarioProvider;

import java.util.List;

@Controller
@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages = "pl.sarseth.lotrchallanger.repository.data.providers.scenario")
public class ScenarioWebController {

    @Autowired
    private ScenarioProvider scenarioProvider;

    @RequestMapping("/")
    @ResponseBody
    String test() {
        List<Scenario> allScenarios = scenarioProvider.findAllScenarios();
        return "It's working RICK!";
    }

    public static void main(String... args) {
        SpringApplication.run(ScenarioWebController.class, args);
    }
}
