import javax.swing.*;

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

        // frame.add(new JButton());
        // frame.add(sidebarLeft, BorderLayout.WEST);
        // frame.add(sidebarRight, BorderLayout.EAST);

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
        panel = new Board("hello world");
        sidebarRight = new SideBar();
        sidebarLeft = new SideBar();
    }

    
    public static void main(String[] args) throws Exception {
        new App();
    }
}

