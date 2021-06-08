package Assets.Pieces;

import Assets.Piece;
import Assets.PieceColor;
import Assets.PieceType;

public class Pawn extends Piece {
    private final PieceType type = PieceType.PAWN; 
    private boolean firstMove = true;

    public Pawn(PieceColor color) {
        super(color);
    }

    public void showLegalMoves(){
        

    }
    
}
