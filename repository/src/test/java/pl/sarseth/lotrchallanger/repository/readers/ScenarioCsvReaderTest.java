package pl.sarseth.lotrchallanger.repository.readers;

import org.junit.Test;
import pl.sarseth.lotrchallanger.model.game.scenario.Scenario;
import pl.sarseth.lotrchallanger.repository.data.readers.ScenarioCsvReader;

import java.util.List;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class ScenarioCsvReaderTest {

    private static ScenarioCsvReader scenarioCsvReader = new ScenarioCsvReader();

    @Test
    public void checkIfAllFieldsHasAllScenarios() {
        List<Scenario> scenarioList = scenarioCsvReader.loadScenarios(System.getProperty("user.dir") + "/src/main/resources/data/Scenarios.csv");

        for (Scenario scenario : scenarioList) {
            assertThat("Issue in " + scenario, scenario.getCode(), not(nullValue()));
            assertThat("Issue in " + scenario, scenario.getCycle(), not(nullValue()));
            assertThat("Issue in " + scenario, scenario.getType(), not(nullValue()));
            assertThat("Issue in " + scenario, scenario.getYearOfRelease(), not(nullValue()));
            assertThat("Issue in " + scenario, scenario.getMonthOfRelease(), not(nullValue()));
            assertThat("Issue in " + scenario, scenario.getName(), not(nullValue()));
        }
    }

}
