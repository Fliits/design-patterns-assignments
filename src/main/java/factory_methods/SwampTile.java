package factory_methods;

public class SwampTile extends Tile {

    @Override
    public String getCharacter() {
        return "S";
    }

    @Override
    public String getType() {
        return "Swamp tile.";
    }

    @Override
    public void action() {
    }
}
