package pack;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Flotte {
	
	List<Navire> Navirelist = new ArrayList<Navire>();
	
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
	
	public Flotte() 
	{
		InstancierFlotte();
		
	}
	
	public boolean dejaRecuCoup(Coord tir) 
	{
		
		return false;
	}
	
	public boolean jeuTermine() 
	{
		
		return false;
	}
	
	
	public boolean leTirTouche(Coord tir) 
	{
		
		return false;
	}
	
	
	public void InstancierFlotte()  
	{
		
		Navire porteavions = new Navire(Constantes.PORTE_AVION,cord1,cord2,Color.RED);
		Navirelist.add(porteavions);
		Navire croiseur = new Navire(Constantes.CROISEUR,cord3,cord4,Color.BLUE);
		Navirelist.add(croiseur);
		Navire contretorpilleurs = new Navire(Constantes.DESTROYER,cord5,cord6,Color.YELLOW);
		Navirelist.add(contretorpilleurs);
		Navire sousmarin = new Navire(Constantes.SOUS_MARIN,cord7,cord8,Color.BLACK);
		Navirelist.add(sousmarin);
		Navire torpilleur = new Navire(Constantes.CUIRASSE,cord9,cord10,Color.ORANGE);
		Navirelist.add(torpilleur);
	
	}
	
	
}
