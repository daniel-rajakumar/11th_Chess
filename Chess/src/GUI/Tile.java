package GUI;

import javax.swing.JButton;
import java.awt.*;

public class Tile extends JButton {
    TileColor color;

    Tile(TileColor color){
        this.color = color;
        // setMinimumSize(new Dimension(30, 30));
        // setMaximumSize(new Dimension(30, 30));
        // setPreferredSize(new Dimension(30, 30));
        if (color.equals(TileColor.DARK))
            setBackground(Color.DARK_GRAY);
        else 
            setBackground(Color.LIGHT_GRAY);
    }

    public TileColor getColor() {
        return color;
    }
    
}
