package flyweight;

import java.util.Random;

public class CityMap extends Map {
    //creates map of city tiles, road tiles and forest tiles
    private static final Random rand = new Random();

    @Override
    public TileFlyweight createTile() {
        int choice = rand.nextInt(3);

        if (choice == 0) {
            return TileGraphicFactory.getTile(TileType.ROAD);
        } else if (choice == 1) {
            return TileGraphicFactory.getTile(TileType.FOREST);
        } else {
            return TileGraphicFactory.getTile(TileType.BUILDING);
        }
    }
}
