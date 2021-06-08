package Assets.Pieces;

import Assets.Piece;
import Assets.PieceColor;
import Assets.PieceType;

public class Queen extends Piece {
    private final PieceType type = PieceType.QUEEN; 

    /**
     * creates a Piece as Queen
     * @param color Queen's color
     */
    public Queen(PieceColor color) {
        super(color);
    }
    
}
