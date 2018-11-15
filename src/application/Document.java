package application;

public class Document {
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

}
