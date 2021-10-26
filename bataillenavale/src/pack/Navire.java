import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Navire {
	
	/**
	 * Les attributs conservés.
	 */
	public  String nom;
	public Coord debut;
	public Coord fin;
	public int taille=0; 
	public Color couleur;
	public List<Coord> list = new ArrayList<Coord>();
	
	/**
	 * Constructeurs par copie d'attributs,
	 * 
	 * @param nom
	 * @param debut Le début d'une coordonnée
	 * @param fin	La fin d'une coordonnée
	 * @param couleur
	 * 
	 * Auteur: Antoine Bolduc && Youcef Mekki Daouadji
	 */
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
	
	/**
	 * Une méthode qui retourne vrai si le bateau est coulé,
	 * 
	 * Auteur: Antoine Bolduc
	 */
	public boolean estCoule() {
		boolean estcoule = false;
		if(list.size() == taille) {
			estcoule = true;
		}
		return estcoule;
	}

	/**
	 * Une méthode qui retourne vrai si la coordonnée reçue à déjà touché au navire,
	 * 
	 * Auteur: Antoine Bolduc
	 */
	public boolean dejaRecuTir(Coord tir)  
    { 
        boolean dejaRecuTir=false;       
        if(list.contains(tir))  { 
            dejaRecuTir=true; 
        }    
        return dejaRecuTir; 
    } 
	
	/**
	 * Une méthode qui retourne vrai si la coordonnée reçue touche au navire actuel
	 * et retient aussi la coordonnée si elle l’a touché,
	 * 
	 * Auteur: Antoine Bolduc
	 */
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
	
	/**
	 * Une méthode qui retourne vrai si une des positions du navire reçu touche à une des positions du navire actuel,
	 * 
	 * Auteur: Antoine Bolduc
	 */
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
	
	/**
	 * Une méthode qui retourne vrai si la coordonnée du tir touche au navire,
	 * 
	 * Auteur: Antoine Bolduc
	 */
	private boolean positionTouche(Coord tir) {	
		boolean positionTouche = false;
		int nbLigne = fin.ligne-debut.ligne+1;
		int nbColonne = fin.colonne-debut.colonne+1;
		 
		 if(nbLigne>1) {
			if (tir.ligne>= debut.ligne && tir.ligne <= fin.ligne) {	 
				positionTouche = true;
			}
			// debut.colonne est égale à fin.colonne car le nb de colonne est a 1
			if(tir.colonne != debut.colonne) {
				positionTouche = false;
			}		
		 }
		 else if(nbColonne>1) {
			 if (tir.colonne>= debut.colonne && tir.colonne <= fin.colonne) {		
					positionTouche = true;		
			 }
			// debut.ligne est égale à fin.ligne car le nb de ligne est a 1
			 if(tir.ligne != debut.ligne) {
					positionTouche = false;
				}
		 }
		return positionTouche;
	}
	
	/**
	 * Une fonction qui affiche la liste courante,
	 * 
	 * Auteur: Antoine Bolduc
	 */
	public void afficherList() {
		for(Coord elem: list){
	       	 System.out.println (elem);
	    }
	}
}
