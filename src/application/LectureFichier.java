package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LectureFichier {
	private ArrayList<Document> listDocAdherent = new ArrayList<Document>();
	
	public ArrayList<Document> getListDocAdherent() {
		return listDocAdherent;
	}

	public void setListDocAdherent(ArrayList<Document> listDocAdherent) {
		this.listDocAdherent = listDocAdherent;
	}

	public void lectureDVD() {

	File file = new File("L:\\Objet2\\gariepydjelloud\\donneesEntrees\\DVD.txt");
	BufferedReader br = null;
	try {
		br = new BufferedReader(new FileReader(file));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	 String strLigne = ""; 
	StringTokenizer st;
	  try {
		  
		while ((strLigne = br.readLine()) != null) {
			st = new StringTokenizer(strLigne, ",");
			int intNumeroDoc = Integer.parseInt(st.nextToken().trim().substring(2,1));
		    String strTitre = st.nextToken().trim();
		    String strDate = st.nextToken().trim();
		    int intNombreDePret = Integer.parseInt(st.nextToken().trim());
		    String strAuteur = st.nextToken().trim();
		    
		    Document docDvd = new Document(TypeDocument.DVD, strTitre,intNombreDePret, strAuteur, strDate, "");
		    listDocAdherent.add(docDvd);
		}
		}catch(Exception e) {
			
		}
	  }
}
