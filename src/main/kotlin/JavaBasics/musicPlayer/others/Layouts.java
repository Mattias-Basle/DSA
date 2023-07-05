package JavaBasics.musicPlayer.others;

import javax.swing.*;
import java.awt.*;

public class Layouts {
    public static void main(String[] args) {
        Layouts layouts = new Layouts();
        layouts.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton button = new JButton("shock me");
        JButton button1 = new JButton("bliss");
        JButton button2 = new JButton("huh?");

        panel.add(button);
        panel.add(button1);
        panel.add(button2);

        frame.getContentPane().add(BorderLayout.EAST, panel);
        frame.setSize(250, 200);
        frame.setVisible(true);
    }
}
