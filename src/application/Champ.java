package application;


public class Champ {
	 private String nom;
	 private Object valeur;
	    
	 /**
	  * 
	  * @param name
	  * @param v
	  * @throws Exception 
	  */
	 public Champ(String name, Object v){   
	    	this.nom = name;
		    this.valeur = v;    
	 }
	 	    
	 /**
	  * 
	  * @return nom
	  */
	 public String getNameChamp(){return this.nom;}
	    
	 /**
	  * 
	  * @return valeur
	  */
	 public Object getValeurChamp() {return this.valeur;}	
	 
	 /**
	  * modifie la valeur d'un champ
	  * @param val
	  */
	 public void modifierValeur(Object val) {valeur=val;}
	 
}
