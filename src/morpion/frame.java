package morpion;

import javax.swing.*;
import java.awt.*;

/**
 * Class that update the display of the game and keep the tab of the game
 * @author Billequin Thomas
 */
public class frame extends JPanel {
    private final int[][] tab;
    private final int lenght = 3;
    private int size;

    /**
     * Constructor init the tab at 0
     */
    frame(){
        tab=new int[getLenght()][getLenght()];
        for (int i=0;i<getLenght();i++){
            for (int j=0;j<getLenght();j++){
                setTab(i,j,0);
            }
        }
    }

    /**
     * Update the windows
     * @param g window object
     */
    public void paint(Graphics g){
        int border = 0;
        int i1 = getSizeF()/getLenght(),i2=2*getSizeF()/getLenght();

        g.drawLine(border, i1, getSizeF()+border,i1);
        g.drawLine(border, i2, getSizeF()+border, i2);
        g.drawLine(i1, border, i1, getSizeF()+border);
        g.drawLine(i2, border, i2, getSizeF()+border);

        for (int i=0;i<getLenght();i++){
            for (int j=0;j<getLenght();j++){
                if(getTab(i,j)==1){
                    g.setColor (Color.blue);
                }else if(getTab(i,j)==2){
                    g.setColor (Color.red);
                }
                if(getTab(i,j)!=0)
                    g.fillOval(i*i1+1,j*i1+1,i1-2,i1-2);
            }
        }
    }

    /**
     * setter of the size of tab
     * @param val
     */
    void setSizeF(int val){
        size = val;
    }

    /**
     * @return size
     */
    int getSizeF(){return size;}

    /**
     * @return lenght
     */
    int getLenght(){return lenght;}

    /**
     * return la valeur du tab aux coord i,j
     * @param i x
     * @param j y
     * @return value of a spot
     */
    int getTab(int i, int j){return tab[i][j];}

    /**
     * set la valeur du tab aux coord i,j
     * @param i x
     * @param j y
     * @return value of a spot
     */
    void setTab(int i, int j, int value){tab[i][j]=value;}

    /**
     * vérifie toutes les possibilités de victoire et decide de la marche à suivre
     * @param l labelTexte
     * @return winner player
     */
    int verifWinner(JLabel l) {
        int isWin = 0;

        if(getTab(0,0)==getTab(0,1) && getTab(0,0)==getTab(0,2) && getTab(0,0)!=0)isWin=getTab(0,0);
        else if(getTab(1,0)==getTab(1,1) && getTab(1,0)==getTab(1,2) && getTab(1,0)!=0)isWin=getTab(1,0);
        else if(getTab(2,0)==getTab(2,1) && getTab(2,0)==getTab(2,2) && getTab(2,0)!=0)isWin=getTab(2,0);

        else if(getTab(0,0)==getTab(1,0) && getTab(0,0)==getTab(2,0) && getTab(0,0)!=0)isWin=getTab(0,0);
        else if(getTab(0,1)==getTab(1,1) && getTab(0,1)==getTab(2,1) && getTab(0,1)!=0)isWin=getTab(0,1);
        else if(getTab(0,2)==getTab(1,2) && getTab(0,2)==getTab(2,2) && getTab(0,2)!=0)isWin=getTab(0,2);

        else if(getTab(0,0)==getTab(1,1) && getTab(0,0)==getTab(2,2) && getTab(0,0)!=0)isWin=getTab(0,0);
        else if(getTab(2,0)==getTab(1,1) && getTab(2,0)==getTab(0,2) && getTab(2,0)!=0)isWin=getTab(2,0);

        if(isWin==1)l.setText("Bleu a gagné !");
        else if (isWin==2)l.setText("Rouge a gagné !");
        return isWin;
    }
}


