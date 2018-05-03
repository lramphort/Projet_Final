package application;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import application.connection.ConnexionSGBD;

public class Profil {
	protected ArrayList<Champ> champs = new ArrayList<Champ>(); 
	private ConnexionSGBD dbOracle;
    private Connection conn;
	/**
	 * 
	 * @param login2
	 * @param pwd2
	 * constructeur de la classe Profil
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws Exception 
	 */
	public Profil() throws ClassNotFoundException, SQLException {
		dbOracle = new ConnexionSGBD();
        conn = dbOracle.connexion();
	}
		
	/**
	 * obtenir les champs
	 * @return les champs de la class Profil
	 */
	public ArrayList<Champ> getChamps() {return this.champs;}
		
	/**
	 * supprimer un champ dans la liste
	 * @param champ le champ qu'on veut supprimer
	 */
	public void supprimerChamp(String champ) {
		for (Champ item : this.champs) {
            if (item.getNameChamp().equals(champ)) {
                this.champs.remove(item);
            }
        }
	}
	
	/**
	 * ajout d'un champ
	 * @param le champ à ajouter dans la liste des champs
	 * 
	 */
	public void ajouterChamp(Champ c) {this.champs.add(c);}

	/**
	 * @param nomChamp
	 * @param val
	 */
	public void modifierValeurChamp(String nom, TypeChamp<?> val) {	
		for(int i=0;i<champs.size();i++) {
			if(champs.get(i).getNameChamp().equals(nom)) {
				champs.get(i).modifierValeur(val);
			}
		}
	}
	
	public void inscription(String table) throws SQLException {
		
		Statement stmt = conn.createStatement();
	        
	        
	        
	    ArrayList<String> nomsChamps = new ArrayList<>();
	    ArrayList<Object> valChamps = new ArrayList<>();    
	    
	        
	    /** récupère les champs de la table **/
	    ResultSet rs = stmt.executeQuery("Describe"+ table);
	    while (rs.next()) {
	    	nomsChamps.add(rs.getString(1).toUpperCase());
	    }
	    
	    String sql = "SELECT * FROM "+table; 
	    
	    ResultSet resultat = stmt.executeQuery(sql); 
	    ResultSetMetaData metadata = resultat.getMetaData(); 
	    
	    for(int i = 1; i<= metadata.getColumnCount(); i++){ 
     
	    	String typeJava = metadata.getColumnClassName(i); 
	    	switch (typeJava) {
			case typeJava.equals("java.math.BigDecimal"):
				Double val;
				System.out.println("Donnez une valeur");
				
				
				break;

			default:
				break;
			}
	  	       
	    }
	    
	    
	    
	    Scanner sc = new Scanner(System.in);
	   // String patternInt = "[0-9]+";
	    for(int i=0; i< nomsChamps.size(); i++) {
	    	
	    }
	        
	        
	}

}
