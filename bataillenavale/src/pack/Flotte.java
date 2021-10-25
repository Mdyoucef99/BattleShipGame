package pack;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Flotte {
	public static Random rand = new Random();
	List<Navire> list = new ArrayList<Navire>();
	
	public Flotte() 
	{
		InstancierFlotte();
		
	}
	
	 public Navire[] getTabNavires() {
		 Navire[] arrayBateau = new Navire[list.size()]; 
		 arrayBateau = list.toArray(arrayBateau); 
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
		
		
		return 0;
	}
	/*
	 * 
	 * ajoute un navire dans la flotte un a un 
	 * autant de boucle quil y a de navire 
	 * boucle se termine quand ajouternavire retourne aucune erreur
	 */

	private void genererPosNavireAleaInsererDsGrille() {
	

	}
	/*
	public static obtenirFlotteAleatoire() {
		
		
		return 0;
	}
	
	private obtenirNavireAleatoire(String nom, int longueur, Color couleur) {
		
		
		
		return 0;
	}
	*/
	public void InstancierFlotte()  
	{
		int x = 0;
		int y = 0;
		int x1 = 0;
		int y1 = 0;
		int direction = 0;
		/*
		 * on randomize 2 coordonne et dependemment 
		 * la valeur de la direction on additionne + x
		 */
		
		x = rand.nextInt(10);
		y = rand.nextInt(10);
		while (x > 5 || y > 5) {
			x = rand.nextInt(10);
			y = rand.nextInt(10);
			
			
			
		}
		/*
		 * randomize une direction si direction = 0
		 * on modifie la ligne si direction = 1 
		 * on modifie la colonne
		 */
		direction = rand.nextInt(2);
		System.out.println(direction);
		if(direction ==1) {
			x1 = x;
			y1 = (y+4);
		}
		else {
			x1 = x+4;
			y1 = y;
		}	
		/*
		 * on met en coordonne les 4 valeurs 
		 */
		Coord cord1 = new Coord(x,y);
		Coord cord2 = new Coord(x1,y1);	
/*
 * on rajoute a la liste la bateau
 */
		Navire porteavions = new Navire(Constantes.PORTE_AVION,cord1,cord2,Color.RED);
		list.add(porteavions);
		/*
		 * 
		 * Bateau 2
		 */
		x = rand.nextInt(10);
		y = rand.nextInt(10);
		while (x > 6 || y > 6) {
			x = rand.nextInt(10);
			y = rand.nextInt(10);	
		}

		direction = rand.nextInt(2);
		if(direction ==1) {
			x1 = x;
			y1 = (y+3);
		}
		else {
			x1 = x+3;
			y1 = y;
		}
		Coord cord3 = new Coord(x,y);
		Coord cord4 = new Coord(x1,y1);	
		Navire croiseur = new Navire(Constantes.CROISEUR,cord3,cord4,Color.BLUE);
		list.add(croiseur);
/*
 * Bateau 3
 */
		x = rand.nextInt(10);
		y = rand.nextInt(10);
		while (x > 7 || y > 7) {
			x = rand.nextInt(10);
			y = rand.nextInt(10);	
		}

		direction = rand.nextInt(2);
		if(direction ==1) {
			x1 = x;
			y1 = (y+2);
		}
		else {
			x1 = x+2;
			y1 = y;
		}
		Coord cord5 = new Coord(x,y);
		Coord cord6 = new Coord(x1,y1);	
		Navire contretorpilleurs = new Navire(Constantes.CROISEUR,cord5,cord6,Color.GREEN);
		list.add(contretorpilleurs);
		
		/*
		 * Bateau 4
		 */
		x = rand.nextInt(10);
		y = rand.nextInt(10);
		while (x > 8 || y > 8) {
			x = rand.nextInt(10);
			y = rand.nextInt(10);	
		}

		direction = rand.nextInt(2);
		if(direction ==1) {
			x1 = x;
			y1 = (y+1);
		}
		else {
			x1 = x+1;
			y1 = y;
		}
		Coord cord7 = new Coord(x,y);
		Coord cord8 = new Coord(x1,y1);	
		Navire sousmarin = new Navire(Constantes.SOUS_MARIN,cord7,cord8,Color.BLACK);
		list.add(sousmarin);

		/*
		 * Bateau 5
		 */
		x = rand.nextInt(10);
		y = rand.nextInt(10);
		while (x > 7 || y > 7) {
			x = rand.nextInt(10);
			y = rand.nextInt(10);	
		}
		direction = rand.nextInt(2);
		if(direction ==1) {
			x1 = x;
			y1 = (y+2);
		}
		else {
			x1 = x+2;
			y1 = y;
		}
		Coord cord9 = new Coord(x,y);
		Coord cord10 = new Coord(x1,y1);	
		Navire torpilleur = new Navire(Constantes.CUIRASSE,cord9,cord10,Color.ORANGE);
		list.add(torpilleur);	
		
		/*
		 * 
		 * fonction chevauche imcomplet
		 */
		for(Navire nav : list) {
			if(nav.chevauche(nav) == true) {
				
			}
		}

	}
	
	
}