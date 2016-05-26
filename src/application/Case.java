package application;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Case extends Parent{
	
	 public String lettre;	//lettre de la touche, c'est une variable public pour qu'elle puisse être lue depuis les autres classes
	 private int positionX;	//abscisse
	 private int positionY;	//ordonnée de la touche
	 private boolean bombe;	//case est porteuse de bombe
	  
	 Rectangle fond_touche;
	 Text lettre_touche;
	    
	public Case(int posX, int posY){
		lettre =  "0";
	    positionX = posX;
	    positionY = posY;
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
	    lettre_touche.setX(25);
	    lettre_touche.setY(45);
	    this.getChildren().add(lettre_touche);//ajout de la lettre de la touche
	        
	    this.setTranslateX(positionX);//positionnement de la touche sur le clavier
	    this.setTranslateY(positionY);
	    
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

	public void appuyer(){
		fond_touche.setFill(Color.DARKGREY);
        this.setTranslateY(positionY+2);
	}
	
    public void relacher(){
        fond_touche.setFill(Color.WHITE);
        this.setTranslateY(positionY);
        lettre_touche.setText("1");
    }
}


