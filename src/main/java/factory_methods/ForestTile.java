package factory_methods;

public class ForestTile extends Tile{

    @Override
    public String getCharacter() {
        return "F";
    }

    @Override
    public String getType() {
        return "Forest tile.";
    }

    @Override
    public void action() {
    }
}
