package factory_methods;

public class RoadTile extends Tile{

    @Override
    public String getCharacter() {
        return "R";
    }

    @Override
    public String getType() {
        return "Road tile.";
    }

    @Override
    public void action() {
    }
}
