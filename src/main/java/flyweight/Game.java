package flyweight;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Random;
import java.util.logging.Logger;

public class Game {
    private static final Logger LOGGER = Logger.getLogger(Game.class.getName());

    public static Map createMap() {
        Random rand = new Random();

        if (rand.nextBoolean()) {
            LOGGER.info("Generating a City Map...");
            return new CityMap();
        } else {
            LOGGER.info("Generating a Wilderness Map...");
            return new WildernessMap();
        }
    }

    public static void main(String[] args) {
        Application.launch(MapApplication.class, args);
    }

    public static class MapApplication extends Application {
        @Override
        public void start(Stage stage) {
            Map map = createMap();
            int mapSize = map.getSize();
            Canvas mapView = new Canvas(
                    mapSize * TileGraphicFactory.TILE_SIZE,
                    mapSize * TileGraphicFactory.TILE_SIZE);
            GraphicsContext graphics = mapView.getGraphicsContext2D();

            for (int row = 0; row < mapSize; row++) {
                for (int col = 0; col < mapSize; col++) {
                    graphics.drawImage(
                            map.getTileGraphic(row, col),
                            col * TileGraphicFactory.TILE_SIZE,
                            row * TileGraphicFactory.TILE_SIZE);
                }
            }

            stage.setTitle("Flyweight Map");
            stage.setScene(new Scene(new StackPane(mapView)));
            stage.show();
        }
    }
}
