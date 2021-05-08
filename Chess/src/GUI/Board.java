package GUI;

import java.awt.*;

import javax.swing.*;

public class Board extends JPanel {


    public Board(String text){
       setBackground(Color.green);
       setPreferredSize(new Dimension(400, 400));
       setLayout(new GridLayout(8,8));

       draw();
    }

    void draw(){
        JButton[][] tile = new Tile[8][8];

        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if ((i+j) % 2 == 0) tile[i][j] = new Tile(TileColor.LIGHT);
                else            tile[i][j] = new Tile(TileColor.DARK);
            }
        }



        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                add(tile[i][j]);
            }
        }


    }

}


