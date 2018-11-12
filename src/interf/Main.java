package interf;

import java.time.format.DateTimeFormatter;
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

	private ImageView imageView = new ImageView(image3);
	private ImageView addView = new ImageView(imageAdd);
	private ImageView delView = new ImageView(imageDel);
	private ImageView gererView = new ImageView(imageGerer);
	private ImageView retourView = new ImageView(imageRetour);
	private ImageView pretView = new ImageView(imagePret);
	private ImageView quitterView = new ImageView(imageQuitter);
	private ImageView confirmerView = new ImageView(imageConfirmer);
	private ImageView annulerView = new ImageView(imageAnnuler);

	private Button btnAjouter = new Button("Ajouter un document");
	private Button btnSupprimer = new Button("Supprimer un document");
	private Button btnGerer = new Button("G�rer les adh�rents");
	private Button btnInscire = new Button("Inscire un pr�t");
	private Button btnRetour = new Button("Inscire un retour");
	private Button btnQuitter = new Button("D�connexion");
	private Button btnUsager = new Button("�tes vous un usager?");
	private Button btnConnexion = new Button("Connexion");
	private Button btnConfirmer = new Button("Confirmer");
	private Button btnAnnuler = new Button("Annuler");
	
	private Tab tabDoc = new Tab("Collection");
	private Tab tabLivre = new Tab("Livres");
	private Tab tabPerio = new Tab("P�riodiques");
	private Tab tabDVD = new Tab("DVDS");
	
	private BackgroundSize bgTaille = new BackgroundSize(500, 400, false, false, false, false);
	private BackgroundSize bgTaille2 = new BackgroundSize(1280, 720, false, false, false, false);
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
	private LectureFichier fichier = new LectureFichier();
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

			Text t = new Text("\nCopyright � 2018 \nM�diath�que r�alis�e par : \nAlex Gari�py et Mohamed Djelloud");
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
				btnInscire.setDisable(true);
				btnRetour.setDisable(true);
			}

			btnAjouter.setOnAction(gestionAjouter);

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

			

			
			fichier.lecture();
			
			tabDoc.setContent(remplirTabDocument(tabDoc));
			tabLivre.setContent(remplirTabLivre(tabLivre));
			tabPerio.setContent(remplirTabPer(tabPerio));
			tabDVD.setContent(remplirTabDVD(tabDVD));
			
			
			tabDoc.setClosable(false);
			tabLivre.setClosable(false);
			tabPerio.setClosable(false);
			tabDVD.setClosable(false);
			

			tp.getTabs().addAll(tabDoc, tabLivre, tabPerio, tabDVD);
			vBox1.getChildren().addAll(tp, hBox);
			mediathequeFenetre.setLeft(vBox1);
			mediathequeFenetre.setRight(vBox2);
			mediathequeFenetre.setPadding(new Insets(30));

			// New window (Stage)
			Stage newWindow = new Stage();
			newWindow.setTitle("M�diath�que");
			newWindow.setScene(secondScene);
			newWindow.setResizable(false);
			btnQuitter.setOnAction(e -> {
				newWindow.close();
				
			});

			newWindow.show();

		}

	};
	public VBox remplirTabDocument(Tab tabDoc) {
		//Tous les documents
		ObservableList<Document> donnees = FXCollections.observableArrayList(fichier.getListDoc());
		TableView<Document> table = new TableView<Document>();
		VBox vbox = new VBox();
		vbox.getChildren().add(table);
		TableColumn<Document, String> colonneNumDoc = new TableColumn<Document, String>("Num�ro du document");
		TableColumn<Document, String> colonneTitreDoc = new TableColumn<Document, String>("Titre");
		TableColumn<Document, Integer> colonneNomDoc = new TableColumn<Document, Integer>("Nombre de pr�t");
		TableColumn<Document, String> colonneDateDoc = new TableColumn<Document, String>("Date");
		TableColumn<Document, String> colonneEtat = new TableColumn<Document, String>("Mots-cle");
		
		colonneNumDoc.setCellValueFactory(new PropertyValueFactory<>("strNumeroDoc"));
		colonneTitreDoc.setCellValueFactory(new PropertyValueFactory<>("Titre"));
		colonneNomDoc.setCellValueFactory(new PropertyValueFactory<>("intNombreDePret"));
		colonneDateDoc.setCellValueFactory(new PropertyValueFactory<>("Date"));
		colonneEtat.setCellValueFactory(new PropertyValueFactory<>("Etat"));
		
		table.getColumns().addAll(colonneNumDoc, colonneTitreDoc, colonneNomDoc,
				colonneDateDoc, colonneEtat);
		table.setItems(donnees);
		
		colonneNumDoc.setResizable(false);
		colonneTitreDoc.setResizable(false);
		colonneNomDoc.setResizable(false);
	
		colonneDateDoc.setResizable(false);
		colonneEtat.setResizable(false);

		colonneNumDoc.setMinWidth(150);
		colonneNomDoc.setMinWidth(150);
	
		colonneDateDoc.setMinWidth(150);
	
		colonneTitreDoc.setMinWidth(150);
		
		return vbox;
	}
	public VBox remplirTabDVD(Tab tabDVD) {
		//DVD
		System.out.println("aaa");
		ObservableList<DVD> donneesDVD = FXCollections.observableArrayList(fichier.getListDvd());
		TableView<DVD> tableDVD = new TableView<DVD>();
		VBox vboxDVD = new VBox();
		vboxDVD.getChildren().add(tableDVD);
		
		
		TableColumn<DVD, String> colonneNumDVD = new TableColumn<DVD, String>("Num�ro du document");
		TableColumn<DVD, String> colonneTitreDVD = new TableColumn<DVD, String>("Titre");
		TableColumn<DVD, Integer> colonneNombreDeDisque = new TableColumn<DVD, Integer>("Nombre de disque");
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
		
		tableDVD.getColumns().addAll(colonneNumDVD, colonneTitreDVD, colonneDateDVD,
				colonneNombreDeDisque, colonneAuteurDVD,colonneNombreDePret,colonneEtatDVD);
		tableDVD.setItems(donneesDVD);
		colonneNumDVD.setResizable(false);
		colonneTitreDVD.setResizable(false);
		colonneDateDVD.setResizable(false);
		colonneNombreDeDisque.setResizable(false);
		colonneAuteurDVD.setResizable(false);
		colonneNombreDePret.setResizable(false);
		colonneEtatDVD.setResizable(false);
		
		
		
		colonneNumDVD.setMinWidth(150);
		colonneTitreDVD.setMinWidth(150);
		colonneDateDVD.setMinWidth(150);
		colonneNombreDeDisque.setMinWidth(150);
		colonneAuteurDVD.setMinWidth(150);
		colonneNombreDePret.setMinWidth(150);
		colonneEtatDVD.setMinWidth(150);
		
	
		return vboxDVD;
		
	}
	public VBox remplirTabPer(Tab tabPerio) {
		//Periodiques
		
		ObservableList<Periodiques> donneesPer = FXCollections.observableArrayList(fichier.getListPeriodique());
		TableView<Periodiques> tablePer = new TableView<Periodiques>();
		VBox vboxPer = new VBox();
		vboxPer.getChildren().add(tablePer);
		
		TableColumn<Periodiques, String> colonneNumPer = new TableColumn<Periodiques, String>("Num�ro du document");
		TableColumn<Periodiques, String> colonneTitrePer = new TableColumn<Periodiques, String>("Titre");
		TableColumn<Periodiques, Integer> colonneNumeroDeVolume = new TableColumn<Periodiques,Integer>("Numero de volume");
		TableColumn<Periodiques, Integer> colonneNumeroDePeriodique= new TableColumn<Periodiques,Integer>("Numero de periodique");
		TableColumn<Periodiques, String> colonneDatePer = new TableColumn<Periodiques, String>("Date");
		TableColumn<Periodiques, String> colonneEtatPer = new TableColumn<Periodiques, String>("Etat");
		TableColumn<Periodiques,Integer> colonneNombreDePretPer = new TableColumn<Periodiques, Integer>("Nombre de pret");
		
		
		colonneNumPer.setCellValueFactory(new PropertyValueFactory<>("strNumeroDuDoc"));
		colonneTitrePer.setCellValueFactory(new PropertyValueFactory<>("strNomDuPeriodique"));
		colonneNumeroDeVolume.setCellValueFactory(new PropertyValueFactory<>("intNumDuVolume"));
		colonneNumeroDePeriodique.setCellValueFactory(new PropertyValueFactory<>("intNumDuPeriodique"));
		colonneDatePer.setCellValueFactory(new PropertyValueFactory<>("strDate"));
		colonneEtatPer.setCellValueFactory(new PropertyValueFactory<>("strEtat"));
		colonneNombreDePretPer.setCellValueFactory(new PropertyValueFactory<>("intNumDePret"));
		
		tablePer.getColumns().addAll(colonneNumPer, colonneTitrePer, colonneNumeroDeVolume,
				colonneNumeroDePeriodique, colonneDatePer,colonneEtatPer,colonneNombreDePretPer);
		tablePer.setItems(donneesPer);
		colonneNumPer.setResizable(false);
		colonneTitrePer.setResizable(false);
		colonneNumeroDeVolume.setResizable(false);
		colonneNumeroDePeriodique.setResizable(false);
		colonneDatePer.setResizable(false);
		colonneEtatPer.setResizable(false);
		colonneNombreDePretPer.setResizable(false);
		
		
		colonneNumPer.setMinWidth(150);
		colonneTitrePer.setMinWidth(150);
		colonneNumeroDeVolume.setMinWidth(150);
		colonneNumeroDePeriodique.setMinWidth(150);
		colonneDatePer.setMinWidth(150);
		colonneEtatPer.setMinWidth(150);
		colonneNombreDePretPer.setMinWidth(150);
		return vboxPer;
		
	}
	public VBox remplirTabLivre(Tab tabLivre) {
		//Livre
		
		ObservableList<Livre> donneesLivre = FXCollections.observableArrayList(fichier.getListLivre());
		TableView<Livre> tableLivre = new TableView<Livre>();
		VBox vboxLivre = new VBox();
		vboxLivre.getChildren().add(tableLivre);
		
		TableColumn<Livre, String> colonneNumLivre = new TableColumn<Livre, String>("Num�ro du document");
		TableColumn<Livre, String> colonneTitreLivre = new TableColumn<Livre, String>("Titre");
		TableColumn<Livre, String> colonneAuteurLivre = new TableColumn<Livre, String>("Auteur");
		TableColumn<Livre, String> colonneDateLivre = new TableColumn<Livre, String>("Date");
		TableColumn<Livre, String> colonneEtatLivre = new TableColumn<Livre, String>("Etat");
		TableColumn<Livre,Integer> colonneNombreDePretLivre = new TableColumn<Livre, Integer>("Nombre de pret");
		
		
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
		colonneTitreLivre.setMinWidth(150);
		colonneAuteurLivre.setMinWidth(150);
		colonneDateLivre.setMinWidth(150);
		colonneEtatLivre.setMinWidth(150);
		colonneNombreDePretLivre.setMinWidth(150);
		
		tableLivre.getColumns().addAll(colonneNumLivre, colonneTitreLivre, colonneAuteurLivre,
				colonneDateLivre, colonneEtatLivre,colonneNombreDePretLivre);
		tableLivre.setItems(donneesLivre);
		return vboxLivre;
		
	}

	private EventHandler<ActionEvent> gestionAjouter = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Stage stageAjouter = new Stage();
			VBox ajouterFenetre = new VBox();
			VBox vBox = new VBox();
			ajouterFenetre.setAlignment(Pos.CENTER);
			Scene troisiemeScene = new Scene(ajouterFenetre, 500, 350);

			Label labelTypeDoc = new Label("Type de Document : ");
			Label labelTitre = new Label("Titre : ");
			Label labelAuteur = new Label("Auteur : ");
			Label labelMC = new Label("Mots cl�s (s�par� par des virgules) : ");
			Label labelDate = new Label("Date : ");
			labelMC.setMinSize(180, 30);
			labelTitre.setMinSize(180, 30);
			labelAuteur.setMinSize(180, 30);
			labelDate.setMinSize(180, 30);
			
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
			
			TextField tfTitre = new TextField();
			TextField tfAuteur = new TextField();
			TextField tfMC = new TextField();
			tfTitre.setMinSize(180, 30);
			tfAuteur.setMinSize(180, 30);
			tfMC.setMinSize(180, 30);
			
			DatePicker dp = new DatePicker();
	
			ObservableList<String> optionDocument = FXCollections.observableArrayList("Livre", "DVD",
					"Periodiques");
			ComboBox comboBox = new ComboBox(optionDocument);
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
			//
			HBox hBoxButton = new HBox();
			hBoxButton.getChildren().addAll(btnAnnuler, btnConfirmer);
			btnConfirmer.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
				String typeDoc =(String) comboBox.getSelectionModel().getSelectedItem();
				String strTitre = tfTitre.getText();
				String strAuteur = tfAuteur.getText();
				String strMotCle = tfMC.getText();
				String date = dp.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				
				if(typeDoc == null) {
					
					}else if(strTitre == "") {
						
					}else if(strAuteur == "") {
						
					}else if(strMotCle == "") {
						
					}else if(date == "") {
						
					}
					else {
						
						switch (typeDoc) {
						case "DVD":
							 Document docDvd = new Document("DVD11", strTitre, date, "Disponible",0,TypeDocument.DVD);
							    DVD dvd = new DVD("DVD11", strTitre, date, 2, strAuteur, 0, "Disponible");
							    fichier.getListDvd().add(dvd);
							    fichier.getListDoc().add(docDvd);
							   System.out.println(fichier.getListDvd().size());
							   for(int i = 0;i<fichier.getListDvd().size();i++) {
								   System.out.println(fichier.getListDvd().get(i).getStrAuteur());
							   }
							  tabDVD.setContent(remplirTabDVD(tabDVD)); 
							break;
						case "Periodiques":
							break;
						case "Livre":	
							break;

						default:
							break;
						}
					}
				}
				
			});
			btnAnnuler.setOnMouseClicked(e -> stageAjouter.close());
			hBoxButton.setSpacing(20);
			hBoxButton.setAlignment(Pos.BOTTOM_RIGHT);
			
			vBoxLabel.getChildren().addAll(labelTitre, labelAuteur, labelDate, labelMC);
			vBoxTF.getChildren().addAll(tfTitre, tfAuteur,dp,  tfMC);
		
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

		Label labelNoEmploye = new Label("No. d'employ� : ");
		Label labelMDP = new Label("Mot de passe : ");

		TextField tfNoEmploye = new TextField();
		TextField tfMDP = new TextField();

		btnUsager.setOnAction(gestionConnexion);
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
		primaryStage.setTitle("Bienvenue � la m�diath�que");
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

		addView.setFitWidth(40);
		delView.setFitWidth(40);
		gererView.setFitWidth(40);
		pretView.setFitWidth(40);
		retourView.setFitWidth(40);
		quitterView.setFitWidth(30);
		confirmerView.setFitWidth(30);
		annulerView.setFitWidth(30);

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

}
