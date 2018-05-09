package rmi.server;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.TreeMap;

import application.Champ;
import application.ConnexionSGBD;
import application.Services;


public class ServerDatabase {
	private TreeMap<String, String> loginInfo;
	private TreeMap<String, Object> admin;
	private ConnexionSGBD dbOracle;
    private Connection conn;
	public ServerDatabase ()
	{
		loginInfo = new TreeMap<String, String>();
		loginInfo.put("admin", "admin");
		admin = new TreeMap<String, Object>();
		admin.put("admin", null);
		dbOracle = new ConnexionSGBD();
        conn = dbOracle.connexion();
	}//constructor
	
	public boolean authenticateLogin (String username, String password)
	{
		if (!loginInfo.containsKey(username))
			return false;
		else 
		{
			String correctPassword = loginInfo.get(username);
			if (correctPassword.equals(password))
				return true;
			else
				return false;
		}//else
	}//authenticateLogin
	
	public boolean createUser (String username, String password)
	{
		
		try {
		Champ champUsername = new Champ("username", username);
		Champ champPass = new Champ("password", password);
		
		ArrayList<Champ> champs = new ArrayList<Champ>();
		champs.add(champUsername);
		champs.add(champPass);
		new Services().inserer("Profil",champs);
		}
		catch (Exception e){
			e.getMessage();
		}
//		if (loginInfo.containsKey(username))
//			return false;
//		else 
//		{
//			loginInfo.put(username, password);
//			return true;
//		}//else	
		return false;
	}//createUser
	
	public boolean changePassword (String username, String password)
	{
		if (!loginInfo.containsKey(username))
			return false;
		else 
		{
			loginInfo.put(username, password);
			return true;
		}//else
	}//changePassword

	public boolean isAdmin (String username)
	{
		return admin.containsKey(username);
	}//isAdmin
	
	public void reagit(int idEtudiant, int idPublication, String rea) throws RemoteException {
		// TODO Auto-generated method stub
		
		//inserer une ligne dans bd
		
	}
	public void afficherReactionById(int idReaction) throws RemoteException {
		// TODO Auto-generated method stub
		//select * form bd where idReaction = idReaction;
		
	}


	public void afficherReactionByIdPers(int idPers) throws RemoteException {
		// TODO Auto-generated method stub
		
		//select reaction from bd where id = idPers
		
	}


	public void afficherReactionByIdPub(int idReaction) throws RemoteException {
		// TODO Auto-generated method stub
		
		//select reaction from bd where id=IdPub
		
	}


	public void modifierReaction(int idReaction) throws RemoteException {
		// TODO Auto-generated method stub
		//delete une ligne where id = idReaction
		//inserer une linge where id = idReaction
		
	}


	public void retirerReaction(int idReaction) throws RemoteException {
		// TODO Auto-generated method stub
		//delete une ligne where id = idReaction
		
	}


	public int nbReactions() throws RemoteException {
		// TODO Auto-generated method stub
		// select count (*) from bd;
		return 0;
	}
}
