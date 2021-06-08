package Assets.Pieces;

import Assets.Piece;
import Assets.PieceColor;
import Assets.PieceType;

public class King extends Piece {
    private final PieceType type = PieceType.KING; 
    private boolean firstMove = true;

    /**
     * creates a Piece as King
     * @param color King's color
     */
    public King(PieceColor color) {
        super(color);
    }
    
}
