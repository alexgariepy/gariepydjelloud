package application;


public class Periodiques {
	
	private String strNumeroDuDoc;
	private String strNomDuPeriodique;
	private String strDate;
	private int intNumDuVolume;
	private int intNumDuPeriodique;
	private String strEtat;
	private int intNumDePret;
	private TypeDocument typeDocument;
	public Periodiques(String strNumeroDuDoc,String strNomDuPeriodique,String strDate,int intNumDuVolume, int intNumDuPeriodique,String strEtat,int intNumDePret,TypeDocument typeDocument) {
		// TODO Auto-generated constructor stub
		this.strNumeroDuDoc = strNumeroDuDoc;
		this.strNomDuPeriodique = strNomDuPeriodique;
		this.strDate = strDate;
		this.intNumDuVolume = intNumDuVolume;
		this.intNumDuPeriodique = intNumDuPeriodique;
		this.strEtat = strEtat;
		this.intNumDePret = intNumDePret;
		this.typeDocument = typeDocument;
	}
	public String getStrNumeroDuDoc() {
		return strNumeroDuDoc;
	}
	public String getStrNomDuPeriodique() {
		return strNomDuPeriodique;
	}
	public String getStrDate() {
		return strDate;
	}
	public int getIntNumDuVolume() {
		return intNumDuVolume;
	}
	public int getIntNumDuPeriodique() {
		return intNumDuPeriodique;
	}
	public String getStrEtat() {
		return strEtat;
	}
	public int getIntNumDePret() {
		return intNumDePret;
	}
	public TypeDocument getTypeDocument() {
		return typeDocument;
	}
}
