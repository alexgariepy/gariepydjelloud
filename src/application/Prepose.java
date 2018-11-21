package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Prepose {
	 public static void main(String[] args) {
		   ArrayList<Adherent> listDocAdherent = new ArrayList<Adherent>();
		   ArrayList<Document> listDocDocument = new ArrayList<Document>();
		   ArrayList<Pret> listDocPret = new ArrayList<Pret>();
		 
		  
	}
   public ArrayList<Document> ajouterdocument(ArrayList<Document> listDoc){
	    TypeDocument typeDocument = TypeDocument.DVD;
		String Titre = "Allo";
		String Auteur = "moi";
		int intNombrePret = 0;
		String Date = "30/10/2018";
		String MotCle = "Fax";
	//	Document document = new Document(typeDocument, Titre,intNombrePret, Auteur, Date, MotCle);
	//	listDoc.add(document);
	   return listDoc;
   }
 //AL
   public ArrayList<Adherent> ajouteradherent(ArrayList<Adherent> listDoc){
	   	String strPrenom = "Mohamed";
	   	String strNom = "Djelloud";
	   	String strNum = "5147073747";
	   	String strAdresse ="on est la";
	   	Adherent adherent = new Adherent(strPrenom, strNom, strNum, strAdresse);
	   	listDoc.add(adherent);
	   	return listDoc;
	}
   public static ArrayList<Pret> ajouterpret(ArrayList<Pret> listDoc){
		String strPrenom = "Mohamed";
	   	String strNom = "Djelloud";
	   	String strNum = "5147073747";
	   	String strAdresse ="on est la";
	   	Adherent adherent = new Adherent(strPrenom, strNom, strNum, strAdresse);
	   	try {
			Date strDatePret = new SimpleDateFormat("dd/MM/yyyy").parse("01/11/2018");
			Date strDateRetourPrevu = new SimpleDateFormat("dd/MM/yyyy").parse("03/11/2018");
			Date strDateDeRemise = new SimpleDateFormat("dd/MM/yyyy").parse("04/11/2018");
			Pret pret = new Pret(adherent,strDatePret,strDateRetourPrevu);
			listDoc.add(pret);	  
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	   
	   
	  
	   	return listDoc;
	}
 
}
