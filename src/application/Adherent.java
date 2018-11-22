package application;

import java.io.Serializable;

public class Adherent implements Serializable {
	
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

	public void setStrNum(String strNum) {
		this.strNum = strNum;
	}

	public void setStrAdresse(String strAdresse) {
		this.strAdresse = strAdresse;
	}
}
