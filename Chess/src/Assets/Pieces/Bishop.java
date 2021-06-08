package Assets.Pieces;

import Assets.Piece;
import Assets.PieceColor;
import Assets.PieceType;

public class Bishop extends Piece {
    private final PieceType type = PieceType.BISHOP; 

    /**
     * creates a Piece as Bishop
     * @param color Bishop's color
     */
    public Bishop(PieceColor color) {
        super(color);
    }
    
}
