package pl.sarseth.lotrchallanger.model.game.scenario;

public enum ScenarioType {

    CORE_SET("Core Set"),
    DELUXE_EXPANSION("Deluxe Expansion"),
    ADVENTURE_PACK("Adventure Pack"),
    SAGA_EXPANSION("Saga Expansion"),
    PRINT_ON_DEMAND("Print on Demand"),
    NIGHTMARE_DECK("Nightmare Deck");

    private String name;

    ScenarioType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static ScenarioType fromName(String name) {
        switch (name) {
            case "Core Set":
                return CORE_SET;
            case "Deluxe Expansion":
                return DELUXE_EXPANSION;
            case "Adventure Pack":
                return ADVENTURE_PACK;
            case "Saga Expansion":
                return SAGA_EXPANSION;
            case "Print on Demand":
                return PRINT_ON_DEMAND;
            case "Nightmare Deck":
                return NIGHTMARE_DECK;
        }
        return null;
    }

}
