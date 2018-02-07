package pl.sarseth.lotrchallanger.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.sarseth.lotrchallanger.model.game.scenario.Scenario;
import pl.sarseth.lotrchallanger.repository.data.providers.scenario.ScenarioProviderBean;

import java.util.List;

@Controller
@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages = "pl.sarseth.lotrchallanger")
public class ScenarioWebController {

    @Autowired
    private ScenarioProviderBean scenarioProvider;

    @RequestMapping("/scenarios")
    @ResponseBody
    String test() {
        List<Scenario> allScenarios = scenarioProvider.findAllScenarios();
        StringBuilder stringBuilder = new StringBuilder();
        for (Scenario scenario : allScenarios) {
            stringBuilder.append("<td>" + scenario.getName() + "</br></td>");
        }
        return stringBuilder.toString();
    }

    public static void main(String... args) {
        SpringApplication.run(ScenarioWebController.class, args);
    }
}
