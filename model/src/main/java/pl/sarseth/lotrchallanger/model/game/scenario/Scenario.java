package pl.sarseth.lotrchallanger.model.game.scenario;

import java.util.Objects;

public class Scenario {

    private Integer yearOfRelease;

    private Integer monthOfRelease;

    private String code;

    private String name;

    private String cycle;

    private Integer officialDifficulty;

    private ScenarioType type;

    private Scenario nightmareDeck;

    private boolean released;

    public Integer getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(Integer yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public Integer getMonthOfRelease() {
        return monthOfRelease;
    }

    public void setMonthOfRelease(Integer monthOfRelease) {
        this.monthOfRelease = monthOfRelease;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public Integer getOfficialDifficulty() {
        return officialDifficulty;
    }

    public void setOfficialDifficulty(Integer officialDifficulty) {
        this.officialDifficulty = officialDifficulty;
    }

    public ScenarioType getType() {
        return type;
    }

    public void setType(ScenarioType type) {
        this.type = type;
    }

    public Scenario getNightmareDeck() {
        return nightmareDeck;
    }

    public void setNightmareDeck(Scenario nightmareDeck) {
        this.nightmareDeck = nightmareDeck;
    }

    public boolean isReleased() {
        return released;
    }

    public void setReleased(boolean released) {
        this.released = released;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Scenario scenario = (Scenario) o;
        return released == scenario.released &&
                Objects.equals(yearOfRelease, scenario.yearOfRelease) &&
                Objects.equals(monthOfRelease, scenario.monthOfRelease) &&
                Objects.equals(code, scenario.code) &&
                Objects.equals(name, scenario.name) &&
                Objects.equals(cycle, scenario.cycle) &&
                Objects.equals(officialDifficulty, scenario.officialDifficulty) &&
                type == scenario.type &&
                Objects.equals(nightmareDeck, scenario.nightmareDeck);
    }

    @Override
    public int hashCode() {
        return Objects.hash(yearOfRelease, monthOfRelease, code, name, cycle, officialDifficulty, type, nightmareDeck, released);
    }

    @Override
    public String toString() {
        return "Scenario{" +
                "yearOfRelease=" + yearOfRelease +
                ", monthOfRelease=" + monthOfRelease +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", cycle='" + cycle + '\'' +
                ", officialDifficulty=" + officialDifficulty +
                ", type=" + type +
                ", nightmareDeck=" + nightmareDeck +
                ", released=" + released +
                '}';
    }
}
