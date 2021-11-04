package pack;

import java.util.Vector;

public class JoueurIntermediaire {

	public Vector TableauCoups; 
	public Vector Adjacent;

	public JoueurIntermediaire()
	{
		TableauCoups= new Vector();
		Adjacent = new Vector();
	}
	
	
	public Coord getTir() 
	{
		Coord c;
		
		while(!Adjacent.isEmpty()) 
		{
			
		}
		
		
		 c = UtilitaireCollection.obtenirCoupPasDejaJouer(TableauCoups);  
		TableauCoups.add(c);
		return c; 
	}
	
	
	public void aviseTouche(Coord c) 
	{
		
		
		
		
	}
	
}
