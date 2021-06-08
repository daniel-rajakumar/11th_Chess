package GUI;

import java.awt.*;

public enum TileColor {
    LIGHT(Color.decode("#EEEED2")), 
    DARK(Color.decode("#769656")),
    LEGAL_LIGHT(Color.decode("#aab91a")),
    LEGAL_DARK(Color.decode("#BBCA2B"));
    
    Color color;

    /**
     * creates a tile
     * @param color
     */
    TileColor(Color color){
        this.color = color;
    }

    /**
     * get the color of the tile.
     * @return tile's color
     */
    public Color getColor() { return color; }
}


