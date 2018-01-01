package pl.sarseth.lotrchallanger.repository.data.providers.scenario;

import pl.sarseth.lotrchallanger.model.game.scenario.Scenario;

import java.util.List;

public interface ScenarioProvider {

    List<Scenario> findAllScenarios();

    Scenario findRandomScenario();

    List<Scenario> findScenarioList(ScenarioSearchParams scenarioSearchParams);
}
