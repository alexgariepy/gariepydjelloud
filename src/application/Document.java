package application;

import java.io.Serializable;

public class Document implements Serializable{
	private String strNumeroDoc;
	private	String Titre;
	private String Etat;
	private int intNombreDePret;
	private	String Date;
	private TypeDocument typeDocument;
	
	
	public Document(String strNumeroDoc,String Titre,String Date,String Etat,int intNombreDePret,TypeDocument typeDocument){
		this.strNumeroDoc = strNumeroDoc;
		this.Titre = Titre;
		this.Etat = Etat;
		this.Date = Date;
		this.intNombreDePret = intNombreDePret;
		this.typeDocument = typeDocument;
		
	}
	
	public TypeDocument getTypeDocument() {
		return typeDocument;
	}

	public String getTitre() {
		return Titre;
	}


	public String getDate() {
		return Date;
	}

	public String getStrNumeroDoc() {
		return strNumeroDoc;
	}

	public String getEtat() {
		return Etat;
	}

	public int getIntNombreDePret() {
		return intNombreDePret;
	}

	public void setEtat(String etat) {
		Etat = etat;
	}

	public void setStrNumeroDoc(String strNumeroDoc) {
		this.strNumeroDoc = strNumeroDoc;
	}

	public void setTitre(String titre) {
		Titre = titre;
	}

	public void setIntNombreDePret(int intNombreDePret) {
		this.intNombreDePret = intNombreDePret;
	}

	public void setDate(String date) {
		Date = date;
	}

	public void setTypeDocument(TypeDocument typeDocument) {
		this.typeDocument = typeDocument;
	}
	public String toString() {
		return Titre + "  " + strNumeroDoc;
	}

}
