package pack;
import java.awt.Color;

public class bataillenavalemain {


	/*
	 * Auteur du projet :
	 * Auteur : Youcef mekki daouadji
     * Auteur : Rada Leng
     * Auteur : Antoine Bolduc

	 * */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		GrilleGui grille = new GrilleGui(Constantes.TAILLE,Constantes.TAILLE,Color.BLACK,Color.WHITE,Constantes.OPTIONS,1);
		grille.run();
		UtilitaireGrilleGui.montrerFlotte(Flotte.obtenirFlotteAleatoire(), grille);//montrer la flotte dans la grille @Youcef mekki daouadji
		
	}

}
