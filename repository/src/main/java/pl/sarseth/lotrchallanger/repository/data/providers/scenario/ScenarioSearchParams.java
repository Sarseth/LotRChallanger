package pl.sarseth.lotrchallanger.repository.data.providers.scenario;

import pl.sarseth.lotrchallanger.model.game.scenario.ScenarioType;

import java.util.EnumSet;
import java.util.List;

public class ScenarioSearchParams {

    private List<String> codes;

    private EnumSet<ScenarioType> scenarioTypes;

    private Integer maxDifficulty;

    private Integer minDifficulty;

    private boolean onlyWithNightmare = false;

    public List<String> getCodes() {
        return codes;
    }

    public void setCodes(List<String> codes) {
        this.codes = codes;
    }

    public EnumSet<ScenarioType> getScenarioTypes() {
        return scenarioTypes;
    }

    public void setScenarioTypes(EnumSet<ScenarioType> scenarioTypes) {
        this.scenarioTypes = scenarioTypes;
    }

    public Integer getMaxDifficulty() {
        return maxDifficulty;
    }

    public void setMaxDifficulty(Integer maxDifficulty) {
        this.maxDifficulty = maxDifficulty;
    }

    public Integer getMinDifficulty() {
        return minDifficulty;
    }

    public void setMinDifficulty(Integer minDifficulty) {
        this.minDifficulty = minDifficulty;
    }

    public boolean isOnlyWithNightmare() {
        return onlyWithNightmare;
    }

    public void setOnlyWithNightmare(boolean onlyWithNightmare) {
        this.onlyWithNightmare = onlyWithNightmare;
    }
}
