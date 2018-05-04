package application;

import java.sql.SQLException;

import java.util.ArrayList;



public class Profil {
	protected static ArrayList<Champ> champs; 
	
	/**
	 * 
	 * constructeur de la classe Profil
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws Exception 
	 */
	public Profil(ArrayList<Champ> c) {
		champs = new ArrayList<Champ>();
		champs = c;
	}		
	
	/**
	 * 
	 * @return les champs de la class Profil
	 */
	public ArrayList<Champ> getChamps() {return Profil.champs;}
		
	/**

	 * @param nomChamp
	 * @param val
	 * @require stringNotNull : 

	 */
	public ArrayList<Champ> modifierProfil(ArrayList<Champ> c) {
		ArrayList<Champ> oldChamps = new ArrayList<>();
		oldChamps = this.getChamps();
		for(int i=0 ; i<c.size() ; i++) {
			for(int j=0 ; j<champs.size() ; j++) {
				if(c.get(i).getNameChamp().toUpperCase().equals(champs.get(j).getNameChamp().toUpperCase())) {
					champs.get(j).modifierValeur(c.get(i).getValeurChamp());
				}
			}
		}https://www.developpez.net/forums/d428515/java/general-java/apis/java-util/parcourir-liste-l-aide-d-iterator/
		return oldChamps;
	}

	
	
	

}
