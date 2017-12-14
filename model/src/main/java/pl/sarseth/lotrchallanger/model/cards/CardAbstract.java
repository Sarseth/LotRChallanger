package pl.sarseth.lotrchallanger.model.cards;

import pl.sarseth.lotrchallanger.model.cards.types.DeckType;

import java.util.Objects;

public abstract class CardAbstract {

    private DeckType deckType;

    private String name;

    private boolean unique;

    private String flavorText;

    private String text;

    private String imagePath;

    public DeckType getDeckType() {
        return deckType;
    }

    public void setDeckType(DeckType deckType) {
        this.deckType = deckType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isUnique() {
        return unique;
    }

    public void setUnique(boolean unique) {
        this.unique = unique;
    }

    public String getFlavorText() {
        return flavorText;
    }

    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CardAbstract that = (CardAbstract) o;
        return unique == that.unique &&
                deckType == that.deckType &&
                Objects.equals(name, that.name) &&
                Objects.equals(flavorText, that.flavorText) &&
                Objects.equals(text, that.text) &&
                Objects.equals(imagePath, that.imagePath);
    }

    @Override
    public int hashCode() {

        return Objects.hash(deckType, name, unique, flavorText, text, imagePath);
    }
}
