package pack;

import java.util.List;
import java.util.Vector;
import java.util.ArrayList;

public class JoueurIntermediaire {

	public Vector TableauCoups; 
	public List<Coord> Adjacent;

	public JoueurIntermediaire()
	{
		TableauCoups= new Vector();
		Adjacent = new ArrayList<Coord>();
	}
	
	/*
	 * 
	 * fontion qui s'occupe de generer un tir si il n'existe pas de coordonner adjacent alors il donne un coup aleatoire 
	 * si une coordonner adjacente existe alors le prochaine coups sont le nord du navire touche ensuite le sud, est et enfin ouest 
	 * 
	 * @auteur Youcef mekki daouadji
	 * */
	public Coord getTir() 
	{  
		Coord c;
		int index=0;
	    while(Adjacent.isEmpty()==false) 
	    {
	    	c=Adjacent.get(index);
	    	Adjacent.remove(index);
	    	while(!UtilitaireCollection.tableauContientCoord(TableauCoups, c)) 
	    	{
		    	TableauCoups.add(c);
		    	return c;
	    	}
	    	
	    }
	    c = UtilitaireCollection.obtenirCoupPasDejaJouer(TableauCoups);
	    TableauCoups.add(c);
		return c;
		
	}
	/*
	 * @auteur Youcef mekki daouadji et  Antoine Bolduc 
	 * une fonction qui s'oocupe de aviser si un tir a touche si oui alors nous ajoutant les coordonner adjacente a une liste et nous parcourant la liste dans la fonction gettir() en haut 
	 * */
	public void aviseTouche(Coord c) 
	{
		
		Coord Nord = new Coord(c.ligne-1,c.colonne);
		Coord Sud = new Coord(c.ligne+1,c.colonne);
		Coord Est = new Coord(c.ligne,c.colonne+1);
		Coord Ouest = new Coord(c.ligne,c.colonne-1);
		
		if(Nord.ligne<0 || Nord.ligne>=10) 
		{
			System.out.println("out of bounds ");
		}
		
		else 
		{
			Adjacent.add(Nord);
		}
		
		if(Sud.ligne<0 || Sud.ligne>=10) 
		{
			System.out.println("out of bounds ");
		}
		
		else 
		{
			Adjacent.add(Sud);
		}	
		
		if(Est.colonne<0 || Est.colonne>=10) 
		{
			System.out.println("out of bounds ");
		}
		
		else 
		{
			Adjacent.add(Est);
		}
		if(Ouest.colonne<0 || Ouest.colonne>=10) 
		{
			System.out.println("out of bounds ");
		}
		
		else 
		{
			Adjacent.add(Ouest);
		}
		
	}
	
}
