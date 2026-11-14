package flyweight;

public abstract class Map {
    private static final int SIZE = 32;

    protected TileFlyweight[][] grid;

    protected Map() {
        grid = new TileFlyweight[SIZE][SIZE];

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                grid[row][col] = createTile();
            }
        }
    }

    public abstract TileFlyweight createTile();

    public TileFlyweight getTile(int row, int col) {
        validatePosition(row, col);
        return grid[row][col];
    }

    public javafx.scene.image.Image getTileGraphic(int row, int col) {
        return getTile(row, col).getGraphic();
    }

    private void validatePosition(int row, int col) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            throw new IndexOutOfBoundsException("Tile position is outside the map: (" + row + ", " + col + ")");
        }
    }

    public int getSize() {
        return SIZE;
    }
}
