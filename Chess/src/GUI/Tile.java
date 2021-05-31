package GUI;

import javax.swing.JButton;

import Assets.*;

import java.awt.*;

public class Tile extends JButton {
    private TileColor color;
    private Piece piece;

    Tile(TileColor color, Piece piece){
        this.color = color;
        this.piece = piece;

        setOpaque(true);
        setBorderPainted(false);

        if (color.equals(TileColor.DARK)) setBackground(Color.decode("#EEEED2"));
        else                              setBackground(Color.decode("#769656"));
    }

    public TileColor getTileColor() {
        return color;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(PieceType type) {
        piece.setType(type);
    }

    public void setPiece(PieceType type, PieceColor color) {
        this.piece = new Piece(type, color);
    }
}
