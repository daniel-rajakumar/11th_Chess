package Assets.Pieces;

import Assets.Piece;
import Assets.PieceColor;
import Assets.PieceType;

public class King extends Piece {
    private final PieceType type = PieceType.KING; 

    public King(PieceColor color) {
        super(color);
    }
    
}
