package JavaBasics.musicPlayer;

import javax.swing.*;
import java.awt.*;

public class SimpleAnimation {
    int x = 1;
    int y = 1;

    public static void main(String[] args) {
        SimpleAnimation animation = new SimpleAnimation();
        animation.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        MyDrawPanelInner drawPanel = new MyDrawPanelInner();

        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.setSize(500, 270);
        frame.setVisible(true);

        for (int i = 0; i < 124; i++, y++, x++) {
            x++;
            drawPanel.repaint();

            try {
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class MyDrawPanelInner extends JPanel {
        public void paintComponent(Graphics g) {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 500, 250);

            g.setColor(Color.BLUE);
            g.fillRect(x, y, 500-x*2, 250-y*2);
        }
    }
}
