package factory_methods;

public class BuildingTile extends Tile{
    @Override
    public String getCharacter() {
        return "B";
    }

    @Override
    public String getType() {
        return "Building tile.";
    }

    @Override
    public void action() {

    }
}
