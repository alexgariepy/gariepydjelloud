package application;

public class Livre {
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
}
