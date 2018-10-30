package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub		
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 400, 300);
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("Projet 2");
		primaryStage.setResizable(false);
		primaryStage.sizeToScene();
		
	}
	

	public static void main(String[] args) {
		launch(args);
	}

}
