package morpion;

import javax.swing.*;
import java.awt.*;

public class frame extends JPanel {
    private int[][] tab;
    private final int lenght = 3;
    frame(){
        tab=new int[lenght][lenght];
        for (int i=0;i<lenght;i++){
            for (int j=0;j<lenght;j++){
                setTab(i,j,0);
            }
        }
    }

    public void paint(Graphics g){
        g.drawLine(0, 100, 300, 100);
        g.drawLine(0, 200, 300, 200);
        g.drawLine(100, 0, 100, 300);
        g.drawLine(200, 0, 200, 300);

        for (int i=0;i<lenght;i++){
            for (int j=0;j<lenght;j++){
                if(getTab(i,j)==1){
                    g.setColor (Color.blue);
                }else if(getTab(i,j)==2){
                    g.setColor (Color.red);
                }
                if(getTab(i,j)!=0)
                    g.fillOval(i*100+1,j*100+1,100-2,100-2);
            }
        }
    }

    int getTab(int i, int j){return tab[i][j];}
    void setTab(int i, int j, int value){tab[i][j]=value;}

    boolean verifWinner() {
        boolean isWin = false;

        if(getTab(0,0)==getTab(0,1) && getTab(0,0)==getTab(0,2) && getTab(0,0)!=0)isWin=true;
        else if(getTab(1,0)==getTab(1,1) && getTab(1,0)==getTab(1,2) && getTab(1,0)!=0)isWin=true;
        else if(getTab(2,0)==getTab(2,1) && getTab(2,0)==getTab(2,2) && getTab(2,0)!=0)isWin=true;

        else if(getTab(0,0)==getTab(1,0) && getTab(0,0)==getTab(2,0) && getTab(0,0)!=0)isWin=true;
        else if(getTab(0,1)==getTab(1,1) && getTab(0,1)==getTab(2,1) && getTab(0,1)!=0)isWin=true;
        else if(getTab(0,2)==getTab(1,2) && getTab(0,2)==getTab(2,2) && getTab(0,2)!=0)isWin=true;

        else if(getTab(0,0)==getTab(1,1) && getTab(0,0)==getTab(2,2) && getTab(0,0)!=0)isWin=true;
        else if(getTab(2,0)==getTab(1,1) && getTab(2,0)==getTab(0,2) && getTab(2,0)!=0)isWin=true;

        return isWin;
    }
}


