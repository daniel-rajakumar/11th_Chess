package Assets.Pieces;

import Assets.Piece;
import Assets.PieceColor;
import Assets.PieceType;

public class Rook extends Piece {
    private final PieceType type = PieceType.ROOK; 
    private boolean firstMove = true;

    /**
     * creates a Piece as Rook
     * @param color Rook's color
     */
    public Rook(PieceColor color) {
        super(color);
    }
    
}
