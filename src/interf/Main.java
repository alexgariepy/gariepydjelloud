package interf;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import application.DVD;
import application.Document;
import application.LectureFichier;
import application.Livre;
import application.Periodiques;
import application.TypeDocument;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
	private Image image4 = new Image("img4.jpg");

	private Image imageAdd = new Image("add.png");
	private Image imageDel = new Image("supp.png");
	private Image imageGerer = new Image("gerer.png");
	private Image imageRetour = new Image("retour.png");
	private Image imagePret = new Image("pret.png");
	private Image imageQuitter = new Image("quitter.png");
	private Image imageConfirmer = new Image("confirmer.png");
	private Image imageAnnuler = new Image("annuler.png");
	private Image imageInscire = new Image("inscire.png");

	private ImageView imageView = new ImageView(image3);
	private ImageView addView = new ImageView(imageAdd);
	private ImageView delView = new ImageView(imageDel);
	private ImageView gererView = new ImageView(imageGerer);
	private ImageView retourView = new ImageView(imageRetour);
	private ImageView pretView = new ImageView(imagePret);
	private ImageView quitterView = new ImageView(imageQuitter);
	private ImageView confirmerView = new ImageView(imageConfirmer);
	private ImageView annulerView = new ImageView(imageAnnuler);
	private ImageView inscireView = new ImageView(imageInscire);

	private Button btnAjouter = new Button("Ajouter un document");
	private Button btnSupprimer = new Button("Supprimer un document");
	private Button btnGerer = new Button("Gérer les adhérents");
	private Button btnInscire = new Button("Inscire un prêt");
	private Button btnRetour = new Button("Inscire un retour");
	private Button btnQuitter = new Button("Déconnexion");
	private Button btnUsager = new Button("Êtes vous un usager?");
	private Button btnConnexion = new Button("Connexion");
	private Button btnConfirmer = new Button("Confirmer");
	private Button btnAnnuler = new Button("Annuler");

	private Tab tabDoc = new Tab("Collection");
	private Tab tabLivre = new Tab("Livres");
	private Tab tabPerio = new Tab("Périodiques");
	private Tab tabDVD = new Tab("DVDS");

	private BackgroundSize bgTaille = new BackgroundSize(500, 400, false, false, false, false);
	private BackgroundSize bgTaille2 = new BackgroundSize(1290, 730, false, false, false, false);
	private BackgroundImage BGMain = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
			BackgroundPosition.DEFAULT, bgTaille);
	private BackgroundImage BGMain2 = new BackgroundImage(image2, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
			BackgroundPosition.DEFAULT, bgTaille2);
	private BackgroundImage BGMain3 = new BackgroundImage(image4, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
			BackgroundPosition.DEFAULT, bgTaille);
	private Background bg1 = new Background(BGMain);
	private Background bg2 = new Background(BGMain2);
	private Background bg3 = new Background(new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY));
	private Background bg4 = new Background(BGMain3);
	private Border border = new Border(
			new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
	private Border border2 = new Border(
			new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
	private boolean booUsager = false;
	private ComboBox comboBox;
	private LectureFichier fichier = new LectureFichier();
	private TextField tfTitre;
	private TextField tfAuteur;
	private TextField tfMC;
	private Stage stageAjouter;
	private TextField tfVolumePerio;
	private TextField tfNumPerio;
	private TextField tfNumTel;
	private TextField tfNom;
	private TextField tfPrenom;
	private DatePicker dp = new DatePicker();
	private ObservableList<Document> donnees;
	private ObservableList<DVD> donneesDVD;
	private ObservableList<Periodiques> donneesPer;
	private TableView<Periodiques> tablePer;
	private TableView<Document> table;
	private TableView<DVD> tableDVD;
	private ObservableList<Livre> donneesLivre;
	private TableView<Livre> tableLivre;
	private int intCompteurLivre = 0;
	private int intCompteurDVD = 0;
	private int intCompteurPerio = 0;
	private String strReponse = "";
	private Stage primaryStage;

	private EventHandler<ActionEvent> gestionInscrire = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent arg0) {
			// TODO Auto-generated method stub
			VBox vBoxInscire = new VBox();
			vBoxInscire.setSpacing(10);
			vBoxInscire.setPadding(new Insets(10));
			Scene sceneInsciption = new Scene(vBoxInscire, 450, 325);
			vBoxInscire.setBackground(bg4);
			vBoxInscire.setPadding(new Insets(10));
			
			Label lableInscription = new Label("Inscription");
			Label labelPrenom = new Label("Prénom : ");
			Label labelNom = new Label("Nom : ");
			Label labelTel = new Label("Numéro de téléphone : ");
			Label labelAdresse = new Label("Adresse : ");
			
			TextField tfPrenom = new TextField();
			TextField tfNom = new TextField();
			TextField tfTel = new TextField();
			TextField tfAdresse = new TextField();
			
			HBox hBoxButton = new HBox();
			hBoxButton.setPadding(new Insets(20));
			hBoxButton.setAlignment(Pos.CENTER);
			hBoxButton.setSpacing(20);
			Button btnConfirmer = new Button("Confirmer");
			btnConfirmer.setOnMouseClicked(e -> gestionErreurInscriptionAdherant(tfPrenom, tfNom, tfTel, tfAdresse));
			Button btnAnnuler = new Button("Annuler");
			btnAnnuler.setOnAction(gestionUsager);
			
			parametreBoutton();
			btnConfirmer.setFont(Font.font("Arial", FontWeight.BOLD, 13));
			btnConfirmer.setGraphic(confirmerView);
			btnAnnuler.setFont(Font.font("Arial", FontWeight.BOLD, 13));
			btnAnnuler.setGraphic(annulerView);
			
			hBoxButton.getChildren().addAll(btnConfirmer, btnAnnuler);
			
			lableInscription.setMinSize(180, 30);
			labelPrenom.setMinSize(180, 30);
			labelNom.setMinSize(180, 30);
			labelTel.setMinSize(180, 30);
			labelAdresse.setMinSize(180, 30);
			
			tfPrenom.setMinSize(180, 30);
			tfNom.setMinSize(180, 30);
			tfTel.setMinSize(180, 30);
			tfAdresse.setMinSize(180, 30);
			
			lableInscription.setFont(Font.font("Arial", FontWeight.BOLD, 15));
			labelPrenom.setFont(Font.font("Arial", FontWeight.BOLD, 13));
			labelNom.setFont(Font.font("Arial", FontWeight.BOLD, 13));
			labelTel.setFont(Font.font("Arial", FontWeight.BOLD, 13));
			labelAdresse.setFont(Font.font("Arial", FontWeight.BOLD, 13));
			
			lableInscription.setTextFill(Color.WHITE);
			labelPrenom.setTextFill(Color.WHITE);
			labelNom.setTextFill(Color.WHITE);
			labelTel.setTextFill(Color.WHITE);
			labelAdresse.setTextFill(Color.WHITE);
			
			HBox hBoxInscription = new HBox();
			VBox vBoxLabel = new VBox();
			vBoxLabel.setSpacing(10);
			vBoxLabel.setPadding(new Insets(10));
			vBoxLabel.getChildren().addAll(labelPrenom, labelNom, labelTel, labelAdresse);

			VBox vBoxTF = new VBox();
			vBoxTF.setSpacing(10);
			vBoxTF.setPadding(new Insets(10));
			vBoxTF.getChildren().addAll(tfPrenom, tfNom, tfTel, tfAdresse);

			hBoxInscription.getChildren().addAll(vBoxLabel, vBoxTF);
			hBoxInscription.setBorder(border2);
			
			vBoxInscire.getChildren().addAll(lableInscription, hBoxInscription, hBoxButton);
			
			Stage stageInscription = new Stage();
			stageInscription.setTitle("Inscription d'un adhérant");
			stageInscription.setScene(sceneInsciption);
			stageInscription.setResizable(false);
			stageInscription.show();
			btnAnnuler.setOnMouseClicked(e -> stageInscription.close());
		}
		
	};
	
	private EventHandler<ActionEvent> gestionUsager = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			VBox vBoxAdherant = new VBox();
			vBoxAdherant.setSpacing(20);
			Scene sceneAdherant = new Scene(vBoxAdherant, 450, 360);
			vBoxAdherant.setBackground(bg1);
			vBoxAdherant.setPadding(new Insets(10));

			Label labelConnexionNumTel = new Label("Connexion avec numéro de téléphone");
			Label labelConnexionNom = new Label("Connexion avec Nom et Prénom");

			Label labelNumTel = new Label("Numéro de téléphone : ");

			Label labelNom = new Label("Nom : ");
			Label labelPrenom = new Label("Prénom : ");

			tfNumTel = new TextField();
			tfNom = new TextField();
			tfPrenom = new TextField();
			
			labelNumTel.setMinSize(180, 30);
			labelNom.setMinSize(180, 30);
			labelPrenom.setMinSize(180, 30);
			tfNumTel.setMinSize(180, 30);
			tfNom.setMinSize(180, 30);
			tfPrenom.setMinSize(180, 30);

			labelNumTel.setFont(Font.font("Arial", FontWeight.BOLD, 13));
			labelNumTel.setTextFill(Color.WHITE);
			labelConnexionNumTel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
			labelConnexionNumTel.setTextFill(Color.WHITE);
			labelConnexionNom.setFont(Font.font("Arial", FontWeight.BOLD, 15));
			labelConnexionNom.setTextFill(Color.WHITE);
			labelNom.setFont(Font.font("Arial", FontWeight.BOLD, 13));
			labelNom.setTextFill(Color.WHITE);
			labelPrenom.setFont(Font.font("Arial", FontWeight.BOLD, 13));
			labelPrenom.setTextFill(Color.WHITE);

			HBox hBoxButton = new HBox();
			hBoxButton.setSpacing(10);
			hBoxButton.setAlignment(Pos.CENTER);
			Button btnConfirmation = new Button("Confirmer");
			Button btnInscrire = new Button("Inscrivez vous!");
			Button btnRetour = new Button("Retour");
			
			parametreBoutton();
			btnConfirmation.setFont(Font.font("Arial", FontWeight.BOLD, 13));
			btnConfirmation.setGraphic(confirmerView);
			btnInscrire.setFont(Font.font("Arial", FontWeight.BOLD, 13));
			btnInscrire.setGraphic(inscireView);
			HBox hBoxRetour = new HBox();		
			retourView.setFitHeight(20);
			retourView.setFitWidth(20);		
			btnRetour.setGraphic(retourView);
			btnRetour.setFont(Font.font("Arial", FontWeight.BOLD, 11));
			hBoxRetour.setAlignment(Pos.CENTER);
			hBoxRetour.getChildren().add(btnRetour);
			
			btnInscrire.setOnAction(gestionInscrire);

			hBoxButton.getChildren().addAll(btnConfirmation, btnInscrire);

			HBox hBoxInfo = new HBox();
			VBox vBoxLabel = new VBox();
			vBoxLabel.setSpacing(10);
			vBoxLabel.setPadding(new Insets(10));
			vBoxLabel.getChildren().add(labelNumTel);

			VBox vBoxTF = new VBox();
			vBoxTF.setSpacing(10);
			vBoxTF.setPadding(new Insets(10));
			vBoxTF.getChildren().addAll(tfNumTel);

			hBoxInfo.getChildren().addAll(vBoxLabel, vBoxTF);
			hBoxInfo.setBorder(border2);

			HBox hBoxInfoNom = new HBox();
			VBox vBoxLabelNom = new VBox();
			vBoxLabelNom.setSpacing(10);
			vBoxLabelNom.setPadding(new Insets(10));
			vBoxLabelNom.getChildren().addAll(labelNom, labelPrenom);

			VBox vBoxTFNom = new VBox();
			vBoxTFNom.setSpacing(10);
			vBoxTFNom.setPadding(new Insets(10));
			vBoxTFNom.getChildren().addAll(tfNom, tfPrenom);

			hBoxInfoNom.getChildren().addAll(vBoxLabelNom, vBoxTFNom);
			hBoxInfoNom.setBorder(border2);

			vBoxAdherant.getChildren().addAll(labelConnexionNumTel, hBoxInfo, labelConnexionNom, hBoxInfoNom, hBoxButton, hBoxRetour);

			Stage stageAdherant = new Stage();
			stageAdherant.setTitle("Médiathèque");
			stageAdherant.setScene(sceneAdherant);
			stageAdherant.setResizable(false);
			stageAdherant.show();
			btnInscrire.setOnMouseClicked(e -> stageAdherant.close());
			btnRetour.setOnMouseClicked(e -> stageAdherant.close());
			
		}

	};

	private EventHandler<ActionEvent> gestionConnexion = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			if (event.getSource().equals(btnUsager)) {
				booUsager = true;
			}
			BorderPane mediathequeFenetre = new BorderPane();
			Scene secondScene = new Scene(mediathequeFenetre, 1280, 720);
			mediathequeFenetre.setBackground(bg2);

			VBox vBox1 = new VBox();
			vBox1.setMaxSize(900, 690);
			vBox1.setPrefSize(900, 690);
			vBox1.setSpacing(20);

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

			parametreBoutton();
			vBox3.getChildren().addAll(imageView, t);
			vBox4.getChildren().addAll(t2, btnAjouter, btnSupprimer, btnGerer, btnInscire, btnRetour, btnQuitter);

			if (booUsager) {
				btnAjouter.setDisable(true);
				btnSupprimer.setDisable(true);
				btnGerer.setDisable(true);
			}

			btnAjouter.setOnAction(gestionAjouter);
			btnRetour.setOnAction(gestionRetour);
			btnInscire.setOnAction(gestionPret);

			vBox2.getChildren().addAll(vBox3, vBox4);

			HBox hBox = new HBox();
			hBox.setMaxSize(900, 80);
			hBox.setPrefSize(900, 80);
			hBox.setBorder(border);
			hBox.setBackground(bg3);

			HBox hBox2 = new HBox();
			hBox2.setMaxSize(900, 120);
			hBox2.setPrefSize(900, 120);
			hBox2.setBorder(border);
			hBox2.setBackground(bg3);

			TabPane tp = new TabPane();
			tp.setBorder(border);
			vBox2.setBorder(border);

			tp.setMaxSize(900, 550);

			fichier.lecture();

			tabDoc.setContent(remplirTabDocument(tabDoc));
			tabLivre.setContent(remplirTabLivre(tabLivre));
			tabPerio.setContent(remplirTabPer(tabPerio));
			tabDVD.setContent(remplirTabDVD(tabDVD));

			tabDoc.setClosable(false);
			tabLivre.setClosable(false);
			tabPerio.setClosable(false);
			tabDVD.setClosable(false);

			// Supprimer
			btnSupprimer.setOnAction(gestionSupprimer);

			tp.getTabs().addAll(tabDoc, tabLivre, tabPerio, tabDVD);
			vBox1.getChildren().addAll(tp, hBox, hBox2);
			mediathequeFenetre.setLeft(vBox1);
			mediathequeFenetre.setRight(vBox2);
			mediathequeFenetre.setPadding(new Insets(30));

			// New window (Stage)
			Stage newWindow = new Stage();
			newWindow.setTitle("Médiathèque");
			newWindow.setScene(secondScene);
			newWindow.setResizable(false);
			btnQuitter.setOnAction(e -> {
				try {
				 FileOutputStream fileOutDvD =new FileOutputStream("DVD.ser",false);
					         ObjectOutputStream outDvD = new ObjectOutputStream(fileOutDvD);
					         for(int i = 0 ; i < fichier.getListDvd().size();i++) {
					        	 outDvD.writeObject(fichier.getListDvd().get(i));
					         }
				         outDvD.close();
				         fileOutDvD.close();
				        
				         
				         
				         
				        FileOutputStream fileOutPer =
							     new FileOutputStream("Per.ser",false);
							         ObjectOutputStream outPer = new ObjectOutputStream(fileOutPer);
							         for(int i = 0 ; i < fichier.getListPeriodique().size();i++) {
							        	 outPer.writeObject(fichier.getListPeriodique().get(i));
							         }
							         outPer.close();
							         fileOutPer.close();
							         
							         FileOutputStream fileOutLivre = new FileOutputStream("Livre.ser",false);
										         ObjectOutputStream outLivre = new ObjectOutputStream(fileOutLivre);
										         for(int i = 0 ; i < fichier.getListLivre().size();i++) {
										        	 outLivre.writeObject(fichier.getListLivre().get(i));
										         }
										         outLivre.close();
										         fileOutLivre.close();
										         
										         FileOutputStream fileOutDoc = new FileOutputStream("Doc.ser",false);
										         ObjectOutputStream outDoc = new ObjectOutputStream(fileOutDoc);
										         for(int i = 0 ; i < fichier.getListDoc().size();i++) {
										        	 outDoc.writeObject(fichier.getListDoc().get(i));
										         }
										         outDoc.close();
										         fileOutDoc.close();						         
										         
										         
										         
				}catch (Exception e1) {
				System.out.println(e1.getMessage() + " >>>");
				}
				newWindow.close();
			});

			newWindow.show();

		}

	};

	public VBox remplirTabDocument(Tab tabDoc) {
		// Tous les documents
		donnees = FXCollections.observableArrayList(fichier.getListDoc());
		table = new TableView<Document>();
		VBox vbox = new VBox();
		vbox.getChildren().add(table);
		TableColumn<Document, String> colonneNumDoc = new TableColumn<Document, String>("Numéro du document");
		TableColumn<Document, String> colonneTitreDoc = new TableColumn<Document, String>("Titre");
		TableColumn<Document, Integer> colonneNomDoc = new TableColumn<Document, Integer>("Nombre de prêt");
		TableColumn<Document, String> colonneDateDoc = new TableColumn<Document, String>("Date");
		TableColumn<Document, String> colonneEtat = new TableColumn<Document, String>("Mots-cle");

		colonneNumDoc.setCellValueFactory(new PropertyValueFactory<>("strNumeroDoc"));
		colonneTitreDoc.setCellValueFactory(new PropertyValueFactory<>("Titre"));
		colonneNomDoc.setCellValueFactory(new PropertyValueFactory<>("intNombreDePret"));
		colonneDateDoc.setCellValueFactory(new PropertyValueFactory<>("Date"));
		colonneEtat.setCellValueFactory(new PropertyValueFactory<>("Etat"));

		table.getColumns().addAll(colonneNumDoc, colonneTitreDoc, colonneNomDoc, colonneDateDoc, colonneEtat);
		table.setItems(donnees);

		colonneNumDoc.setResizable(false);
		colonneTitreDoc.setResizable(false);
		colonneNomDoc.setResizable(false);

		colonneDateDoc.setResizable(false);
		colonneEtat.setResizable(false);

		colonneNumDoc.setMinWidth(150);
		colonneNomDoc.setMinWidth(150);

		colonneDateDoc.setMinWidth(150);
		colonneEtat.setMinWidth(184);
		colonneTitreDoc.setMinWidth(250);

		return vbox;
	}

	public VBox remplirTabDVD(Tab tabDVD) {
		// DVD
		donneesDVD = FXCollections.observableArrayList(fichier.getListDvd());
		tableDVD = new TableView<DVD>();
		VBox vboxDVD = new VBox();
		vboxDVD.getChildren().add(tableDVD);

		TableColumn<DVD, String> colonneNumDVD = new TableColumn<DVD, String>("Numéro du document");
		TableColumn<DVD, String> colonneTitreDVD = new TableColumn<DVD, String>("Titre");
		TableColumn<DVD, Integer> colonneNombreDeDisque = new TableColumn<DVD, Integer>("Volume");
		TableColumn<DVD, String> colonneDateDVD = new TableColumn<DVD, String>("Date");
		TableColumn<DVD, String> colonneEtatDVD = new TableColumn<DVD, String>("Etat");
		TableColumn<DVD, String> colonneAuteurDVD = new TableColumn<DVD, String>("Auteur");
		TableColumn<DVD, Integer> colonneNombreDePret = new TableColumn<DVD, Integer>("Nombre de pret");

		colonneNumDVD.setCellValueFactory(new PropertyValueFactory<>("strNumeroDuDoc"));
		colonneTitreDVD.setCellValueFactory(new PropertyValueFactory<>("strNomDuDvd"));
		colonneDateDVD.setCellValueFactory(new PropertyValueFactory<>("strDate"));
		colonneNombreDeDisque.setCellValueFactory(new PropertyValueFactory<>("intNombreDeDisque"));
		colonneAuteurDVD.setCellValueFactory(new PropertyValueFactory<>("strAuteur"));
		colonneNombreDePret.setCellValueFactory(new PropertyValueFactory<>("intNombreDePret"));
		colonneEtatDVD.setCellValueFactory(new PropertyValueFactory<>("strEtat"));

		tableDVD.getColumns().addAll(colonneNumDVD, colonneTitreDVD, colonneDateDVD, colonneNombreDeDisque,
				colonneAuteurDVD, colonneNombreDePret, colonneEtatDVD);
		tableDVD.setItems(donneesDVD);
		colonneNumDVD.setResizable(false);
		colonneTitreDVD.setResizable(false);
		colonneDateDVD.setResizable(false);
		colonneNombreDeDisque.setResizable(false);
		colonneAuteurDVD.setResizable(false);
		colonneNombreDePret.setResizable(false);
		colonneEtatDVD.setResizable(false);

		colonneNumDVD.setMinWidth(150);
		colonneTitreDVD.setMinWidth(227);
		colonneDateDVD.setMinWidth(100);
		colonneNombreDeDisque.setMinWidth(70);
		colonneAuteurDVD.setMinWidth(120);
		colonneNombreDePret.setMinWidth(120);
		colonneEtatDVD.setMinWidth(100);

		return vboxDVD;

	}

	public VBox remplirTabPer(Tab tabPerio) {
		// Periodiques

		donneesPer = FXCollections.observableArrayList(fichier.getListPeriodique());
		tablePer = new TableView<Periodiques>();
		VBox vboxPer = new VBox();
		vboxPer.getChildren().add(tablePer);

		TableColumn<Periodiques, String> colonneNumPer = new TableColumn<Periodiques, String>("Numéro du document");
		TableColumn<Periodiques, String> colonneTitrePer = new TableColumn<Periodiques, String>("Titre");
		TableColumn<Periodiques, Integer> colonneNumeroDeVolume = new TableColumn<Periodiques, Integer>("Volume");
		TableColumn<Periodiques, Integer> colonneNumeroDePeriodique = new TableColumn<Periodiques, Integer>(
				"Numero de periodique");
		TableColumn<Periodiques, String> colonneDatePer = new TableColumn<Periodiques, String>("Date");
		TableColumn<Periodiques, String> colonneEtatPer = new TableColumn<Periodiques, String>("Etat");
		TableColumn<Periodiques, Integer> colonneNombreDePretPer = new TableColumn<Periodiques, Integer>(
				"Nombre de pret");

		colonneNumPer.setCellValueFactory(new PropertyValueFactory<>("strNumeroDuDoc"));
		colonneTitrePer.setCellValueFactory(new PropertyValueFactory<>("strNomDuPeriodique"));
		colonneNumeroDeVolume.setCellValueFactory(new PropertyValueFactory<>("intNumDuVolume"));
		colonneNumeroDePeriodique.setCellValueFactory(new PropertyValueFactory<>("intNumDuPeriodique"));
		colonneDatePer.setCellValueFactory(new PropertyValueFactory<>("strDate"));
		colonneEtatPer.setCellValueFactory(new PropertyValueFactory<>("strEtat"));
		colonneNombreDePretPer.setCellValueFactory(new PropertyValueFactory<>("intNumDePret"));

		tablePer.getColumns().addAll(colonneNumPer, colonneTitrePer, colonneNumeroDeVolume, colonneNumeroDePeriodique,
				colonneDatePer, colonneEtatPer, colonneNombreDePretPer);
		tablePer.setItems(donneesPer);
		colonneNumPer.setResizable(false);
		colonneTitrePer.setResizable(false);
		colonneNumeroDeVolume.setResizable(false);
		colonneNumeroDePeriodique.setResizable(false);
		colonneDatePer.setResizable(false);
		colonneEtatPer.setResizable(false);
		colonneNombreDePretPer.setResizable(false);

		colonneNumPer.setMinWidth(150);
		colonneTitrePer.setMinWidth(197);
		colonneNumeroDeVolume.setMinWidth(70);
		colonneNumeroDePeriodique.setMinWidth(150);
		colonneDatePer.setMinWidth(100);
		colonneEtatPer.setMinWidth(100);
		colonneNombreDePretPer.setMinWidth(120);
		return vboxPer;

	}

	public VBox remplirTabLivre(Tab tabLivre) {
		// Livre

		donneesLivre = FXCollections.observableArrayList(fichier.getListLivre());
		tableLivre = new TableView<Livre>();
		VBox vboxLivre = new VBox();
		vboxLivre.getChildren().add(tableLivre);

		TableColumn<Livre, String> colonneNumLivre = new TableColumn<Livre, String>("Numéro du document");
		TableColumn<Livre, String> colonneTitreLivre = new TableColumn<Livre, String>("Titre");
		TableColumn<Livre, String> colonneAuteurLivre = new TableColumn<Livre, String>("Auteur");
		TableColumn<Livre, String> colonneDateLivre = new TableColumn<Livre, String>("Date");
		TableColumn<Livre, String> colonneEtatLivre = new TableColumn<Livre, String>("Etat");
		TableColumn<Livre, Integer> colonneNombreDePretLivre = new TableColumn<Livre, Integer>("Nombre de pret");

		colonneNumLivre.setCellValueFactory(new PropertyValueFactory<>("strNumeroDoc"));
		colonneTitreLivre.setCellValueFactory(new PropertyValueFactory<>("Titre"));
		colonneAuteurLivre.setCellValueFactory(new PropertyValueFactory<>("Auteur"));
		colonneDateLivre.setCellValueFactory(new PropertyValueFactory<>("Date"));
		colonneEtatLivre.setCellValueFactory(new PropertyValueFactory<>("Etat"));
		colonneNombreDePretLivre.setCellValueFactory(new PropertyValueFactory<>("intNombreDePret"));

		colonneNumLivre.setResizable(false);
		colonneTitreLivre.setResizable(false);
		colonneAuteurLivre.setResizable(false);
		colonneDateLivre.setResizable(false);
		colonneEtatLivre.setResizable(false);
		colonneNombreDePretLivre.setResizable(false);

		colonneNumLivre.setMinWidth(150);
		colonneTitreLivre.setMinWidth(247);
		colonneAuteurLivre.setMinWidth(180);
		colonneDateLivre.setMinWidth(100);
		colonneEtatLivre.setMinWidth(100);
		colonneNombreDePretLivre.setMinWidth(120);

		tableLivre.getColumns().addAll(colonneNumLivre, colonneTitreLivre, colonneAuteurLivre, colonneDateLivre,
				colonneEtatLivre, colonneNombreDePretLivre);
		tableLivre.setItems(donneesLivre);
		return vboxLivre;

	}

	private EventHandler<ActionEvent> gestionSupprimer = new EventHandler<ActionEvent>() {

		public void handle(ActionEvent arg0) {
			// TODO Auto-generated method stub
			// ObservableList<Document> listeSelectionne =
			// .getSelectionModel().getSelectedItems();
			Document doc = table.getSelectionModel().getSelectedItem();
			DVD docDVD = tableDVD.getSelectionModel().getSelectedItem();
			Livre docLivre = tableLivre.getSelectionModel().getSelectedItem();
			Periodiques docPer = tablePer.getSelectionModel().getSelectedItem();
			if (doc != null) {

				for (int i = 0; i < fichier.getListDoc().size(); i++) {
					if (fichier.getListDoc().get(i).getStrNumeroDoc().equals(doc.getStrNumeroDoc())) {
						if (fichier.getListDoc().get(i).getTypeDocument() == TypeDocument.DVD) {
							for (int j = 0; j < fichier.getListDvd().size(); j++) {
								if (fichier.getListDvd().get(j).getStrNumeroDuDoc().equals(doc.getStrNumeroDoc())) {
									fichier.getListDvd().remove(j);
								}
							}
						} else if (fichier.getListDoc().get(i).getTypeDocument() == TypeDocument.LIVRE) {
							for (int j = 0; j < fichier.getListLivre().size(); j++) {
								if (fichier.getListLivre().get(j).getStrNumeroDoc().equals(doc.getStrNumeroDoc())) {
									fichier.getListLivre().remove(j);
								}
							}
						} else if (fichier.getListDoc().get(i).getTypeDocument() == TypeDocument.PERIODIQUES) {
							for (int j = 0; j < fichier.getListPeriodique().size(); j++) {
								if (fichier.getListPeriodique().get(j).getStrNumeroDuDoc()
										.equals(doc.getStrNumeroDoc())) {
									fichier.getListPeriodique().remove(j);
								}
							}
						}

						fichier.getListDoc().remove(i);

						// table.getItems().remove(doc);
						tabDoc.setContent(remplirTabDocument(tabDoc));
						tabLivre.setContent(remplirTabLivre(tabLivre));
						tabPerio.setContent(remplirTabPer(tabPerio));
						tabDVD.setContent(remplirTabDVD(tabDVD));
					}
				}
			}
			if (docDVD != null) {

				for (int i = 0; i < fichier.getListDoc().size(); i++) {
					if (fichier.getListDoc().get(i).getStrNumeroDoc().equals(docDVD.getStrNumeroDuDoc())) {

						if (fichier.getListDoc().get(i).getTypeDocument() == TypeDocument.DVD) {
							for (int j = 0; j < fichier.getListDvd().size(); j++) {
								if (fichier.getListDvd().get(j).getStrNumeroDuDoc()
										.equals(docDVD.getStrNumeroDuDoc())) {
									fichier.getListDvd().remove(j);
								}
							}
						}
						fichier.getListDoc().remove(i);
					}

				}
				tabDoc.setContent(remplirTabDocument(tabDoc));
				tabDVD.setContent(remplirTabDVD(tabDVD));

			}

			if (docLivre != null) {

				for (int i = 0; i < fichier.getListDoc().size(); i++) {
					if (fichier.getListDoc().get(i).getStrNumeroDoc().equals(docLivre.getStrNumeroDoc())) {
						if (fichier.getListDoc().get(i).getTypeDocument() == TypeDocument.LIVRE) {
							for (int j = 0; j < fichier.getListLivre().size(); j++) {
								if (fichier.getListLivre().get(j).getStrNumeroDoc()
										.equals(docLivre.getStrNumeroDoc())) {
									fichier.getListLivre().remove(j);
								}
							}
						}
						fichier.getListDoc().remove(i);
					}

				}
				tabDoc.setContent(remplirTabDocument(tabDoc));
				tabLivre.setContent(remplirTabLivre(tabLivre));

			}

			if (docPer != null) {

				for (int i = 0; i < fichier.getListDoc().size(); i++) {
					if (fichier.getListDoc().get(i).getStrNumeroDoc().equals(docPer.getStrNumeroDuDoc())) {
						if (fichier.getListDoc().get(i).getTypeDocument() == TypeDocument.PERIODIQUES) {
							for (int j = 0; j < fichier.getListPeriodique().size(); j++) {
								if (fichier.getListPeriodique().get(j).getStrNumeroDuDoc()
										.equals(docPer.getStrNumeroDuDoc())) {
									fichier.getListPeriodique().remove(j);
								}
							}
						}
						fichier.getListDoc().remove(i);
					}

				}
				tabDoc.setContent(remplirTabDocument(tabDoc));
				tabPerio.setContent(remplirTabPer(tabPerio));

			}
		}

	};

	private EventHandler<ActionEvent> gestionPret = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent a) {
			// TODO Auto-generated method stub
			Document doc = table.getSelectionModel().getSelectedItem();
			DVD docDVD = tableDVD.getSelectionModel().getSelectedItem();
			Livre docLivre = tableLivre.getSelectionModel().getSelectedItem();
			Periodiques docPer = tablePer.getSelectionModel().getSelectedItem();

			if (doc != null) {
				if (doc.getEtat() == "Disponible") {
					switch (doc.getTypeDocument()) {
					case LIVRE:
						if (intCompteurLivre < 3) {
							pret(doc);
							tabLivre.setContent(remplirTabLivre(tabLivre));
							intCompteurLivre++;

						} else {
							messageErreurMaxLivre();
						}
						break;
					case PERIODIQUES:
						if (intCompteurPerio < 3) {
							pret(doc);
							tabPerio.setContent(remplirTabPer(tabPerio));
							intCompteurPerio++;
						} else {
							messageErreurMaxPerio();
						}
						break;
					case DVD:
						if (intCompteurDVD < 3) {
							pret(doc);
							intCompteurDVD++;
							tabDVD.setContent(remplirTabDVD(tabDVD));
						} else {
							messageErreurMaxDVD();
						}
						break;
					}
				} else {
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Prêt du livre");
					alert.setHeaderText(null);
					alert.setContentText("Le livre '" + doc.getTitre() + "' n'est pas disponible");
					alert.showAndWait();
				}
			} else if (docLivre != null) {
				if (docLivre.getEtat() == "Disponible") {
					if (intCompteurLivre < 3) {
						pret(doc);
						tabLivre.setContent(remplirTabLivre(tabLivre));
						intCompteurLivre++;

					} else {
						messageErreurMaxLivre();
					}
				} else {
					messageErreur();
				}
			} else if (docPer != null) {
				if (docPer.getStrEtat() == "Disponible") {
					if (intCompteurPerio < 3) {
						pret(doc);
						tabPerio.setContent(remplirTabPer(tabPerio));
						intCompteurPerio++;
					} else {
						messageErreurMaxPerio();
					}
				} else {
					messageErreur();
				}
			} else if (docDVD != null) {
				if (docDVD.getStrDate() == "Disponible") {
					if (intCompteurDVD < 3) {
						pret(doc);
						intCompteurDVD++;
						tabDVD.setContent(remplirTabDVD(tabDVD));
					} else {
						messageErreurMaxDVD();
					}
				} else {
					messageErreur();
				}
			}

			else {
				messageErreur();
			}
		}
	};

	private EventHandler<ActionEvent> gestionRetour = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent a) {
			// TODO Auto-generated method stub

		}

	};

	private EventHandler<ActionEvent> gestionAjouter = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent arg0) {
			// TODO Auto-generated method stub
			stageAjouter = new Stage();
			VBox ajouterFenetre = new VBox();
			VBox vBox = new VBox();
			ajouterFenetre.setAlignment(Pos.CENTER);
			Scene troisiemeScene = new Scene(ajouterFenetre, 500, 350);

			Label labelTypeDoc = new Label("Type de Document : ");
			Label labelTitre = new Label("Titre : ");
			Label labelAuteur = new Label("Auteur : ");
			Label labelMC = new Label("Mots clés (séparé par des virgules) : ");
			Label labelDate = new Label("Date : ");
			Label labelNumPerio = new Label("Numéro de périodique : ");
			Label labelVolumePerio = new Label("Volume : ");

			labelMC.setMinSize(180, 30);
			labelTitre.setMinSize(180, 30);
			labelAuteur.setMinSize(180, 30);
			labelDate.setMinSize(180, 30);
			labelNumPerio.setMinSize(180, 30);
			labelVolumePerio.setMinSize(180, 30);

			labelTypeDoc.setFont(Font.font("Arial", FontWeight.BOLD, 13));
			labelTypeDoc.setTextFill(Color.WHITE);
			labelTitre.setFont(Font.font("Arial", FontWeight.BOLD, 13));
			labelTitre.setTextFill(Color.WHITE);
			labelAuteur.setFont(Font.font("Arial", FontWeight.BOLD, 13));
			labelAuteur.setTextFill(Color.WHITE);
			labelMC.setFont(Font.font("Arial", FontWeight.BOLD, 13));
			labelMC.setTextFill(Color.WHITE);
			labelDate.setFont(Font.font("Arial", FontWeight.BOLD, 13));
			labelDate.setTextFill(Color.WHITE);
			labelNumPerio.setFont(Font.font("Arial", FontWeight.BOLD, 13));
			labelNumPerio.setTextFill(Color.WHITE);
			labelVolumePerio.setFont(Font.font("Arial", FontWeight.BOLD, 13));
			labelVolumePerio.setTextFill(Color.WHITE);

			tfVolumePerio = new TextField();
			tfNumPerio = new TextField();
			tfTitre = new TextField();
			tfAuteur = new TextField();
			tfMC = new TextField();
			tfTitre.setMinSize(180, 30);
			tfAuteur.setMinSize(180, 30);
			tfMC.setMinSize(180, 30);
			tfVolumePerio.setMinSize(180, 30);
			tfNumPerio.setMinSize(180, 30);

			dp = new DatePicker();

			ObservableList<String> optionDocument = FXCollections.observableArrayList("Livre", "DVD", "Periodiques");
			comboBox = new ComboBox(optionDocument);
			comboBox.setMinWidth(250);
			HBox hBox = new HBox();
			hBox.getChildren().addAll(labelTypeDoc, comboBox);
			hBox.setAlignment(Pos.CENTER_LEFT);
			hBox.setSpacing(50);
			hBox.setPadding(new Insets(10));
			vBox.getChildren().add(hBox);
			vBox.setBorder(border2);

			HBox hBoxInfo = new HBox();
			VBox vBoxLabel = new VBox();
			vBoxLabel.setSpacing(10);
			vBoxLabel.setPadding(new Insets(10));
			VBox vBoxTF = new VBox();
			vBoxTF.setSpacing(10);
			vBoxTF.setPadding(new Insets(10));
			hBoxInfo.getChildren().addAll(vBoxLabel, vBoxTF);
			hBoxInfo.setBorder(border2);
			HBox hBoxButton = new HBox();
			hBoxButton.getChildren().addAll(btnAnnuler, btnConfirmer);
			btnAnnuler.setOnMouseClicked(e -> stageAjouter.close());
			btnConfirmer.setOnMouseClicked(gestionConfirmer);
			hBoxButton.setSpacing(20);
			hBoxButton.setAlignment(Pos.BOTTOM_RIGHT);

			vBoxLabel.getChildren().addAll(labelTitre, labelDate, labelMC, labelAuteur);
			vBoxTF.getChildren().addAll(tfTitre, dp, tfMC, tfAuteur);

			comboBox.setOnAction(e -> {
				Object strChoix = comboBox.getSelectionModel().getSelectedItem();
				strReponse = strChoix.toString();
				if (strReponse == "Periodiques") {
					try {
						vBoxLabel.getChildren().addAll(labelVolumePerio, labelNumPerio);
						vBoxTF.getChildren().addAll(tfVolumePerio, tfNumPerio);
						vBoxLabel.getChildren().remove(labelAuteur);
						vBoxTF.getChildren().remove(tfAuteur);
					} catch (Exception e1) {

					}
				} else {
					try {
						vBoxLabel.getChildren().add(labelAuteur);
						vBoxTF.getChildren().add(tfAuteur);
						vBoxLabel.getChildren().removeAll(labelVolumePerio, labelNumPerio);
						vBoxTF.getChildren().removeAll(tfVolumePerio, tfNumPerio);
					} catch (Exception e2) {

					}
				}
			});

			ajouterFenetre.setSpacing(20);
			ajouterFenetre.getChildren().addAll(vBox, hBoxInfo, hBoxButton);
			ajouterFenetre.setPadding(new Insets(10));

			ajouterFenetre.setBackground(bg4);
			stageAjouter.setTitle("Ajouter un document");
			stageAjouter.setScene(troisiemeScene);
			stageAjouter.show();
			stageAjouter.setResizable(false);
		}

	};

	private EventHandler<MouseEvent> gestionConfirmer = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent arg0) {
			// TODO Auto-generated method stub
			try {
				String typeDoc = (String) comboBox.getSelectionModel().getSelectedItem();
				String strTitre = tfTitre.getText();
				String strAuteur = tfAuteur.getText();
				String strMotCle = tfMC.getText();
				int intVolumePerio = Integer.parseInt(tfVolumePerio.getText());
				int intNumPerio = Integer.parseInt(tfNumPerio.getText());
				String date = dp.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				switch (typeDoc) {
				case "DVD":
					int intNumeroDocDVD = fichier.getListDvd().size() + 1;
					Document docDvd = new Document("DVD" + intNumeroDocDVD, strTitre, date, "Disponible", 0,
							TypeDocument.DVD);
					DVD dvd = new DVD("DVD" + intNumeroDocDVD, strTitre, date, 2, strAuteur, 0, "Disponible");
					fichier.getListDvd().add(dvd);
					fichier.getListDoc().add(docDvd);
					tabDoc.setContent(remplirTabDocument(tabDoc));
					tabDVD.setContent(remplirTabDVD(tabDVD));
					break;
				case "Periodiques":
					int intNumeroDocPer = fichier.getListPeriodique().size() + 1;
					Document docPer = new Document("Per" + intNumeroDocPer, strTitre, date, "Disponible", 0,
							TypeDocument.PERIODIQUES);
					Periodiques per = new Periodiques("Per" + intNumeroDocPer, strTitre, date, intVolumePerio, intNumPerio, "Disponible", 0, TypeDocument.PERIODIQUES);
					fichier.getListPeriodique().add(per);
					fichier.getListDoc().add(docPer);
					tabDoc.setContent(remplirTabDocument(tabDoc));
					tabPerio.setContent(remplirTabPer(tabPerio));
					
					break;
				case "Livre":
					int intNumeroDocLivre = fichier.getListLivre().size() + 1;
					Document docLivre = new Document("Livre" + intNumeroDocLivre, strTitre, date, "Disponible", 0,
							TypeDocument.LIVRE);
					Livre liv = new Livre("Livre" + intNumeroDocLivre, strTitre, "Disponible", date, strAuteur,
							TypeDocument.LIVRE, 0);
					fichier.getListLivre().add(liv);
					fichier.getListDoc().add(docLivre);

					tabDoc.setContent(remplirTabDocument(tabDoc));
					tabLivre.setContent(remplirTabLivre(tabLivre));
					break;

				default:
					break;
				}
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Ajout de document");
				alert.setHeaderText(null);
				alert.setContentText("Votre document à été ajouté");
				stageAjouter.close();
				alert.showAndWait();

			} catch (Exception e) {
				Alert alert1 = new Alert(AlertType.ERROR);
				alert1.setTitle("Erreur!");
				alert1.setHeaderText("Une des cases est vide!");
				alert1.setContentText("Il est obligatoire de remplir tous les cases pour ajouter un document");

				alert1.showAndWait();
			}
		}
	};

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		root = new BorderPane();
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

		btnUsager.setOnAction(gestionUsager);
		btnUsager.setOnMouseClicked(e -> {
			primaryStage.hide();

		});

		btnConnexion.setOnAction(gestionConnexion);
		btnConnexion.setOnMouseClicked(e -> {
			primaryStage.hide();

		});
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
	
	public void launch() {
		root = new BorderPane();
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

		btnUsager.setOnAction(gestionUsager);
		btnUsager.setOnMouseClicked(e -> {
			primaryStage.hide();

		});

		btnConnexion.setOnAction(gestionConnexion);
		btnConnexion.setOnMouseClicked(e -> {
			primaryStage.hide();

		});

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

	public void parametreBoutton() {

		addView.setFitHeight(40);
		delView.setFitHeight(40);
		gererView.setFitHeight(40);
		pretView.setFitHeight(40);
		retourView.setFitHeight(40);
		quitterView.setFitHeight(30);
		confirmerView.setFitHeight(30);
		annulerView.setFitHeight(30);
		inscireView.setFitHeight(30);

		addView.setFitWidth(40);
		delView.setFitWidth(40);
		gererView.setFitWidth(40);
		pretView.setFitWidth(40);
		retourView.setFitWidth(40);
		quitterView.setFitWidth(30);
		confirmerView.setFitWidth(30);
		annulerView.setFitWidth(30);
		inscireView.setFitWidth(30);

		btnAjouter.setMinHeight(50);
		btnSupprimer.setMinHeight(50);
		btnGerer.setMinHeight(50);
		btnInscire.setMinHeight(50);
		btnRetour.setMinHeight(50);
		btnQuitter.setMinHeight(40);
		btnConfirmer.setMinHeight(40);
		btnAnnuler.setMinHeight(40);

		btnAjouter.setGraphic(addView);
		btnSupprimer.setGraphic(delView);
		btnGerer.setGraphic(gererView);
		btnInscire.setGraphic(pretView);
		btnRetour.setGraphic(retourView);
		btnQuitter.setGraphic(quitterView);
		btnConfirmer.setGraphic(confirmerView);
		btnAnnuler.setGraphic(annulerView);

		btnAjouter.setFont(Font.font("Arial", FontWeight.BOLD, 13));
		btnSupprimer.setFont(Font.font("Arial", FontWeight.BOLD, 13));
		btnGerer.setFont(Font.font("Arial", FontWeight.BOLD, 13));
		btnInscire.setFont(Font.font("Arial", FontWeight.BOLD, 13));
		btnRetour.setFont(Font.font("Arial", FontWeight.BOLD, 13));
		btnQuitter.setFont(Font.font("Arial", FontWeight.BOLD, 13));
		btnConfirmer.setFont(Font.font("Arial", FontWeight.BOLD, 13));
		btnAnnuler.setFont(Font.font("Arial", FontWeight.BOLD, 13));

		btnAjouter.setMinWidth(250);
		btnSupprimer.setMinWidth(250);
		btnGerer.setMinWidth(250);
		btnInscire.setMinWidth(250);
		btnRetour.setMinWidth(250);
		btnConfirmer.setMinWidth(100);
		btnAnnuler.setMinWidth(100);
	}

	public void pret(Document doc) {
		int nbJour = 0;
		doc.setEtat("Non Disponible");

		switch (doc.getTypeDocument()) {
		case LIVRE:
			for (int i = 0; i < fichier.getListLivre().size(); i++) {
				if (doc.getStrNumeroDoc() == fichier.getListLivre().get(i).getStrNumeroDoc()) {
					fichier.getListLivre().get(i).setEtat("Non Disponible");
					fichier.getListLivre().get(i)
							.setIntNombreDePret(fichier.getListLivre().get(i).getIntNombreDePret() + 1);
					nbJour = 14;
				}
			}
			break;
		case PERIODIQUES:
			for (int j = 0; j < fichier.getListPeriodique().size(); j++) {
				if (doc.getStrNumeroDoc() == fichier.getListPeriodique().get(j).getStrNumeroDuDoc()) {
					fichier.getListPeriodique().get(j).setStrEtat("Non Disponible");
					fichier.getListPeriodique().get(j)
							.setIntNumDePret(fichier.getListPeriodique().get(j).getIntNumDePret() + 1);
					nbJour = 3;
				}
			}
			break;
		case DVD:
			for (int k = 0; k < fichier.getListDvd().size(); k++) {
				if (doc.getStrNumeroDoc() == fichier.getListDvd().get(k).getStrNumeroDuDoc()) {
					fichier.getListDvd().get(k).setStrEtat("Non Disponible");
					fichier.getListDvd().get(k)
							.setIntNombreDePret(fichier.getListDvd().get(k).getIntNombreDePret() + 1);
					nbJour = 7;
				}
			}
			break;
		}
		tabDoc.setContent(remplirTabDocument(tabDoc));

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date datePret = new Date();

		// i.e two weeks
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(datePret);
		calendar.add(Calendar.DAY_OF_YEAR, nbJour);
		Date dateRetour = calendar.getTime();

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Prêt du document");
		alert.setHeaderText(null);
		alert.setContentText("Vous avez emprunté le document '" + doc.getTitre() + "'\n\nType du document : "
				+ doc.getTypeDocument() + "\nDate du prêt : " + dateFormat.format(datePret) + "\nDate de retour : "
				+ dateFormat.format(dateRetour));
		alert.showAndWait();

	}

	public void messageErreur() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Prêt du document impossible");
		alert.setHeaderText(null);
		alert.setContentText("Veuillez choisir un document disponible dans la liste");
		alert.showAndWait();
	}

	public void messageErreurMaxLivre() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Prêt du livre impossible");
		alert.setHeaderText(null);
		alert.setContentText("Vous avez déjà emprunté le nombre maximum de livres!");
		alert.showAndWait();
	}

	public void messageErreurMaxPerio() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Prêt du périodique impossible");
		alert.setHeaderText(null);
		alert.setContentText("Vous avez déjà emprunté le nombre maximum de périodiques!");
		alert.showAndWait();
	}

	public void messageErreurMaxDVD() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Prêt du DVD impossible");
		alert.setHeaderText(null);
		alert.setContentText("Vous avez déjà emprunté le nombre maximum de DVDs!");
		alert.showAndWait();
		;
	}

	public void gestionErreurLoginAdherant(TextField tfNumTel, TextField tfNom, TextField tfPrenom) {
		
	}
	
	public void gestionErreurInscriptionAdherant(TextField tf1, TextField tf2, TextField tf3, TextField tf4) {
		if (tf1.getText().isEmpty() || tf2.getText().isEmpty() || tf3.getText().isEmpty() || tf4.getText().isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Inscription impossible");
			alert.setHeaderText(null);
			alert.setContentText("Vous devez remplir toutes les cases pour vous inscire en tant qu'adhérant");
			alert.showAndWait();
		}
	}
}
