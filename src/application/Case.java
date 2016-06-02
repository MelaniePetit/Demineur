package application;


import java.util.ArrayList;
import java.util.HashMap;

import Commun.Commun;
import Commun.Commun.Direction;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Case extends Parent{
	

	public String lettre;	//lettre de la touche, c'est une variable public pour qu'elle puisse être lue depuis les autres classes
	private int i;	//abscisse
	private int j;	//ordonnée de la touche
	private int index;
	private boolean bombe;	//case est porteuse de bombe
	private HashMap<Case, Commun.Direction> voisins;
	
	public ArrayList<Case> listeVoisins;

	
	Rectangle fond_touche;
	Text lettre_touche;
	    
	public Case(int i, int j){
		lettre =  "0";
		this.i = i;
		this.j = j;
	    //this.index=index;
		this.voisins = new HashMap<Case, Commun.Direction>();
		listeVoisins = new ArrayList<Case>();
		
	    int a = (int)Math.random();
	    
	    if ((int)a == 1){
	    	bombe = true;
	    }
	    else  bombe = false;
	        
	    fond_touche = new Rectangle(75,75,Color.WHITE);
	    fond_touche.setArcHeight(10);
	    fond_touche.setArcWidth(10);
	    this.getChildren().add(fond_touche);//ajout du rectangle de fond de la touche
	    
	    lettre_touche = new Text(lettre);
	    lettre_touche.setFont(new Font(25));
	    lettre_touche.setFill(Color.BLACK);
	    lettre_touche.setX(30);
	    lettre_touche.setY(45);
	    this.getChildren().add(lettre_touche);//ajout de la lettre de la touche
	    
	    this.setOnMousePressed(new EventHandler<MouseEvent>(){
	    	public void handle(MouseEvent me){
	    		appuyer();
	    	}
	    });
	    this.setOnMouseReleased(new EventHandler<MouseEvent>(){
	    	public void handle(MouseEvent me){
	    		relacher();
	    	}
	    });
    }
	
	public Boolean getBombe(){
		return bombe;
	}
	
	public void setBombe(Boolean bombe){
		this.bombe=bombe;
	}
	public void appuyer(){
		fond_touche.setFill(Color.DARKGREY);
	}
	
    public void relacher(){
        fond_touche.setFill(Color.WHITE);
        if (getBombe()){
            lettre_touche.setText("B");

        }
        else {
        	lettre_touche.setText("0");
        }
    }
    
	 public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}
	
	public int getIndexArrayList(int nbColonne) {
		return this.i*nbColonne+this.j;
	}
	
    /*public void mesVoisins(int nbColonne){

		if(this.j > 0) {
			// Ajoute a la case courante, la case qui la precede, dans ses voisins.
			this.voisins.put(listeVoisins.get(this.getIndexArrayList(nbColonne)-1), Commun.Direction.getDirection(0, -1));
			// Sachant qu'a la creation de la case precedente, la case courante n'existait pas, on l'ajoute maintenant aux voisins de la case precedente.
			listeVoisins.get(this.getIndexArrayList(nbColonne)-1).voisins.put(this, Commun.Direction.getDirection(0, 1));
			
			if(this.i > 0) {
				//Case en diagonale haut-gauche
				this.voisins.put(listeVoisins.get(this.getIndexArrayList(nbColonne)-1-nbColonne), Commun.Direction.getDirection(-1, -1));
				listeVoisins.get(this.getIndexArrayList(nbColonne)-1-nbColonne).voisins.put(this,Commun.Direction.getDirection(1, 1));
			}
		}
		
		if(this.i > 0) {
			//Case au dessus
			this.voisins.put(listeVoisins.get(this.getIndexArrayList(nbColonne)-nbColonne), Commun.Direction.getDirection(-1, 0));
			listeVoisins.get(this.getIndexArrayList(nbColonne)-nbColonne).voisins.put(this, Commun.Direction.getDirection(1, 0));
		}
		
		if(this.j < nbColonne-1 && this.i > 0) {
			//Case en diagonale-droite
			this.voisins.put(listeVoisins.get(this.getIndexArrayList(nbColonne)+1-nbColonne), Commun.Direction.getDirection(-1, 1));
			listeVoisins.get(this.getIndexArrayList(nbColonne)+1-nbColonne).voisins.put(this, Commun.Direction.getDirection(1, -1));
		}
	}*/
	
}


