package application;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class requetesbd {

    public static void nbseminaire(Connection conn) throws
            SQLException {
// Get a statement from the connection
        Statement stmt = conn.createStatement();
/* Execute the query
        ResultSet rs = stmt.executeQuery("SELECT idSem FROM inscription ");
        while (rs.next()) {
            System.out.println("Nombre de inscription : "
                    + rs.getInt(1));
        }
 Close the result set, statement and theconnection 
        rs.close();
        stmt.close();
    }*/

    String sql = "SELECT * FROM prestataire"; 
    Statement statement = conn.createStatement(); 
    ResultSet resultat = statement.executeQuery(sql); 
    ResultSetMetaData metadata = resultat.getMetaData(); 
    for(int i = 0; i< metadata.getColumnCount(); i++){ 
    int index = i+1; 
    int typeSQL = metadata.getColumnType(index);  
    String nomTypeSQL = metadata.getColumnTypeName(index);  
    String typeJava = metadata.getColumnClassName(index); 
       System.out.println("INFORMATIONS SUR LA COLONNE D'INDEXE "+index); 
       System.out.println("Type SQL dans java.sql.Types : "+typeSQL); 
       System.out.println("Nom du type SQL : "+nomTypeSQL); 
       System.out.println("Classe java correspondante : "+typeJava); 
    }
    resultat.close();
    statement.close();
    }
}
