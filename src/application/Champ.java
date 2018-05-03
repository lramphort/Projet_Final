package application;


public class Champ {
	 private String nom;
	 private Object valeur; 
	 private boolean opt;
	    
	 /**
	  * 
	  * @param name
	  * @param v
	  * @param opt
	  * @throws Exception 
	  * @require val not null : opt && val.equals(null)
	  */
	 public Champ(String name, Object v, boolean opt) throws Exception{
	    if(opt && v.equals(null)) throw new Exception("Le champ doit être rempli");
	    else {
	    	this.nom = name;
		    this.valeur = v;
		    this.opt=opt;
	    }
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
	  * @return opt
	  */
	 public boolean getOptionnal() {return opt;}
	 
	 /**
	  * modifie la valeur d'un champ
	  * @param val
	  */
	 public void modifierValeur(Object val) {valeur=val;}
	
}
