package application;

import java.io.Serializable;

public class DVD implements Serializable{
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
			public void setStrEtat(String strEtat) {
				this.strEtat = strEtat;
			}
			public void setStrNumeroDuDoc(String strNumeroDuDoc) {
				this.strNumeroDuDoc = strNumeroDuDoc;
			}
			public void setStrNomDuDvd(String strNomDuDvd) {
				this.strNomDuDvd = strNomDuDvd;
			}
			public void setStrDate(String strDate) {
				this.strDate = strDate;
			}
			public void setIntNombreDeDisque(int intNombreDeDisque) {
				this.intNombreDeDisque = intNombreDeDisque;
			}
			public void setStrAuteur(String strAuteur) {
				this.strAuteur = strAuteur;
			}
			public void setIntNombreDePret(int intNombreDePret) {
				this.intNombreDePret = intNombreDePret;
			}
			public String toString() {
				return  strNomDuDvd + "  " + strAuteur;
			}
}
