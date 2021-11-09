package pack;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class JoueurAvance {

	public Vector TableauCoups; 
	boolean premierdiagonale = true;
	boolean deuxiemediagonale = false;
	public List<Coord> Adjacent;
	Coord cDiag = new Coord(-1,-1);
	
	
	public JoueurAvance()
	{
		TableauCoups= new Vector();
		Adjacent = new ArrayList<Coord>();
	}

	
	public Coord getTir() 
	{
		Coord coord =cDiag;
		int index=0;
		
		  while(Adjacent.isEmpty()==false) 
		    {
		    	coord=Adjacent.get(index);
		    	Adjacent.remove(index);
		    	while(!UtilitaireCollection.tableauContientCoord(TableauCoups, coord)) 
		    	{
			    	TableauCoups.add(coord);
			    	return coord;
		    	}
		    	
		    }
		
		if(Adjacent.isEmpty()) 
		{
			if(premierdiagonale ==true) 
			{					
				cDiag.ligne =cDiag.ligne+1; 
				cDiag.colonne=cDiag.colonne+1;
				TableauCoups.add(cDiag);
				
				if(cDiag.ligne == Constantes.TAILLE) 
				{
					premierdiagonale =false;
					deuxiemediagonale=true;
					//début de la deuxième diagonal 
					cDiag = new Coord(-1,10);
					TableauCoups.add(cDiag);
						
				}

			}
			
			if(deuxiemediagonale == true) 
			{	
				cDiag.ligne =cDiag.ligne+1; 
				cDiag.colonne=cDiag.colonne-1;
				TableauCoups.add(cDiag);
				System.out.println(cDiag.toString());	
				
				if(cDiag.ligne == Constantes.TAILLE) 
				{
					deuxiemediagonale=false;
				}
			}
			
			if(premierdiagonale==false && deuxiemediagonale ==false) 
			{
				cDiag = UtilitaireCollection.obtenirCoupPasDejaJouer(TableauCoups);
				TableauCoups.add(cDiag);
			}
			
			coord = cDiag;
		}
	
		return coord;
	}
	

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