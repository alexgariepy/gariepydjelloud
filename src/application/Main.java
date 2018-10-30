package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub		
		GridPane root = new GridPane();
		Scene scene = new Scene(root, 500, 400);
		BackgroundImage BGMain= new BackgroundImage(new Image("Background.png",32,32,false,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		Background bg1 = new Background(BGMain);
		root.setBackground(bg1);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("Bienvenue");
		primaryStage.setResizable(false);
		primaryStage.sizeToScene();
		
	}
	

	public static void main(String[] args) {
		launch(args);
	}

}
