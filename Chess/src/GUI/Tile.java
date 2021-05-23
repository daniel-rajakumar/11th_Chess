package GUI;

import javax.swing.JButton;

import GamePeaces.Piece;
import GamePeaces.Piece1;

import java.awt.*;

public class Tile extends JButton {
    private TileColor color;
    private Piece piece;

    Tile(TileColor color, Piece piece){
        this.color = color;
        this.piece = piece;

        if (color.equals(TileColor.DARK)) setBackground(Color.decode("#EEEED2"));
        else                              setBackground(Color.decode("#769656"));
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

    public void setPiece(Piece piece, Piece.Color color) {
        this.piece = piece;
        this.piece.setColor(color);
    }
    
}
