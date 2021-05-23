package GUI;

import javax.swing.JButton;

import GamePeaces.Piece;

import java.awt.*;

public class Tile extends JButton {
    private TileColor color;
    private Piece piece;

    Tile(TileColor color, Piece piece){
        this.color = color;
        this.piece = piece;

        if (color.equals(TileColor.DARK)) setBackground(Color.DARK_GRAY);
        else                              setBackground(Color.LIGHT_GRAY);
    }

    public TileColor getTileColor() {
        return color;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
    
}
