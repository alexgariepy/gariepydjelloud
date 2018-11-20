package application;

import java.io.Serializable;

public class Livre implements Serializable{
	private String strNumeroDoc;
	private	String Titre;
	private String Etat;
	private	String Date;
	public String getStrNumeroDoc() {
		return strNumeroDoc;
	}

	public String getTitre() {
		return Titre;
	}

	public String getEtat() {
		return Etat;
	}

	public String getDate() {
		return Date;
	}

	public String getAuteur() {
		return Auteur;
	}

	public int getIntNombreDePret() {
		return intNombreDePret;
	}

	public TypeDocument getTypeDocument() {
		return typeDocument;
	}

	private	String Auteur;
	private int intNombreDePret;
	private TypeDocument typeDocument;
	
		public Livre(String strNumeroDoc,String Titre,String Etat,String Date,String Auteur,TypeDocument typeDocument,int intNombreDePret) {
			// TODO Auto-generated constructor stub
			this.strNumeroDoc = strNumeroDoc;
			this.Titre = Titre;
			this.Etat = Etat;
			this.Date = Date;
			this.Auteur = Auteur;
			this.typeDocument = typeDocument;
			this.intNombreDePret = intNombreDePret;
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

		public void setDate(String date) {
			Date = date;
		}

		public void setAuteur(String auteur) {
			Auteur = auteur;
		}

		public void setIntNombreDePret(int intNombreDePret) {
			this.intNombreDePret = intNombreDePret;
		}

		public void setTypeDocument(TypeDocument typeDocument) {
			this.typeDocument = typeDocument;
		}
		public String toString() {
			return  Titre + "  " + Auteur;
		}
}
