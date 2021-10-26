import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Flotte {
	public static Random rand = new Random();
	List<Navire> list = new ArrayList<Navire>();
	
	public Flotte() 
	{
		genererPosNavireAleaInsererDsGrille();
		
	}
	
	 public Navire[] getTabNavires() {
		 Navire[] arrayBateau = (Navire[]) list.toArray();
		 return arrayBateau;
	 }
	
	public boolean dejaRecuCoup(Coord tir) 
	{
		boolean dejaRecuCoup = false;
		for(Navire Navire : list) {
			if(Navire.tirAtouche(tir) == true){

				
				dejaRecuCoup = true;
			}
		}

		return dejaRecuCoup;
	}
	
	public boolean jeuTermine() 
	{

		boolean jeuTermine = false;

		int taille = 0;

		for(Navire Navire : list) {
			if(Navire.estCoule() == true) {
				
				taille++;
				if(taille == list.size()) {
					
					jeuTermine = true;
				}
			}

		}
		return jeuTermine;
	}
	
	
	public boolean leTirTouche(Coord tir) 
	{
		boolean leTirTouche = false;
		for(Navire Navire : list) {
			if(Navire.tirAtouche(tir) == true){

				
				leTirTouche = true;
			}
		}
		
	
		return leTirTouche;
	}
	
	/*
	 * ajoute un navire seulement si les coordonnes sont du navires sont valides
	 * doit etre a linterieur de la grille et pas chevaucher un navire dans la flotte
	 * 
	 */
	private int ajouterNavire(Navire Navire) {

		int ajouterNavire = 0;

	/*
		for(Navire nav : list) {
			if(nav.chevauche(Navire) == true) {
				ajouterNavire = 1;	
			}

		}
		*/
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
			list.add(nav);
		}
		return nav;	
	}
	private void genererPosNavireAleaInsererDsGrille()  
	{	
		obtenirNavireAleatoire(Constantes.PORTE_AVION,5,Color.RED);
		obtenirNavireAleatoire(Constantes.CROISEUR,4,Color.BLUE);
		obtenirNavireAleatoire(Constantes.CUIRASSE,3,Color.GREEN);
		obtenirNavireAleatoire(Constantes.SOUS_MARIN,3,Color.BLACK);
		obtenirNavireAleatoire(Constantes.DESTROYER,2,Color.ORANGE);
	
	}
}