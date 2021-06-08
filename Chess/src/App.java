import javax.swing.*;
// import javax.awt.*;

import GUI.Board;

import java.awt.*;

public class App {
    private JFrame frame;
    private JPanel panel;

    /**
     * run the GUI version of the program
     */
    App(){
        GUI();
    }


    /**
     * call the frame and panel. 
     */
    private void GUI(){
        panel();
        frame();
    }

    /**
     * creates the frame of the game (game window)
     */
    private void frame(){
        frame = new JFrame("CHESS");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel, BorderLayout.CENTER);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * creats a panel(includes the chess board) inside the frame.
     */
    private void panel(){
        JPanel background = new JPanel();
        background.setBackground(Color.GRAY);

        background.add(new Board("text"));
        panel = background;
    }

    /**
     * @param args unused
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        new App();
    }
}

