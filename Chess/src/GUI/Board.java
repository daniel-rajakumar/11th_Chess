package GUI;

import java.awt.*;
import javax.swing.*;
import Assets.*;
import Assets.Pieces.*;

public class Board extends JPanel {
    public static Tile[][] tile = new Tile[8][8];

    /**
     * creates the chess board as JPanel 
     */
    public Board(){
       setOpaque(true);
       
       setBackground(Color.red);
       setPreferredSize(new Dimension(800, 800));
       setLayout(new GridLayout(8,8));

       draw();
    }

    /**
     *  draws the board
     */
    void draw(){
        setBoardTile();
        addBoardTile();
        pieceStartingSetup();
        printPieces();
        tileAction();
    }

    /**
     * set up the chess board with assiging each tile its own color and piece. 
     */
    void setBoardTile(){
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                if ((i+j) % 2 == 0) tile[i][j] = new Tile(i, j, TileColor.LIGHT, null);
                else                tile[i][j] = new Tile(i, j, TileColor.DARK, null);

    }

    /**
     *  add all the tile to the board.
     */
    void addBoardTile(){
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                add(tile[i][j]);

    }

    /**
     * set piece to its starting position. 
     */
    void pieceStartingSetup(){
        PieceColor black = PieceColor.BLACK;
        PieceColor white = PieceColor.WHITE;

        tile[0][0].setPiece(new Rook(black));
        tile[0][1].setPiece(new Knight(black));
        tile[0][2].setPiece(new Bishop(black));
        tile[0][3].setPiece(new King(black));
        tile[0][4].setPiece(new Queen(black));
        tile[0][5].setPiece(new Bishop(black));
        tile[0][6].setPiece(new Knight(black));
        tile[0][7].setPiece(new Rook(black));
        for (int i = 0; i < 8; i ++) tile[1][i].setPiece(new Pawn(black));
        for (int i = 0; i < 8; i ++) tile[6][i].setPiece(new Pawn(white));
        tile[7][0].setPiece(new Rook(white));
        tile[7][1].setPiece(new Knight(white));
        tile[7][2].setPiece(new Bishop(white));
        tile[7][3].setPiece(new King(white));
        tile[7][4].setPiece(new Queen(white));
        tile[7][5].setPiece(new Bishop(white));
        tile[7][6].setPiece(new Knight(white));
        tile[7][7].setPiece(new Rook(white));

    }

    /**
     * add chess pieces to the board.
     */
    public static void printPieces(){
        for (int i = 0; i < tile.length; i++) {
            for (int j = 0; j < tile[i].length; j++) {

                if (tile[i][j].getPiece() != null) tile[i][j].setIcon(getPieceIcons(i, j, 85, 85));
                else                               tile[i][j].setIcon(null);

                if ((i+j) % 2 == 0) tile[i][j].setTileColor(TileColor.LIGHT);
                else                tile[i][j].setTileColor(TileColor.DARK);

            }

        }
    }

    /**
     * get the image(.png) of the pieces as Icon.
     * @param x x location of the tile
     * @param y y location of the tile
     * @param width width of the image
     * @param height height of the image
     * @return image (.png) of the chess piece 
     */
    public static ImageIcon getPieceIcons(int x, int y, int width, int height){
        String name = tile[x][y].getPiece().getClass().getSimpleName();
        PieceColor pieceColor = tile[x][y].getPiece().getColor();

        if (pieceColor.equals(PieceColor.WHITE)){
            if (name.equalsIgnoreCase("pawn"))   return pieceImage("white_pawn",   width, height);
            if (name.equalsIgnoreCase("king"))   return pieceImage("white_king",   width, height);
            if (name.equalsIgnoreCase("queen"))  return pieceImage("white_queen",  width, height);
            if (name.equalsIgnoreCase("bishop")) return pieceImage("white_bishop", width, height);
            if (name.equalsIgnoreCase("knight")) return pieceImage("white_knight", width, height);
            if (name.equalsIgnoreCase("rook"))   return pieceImage("white_rook",   width, height);

        } else if (pieceColor.equals(PieceColor.BLACK)){
            if (name.equalsIgnoreCase("pawn"))   return pieceImage("black_pawn",   width, height);
            if (name.equalsIgnoreCase("king"))   return pieceImage("black_king",   width, height);
            if (name.equalsIgnoreCase("queen"))  return pieceImage("black_queen",  width, height);
            if (name.equalsIgnoreCase("bishop")) return pieceImage("black_bishop", width, height);
            if (name.equalsIgnoreCase("knight")) return pieceImage("black_knight", width, height);
            if (name.equalsIgnoreCase("rook"))   return pieceImage("black_rook",   width, height);
        }

        return null;
    }

    /**
     * return a customized version of the chess piece (custome width, height)
     * @param name name of the piece to get as image
     * @param width piece's width
     * @param height piece's height
     * @return customized image of Piece.
     */
    public static ImageIcon pieceImage(String name, int width, int height){
        String path = System.getProperty("user.dir") + "/Chess/res/img/" + name + ".png";
        System.out.println(path);
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }


    private static Piece focusedPiece;

    /**
     * get focued piece (one which is ready to move)
     * @return Piece
     */
    public static Piece getFocusedPiece() { 
        return focusedPiece; 
    }

    /**
     * set piece to focuse (one which is ready to move)
     * @param focusedPiece sets the piece which is ready to move
     */
    public static void setFocusedPiece(Piece focusedPiece) { 
        Board.focusedPiece = focusedPiece; 
    }

    /**
     * make every tile listen to clicks
     */
    void tileAction(){
        for (int i = 0; i < tile.length; i++)
            for (int j = 0; j < tile.length; j++){
                tile[i][j].addActionListener(new UserClick());
            }
        
    }

}
