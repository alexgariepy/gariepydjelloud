package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pret {
	private Adherent adh;
	private	Date DatePret;
	private Date DateRetourPrevu;
	private Date DateDeRemise;
	Pret(Adherent adh,Date DatePret,Date DateRetourPrevu,Date DateDeRemise){
		this.adh = adh;
		this.DatePret = DatePret;
		this.DateRetourPrevu = DateRetourPrevu;
		this.DateDeRemise = DateDeRemise;
	}
	public static void main(String[] args) {
		try {
			Date dateremise = new SimpleDateFormat("dd/MM/yyyy").parse("04/01/2018");
			Date dateremiseprevu = new SimpleDateFormat("dd/MM/yyyy").parse("04/01/2018");
			double montant =retournemontantamende(dateremiseprevu, dateremise);
			System.out.println(Double.toString(montant));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
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