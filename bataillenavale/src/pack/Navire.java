package pack;
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
			throw new IllegalArgumentException("Coordonn�es NORD_SUD invalide");
		}
		
		if(nbColonne>1 && debut.ligne != fin.ligne ) {
			throw new IllegalArgumentException("Coordonn�es EST_OUEST invalide");
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
		
		if(list.contains(tir)) 
		{
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
		boolean positionTouche= false;
		if (tir.ligne>= debut.ligne && tir.ligne <= fin.ligne && debut.ligne !=fin.ligne) {	 
			positionTouche = true;
		}
		else if (tir.colonne>= debut.colonne && tir.colonne <= fin.colonne && debut.colonne !=fin.colonne) {		
			positionTouche = true;
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
         Coord fin = new Coord(4,1);
         
         Coord debut1 = new Coord(5,1);
         Coord fin2 = new Coord(7,1);
         
         Coord tir = new Coord(3,1);
           
         Navire test1 = new Navire("La perle noire",debut,fin,Color.BLACK);
         Navire test2 = new Navire("La perle noire",debut1,fin2,Color.BLACK);
         
         //System.out.println(test1.positionTouche(debut1));
       
         //System.out.println(tir);
         //System.out.println(test1.chevauche(test2));   
         //System.out.println(test1.estCoule());
         
         //test1.tirAtouche(tir);
         
         
         
         
         test1.list.add(tir);
         test1.afficherList();
         System.out.println(test1.dejaRecuTir(tir));
         
    }
	
}
