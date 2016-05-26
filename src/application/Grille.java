package application;


import javafx.scene.Parent;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;

public class Grille extends Parent {
	
	public int nbLignes;
	public int nbColonnes;
	public Case[] cases;
	
	public Grille(int ligne, int colonne){
		GridPane grille = new GridPane();
        for (int i = 0; i < ligne ; i++){
        	for (int j = 0; j < colonne ; j++){
            	grille.add(new Case(i,j), i, j);
            }
        }
        this.getChildren().add(grille);
        grille.setLayoutX(10);
        grille.setLayoutY(10);

	}
	
	
}
