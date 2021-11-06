package morpion;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;

public class Main {
    static private int winner = 0;
    static private final int SPEED = 100;
    static private int SIZE;
    public static void main(String[] argv) throws InterruptedException {
        Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        SIZE = (int)dimension.getHeight()/2;

        frame frame = new frame();
        JFrame f = new JFrame("Morpion");
        Game game = new Game(SIZE);
        JLabel text = new JLabel("Tour du joueur : Bleu.");
        text.setBounds(10,SIZE,SIZE,28);
        f.add(text);
        f.add(frame);

        frame.setSizeF(SIZE);
        frame.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                game.click(e.getX(),e.getY(), frame, text);
            }
        });

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(SIZE+50, SIZE+150);
        f.setVisible(true);

        while (winner==0){
            f.repaint();
            winner = frame.verifWinner(text);
            Thread.sleep(SPEED);
        }
        f.repaint();

        System.out.println("Fin de la partie");
    }
}
