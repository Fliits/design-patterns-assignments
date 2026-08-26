package factory_methods;

public class WaterTile extends Tile{
    public String getType() {
        return "Water tile.";
    }
    public String getCharacter(){
        return "W";
    }

    @Override
    public void action() {

    }
}
