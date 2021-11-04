package pack;

import java.util.Vector;

public class JoueurAvance {

	public Vector TableauCoups; 
	boolean premierdiagonale = true;
	boolean deuxiemediagonale = false;
	Coord cDiag = new Coord(9,1);
	

	public JoueurAvance()
	{
		TableauCoups= new Vector();
	}

	
	public Coord getTir() 
	{
		Coord coord;
		
		if(TableauCoups.isEmpty()) 
		{
			if(premierdiagonale ==true) 
			{			
				//do{}while(UtilitaireCollection.tableauContientCoord(TableauCoups,cDiag) || cDiag.ligne == Constantes.TAILLE-1);
				
				cDiag.ligne= cDiag.ligne-1; 
				cDiag.colonne= cDiag.colonne+1; 
				System.out.println(cDiag.toString());
			
				if(cDiag.ligne == Constantes.TAILLE) 
				{
					premierdiagonale =false;
					deuxiemediagonale=true;
					System.out.println("same ligne que cDiag");
						
				}

			}
			
			if(deuxiemediagonale == true) 
			{
				
				
				
			}
			
			
			if(premierdiagonale==false && deuxiemediagonale ==false) 
			{
				
				
			}
			
			
		}
		return cDiag;
	
	}
	
	
	
	public void aviseTouche(Coord c)
	{
		
	}	
	
	
	
	
	
}
