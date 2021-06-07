package GUI;

import java.awt.*;




public enum TileColor {
    LIGHT(Color.decode("#EEEED2")), 
    DARK(Color.decode("#769656")),
    LEGAL(Color.decode("#BBCA2B"));
    
    Color color;

    TileColor(Color color){
        this.color = color;
    }

    public Color getColor() { return color; }
}


