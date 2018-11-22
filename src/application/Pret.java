package application;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pret  implements Serializable{
	private Adherent adh;
	private	Date DatePret;
	private Date DateRetourPrevu;
	
	private double dblAmende;


	public Pret(Adherent adh,Date DatePret,Date DateRetourPrevu,double dblAmende){

		this.adh = adh;
		this.DatePret = DatePret;
		this.DateRetourPrevu = DateRetourPrevu;
		Date d = new Date();
		this.dblAmende = retournemontantamende(DateRetourPrevu, d);
		
	}
	public double getDblAmende() {
		return dblAmende;
	}
	public static void main(String[] args) {
		try {
			Date dateremise = new SimpleDateFormat("dd/MM/yyyy").parse("04/01/2018");
			Date dateremiseprevu = new SimpleDateFormat("dd/MM/yyyy").parse("04/01/2018");
			double montant =retournemontantamende(dateremiseprevu, dateremise);
			System.out.println(Double.toString(montant));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch blo
			e.printStackTrace(); 
		}
		
		
	}
	
	public Adherent getAdh() {
		return adh;
	}
	public Date getDatePret() {
		return DatePret;
	}
	public Date getDateRetourPrevu() {
		return DateRetourPrevu;
	}
	public static double retournemontantamende(Date DateRetourPrevuAmende,Date DateDeRemiseAmende) {
		int nombreJour =0 ;
		double montant =0;
		if(DateDeRemiseAmende.compareTo(DateRetourPrevuAmende) > 0) {
			nombreJour = daysBetween(DateRetourPrevuAmende, DateDeRemiseAmende);
			montant = nombreJour;
		}

		return montant;
		
	}
	public static int daysBetween(Date d1, Date d2){
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
}
}
