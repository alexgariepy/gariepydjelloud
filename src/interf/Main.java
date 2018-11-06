package interf;

import java.rmi.dgc.Lease;
import java.util.Date;

import application.Document;
import application.LectureFichier;
import application.TypeDocument;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class Main extends Application {
	private BorderPane root;
	private Scene scene;
	private Image image = new Image("Background.png");
	private Image image2 = new Image("img1.jpg");
	private Image image3 = new Image("livre.png");
	private ImageView imageView = new ImageView(image3);
	private Button btnAjouter = new Button("Ajouter un document");
	private Button btnSupprimer = new Button("Supprimer un document");
	private Button btnGerer = new Button("Gérer les adhérents");
	private Button btnInscire = new Button("Inscire un prêt");
	private Button btnRetour = new Button("Inscire un retour");
	private Button btnQuitter = new Button("Déconnexion");
	private BackgroundSize bgTaille = new BackgroundSize(500, 400, false, false, false, false);
	private BackgroundSize bgTaille2 = new BackgroundSize(1280, 720, false, false, false, false);
	private BackgroundImage BGMain = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT, bgTaille);
	private BackgroundImage BGMain2 = new BackgroundImage(image2, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT, bgTaille2);
	private Background bg1 = new Background(BGMain);
	private Background bg2 = new Background(BGMain2);
	private Background bg3 = new Background(new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY));
	private Border border = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
	
	
	private EventHandler<ActionEvent> gestionUsager = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
            
            BorderPane secondaryLayout = new BorderPane();
            Scene secondScene = new Scene(secondaryLayout, 1280, 720);
            secondaryLayout.setBackground(bg2);
            
            VBox vBox1 = new VBox();
            vBox1.setMaxSize(900, 690);
            vBox1.setPrefSize(900, 690);
            
            VBox vBox2 = new VBox();
            vBox2.setMaxSize(300, 690);
            vBox2.setPrefSize(300, 690);
            vBox2.setBackground(bg3);
            vBox2.setPadding(new Insets(10));
            vBox2.setSpacing(50);
            
            VBox vBox3 = new VBox();
            vBox3.setBackground(bg3);
            vBox3.setSpacing(10);
            vBox3.setAlignment(Pos.TOP_CENTER);
            
            VBox vBox4 = new VBox();
            vBox4.setBackground(bg3);
            vBox4.setSpacing(15);
            vBox4.setAlignment(Pos.TOP_CENTER);
            
            imageView.setFitHeight(150);
            imageView.setFitWidth(150);
            vBox2.setAlignment(Pos.CENTER);
            
            Text t = new Text("\nCopyright © 2018 \nMédiathèque réalisée par : \nAlex Gariépy et Mohamed Djelloud");
            t.setFont(Font.font("Arial", FontWeight.MEDIUM, 13));
            t.setTextAlignment(TextAlignment.CENTER);
            
            Text t2 = new Text("Actions possibles :");
            t2.setFont(Font.font("Arial", FontWeight.MEDIUM, 13));
            t2.setTextAlignment(TextAlignment.LEFT);
            
            btnAjouter.setMinHeight(40);
            btnSupprimer.setMinHeight(40);
            btnGerer.setMinHeight(40);
            btnInscire.setMinHeight(40);
            btnRetour.setMinHeight(40);
            btnQuitter.setMinHeight(30);
            
            btnAjouter.setFont(Font.font("Arial", FontWeight.MEDIUM, 13));
            btnSupprimer.setFont(Font.font("Arial", FontWeight.MEDIUM, 13));
            btnGerer.setFont(Font.font("Arial", FontWeight.MEDIUM, 13));
            btnInscire.setFont(Font.font("Arial", FontWeight.MEDIUM, 13));
            btnRetour.setFont(Font.font("Arial", FontWeight.MEDIUM, 13));
            btnQuitter.setFont(Font.font("Arial", FontWeight.MEDIUM, 13));
            
            btnAjouter.setMinWidth(250);
            btnSupprimer.setMinWidth(250);
            btnGerer.setMinWidth(250);
            btnInscire.setMinWidth(250);
            btnRetour.setMinWidth(250);
            
            vBox3.getChildren().addAll(imageView, t);
            vBox4.getChildren().addAll(t2, btnAjouter, btnSupprimer, btnGerer, btnInscire, btnRetour, btnQuitter);
            
            vBox2.getChildren().addAll(vBox3, vBox4);
            
            HBox hBox = new HBox();
            hBox.setMaxSize(900, 80);
            hBox.setPrefSize(900, 80);
            hBox.setBorder(border);
            hBox.setBackground(bg3);
            
            
            TabPane tp = new TabPane();
            tp.setBorder(border);
            vBox2.setBorder(border);
           
            tp.setMaxSize(900, 550);
          
            VBox.setMargin(hBox, new Insets(30, 0, 0, 0));
            
            Tab tabDoc = new Tab("Documents");
            Tab tabLivre = new Tab("Livres");
            Tab tabPerio = new Tab("Périodiques");
            Tab tabDVD = new Tab("DVDS");
            
            
          // if(tabDoc.isSelected()) {
        	   LectureFichier fichier = new LectureFichier();
        	   fichier.lectureDVD();
        	   
        	   ObservableList<Document> donnees = FXCollections.observableArrayList();	   
        	   
        	   TableView<Document> table = new TableView<Document>();
        	   VBox vbox = new VBox();
       		   vbox.getChildren().add(table);
        	   TableColumn<Document,TypeDocument> colonneNumDoc = new TableColumn<Document,TypeDocument>("Numéro du document");
        	   TableColumn<Document,String> colonneTitreDoc = new TableColumn<Document,String>("Titre");
        	   TableColumn<Document,Integer> colonneNomDoc = new TableColumn<Document,Integer>("Nombre de prêt");
        	   TableColumn<Document,String> colonneNomAuteurDoc = new TableColumn<Document,String>("Nombre de prêt");
        	   TableColumn<Document,Date> colonneDateDoc = new TableColumn<Document,Date>("Date");
        	   TableColumn<Document,String> colonneMotCle = new TableColumn<Document,String>("Mots-cle");
        	   table.getColumns().addAll(colonneNumDoc,colonneTitreDoc,colonneNomDoc,colonneNomAuteurDoc,colonneDateDoc,colonneMotCle);
        	   for(int i = 0;i < fichier.getListDocAdherent().size();i++) {
        		   donnees.add(fichier.getListDocAdherent().get(i));
        	   }
        	   table.setItems(donnees);
        	 //  tabDoc.add
     //      }
           tabDoc.setClosable(false);
           tabLivre.setClosable(false);
           tabPerio.setClosable(false);
           tabDVD.setClosable(false);
            tabDoc.setContent(vbox);
            /*tabLivre.setContent(new Rectangle(900,550, Color.GHOSTWHITE));
            tabPerio.setContent(new Rectangle(900,550, Color.GHOSTWHITE));
            tabDVD.setContent(new Rectangle(900,550, Color.GHOSTWHITE));*/
            
            tp.getTabs().addAll(tabDoc, tabLivre, tabPerio, tabDVD);
            vBox1.getChildren().addAll(tp, hBox);
            secondaryLayout.setLeft(vBox1);
            secondaryLayout.setRight(vBox2);
            secondaryLayout.setPadding(new Insets(30));
            
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
		btnUsager.setOnMouseClicked(e -> primaryStage.hide());
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
