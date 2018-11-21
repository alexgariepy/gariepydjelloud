package application;

public class Adherent {
	
private	String strPrenom;
private	String strNom;
private	String strNum;
private	String strAdresse;
	
	public Adherent(String strPrenom,String strNom,String strNum,String strAdresse){
	this.strPrenom = strPrenom;
	this.strNom = strNom;
	this.strNum = strNum;
	this.strAdresse = strAdresse;
	//ALL	
 }

	public String getStrPrenom() {
		return strPrenom;
	}

	public String getStrNom() {
		return strNom;
	}

	public String getStrNum() {
		return strNum;
	}

	public String getStrAdresse() {
		return strAdresse;
	}
	public String toString() {
		return strPrenom + " " + strNom + " " + strNum + " " +strAdresse + " ";	
	}
}
