package flyweight;

import javafx.scene.image.Image;

public interface TileFlyweight {

    String character();

    String type();

    Image getGraphic();
}
