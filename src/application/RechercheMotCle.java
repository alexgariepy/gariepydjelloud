package application;

import java.util.ArrayList;

import interf.Main;
import javafx.scene.layout.VBox;

public class RechercheMotCle {

	private ArrayList<Document> listDocumentRecherche = new ArrayList<Document>();
	private ArrayList<DVD> listDvdRecherche = new ArrayList<DVD>();
	private ArrayList<Periodiques> listPeriodiqueRecherche = new ArrayList<Periodiques>();
	private ArrayList<Livre> listLivreRecherche = new ArrayList<Livre>();
	private Main main;
	public void Recherche(Recherche recherche,String strReponse){
		LectureFichier fichier = new LectureFichier();
		if(recherche.equals(Recherche.AUTEUR)) {
			for(int i = 0; i < fichier.getListLivre().size() ;i++) {
				if(fichier.getListLivre().get(i).getAuteur().equals(strReponse)) {
					listLivreRecherche.add(fichier.getListLivre().get(i));
				}
			}
			for(int i = 0; i < fichier.getListDvd().size() ;i++) {
				if(fichier.getListDvd().get(i).getStrAuteur().equals(strReponse)) {
					listDvdRecherche.add(fichier.getListDvd().get(i));
				}
			}
		}else {
			Document doc = main.getTable().getSelectionModel().getSelectedItem();
			String[] Titreparts = doc.getTitre().split(" ");
			/*for() {
				
			}*/
			
		}
		
		
	}
	public ArrayList<Document> getListDocumentRecherche() {
		return listDocumentRecherche;
	}
	public ArrayList<DVD> getListDvdRecherche() {
		return listDvdRecherche;
	}
	public ArrayList<Periodiques> getListPeriodiqueRecherche() {
		return listPeriodiqueRecherche;
	}
	public ArrayList<Livre> getListLivreRecherche() {
		return listLivreRecherche;
	}
}
