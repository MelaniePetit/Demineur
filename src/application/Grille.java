package application;


import java.util.ArrayList;
import java.util.Collections;

import Commun.Commun;
import javafx.scene.Parent;
import javafx.scene.layout.TilePane;

public class Grille extends Parent {
	
	public int nbLignes;
	public int nbColonnes;
	public ArrayList<Case> cases = new ArrayList<Case>();
	public int nbBombes;
	public TilePane grille = new TilePane();

	
	public Grille(int ligne, int colonne, int nbBombes){
		nbLignes = ligne;
		nbColonnes = colonne;
		this.nbBombes = nbBombes;
		creationCases();
		placementBombe(nbBombes);
		initialisationVoisins();
		creationTableau();

	}
	
	//On place les bombes dans la liste de cases puis on la mélange
	public void placementBombe(int nb){
		for(int i=0;i<nb;i++){
			cases.get(i).setBombe(true);
		}
		Collections.shuffle(cases);
	}
	
	public void creationCases(){
		  for(int i=0;i < nbLignes;i++){
				for(int j=0;j< nbColonnes; j++){
					cases.add(new Case(i,j));
			}
		}
	}
	
	public void initialisationVoisins(){
		 for(int i=0;i < cases.size();i++){
			 remplirLesVoisins(cases.get(i));
		}
	}
	
	//On crée le plateau en fonction du nb de colonnes et de lignes choisies
	public void creationTableau(){
		grille.setPrefColumns(nbColonnes);
		grille.setPrefRows(nbLignes);		
		grille.setLayoutX(10);
        grille.setLayoutY(10);
    
		for (int i = 0; i < cases.size() ; i++){
            	grille.getChildren().add(cases.get(i));
            	
            	//cases.get(i).mesVoisins(nbColonnes);
        }
        this.getChildren().add(grille);
	}

	//Getters and setters
	public int getNbColonnes() {
		return nbColonnes;
	}

	public void setNbColonnes(int nbColonnes) {
		this.nbColonnes = nbColonnes;
	}

	public int getNbBombes() {
		return nbBombes;
	}

	public void setNbBombes(int nbBombes) {
		this.nbBombes = nbBombes;
	}

	public int getNbLignes() {
		return nbLignes;
	}

	public void setNbLignes(int nbLignes) {
		this.nbLignes = nbLignes;
	}	
	
	//Ne marche pas, les cases qui sont ajoutées aux voisins ne son pas du tout des voisins
    public void remplirLesVoisins(Case c){

    	System.out.println(c.getIndexArrayList(nbColonnes));
		if(c.getJ() > 0) {
			// Ajoute a�la case courante, la case qui la precede, dans ses voisins.
			c.ajouterAuxVoisins(cases.get(c.getIndexArrayList(nbColonnes)-1), Commun.Direction.getDirection(0, -1));
			// Sachant qu'a la creation de la case precedente, la case courante n'existait pas, on l'ajoute maintenant aux voisins de la case precedente.
			cases.get(c.getIndexArrayList(nbColonnes)-1).ajouterAuxVoisins(c, Commun.Direction.getDirection(0, 1));
			
			if(c.getI() > 0) {
				//Case en diagonale haut-gauche
				c.ajouterAuxVoisins(cases.get(c.getIndexArrayList(nbColonnes)-1-nbColonnes), Commun.Direction.getDirection(-1, -1));
				cases.get(c.getIndexArrayList(nbColonnes)-1-nbColonnes).ajouterAuxVoisins(c,Commun.Direction.getDirection(1, 1));
			}
		}
		
		if(c.getI() > 0) {
			//Case au dessus
			c.ajouterAuxVoisins(cases.get(c.getIndexArrayList(nbColonnes)-nbColonnes), Commun.Direction.getDirection(-1, 0));
			cases.get(c.getIndexArrayList(nbColonnes)-nbColonnes).ajouterAuxVoisins(c, Commun.Direction.getDirection(1, 0));
		}
		
		if(c.getJ() < nbColonnes-1 && c.getI() > 0) {
			//Case en diagonale-droite
			c.ajouterAuxVoisins(cases.get(c.getIndexArrayList(nbColonnes)+1-nbColonnes), Commun.Direction.getDirection(-1, 1));
			cases.get(c.getIndexArrayList(nbColonnes)+1-nbColonnes).ajouterAuxVoisins(c, Commun.Direction.getDirection(1, -1));
		}
	}
	
}
