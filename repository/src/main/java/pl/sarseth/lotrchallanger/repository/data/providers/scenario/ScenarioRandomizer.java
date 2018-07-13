package pl.sarseth.lotrchallanger.repository.data.providers.scenario;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import pl.sarseth.lotrchallanger.model.game.scenario.Scenario;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ScenarioRandomizer {

    @Autowired
    private ScenarioCache scenarioCache;

    public Scenario findRandomScenario(ScenarioRandomizationParams params) {
        List<Scenario> scenarioList = scenarioCache.getCachedScenarioList().stream()
                .filter(s -> filterByDifficulty(params, s) && filterByCycles(params, s))
                .collect(Collectors.toList());
        int randomNumber = new Random().nextInt(scenarioList.size());
        return scenarioList.get(randomNumber);
    }

    private boolean filterByCycles(ScenarioRandomizationParams params, Scenario s) {
        return CollectionUtils.isEmpty(params.getCycles()) || params.getCycles().contains(s.getCycle());
    }

    private boolean filterByDifficulty(ScenarioRandomizationParams params, Scenario s) {
        return s.getOfficialDifficulty() == null || s.getOfficialDifficulty() < params.getMaxDifficulty();
    }

}
