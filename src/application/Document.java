package application;

public class Document {
	private TypeDocument typeDocument;
	private	String Titre;
	private String Auteur;
	private int intNombreDePret;
	private	String Date;
	private	String MotCle;
	
	
	Document(TypeDocument typeDocument,String Titre,int intNombreDePret,String Auteur,String Date,String MotCle){
		this.typeDocument = typeDocument;
		this.Titre = Titre;
		this.intNombreDePret = intNombreDePret;
		this.Auteur = Auteur;
		this.Date = Date;
		this.MotCle = MotCle;
	}
	public TypeDocument getTypeDocument() {
		return typeDocument;
	}
	public String getTitre() {
		return Titre;
	}
	public String getAuteur() {
		return Auteur;
	}
	public int getIntNombreDePret() {
		return intNombreDePret;
	}
	public String getDate() {
		return Date;
	}
	public String getMotCle() {
		return MotCle;
	}
	public String toString() {
		return typeDocument + " " + Titre + " " + Auteur + " " +Date + " " + MotCle;	
	}
}
