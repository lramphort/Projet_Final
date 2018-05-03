package application;

import java.util.*;

import application.connection.ConnexionSGBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Services {
	private ConnexionSGBD dbOracle;
    private Connection conn;
    

	public Services() throws ClassNotFoundException, SQLException {		
		dbOracle = new ConnexionSGBD();
        conn = dbOracle.connexion();
	}


	public void inserer(String table,ArrayList<Champ> champs) throws Exception {

        Statement stmt = conn.createStatement();
        
        ArrayList<String> noms = new ArrayList<>();
        ArrayList<String> nomsChamps = new ArrayList<>();
        
        /** récupère le nom de tous les champs pour vérifier que la table a les mêmes*/
        for(int i=0;i<champs.size();i++) {
        	nomsChamps.add(champs.get(i).getNameChamp().toUpperCase());
        }
        
        /** récupère les champs de la table **/
        ResultSet rs = stmt.executeQuery("Describe " +table);
        while (rs.next()) {
            noms.add(rs.getString(1).toUpperCase());
        }
        
        /** on vérifie si les champs sont identiques avant de faire l'insertion **/
        for(int i=0; i < noms.size();i++) {
        	if(!(noms.get(i).equals(nomsChamps.get(i)))) throw new 
        		Exception("Les champs donnés sont différents de ceux de la table");
        }
        
        /** on insère les valeurs dans la table pour chaque champ **/
        for(int i=0; i<champs.size() ; i++) {
        	String requete = "INSERT INTO '"+table+"' ('"+nomsChamps.get(i)+"') VALUES('" + 
        			champs.get(i).getValeurChamp() + "')";
            System.out.println(requete);
            try {
                stmt.executeUpdate(requete);
                System.out.println("Ajout du champ "+nomsChamps.get(i)+" réussi");
            } catch (Exception e) {
                System.out.println("ERROR " + e.getMessage());
            }
        }
    }
	
	
}
        	
