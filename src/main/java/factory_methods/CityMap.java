package factory_methods;

import java.util.Random;

public class CityMap extends Map{
    //creates map of city tiles, road tiles and forest tiles
    final private static Random rand = new Random();

    @Override
    public Tile createTile() {
        int choice = rand.nextInt(3);

        if (choice == 0) {
            return new RoadTile();
        } else if (choice == 1) {
            return new ForestTile();
        } else {
            return new BuildingTile();
        }
    }
}
