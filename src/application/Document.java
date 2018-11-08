package application;

public class Document {
	private int intNumeroDoc;
	private	String Titre;
	private String Etat;
	private int intNombreDePret;
	private	String Date;
	
	
	Document(int intNumeroDoc,String Titre,String Date,String Etat,int intNombreDePret){
		this.intNumeroDoc = intNumeroDoc;
		this.Titre = Titre;
		this.Etat = Etat;
		this.Date = Date;
		this.intNombreDePret = intNombreDePret;
		
	}
	
	public String getTitre() {
		return Titre;
	}


	public String getDate() {
		return Date;
	}

	public int getIntNumeroDoc() {
		return intNumeroDoc;
	}

	public String getEtat() {
		return Etat;
	}

	public int getIntNombreDePret() {
		return intNombreDePret;
	}

}
