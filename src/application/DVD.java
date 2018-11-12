package application;

public class DVD {
	private String strNumeroDuDoc;
	private String strNomDuDvd;
	private String strDate;
	private int intNombreDeDisque;
	private String strAuteur;
	private int intNombreDePret;
	private String strEtat;
			public DVD(String strNumeroDuDoc,String strNomDuDvd,String strDate,int intNombreDeDisque,String strAuteur,int intNombreDePret,String strEtat) {
				// TODO Auto-generated constructor stub
				this.strNumeroDuDoc=strNumeroDuDoc;
				this.strNomDuDvd=strNomDuDvd;
				this.strDate=strDate;
				this.intNombreDeDisque=intNombreDeDisque;
				this.strAuteur=strAuteur;
				this.intNombreDePret=intNombreDePret;
				this.strEtat=strEtat;
			}
			public String getStrNumeroDuDoc() {
				return strNumeroDuDoc;
			}
			public String getStrNomDuDvd() {
				return strNomDuDvd;
			}
			public String getStrDate() {
				return strDate;
			}
			public int getIntNombreDeDisque() {
				return intNombreDeDisque;
			}
			public String getStrAuteur() {
				return strAuteur;
			}
			public int getIntNombreDePret() {
				return intNombreDePret;
			}
			public String getStrEtat() {
				return strEtat;
			}
}
