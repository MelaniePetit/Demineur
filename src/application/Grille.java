package application;


import java.util.ArrayList;
import java.util.Collections;

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
		placementBombe(15);
		creationTableau();

	}
	
	public void placementBombe(int nb){
		for (int i = 0; i < nbLignes ; i++){
        	for (int j = 0; j < nbColonnes ; j++){
        		Case c = new Case(i,j);
            	cases.add(c);
            }
        }
		for(int i=0;i<nb;i++){
			cases.get(i).setBombe(true);
		}
		Collections.shuffle(cases);
	}
	
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
	
	
}
