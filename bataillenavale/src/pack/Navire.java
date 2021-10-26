import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Navire {
	
	public String nom;
	public Coord debut;
	public Coord fin;
	public int taille=0; 
	public Color couleur;
	List<Coord> list = new ArrayList<Coord>();
	
	public Navire(String nom,Coord debut,Coord fin,Color couleur) {
		
		int nbLigne = fin.ligne-debut.ligne+1;
		int nbColonne = fin.colonne-debut.colonne+1;
		
		if(nbLigne>1 && debut.colonne != fin.colonne ) {
			throw new IllegalArgumentException("Coordonnées NORD_SUD invalide");
		}
		
		if(nbColonne>1 && debut.ligne != fin.ligne ) {
			throw new IllegalArgumentException("Coordonnées EST_OUEST invalide");
		}
		
		if(debut.ligne > Constantes.TAILLE || debut.ligne > fin.ligne) {
			 throw new IllegalArgumentException("ligne invalide");
		}
		
		else if(debut.colonne > Constantes.TAILLE || debut.colonne > fin.colonne) {
			throw new IllegalArgumentException("Colonne invalide");
		}
		
		
		if(debut.ligne == fin.ligne) 
		{
			this.taille = nbColonne;
		}	
		else if (debut.colonne == fin.colonne) 
		{
			this.taille = nbLigne;
			
		}
		
		this.debut = debut;
		this.fin = fin;
		this.nom = nom;
		this.couleur = couleur;
		
	}
	
	public boolean estCoule() {
		boolean estcoule = false;
		if(list.size() == taille) {
			estcoule = true;
		}
		return estcoule;
	}

	public boolean dejaRecuTir(Coord tir)  
    { 
        boolean dejaRecuTir=false;       
        if(list.contains(tir))  { 
            dejaRecuTir=true; 
        }    
        return dejaRecuTir; 
    } 
	
	public boolean tirAtouche(Coord tir) {
		boolean tirAtouche = false;
		if(!estCoule()) {
			if(!dejaRecuTir(tir)) {
				if(positionTouche(tir)) {
					list.add(tir);
					tirAtouche = true;
				}		
			}		
		}
		return tirAtouche;
	}
	
	public boolean chevauche(Navire navire) {
		boolean chevauche = false;
		Coord coord = new Coord();
		for(int i = navire.debut.ligne; i <= navire.fin.ligne; i++) {
			for(int j = navire.debut.colonne; j <= navire.fin.colonne; j++) {
				coord.ligne = i;
				coord.colonne = j;
				if(positionTouche(coord)){
					chevauche = true;
				}
			}
		}
		return chevauche;
	}
	
	private boolean positionTouche(Coord tir) {	
		boolean positionTouche = false;
		int nbLigne = fin.ligne-debut.ligne+1;
		int nbColonne = fin.colonne-debut.colonne+1;
		
		 System.out.println("nbLigne :"+nbLigne);
		 System.out.println("nbColonne :"+nbColonne);
		 
		 if(nbLigne>1) {
			if (tir.ligne>= debut.ligne && tir.ligne <= fin.ligne) {	 
				positionTouche = true;
			}
			// debut.colonne est égale à fin.ligne car le nb de colonne est a 1
			if(tir.colonne != debut.colonne) {
				positionTouche = false;
			}		
		 }
		 else if(nbColonne>1) {
			 if (tir.colonne>= debut.colonne && tir.colonne <= fin.colonne) {		
					positionTouche = true;		
			 }
			// debut.colonne est égale à fin.ligne car le nb de colonne est a 1
			 if(tir.ligne != debut.ligne) {
					positionTouche = false;
				}
		 }
		return positionTouche;
	}
	
	
	
	public void afficherList() {
		for(Coord elem: list){
	       	 System.out.println (elem);
	    }
	}
	
	public static void main(String[] args){
		
         Coord debut = new Coord(1,1);
         Coord fin = new Coord(1,4);
         
         Coord debut1 = new Coord(1,1);
         Coord fin2 = new Coord(3,1);
         
         Coord tir = new Coord(1,1);
         
           
         Navire test1 = new Navire("La perle noire",debut,fin,Color.BLACK);
         Navire test2 = new Navire("La perle noire",debut1,fin2,Color.BLACK);
         
         //test1.list.add(tir);
         
         //System.out.println(test1.positionTouche(debut1));
         //System.out.println(test1.dejaRecuTir(tir));
         System.out.println(tir);
         //System.out.println(test1.chevauche(test2)); 
         
         // probleme
         
      
         System.out.println(test1.positionTouche(tir));
         
         
         //test1.tirAtouche(tir);
         
         //test1.afficherList();
       
    }
	
}
