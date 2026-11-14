package flyweight;

import javafx.scene.paint.Color;

public enum TileType {
    FOREST("F", "Forest tile.", Color.FORESTGREEN),
    ROAD("R", "Road tile.", Color.DIMGRAY),
    WATER("W", "Water tile.", Color.ROYALBLUE),
    BUILDING("B", "Building tile.", Color.SANDYBROWN),
    SWAMP("S", "Swamp tile.", Color.DARKOLIVEGREEN);

    private final String character;
    private final String description;
    private final Color color;

    TileType(String character, String description, Color color) {
        this.character = character;
        this.description = description;
        this.color = color;
    }

    public String getCharacter() {
        return character;
    }

    public String getDescription() {
        return description;
    }

    public Color getColor() {
        return color;
    }
}
