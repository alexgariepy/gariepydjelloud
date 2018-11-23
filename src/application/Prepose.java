package application;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Prepose implements Serializable{
	private	String strPrenom;
	private	String strNom;
	private	String strNum;
	private	String strAdresse;
	private String strMDP;
	private int intNoEmploye;
	private LectureFichier lf = new LectureFichier();
	 public static void main(String[] args) {
		   ArrayList<Adherent> listDocAdherent = new ArrayList<Adherent>();
		   ArrayList<Document> listDocDocument = new ArrayList<Document>();
		   ArrayList<Pret> listDocPret = new ArrayList<Pret>();
		   

	}
	 
	 public Prepose(String strPrenom,String strNom,String strNum,String strAdresse, String strMDP, int intNoEmploye){
			this.strPrenom = strPrenom;
			this.strNom = strNom;
			this.strNum = strNum;
			this.strAdresse = strAdresse;
			this.strMDP = strMDP;
			this.intNoEmploye = intNoEmploye;
	 }

	public String getStrMDP() {
		return strMDP;
	}

	public int getIntNoEmploye() {
		return intNoEmploye;
	} 



}