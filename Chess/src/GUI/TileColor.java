package GUI;

import java.awt.*;

public enum TileColor {
    LIGHT(Color.decode("#EEEED2")), 
    DARK(Color.decode("#769656")),
    LEGAL_LIGHT(Color.decode("#BBCA2B")),
    LEGAL_DARK(Color.decode("#aab91a"));
    
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


