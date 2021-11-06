package morpion;

import javax.swing.*;

public class Game {
    private int X;
    private int Y;
    private int joueur;
    private final int size;
    Game(int sizeF){
         setJoueur(1);
         size = sizeF;
    }

    void click(int x, int y, frame f, JLabel l){
        if(x<size/3)setX(0);
        else if(x>size*2/3)setX(2);
        else setX(1);

        if(y<size/3)setY(0);
        else if(y>size*2/3)setY(2);
        else setY(1);
        if(f.getTab(getX(),getY())==0){
            f.setTab(getX(),getY(),getJoueur());
        }
        changeJoueur(l);
    }

    private void changeJoueur(JLabel l){
        if(getJoueur()==1){
            setJoueur(2);
            l.setText("Tour du joueur : Rouge.");
        }
        else {
            setJoueur(1);
            l.setText("Tour du joueur : Bleu.");
        }
    }

    private void setJoueur(int val){
        joueur = val;
    }

    private int getJoueur(){
        return joueur;
    }

    private int getX(){
        return X;
    }

    private int getY(){
        return Y;
    }

    private void setX(int val){
        X=val;
    }
    private void setY(int val){
        Y=val;
    }
}
