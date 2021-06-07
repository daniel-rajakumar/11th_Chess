import javax.swing.*;
// import javax.awt.*;

import GUI.Board;
import GUI.SideBar;

import java.awt.*;

public class App {
    private JFrame frame;
    private JPanel panel, sidebarLeft, sidebarRight;

    App(){
        GUI();
    }

    private void GUI(){
        panel();
        frame();
    }

    private void frame(){
        frame = new JFrame("CHESS");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel, BorderLayout.CENTER);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void panel(){
        JPanel background = new JPanel();
        background.setBackground(Color.GRAY);

        background.add(new Board("text"));
        panel = background;
    }

    public static void main(String[] args) throws Exception {
        new App();

    }
}

