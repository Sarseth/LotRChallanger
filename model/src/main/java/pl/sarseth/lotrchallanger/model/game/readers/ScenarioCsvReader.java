package pl.sarseth.lotrchallanger.model.game.readers;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.sarseth.lotrchallanger.model.game.scenario.Scenario;
import pl.sarseth.lotrchallanger.model.game.scenario.ScenarioType;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ScenarioCsvReader {

    private static Logger LOG = LogManager.getLogger(ScenarioCsvReader.class);

    private static String FILE_LOCATION = System.getProperty("user.dir") + "/model/src/main/resources/data/Scenarios.csv";

    private static String DELIMETER = ";";

    public List<Scenario> loadScenarios(String customLocation) {
        List<Scenario> scenarioList = readScenariosFromCsv(customLocation);

        correctScenarioList(scenarioList);

        return scenarioList;
    }

    private List<Scenario> readScenariosFromCsv(String customLocation) {
        List<Scenario> scenarioList = Collections.emptyList();

        try {
            File fileToRead = new File(StringUtils.defaultIfBlank(customLocation, FILE_LOCATION));
            InputStream inputStream = new FileInputStream(fileToRead);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            scenarioList = bufferedReader.lines().map(mapToScenario).collect(Collectors.toList());

            bufferedReader.close();
        } catch (IOException e) {
            LOG.error(e);
        }
        return scenarioList;
    }

    private void correctScenarioList(List<Scenario> scenarioList) {
        int size = scenarioList.size();
        for (int i = 1; i < size; i++) {
            Scenario currentScenario = scenarioList.get(i);
            Scenario previousScenario = scenarioList.get(i - 1);
            correctCurrentScenario(currentScenario, previousScenario);
            if (isPreviousScenarioABox(previousScenario)) {
                scenarioList.remove(--i);
                size = scenarioList.size();
            }
        }
    }

    private void correctCurrentScenario(Scenario currentScenario, Scenario previousScenario) {
        if (currentScenario.getYearOfRelease() == null) {
            currentScenario.setYearOfRelease(previousScenario.getYearOfRelease());
        }
        if (currentScenario.getMonthOfRelease() == null) {
            currentScenario.setMonthOfRelease(previousScenario.getMonthOfRelease());
        }
        if (currentScenario.getCode() == null) {
            currentScenario.setCode(previousScenario.getCode());
        }
        if (currentScenario.getType() == null) {
            currentScenario.setReleased(previousScenario.isReleased()); // Type are missing only on boxes, we want to copy it only from boxes
            currentScenario.setType(previousScenario.getType());
            currentScenario.setCycle(previousScenario.getCycle()); // if type is missing, then cycle is missing as well
        }
    }

    private boolean isPreviousScenarioABox(Scenario previousScenario) {
        // In Core Sets and Deluxe Expansion we have 3 scenarios. The title is just a grouping row. No need for that.
        return (ScenarioType.CORE_SET == previousScenario.getType() || ScenarioType.DELUXE_EXPANSION == previousScenario.getType())
                && previousScenario.getOfficialDifficulty() == null;
    }

    private Function<String, Scenario> mapToScenario = (line) -> {

        String[] args = line.split(DELIMETER, -1);

        if (args.length < 8) {
            System.out.println(args);
        }

        Scenario scenario = new Scenario();
        scenario.setYearOfRelease(StringUtils.isBlank(args[0]) ? null : Integer.valueOf(args[0]));
        scenario.setMonthOfRelease(resolveMonth(args[1]));
        scenario.setCode(args[2]);
        scenario.setName(args[3]);
        scenario.setType(ScenarioType.fromName(args[4]));
        scenario.setCycle(args[5]);
        scenario.setOfficialDifficulty("-".equals(args[6]) || "?".equals(args[6]) ? null : Integer.valueOf(args[6]));
        scenario.setReleased("Released".equals(args[8]));

        return scenario;
    };

    private Integer resolveMonth(String month) {
        switch (month) {
            case "January":
                return 0;
            case "February":
                return 1;
            case "March":
                return 2;
            case "April":
                return 3;
            case "May":
                return 4;
            case "June":
                return 5;
            case "July":
                return 6;
            case "August":
                return 7;
            case "September":
                return 8;
            case "October":
                return 9;
            case "November":
                return 10;
            case "December":
                return 11;
        }
        return null;
    }

}