package pack;
import java.awt.Color;

public class bataillenavalemain {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		GrilleGui grille = new GrilleGui(Constantes.TAILLE,Constantes.TAILLE,Color.BLACK,Color.WHITE,Constantes.OPTIONS,1);
		grille.run();
		Flotte flottemain = new Flotte();
		UtilitaireGrilleGui.montrerFlotte(flottemain, grille);
		
		Navire[] array= flottemain.getTabNavires();
		
		for (int i=0;i<flottemain.list.size();i++) 
		{
			System.out.println("le nom  est "+ array[i].nom);
			
		}
		
	}

}
