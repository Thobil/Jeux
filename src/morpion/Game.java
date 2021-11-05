package morpion;

public class Game {
    private int X;
    private int Y;
    private int joueur;
    Game(){
         setJoueur(1);
    }

    void click(int x, int y, frame f){
        if(x<100)X=0;
        else if(x>200)X=2;
        else X=1;

        if(y<100)Y=0;
        else if(y>200)Y=2;
        else Y=1;
        if(f.getTab(X,Y)==0){
            f.setTab(X,Y,joueur);
        }
        changeJoueur();
    }

    void setJoueur(int val){
        joueur = val;
    }
    void changeJoueur(){
        if(joueur==1)joueur=2;
        else joueur=1;
    }
}
