package pl.sarseth.lotrchallanger.repository.data.providers.scenario;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.sarseth.lotrchallanger.model.game.scenario.Scenario;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ScenarioProviderBean implements ScenarioProvider {

    private ScenarioCache scenarioCache = new ScenarioCache(); // TODO: do to

    @Override
    public List<Scenario> findAllScenarios() {
        return new ArrayList<>(scenarioCache.getCachedScenarioList());
    }

    @Override
    public Scenario findRandomScenario() {
        List<Scenario> scenarioList = scenarioCache.getCachedScenarioList();
        int randomNumber = new Random().nextInt(scenarioList.size());
        return scenarioList.get(randomNumber);
    }

    @Override
    public List<Scenario> findScenarioList(ScenarioSearchParams scenarioSearchParams) {
        List<Scenario> chosenScenarios = new ArrayList<>(scenarioCache.getCachedScenarioList());

        if (CollectionUtils.isNotEmpty(scenarioSearchParams.getCodes())) {
            chosenScenarios.removeIf(scenario -> !scenarioSearchParams.getCodes().contains(scenario.getCode()));
        }
        if (CollectionUtils.isNotEmpty(scenarioSearchParams.getScenarioTypes())) {
            chosenScenarios.removeIf(scenario -> !scenarioSearchParams.getScenarioTypes().contains(scenario.getType()));
        }
        if (scenarioSearchParams.isOnlyWithNightmare()) {
            chosenScenarios.removeIf(scenario -> scenario.getNightmareDeck() == null);
        }
        if (scenarioSearchParams.getMinDifficulty() != null || scenarioSearchParams.getMaxDifficulty() != null) {
            removeScenariosBasedOnDifficulties(chosenScenarios, scenarioSearchParams);
        }

        return chosenScenarios;
    }

    private void removeScenariosBasedOnDifficulties(List<Scenario> chosenScenarios, ScenarioSearchParams scenarioSearchParams) {
        final Integer max = scenarioSearchParams.getMaxDifficulty() == null ? 10 : scenarioSearchParams.getMaxDifficulty();
        final Integer min = scenarioSearchParams.getMinDifficulty() == null ? 0 : scenarioSearchParams.getMinDifficulty();
        chosenScenarios.removeIf(
                scenario -> scenario.getOfficialDifficulty() != null
                        && scenario.getOfficialDifficulty() < max
                        && scenario.getOfficialDifficulty() > min);
    }
}