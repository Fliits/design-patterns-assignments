package flyweight;

import javafx.scene.image.Image;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.util.EnumMap;
import java.util.Map;

public class TileGraphicFactory {

    public static final double TILE_SIZE = 30;
    private static final Map<TileType, TileFlyweight> TILES = new EnumMap<>(TileType.class);

    private TileGraphicFactory() {
    }

    public static TileFlyweight getTile(TileType type) {
        if (type == null) {
            throw new IllegalArgumentException("Tile type cannot be null");
        }
        return TILES.computeIfAbsent(type, TileGraphicFactory::createTile);
    }

    private static TileFlyweight createTile(TileType type) {
        return new TileGraphic(
                type.getCharacter(),
                type.getDescription(),
                createGraphic(type));
    }

    private static Image createGraphic(TileType type) {
        int size = (int) TILE_SIZE;
        WritableImage graphic = new WritableImage(size, size);
        PixelWriter pixels = graphic.getPixelWriter();

        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                pixels.setColor(x, y, x == 0 || y == 0 || x == size - 1 || y == size - 1
                        ? Color.BLACK
                        : type.getColor());
            }
        }

        return graphic;
    }

    private record TileGraphic(String character, String type, Image color) implements TileFlyweight {

        @Override
            public Image getGraphic() {
                return color;
            }
        }
}
