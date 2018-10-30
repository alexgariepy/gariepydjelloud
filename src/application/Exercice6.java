package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercice6 extends Application {

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
