package pl.sarseth.lotrchallanger.repository.data.providers.scenario;

import java.util.HashSet;
import java.util.Set;

public class ScenarioRandomizationParams {

    public ScenarioRandomizationParams() {
    }

    private int maxDifficulty = 10;

    private boolean includeSagas = true;

    private Set<String> cycles = new HashSet<>();

    public int getMaxDifficulty() {
        return maxDifficulty;
    }

    public void setMaxDifficulty(int maxDifficulty) {
        this.maxDifficulty = maxDifficulty;
    }

    public boolean isIncludeSagas() {
        return includeSagas;
    }

    public void setIncludeSagas(boolean includeSagas) {
        this.includeSagas = includeSagas;
    }

    public Set<String> getCycles() {
        return cycles;
    }

    public void setCycles(Set<String> cycles) {
        this.cycles = cycles;
    }
}
