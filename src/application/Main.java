package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Main extends Application {
	private BorderPane root;
	private Scene scene;
	private Image image = new Image("Background.png");
	private BackgroundSize bgTaille = new BackgroundSize(500, 400, false, false, false, false);
	private BackgroundImage BGMain = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT, bgTaille);
	
	
	private EventHandler<ActionEvent> gestionUsager = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
            
            StackPane secondaryLayout = new StackPane();

            Scene secondScene = new Scene(secondaryLayout, 800, 700);

            // New window (Stage)
            Stage newWindow = new Stage();
            newWindow.setTitle("Deuxième fenêtre");
            newWindow.setScene(secondScene);

            newWindow.show();
			
		}
		
};
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		root  = new BorderPane();
		scene = new Scene(root, 500, 400);
		
		Background bg1 = new Background(BGMain);
		root.setBackground(bg1);
		root.setPadding(new Insets(10));
		
		GridPane gp = new GridPane();
		gp.setVgap(10);
		gp.setHgap(10);
		
		Label labelNoEmploye = new Label("No. d'employé : ");
		Label labelMDP = new Label("Mot de passe : ");
		
		TextField tfNoEmploye = new TextField();
		TextField tfMDP = new TextField();
		
		Button btnUsager = new Button("Êtes vous un usager?");
		Button btnConnexion = new Button("Connexion");
		btnUsager.setOnAction(gestionUsager);
		btnConnexion.setOnMouseClicked(e -> primaryStage.hide());
		btnConnexion.setOnAction(gestionUsager);
		
		labelNoEmploye.setFont(Font.font("Arial", 15));
		labelNoEmploye.setTextFill(Color.WHITE);
	
		labelMDP.setFont(Font.font("Arial", 15));
		labelMDP.setTextFill(Color.WHITE);
		
		gp.add(labelNoEmploye, 0, 0);
		gp.add(labelMDP, 0, 1);
		gp.add(tfNoEmploye, 1, 0);
	    gp.add(tfMDP, 1, 1);
	    gp.add(btnConnexion, 1, 3);
	    gp.add(btnUsager, 0, 3);
		
	    gp.setAlignment(Pos.CENTER);
		root.setCenter(gp);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("Bienvenue à la médiathèque");
		primaryStage.setResizable(false);
		primaryStage.sizeToScene();
		

	}
	

	public static void main(String[] args) {
		launch(args);
	}
	
}
