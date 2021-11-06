package morpion;

import javax.swing.*;
import java.awt.*;

public class frame extends JPanel {
    private final int[][] tab;
    private final int lenght = 3;
    private int size;
    frame(){
        tab=new int[lenght][lenght];
        for (int i=0;i<lenght;i++){
            for (int j=0;j<lenght;j++){
                setTab(i,j,0);
            }
        }
    }

    public void paint(Graphics g){
        int border = 0;
        int i1 = size/lenght,i2=2*size/lenght;

        g.drawLine(border, i1, size+border,i1);
        g.drawLine(border, i2, size+border, i2);
        g.drawLine(i1, border, i1, size+border);
        g.drawLine(i2, border, i2, size+border);

        for (int i=0;i<lenght;i++){
            for (int j=0;j<lenght;j++){
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
    void setSizeF(int val){
        size = val;
    }

    int getTab(int i, int j){return tab[i][j];}
    void setTab(int i, int j, int value){tab[i][j]=value;}

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


