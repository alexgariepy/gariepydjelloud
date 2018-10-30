package application;

public class Document {
	private TypeDocument typeDocument;
	private	String Titre;
	private String Auteur;
	private	String Date;
	private	String MotCle;
	
	
	Document(TypeDocument typeDocument,String Titre,String Auteur,String Date,String MotCle){
		this.typeDocument = typeDocument;
		this.Titre = Titre;
		this.Auteur = Auteur;
		this.Date = Date;
		this.MotCle = MotCle;
	}
	public String toString() {
		return typeDocument + " " + Titre + " " + Auteur + " " +Date + " " + MotCle;
		
	}
}
