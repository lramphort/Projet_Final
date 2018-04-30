package application;


import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Scanner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yi
 */
public class Base {
    private ArrayList<String> schema = new ArrayList<String>();
     // JDBC driver name and database URL
   static final String JDBC_DRIVER = "oracle.jdbc.OracleDriver";  
   static final String DB_URL = "jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag";

   //  Database credentials
   static final String USER = "li3";
   static final String PASS = "Lee199715";

    Base(){
        
    }
    /**
     * cr√©er une relation
     * @param schema une arrayliste qui comorends les atrributs de relation
     * @para nomType le nom de la relation
    */
    public void creerRelation(ArrayList<Champ> schema) {
        Connection conn = null;
        Statement stmt = null;
        try{
        //STEP 2: Register JDBC driver
        Class.forName(this.JDBC_DRIVER);

        //STEP 3: Open a connection
        System.out.println("Connecting to a selected database...");
        conn = DriverManager.getConnection(this.DB_URL, this.USER, this.PASS);
        System.out.println("Connected database successfully...");

        //STEP 4: Execute a query
        System.out.println("Creating table in given database...");
        stmt = conn.createStatement();

        String sql = "CREATE TABLE REGISTRATION (" +
                   "id number(5) not NULL, "; 
        for( int i = 0; i < schema.size(); i++){
            String attribut = schema.get(i).getAttribut();
            String type = schema.get(i).getType();
            sql = sql + attribut + " " + type + ",";
        }
        sql = sql + "PRIMARY KEY (id))";
            
      stmt.executeUpdate(sql);
      System.out.println("Created table in given database...");
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
               if(stmt!=null)
                  conn.close();
            }catch(SQLException se){
               }// do nothing
            try{
               if(conn!=null)
                  conn.close();
            }catch(SQLException se){
               se.printStackTrace();
            }//end finally try
         }//end try
   System.out.println("Goodbye!");
    }//end main
    
    /**
     * 
     * @param nomRelation c'est le nom de la relation qu'on va crÈer
     * @param schema c'est le schema de la relation qu'on va crÈer
     * @return une chaÓne de caractËres de SQL qui est pour crÈer la relation
     * @require nomRelation_NonVide : nomRelation != null; 
     */
    public String creerSQL(String nomRelation, ArrayList<Champ> schema) throws Exception {
    	if (nomRelation == null || nomRelation.equals("")) {
    		throw new Exception("Le nom doit pas Ítre vide !");
    	}
    	String sql = null;
    	String SQL = "CREATE TABLE" + " " + nomRelation + "(" +
                "id number(5) not NULL, "
                + "pseudo varchar(255),"
                +"code varchar(255),"; 
     for( int i = 0; i < schema.size(); i++) {
         String attribut = schema.get(i).getAttribut();
         String type = schema.get(i).getType();
         sql = SQL + attribut + " " + type + ",";
     }
     sql = sql + "constraint " + nomRelation + " " + "PRIMARY KEY (id))";
    	return sql;
    }
    /**
     * crÈer une chaine de caractËre ‡ partir le Profil
     * @param profil 
     * @return une chaine de caractËre crÈÈe ‡ partir le Profil
     * @throws Exception
     */
   public String creerProfilSQL(Profil profil) throws Exception {
	   if (profil.getNomProfil()== null || profil.getNomProfil().equals("")) {
		   throw new Exception("Le nom doit pas Ítre vide!");
	   }
	   String sql = null;
   	String SQL = "CREATE TABLE" + " " + profil.getNomProfil() + "(" +
               "id number(5) not NULL, "
               + "pseudo varchar(255),"
               +"code varchar(255),"; 
    for( int i = 0; i < profil.getSchema().size(); i++) {
        String attribut = profil.getSchema().get(i).getAttribut();
        String type = profil.getSchema().get(i).getType();
        sql = SQL + attribut + " " + type + ",";
    }
    sql = sql + "constraint " + profil.getNomProfil() + " " + "_c1 PRIMARY KEY (id))";
   	return sql;
	   
   }
    
}


    
