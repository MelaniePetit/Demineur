package application;
	
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class Main extends Application {
	
	private int nbL = 8;
	private int nbC = 8;
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Demineur");
			primaryStage.setResizable(false);
			BorderPane root = new BorderPane();  //contient les objets graphiques
	        Scene scene = new Scene(root, 500, 250, Color.CORNFLOWERBLUE);	//contient le root
	        
	        
	        //titre 
	        Pane haut = new Pane();
	        Text titre = new Text("DEMINEUR");
	        titre.setUnderline(true);
	        titre.setFont(Font.font("Comic Sans MS", 20));
	        titre.setLayoutX(200);
	        titre.setLayoutY(30);
	        haut.getChildren().add(titre);
      
	        //bouton pour lancer la partie
	        Pane bas = new Pane();
	        Button btn = new Button();
	        btn.setText("Lancer une partie");
	        btn.setOnAction(new EventHandler<ActionEvent>() {

	            public void handle(ActionEvent event) {
	                game(primaryStage);
	            }
	        });
	        btn.setLayoutX(200);
	        btn.setLayoutY(-10);
	        bas.getChildren().add(btn);
	        
	        //choix de la taille de la grille
	        GridPane choix = new GridPane();
	        
	        RadioButton choix1 = new RadioButton();
	        RadioButton choix2 = new RadioButton();
	        RadioButton choix3 = new RadioButton();
	        
	        final ToggleGroup radioGroup = new ToggleGroup(); 
	        choix1.setToggleGroup(radioGroup); 
	        choix2.setToggleGroup(radioGroup); 
	        choix3.setToggleGroup(radioGroup);
	        choix1.setFocusTraversable(false);
	        choix2.setFocusTraversable(false);
	        choix3.setFocusTraversable(false);
	        choix1.setSelected(true);
	        
	        choix.add(choix1, 0, 0);
	        choix.add(choix2, 0, 1);
	        choix.add(choix3, 0, 2);
	        choix.add(new Text("Grille 8*8"), 1, 0);
	        choix.add(new Text("Grille 10*10"), 1, 1);
	        choix.add(new Text("Grille 20*10"), 1, 2);
	        
	        choix.setHgap(20);
	        choix.setLayoutX(200);
	        
	        //ajout d'un ChangeListener au groupe de boutons radio
	        radioGroup.selectedToggleProperty().addListener(new ChangeListener(){
	            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
	                if(newValue.equals(choix1)){
	                    nbC = 8;
	                	nbL = 8;
	                }
	                else if(newValue.equals(choix2)){
	                	nbC = 10;
	                	nbL = 10;
	                }
                    else{
                    	nbC = 20;
	                	nbL = 10;	            
                    }
	            }
	        });

	        root.setCenter(choix);
	        root.setBottom(bas);        
	        root.setTop(haut);
	        
	        primaryStage.setScene(scene);	//ajout de la scene au stage
	        primaryStage.show();
	    
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void game(Stage primaryStage) {
		try {
			primaryStage.setTitle("Demineur");
			primaryStage.setResizable(true);
			primaryStage.setX(Screen.getPrimary().getVisualBounds().getMinX());
			primaryStage.setY(Screen.getPrimary().getVisualBounds().getMinY());
			
			BorderPane root = new BorderPane(); //zone d'affichage divisée en 5 parties : haut, bas, droite, gauche, centre 
	        Scene scene = new Scene(root, 900, 850, Color.DARKRED);
	        
	        Grille grille = new Grille(nbL,nbC,20);

	        Pane haut = new Pane();
	        Text titre = new Text("DEMINEUR");
	        titre.setUnderline(true);
	        titre.setFont(Font.font("Comic Sans MS", 50));
	        titre.setLayoutX(325);
	        titre.setLayoutY(75);
	        haut.getChildren().add(titre);
	        
	        root.setCenter(grille); 
	        root.setTop(haut);
	        	        
	        primaryStage.setScene(scene);
	        primaryStage.show();
	    
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
