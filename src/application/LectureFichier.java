package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import javafx.scene.control.Alert;

public class LectureFichier {
	private ArrayList<Document> listDoc = new ArrayList<Document>();
	private ArrayList<DVD> listDvd = new ArrayList<DVD>();
	private ArrayList<Periodiques> listPeriodique = new ArrayList<Periodiques>();
	private ArrayList<Livre> listLivre = new ArrayList<Livre>();
	public ArrayList<Document> getListDoc() {
		return listDoc;
	}

	public void setListDoc(ArrayList<Document> listDoc) {
		this.listDoc = listDoc;
	}

	public void lecture() {
	File fileSer = new File("L:\\Objet2\\gariepydjelloud\\DVD.ser");
		
		
		
		if(fileSer.exists()) {
			System.out.println("rentrer");
		try {
		FileInputStream fileIn = new FileInputStream("DVD.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        while(in.readObject() != null ) {
        listDvd.add((DVD)in.readObject());
        }
        in.close();
        fileIn.close();
        
        
        FileInputStream fileInPer = new FileInputStream("Per.ser");
        ObjectInputStream inPer = new ObjectInputStream(fileInPer);
        while(in.readObject() != null ) {
        listPeriodique.add((Periodiques)in.readObject());
        }
        inPer.close();
        fileInPer.close();
        
        
        FileInputStream fileInLivre = new FileInputStream("Liv.ser");
        ObjectInputStream inLivre = new ObjectInputStream(fileInLivre);
        while(in.readObject() != null ) {
        listLivre.add((Livre)in.readObject());
        }
        inLivre.close();
        fileInLivre.close();
        
		}catch(Exception e) {
			
		}
		}else {
			System.out.println("sorti");
	File file = new File("L:\\Objet2\\gariepydjelloud\\donneesEntrees\\DVD.txt");
	BufferedReader br = null;
	try {
		br = new BufferedReader(new FileReader(file));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
	} 
	  try {
		  String strLigne = ""; 
		  StringTokenizer st;
		  while ((strLigne = br.readLine()) != null) {
			st = new StringTokenizer(strLigne, ",");
			String strNumeroDoc = st.nextToken().trim();
		//	int intNumeroDo = Integer.parseInt(strNumeroDoc.trim().substring(3,strNumeroDoc.trim().length()));
			String strTitre = st.nextToken().trim();
		    String strDate = st.nextToken().trim();
			int intNombreDeDisque = Integer.parseInt(st.nextToken().trim());
			String strAuteur = st.nextToken().trim();
		    Document docDvd = new Document(strNumeroDoc, strTitre, strDate, "Disponible",0,TypeDocument.DVD);
		    DVD dvd = new DVD(strNumeroDoc, strTitre, strDate, intNombreDeDisque, strAuteur, 0, "Disponible");
		    listDvd.add(dvd);
		    listDoc.add(docDvd);
		}
		}catch(Exception e) {
		}
	  File fileLivre = new File("L:\\Objet2\\gariepydjelloud\\donneesEntrees\\Livres.txt");
		BufferedReader brLivre = null;
		try {
			brLivre = new BufferedReader(new FileReader(fileLivre));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		}
		 try {
			  String strLigne = ""; 
			  StringTokenizer st;
			  while ((strLigne = brLivre.readLine()) != null) {
				st = new StringTokenizer(strLigne, ",");
				String strNumeroDoc = st.nextToken();
			//	int intNumeroDo = Integer.parseInt(strNumeroDoc.trim().substring(3,strNumeroDoc.trim().length()));
				String strTitre = st.nextToken().trim();
			    String strDate = st.nextToken().trim();
				String strAuteur = st.nextToken().trim();
			    Document docDvd = new Document(strNumeroDoc, strTitre, strDate, "Disponible",0,TypeDocument.LIVRE);
			    Livre livre = new Livre(strNumeroDoc, strTitre, "Disponible", strDate, strAuteur, TypeDocument.LIVRE,0);
			    listLivre.add(livre);
			    listDoc.add(docDvd);
			}
			}catch(Exception e) {
			}
		 
		 
		 
		 	File filePer = new File("L:\\Objet2\\gariepydjelloud\\donneesEntrees\\Periodiques.txt");
			BufferedReader brPer = null;
			try {
				brPer = new BufferedReader(new FileReader(filePer));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
			}
			 try {
				  String strLigne = ""; 
				  StringTokenizer st;
				  while ((strLigne = brPer.readLine()) != null) {		  
					st = new StringTokenizer(strLigne, ",");
					String strNumeroDoc = st.nextToken();
					//int intNumeroDo = Integer.parseInt(strNumeroDoc.trim().substring(3,strNumeroDoc.trim().length()));
					String strTitre = st.nextToken().trim();
				    String strDate = st.nextToken().trim();
					int intNumDuVolume = Integer.parseInt(st.nextToken().trim());
					int intNumDuPeriodique = Integer.parseInt(st.nextToken().trim());
				    Document docDvd = new Document(strNumeroDoc, strTitre, strDate, "Disponible",0,TypeDocument.PERIODIQUES);
				    Periodiques Per = new Periodiques(strNumeroDoc, strTitre, strDate, intNumDuVolume, intNumDuPeriodique, "Disponible", 0, TypeDocument.PERIODIQUES);
				    listPeriodique.add(Per);
				    listDoc.add(docDvd);
				}
				}catch(Exception e) {
				}
			 
		}
	  }

	public ArrayList<Livre> getListLivre() {
		return listLivre;
	}

	public ArrayList<Periodiques> getListPeriodique() {
		return listPeriodique;
	}

	public ArrayList<DVD> getListDvd() {
		return listDvd;
	}
	
	
}
