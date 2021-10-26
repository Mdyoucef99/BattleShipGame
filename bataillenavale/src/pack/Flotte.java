import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Flotte {
	public static Random rand = new Random();
	List<Navire> Navirelist = new ArrayList<Navire>();
	
	public Flotte() 
	{
		genererPosNavireAleaInsererDsGrille();
		
	}
	/*
	 *fonciton qui nous donne le Navirelist en array 
	 *en utilisant toArray
	 */
	 public Navire[] getTabNavires() {
		 Navire[] arrayBateau = (Navire[]) Navirelist.toArray();
		 return arrayBateau;
	 }
	/*
	 * fonction qui nous returne true si un navire 
	 * a ete touche par le tir
	 */
	public boolean dejaRecuCoup(Coord tir) 
	{
		boolean dejaRecuCoup = false;
		for(Navire Navire : Navirelist) {
			if(Navire.tirAtouche(tir) == true){

				
				dejaRecuCoup = true;
			}
		}

		return dejaRecuCoup;
	}
	/*
	 * fonction qui nous returne true si tous les 
	 * bateaux ont ete coule
	 * sil retourne true le jeu est termine
	 */
	public boolean jeuTermine() 
	{

		boolean jeuTermine = false;

		int taille = 0;

		for(Navire Navire : Navirelist) {
			if(Navire.estCoule() == true) {
				
				taille++;
				if(taille == Navirelist.size()) {
					
					jeuTermine = true;
					System.out.println("le jeu est termine");
				}
			}

		}
		return jeuTermine;
	}
	
	/*
	 * fonction qui retourne true si le
	 * tir a touche un navire de la flotte
	 */
	public boolean leTirTouche(Coord tir) 
	{
		boolean leTirTouche = false;
		for(Navire Navire : Navirelist) {
			if(Navire.tirAtouche(tir) == true){

				
				leTirTouche = true;
			}
		}
		
	
		return leTirTouche;
	}
	
	/*
	 *fonction qui regarde si un navire chevauche par 
	 *dessus un autre ou si les coordonnes
	 *dun navire est a linterieur de la grille
	 *si jamais une des contraintes nest pas respecte 
	 *ajouterNavire retourne 1 et sil retourne un il ne sera pas ajoute 
	 *dans la liste
	 */
	private int ajouterNavire(Navire navire) {

		int ajouterNavire = 0;
		
		if(navire.debut.ligne < 0 || navire.fin.ligne > Constantes.TAILLE -1) {
			 System.out.println("ligne invalide");
			 ajouterNavire = 1;
		}
			if(navire.debut.colonne < 0 || navire.fin.colonne > Constantes.TAILLE - 1) {
				System.out.println("colonne invalide");
			ajouterNavire = 1;
			}
		
		

	
		for(Navire nav : Navirelist) {
			if(nav.chevauche(navire) == true) {
				ajouterNavire = 1;	
			}
		}
		
		return ajouterNavire;
	}
	/*
	 * 
	 * ajoute un navire dans la flotte un a un 
	 * autant de boucle quil y a de navire 
	 * boucle se termine quand ajouternavire retourne aucune erreur
	 */

	
	public static Flotte obtenirFlotteAleatoire(GrilleGui gui, Flotte flotte) {
		
		
		return flotte;
	}
	
	/*
	 * fonction qui nous donne un navire avec des coordonnes 
	 * aleatoire en commence avec la valeur du premier coordonnees
	 * pour en suite faire un random et tant quil nest pas plus grand que
	 * la taille de la grille - la longueur du bateau qui est demande
	 * et on fait ensuite un random pour choisir la direction sil va par colonne
	 * ou par ligne et sil respecte les contraintes de ajouerNavire on lajoute 
	 * a la liste
	 */
	private Navire obtenirNavireAleatoire(String nom, int longueur, Color couleur) {

		int x = 0;
		int y = 0;

		int x1 = 0;
		int y1 = 0;
		int direction = 0;
		x = rand.nextInt(10);
		y = rand.nextInt(10);
		while(x >Constantes.TAILLE - longueur || y > Constantes.TAILLE - longueur ) {
			x = rand.nextInt(10);
			y = rand.nextInt(10);
		}
	
		direction = rand.nextInt(2);
		if(direction == 1) {
			x1 = x;
			y1 = y+longueur-1;
		}
		else {
			x1 = x+longueur-1;
			y1 = y;
		}	
		Coord cord1 = new Coord(x,y);
		Coord cord2 = new Coord(x1,y1);	
		Navire nav = new Navire(nom,cord1,cord2,couleur);
		System.out.println(nom);
		System.out.println(cord1);
		System.out.println(cord2);
		System.out.println(direction);
		
		if(ajouterNavire(nav) == 0) {
			Navirelist.add(nav);
		}
		return nav;	
	}
	
	/*
	 * on genere les bateaux et pour les bateaux qui nont pas respecter 
	 * les contraintes de ajouterNavire on met une boucle for pour 
	 * regenrer les bateaux perdus
	 * 
	 */
	private void genererPosNavireAleaInsererDsGrille()  
	{	
		obtenirNavireAleatoire(Constantes.PORTE_AVION,5,Color.RED);
		obtenirNavireAleatoire(Constantes.CROISEUR,4,Color.BLUE);
		obtenirNavireAleatoire(Constantes.CUIRASSE,3,Color.GREEN);
		obtenirNavireAleatoire(Constantes.SOUS_MARIN,3,Color.BLACK);
		obtenirNavireAleatoire(Constantes.DESTROYER,2,Color.ORANGE);
		String[] Bateau = new String[5];
		Bateau[0] = Constantes.PORTE_AVION;
		Bateau[1] = Constantes.CROISEUR;
		Bateau[2] = Constantes.CUIRASSE;
		Bateau[3] = Constantes.SOUS_MARIN;
		Bateau[4] = Constantes.DESTROYER;
		
		for(int i = 0; i < 4 ; i++) {
			if(Navirelist.contains(Bateau[i])) {
				System.out.println(Bateau[i]+"est dans la flotte");
			}
			else {
				int j = 0;
				if(i == 4) {
					 j = 2;
				}
				else if(i == 3 || i == 2) {
					 j = 3;
				}
				else if(i == 1) {
					 j = 4;
				}else if( i == 0) {
					 j = 5;
				}
				obtenirNavireAleatoire(Bateau[i],j,Color.GRAY);
			}
		}

}
	
}