package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LectureFichier {
	private ArrayList<Document> listDoc = new ArrayList<Document>();
	
	public ArrayList<Document> getListDoc() {
		return listDoc;
	}

	public void setListDoc(ArrayList<Document> listDoc) {
		this.listDoc = listDoc;
	}

	public void lecture() {
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
			String strNumeroDoc = st.nextToken();
			int intNumeroDo = Integer.parseInt(strNumeroDoc.trim().substring(3,strNumeroDoc.trim().length()));
			String strTitre = st.nextToken().trim();
		    String strDate = st.nextToken().trim();
			int intNombreDePret = Integer.parseInt(st.nextToken().trim());
			String strAuteur = st.nextToken().trim();
		    Document docDvd = new Document(intNumeroDo, strTitre, strDate, "Disponible",0);
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
				int intNumeroDo = Integer.parseInt(strNumeroDoc.trim().substring(3,strNumeroDoc.trim().length()));
				String strTitre = st.nextToken().trim();
			    String strDate = st.nextToken().trim();
				String strAuteur = st.nextToken().trim();
			    Document docDvd = new Document(intNumeroDo, strTitre, strDate, "Disponible",0);
			    listDoc.add(docDvd);
			}
			}catch(Exception e) {
			}
		 
		 
		 
		 	File filePer = new File("L:\\Objet2\\gariepydjelloud\\donneesEntrees\\Periodiques.txt");
			BufferedReader brPer = null;
			try {
				brLivre = new BufferedReader(new FileReader(filePer));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
			}
			 try {
				  String strLigne = ""; 
				  StringTokenizer st;
				  System.out.println("a");
				  while ((strLigne = brPer.readLine()) != null) {
					  System.out.println(strLigne);
					st = new StringTokenizer(strLigne, ",");
					String strNumeroDoc = st.nextToken();
					int intNumeroDo = Integer.parseInt(strNumeroDoc.trim().substring(3,strNumeroDoc.trim().length()));
					String strTitre = st.nextToken().trim();
				    String strDate = st.nextToken().trim();
					//String strAuteur = st.nextToken().trim();
				    Document docDvd = new Document(intNumeroDo, strTitre, strDate, "Disponible",0);
				    listDoc.add(docDvd);
				}
				}catch(Exception e) {
				}
	  }
	
	
}
