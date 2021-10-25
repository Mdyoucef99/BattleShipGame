import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Flotte {
	
	List<Navire> list = new ArrayList<Navire>();
	
	public Flotte() 
	{
		InstancierFlotte();
		
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
	
	
	public void InstancierFlotte()  
	{
		Coord cord1 = new Coord(1,5);
		Coord cord2 = new Coord(1,8);
		
		Coord cord3 = new Coord(1,4);
		Coord cord4 = new Coord(2,4);
		
		Coord cord5 = new Coord(3,1);
		Coord cord6 = new Coord(3,5);
		
		Coord cord7 = new Coord(8,5);
		Coord cord8 = new Coord(8,6);
		
		Coord cord9 = new Coord(4,9);
		Coord cord10 = new Coord(7,9);
		
		Navire porteavions = new Navire(Constantes.PORTE_AVION,cord1,cord2,Color.RED);
		list.add(porteavions);
		Navire croiseur = new Navire(Constantes.CROISEUR,cord3,cord4,Color.BLUE);
		list.add(croiseur);
		Navire contretorpilleurs = new Navire(Constantes.DESTROYER,cord5,cord6,Color.YELLOW);
		list.add(contretorpilleurs);
		Navire sousmarin = new Navire(Constantes.SOUS_MARIN,cord7,cord8,Color.BLACK);
		list.add(sousmarin);
		Navire torpilleur = new Navire(Constantes.CUIRASSE,cord9,cord10,Color.ORANGE);
		list.add(torpilleur);

		
		
	}
	
	
}