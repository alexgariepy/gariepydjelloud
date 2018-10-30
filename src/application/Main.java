package application;

import javax.swing.border.EtchedBorder;

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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.RadialGradient;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 500, 400);
		Image image = new Image("Background.png");
		BackgroundSize bgTaille = new BackgroundSize(500, 400, false, false, false, false);
		BackgroundImage BGMain = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT, bgTaille);
		Background bg1 = new Background(BGMain);
		Background bg2 = new Background(new BackgroundFill(Color.DIMGRAY, new CornerRadii(5), Insets.EMPTY));
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
	private EventHandler<ActionEvent> gestionUsager = new EventHandler<ActionEvent>() {
	public void handle(ActionEvent event) {
		 
        Label secondLabel = new Label("I'm a Label on new Window");

        StackPane secondaryLayout = new StackPane();
        secondaryLayout.getChildren().add(secondLabel);

        Scene secondScene = new Scene(secondaryLayout, 230, 100);

        // New window (Stage)
        Stage newWindow = new Stage();
        newWindow.setTitle("Second Stage");
        newWindow.setScene(secondScene);

        // Set position of second window, related to primary window.

        newWindow.show();
	}
};

	public static void main(String[] args) {
		launch(args);
	}
	
}
