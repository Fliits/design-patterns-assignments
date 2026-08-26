package factory_methods;

import java.util.Random;

public class WildernessMap extends Map{
    final private static Random rand = new Random();

    @Override
    // creates map of swamp tiles, forest tiles and water tiles
    public Tile createTile() {
        int choice = rand.nextInt(3);

        if (choice == 0) {
            return new SwampTile();
        } else if (choice == 1) {
            return new ForestTile();
        } else {
            return new WaterTile();
        }
    }
}
