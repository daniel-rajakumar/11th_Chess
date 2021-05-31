package Assets.Pieces;

import Assets.Piece;
import Assets.PieceColor;
import Assets.PieceType;

public class Queen extends Piece {
    private final PieceType type = PieceType.QUEEN; 

    public Queen(PieceColor color) {
        super(color);
    }
    
}
