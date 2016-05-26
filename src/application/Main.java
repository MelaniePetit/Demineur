package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Demineur");
			Group root = new Group();  //contient les objets graphiques
	        Scene scene = new Scene(root, 500, 250, Color.CORNFLOWERBLUE);	//contient le root
	        Button btn = new Button();
	        btn.setLayoutX(200);
	        btn.setLayoutY(100);
	        btn.setText("Lancer une partie");
	        btn.setOnAction(new EventHandler<ActionEvent>() {

	            public void handle(ActionEvent event) {
	                game(primaryStage);
	            }
	        });
	        root.getChildren().add(btn);        
	        primaryStage.setScene(scene);	//ajout de la scene au stage
	        primaryStage.show();
	    
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void game(Stage primaryStage) {
		try {
			primaryStage.setTitle("Demineur");
			primaryStage.setX(Screen.getPrimary().getVisualBounds().getMinX());
			primaryStage.setY(Screen.getPrimary().getVisualBounds().getMinY());
			BorderPane root = new BorderPane(); //zone d'affichage divisée en 5 parties : haut, bas, droite, gauche, centre 
	        Scene scene = new Scene(root, 900, 850, Color.DARKRED);
	        Text titre = new Text("Demineur");
	        Grille grille = new Grille(8,8);

	        root.setCenter(grille); 
	        root.setTop(titre);
	        	        
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
