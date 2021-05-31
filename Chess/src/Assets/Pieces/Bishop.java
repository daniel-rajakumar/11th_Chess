package Assets.Pieces;

import Assets.Piece;
import Assets.PieceColor;
import Assets.PieceType;

public class Bishop extends Piece {
    private final PieceType type = PieceType.BISHOP; 

    public Bishop(PieceColor color) {
        super(color);
    }
    
}
