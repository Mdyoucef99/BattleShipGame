package pack;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Flotte 
{
	public static Random rand = new Random();
	List<Navire> Navirelist = new ArrayList<Navire>();
	
	public Flotte() 
	{
		genererPosNavireAleaInsererDsGrille();
	}
	/*
	 *fonciton qui nous donne le Navirelist en array 
	 *en utilisant toArray 
	 *
	 *Auteur : Rada Leng && Youcef mekki daouadji
	 */
	 public Navire[] getTabNavires() 
	 {
		 Navire[] arrayBateau = new Navire[Navirelist.size()]; 
		 arrayBateau = Navirelist.toArray(arrayBateau);
		 return arrayBateau;
	 }
	/*
	 * fonction qui nous returne true si un navire 
	 * a ete touche par le tir
	 * 
	 * Auteur : Rada Leng
	 */
	public boolean dejaRecuCoup(Coord tir) 
	{
		boolean dejaRecuCoup = false;
		for(Navire Navire : Navirelist) {
			if(Navire.dejaRecuTir(tir) == true)
			{
				dejaRecuCoup = true;
			}
		}

		return dejaRecuCoup;
	}
	/*
	 * fonction qui nous returne true si tous les 
	 * bateaux ont ete coule
	 * sil retourne true le jeu est termine
	 * 
	 * Auteur : Rada Leng
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
	 * 
	 * Auteur : Rada Leng
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
	 *
	 *Auteur : Rada Leng
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
				System.out.println("NAVIRE_DEJA_SUR_PLACE");
				System.out.println("POSITION_INVALIDE");
				ajouterNavire = 1;	
			}
		}
		if(ajouterNavire == 0) {
			System.out.println("AUCUNE_ERREUR");
		}
		return ajouterNavire;
	}


	/* Fonction qui s'occupe de generer la flotte avec tous les navires
 * Auteur : youcef mekki daouadji
 * 
 * */
	public static Flotte obtenirFlotteAleatoire() {
        Flotte flottemain = new Flotte();
        return flottemain;

	}
	
	/*
	 * fonction qui nous donne un navire avec des coordonnes 
	 * aleatoire en commence avec la valeur du premier coordonnees
	 * pour en suite faire un random et tant quil nest pas plus grand que
	 * la taille de la grille - la longueur du bateau qui est demande
	 * et on fait ensuite un random pour choisir la direction sil va par colonne
	 * ou par ligne et sil respecte les contraintes de ajouerNavire on lajoute 
	 * a la liste. tant que ajouternavire == 1 on redemande les coordonnes pour 
	 * au final avoir nos 5 bateaux
	 * 
	 * Auteur : Rada Leng
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

		while(ajouterNavire(nav) == 1) {
			int a,b,c,d,e = 0;
			a = rand.nextInt(10);
			b = rand.nextInt(10);
			while(a >Constantes.TAILLE - longueur || b > Constantes.TAILLE - longueur ) {
				a = rand.nextInt(10);
				b = rand.nextInt(10);
			}
			e = rand.nextInt(2);
			if(e == 1) {
				c = a;
				d = b+longueur-1;
			}
			else {
				c = a+longueur-1;
				d = b;
			}	
			cord1 = new Coord(a,b);
			cord2 = new Coord(c,d);	
			nav = new Navire(nom,cord1,cord2,couleur);			
		}
		
		if(ajouterNavire(nav) == 0) {
			Navirelist.add(nav);
		}
		return nav;	
	}
	
	/*
	 * on genere les bateaux par obtenirNavireAleatoire
	 * Auteur: Rada Leng
	 */
	private void genererPosNavireAleaInsererDsGrille()  
	{	
		obtenirNavireAleatoire(Constantes.PORTE_AVION,5,Color.RED);
		obtenirNavireAleatoire(Constantes.CROISEUR,4,Color.BLUE);
		obtenirNavireAleatoire(Constantes.CUIRASSE,3,Color.GREEN);
		obtenirNavireAleatoire(Constantes.SOUS_MARIN,3,Color.BLACK);
		obtenirNavireAleatoire(Constantes.DESTROYER,2,Color.ORANGE);
		
}
	
}