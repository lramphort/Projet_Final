package rmi.server;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import rmi.remoteInterface.*;


public class Server implements RemoteInterface {
	private ServerDatabase db;
	
	public Server ()
	{
		db = new ServerDatabase();
	}//constructor

	
	public boolean authenticateLogin(String username, String password) throws RemoteException 
	{
		return db.authenticateLogin(username, password);
	}//authenticateLogin

	
	public boolean createUser(String username, String password) throws RemoteException 
	{
		return db.createUser(username, password);
	}//createUser

	
	public boolean changePassword(String username, String password) throws RemoteException 
	{
		return db.changePassword(username, password);
	}//changePassword
	
	
	public boolean isAdmin (String username) throws RemoteException
	{
		return db.isAdmin(username);
	}//isAdmin
	
	
	public static void main (String [] args)
	{
		try {
			Server myServer = new Server();
			RemoteInterface stub = (RemoteInterface) UnicastRemoteObject.exportObject(myServer, 0);
			Registry registry = LocateRegistry.createRegistry(Constant.portNumber);
			System.setProperty("java.rmi.server.hostname","localhost");
			registry.rebind(Constant.RMIName, stub);
			System.out.println("Server is up and running!");
		}//try
		catch (Exception e)
		{
			System.err.println("Server Exception.");
			e.printStackTrace();
		}//catch
	}//main

	@Override
	public void reagit(int idEtudiant, int idPublication, String rea) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void afficherReactionById(int idReaction) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void afficherReactionByIdPers(int idReaction) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void afficherReactionByIdPub(int idReaction) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void modifierReaction(int idReaction) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void retirerReaction(int idReaction) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int nbReactions() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}
	
}//class
