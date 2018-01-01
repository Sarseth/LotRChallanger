package pl.sarseth.lotrchallanger.repository.data.providers.scenario;

import pl.sarseth.lotrchallanger.model.game.scenario.Scenario;
import pl.sarseth.lotrchallanger.repository.data.readers.ScenarioCsvReader;

import java.util.List;

public class ScenarioCache {

    private List<Scenario> cachedScenarioList;

    private ScenarioCsvReader scenarioCsvReader;

    public ScenarioCache() {
        scenarioCsvReader = new ScenarioCsvReader();
        cachedScenarioList = scenarioCsvReader.loadScenarios(null);
    }

    List<Scenario> getCachedScenarioList() {
        return cachedScenarioList;
    }
}
