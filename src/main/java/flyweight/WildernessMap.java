package flyweight;

import java.util.Random;

public class WildernessMap extends Map {
    private static final Random rand = new Random();

    @Override
    // creates map of swamp tiles, forest tiles and water tiles
    public TileFlyweight createTile() {
        int choice = rand.nextInt(3);

        if (choice == 0) {
            return TileGraphicFactory.getTile(TileType.SWAMP);
        } else if (choice == 1) {
            return TileGraphicFactory.getTile(TileType.FOREST);
        } else {
            return TileGraphicFactory.getTile(TileType.WATER);
        }
    }
}
