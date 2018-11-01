package application;

import java.util.ArrayList;
import java.util.Date;

public class Prepose {
	 public void main(String[] args) {
	/*	   ArrayList<Adherent> listDocAdherent = new ArrayList<Adherent>();
		   ArrayList<Document> listDocDocument = new ArrayList<Document>();
		 //  ajouteradherent(listDocAdherent);
		   ajouterdocument(listDocDocument);
		   System.out.println(listDocDocument);
		  */
	}
   public ArrayList<Document> ajouterdocument(ArrayList<Document> listDoc){
	    TypeDocument typeDocument = TypeDocument.DVD;
		String Titre = "Allo";
		String Auteur = "moi";
		String Date = "30/10/2018";
		String MotCle = "Fax";
		Document document = new Document(typeDocument, Titre, Auteur, Date, MotCle);
		listDoc.add(document);
	   return listDoc;
   }
 //ALLO
   public ArrayList<Adherent> ajouteradherent(ArrayList<Adherent> listDoc){
	   	String strPrenom = "Mohamed";
	   	String strNom = "Djelloud";
	   	String strNum = "5147073747";
	   	String strAdresse ="on est la";
	   	Adherent adherent = new Adherent(strPrenom, strNom, strNum, strAdresse);
	   	listDoc.add(adherent);
	   	return listDoc;
	}
   public ArrayList<Pret> ajouterpret(ArrayList<Pret> listDoc){
		String strPrenom = "Mohamed";
	   	String strNom = "Djelloud";
	   	String strNum = "5147073747";
	   	String strAdresse ="on est la";
	   	Adherent adherent = new Adherent(strPrenom, strNom, strNum, strAdresse);
	 /*  	Date strDatePret = "01/11/2018";
	   	Date strDateRetourPrevu= "03/11/2018";
	   	Date strDateDeRemise= "04/11/2018";*/
	  //  Pret pret = new Pret(adherent,strDatePret,strDateRetourPrevu,strDateDeRemise);
	  //  listDoc.add(pret);
	  
	   	return listDoc;
	}
   
}
