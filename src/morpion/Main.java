package morpion;

import javax.swing.*;
import java.awt.event.*;


public class Main {
    static private boolean winner = false;
    static private final int SPEED = 100;
    public static void main(String[] argv) throws InterruptedException {
        frame frame = new frame();
        JFrame f = new JFrame("Morpion");
        Game game = new Game();
        f.add(frame);
        frame.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                game.click(e.getX(),e.getY(), frame);
            }
        });

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(350, 350);
        f.setVisible(true);

        while (!winner){
            f.repaint();
            winner = frame.verifWinner();
            Thread.sleep(SPEED);
        }
        f.repaint();
        System.out.println("Fin de la partie");

    }
}
