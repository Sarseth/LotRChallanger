package pl.sarseth.lotrchallanger.model.cards;

import pl.sarseth.lotrchallanger.model.cards.types.PlayerCardType;
import pl.sarseth.lotrchallanger.model.cards.types.Sphere;

import java.util.Objects;

public class PlayerCard extends CardAbstract {

    private int cost;

    private PlayerCardType playerCardType;

    private Sphere sphere;

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public PlayerCardType getPlayerCardType() {
        return playerCardType;
    }

    public void setPlayerCardType(PlayerCardType playerCardType) {
        this.playerCardType = playerCardType;
    }

    public Sphere getSphere() {
        return sphere;
    }

    public void setSphere(Sphere sphere) {
        this.sphere = sphere;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        PlayerCard that = (PlayerCard) o;
        return cost == that.cost &&
                playerCardType == that.playerCardType &&
                sphere == that.sphere;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), cost, playerCardType, sphere);
    }
}
