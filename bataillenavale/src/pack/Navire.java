package pack;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Navire {

	public String nom;
	public Coord debut;
	public Coord fin;
	public int taille=0; 
	public Color couleur;
	List<Coord> Coordlist = new ArrayList<Coord>();
	
	
	public Navire(String nom, Coord debut, Coord fin, Color couleur) 
	{
		this.nom = nom;
		this.debut=debut;
		this.fin=fin;
		this.couleur = couleur;
	/*
		if(debut.ligne-fin.ligne+1 > 1 && debut.colonne != fin.colonne) 
		{
			throw new IllegalArgumentException("Coordonnées NORD_SUD invalide");
		}
		
		else if(debut.colonne - fin.colonne + 1 > 1 && debut.ligne != fin.ligne) 
		{
			throw new IllegalArgumentException("Coordonnées EST_OUEST invalide");
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
		
		System.out.println("Taille du navire  "+nom+ " est de : "+ taille);

		
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
		
		else 
		{
			return false;
		}
		
	}
	
	
	public boolean estCoule() 
	{
		int j=0;
		for(Coord cord : Coordlist) 
		{
			for(int i=debut.colonne;i<=fin.colonne;i++) 
			{
				int tempcolonne =+ fin.colonne;
				Coord temp = new Coord(i,tempcolonne);
				if(cord ==temp) 
				{
					j++;
				}
			}
			
		}
		
		if(j==taille) 
		{
			System.out.println("Navire a coule ");
			return true;
		}
		else 
		{
			return false;
		}
		
	}
	
	
	

}
