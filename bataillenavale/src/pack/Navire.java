package pack;
import java.awt.Color;
import java.util.ArrayList;

public class Navire {

	public String nom;
	public Coord debut;
	public Coord fin;
	public int taille=0; 
	public Color couleur;
	public ArrayList Couptouche;
	
	
	public Navire(String nom, Coord debut, Coord fin, Color couleur) 
	{
		this.nom = nom;
		this.debut=debut;
		this.fin=fin;
		this.couleur = couleur;
	
		/*if(debut.ligne > 1 && debut.colonne != fin.colonne) 
		{
			throw new Exception("Coordonnées NORD_SUD invalide");
		}
		
		else if(debut.colonne > 1 && debut.ligne != fin.ligne) 
		{
			throw new Exception("Coordonnées EST_OUEST invalide");
		}
		*/
		 if(debut.ligne > Constantes.TAILLE || debut.ligne > fin.ligne) 
		{
			 throw new IllegalArgumentException("ligne invalide");
		}
		
		else if(debut.colonne > Constantes.TAILLE || debut.colonne > fin.colonne) 
		{
			throw new IllegalArgumentException("Colonne invalide");
		}
		
		
		if(debut.ligne == fin.ligne) 
		{
			taille = fin.colonne - debut.colonne +1;
		}
		
		else if (debut.colonne == fin.colonne) 
		{
			taille = fin.ligne - debut.ligne +1;
			
		}
		
		System.out.println("Taille du navire est : "+ taille);

		
	}
	
	
	public void test() 
	{
		Coord yo = new Coord(3,9);
		System.out.print("POSITION TOUCHES DANS LA COORDONNE "+positionTouche(yo));
	}
	
	
	private boolean positionTouche(Coord tir) 
	{
		if (tir.ligne>= debut.ligne && tir.ligne <= fin.ligne) 
		{
			 
			return true;
		}
		
		else if (tir.colonne>= debut.colonne && tir.colonne <= fin.colonne) 
		{
			
			return true;
		}
		
		else {return false;}
		
	}
	
	
	
}
