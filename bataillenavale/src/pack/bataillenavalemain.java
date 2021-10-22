package pack;
import java.awt.Color;

public class bataillenavalemain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		GrilleGui grille = new GrilleGui(Constantes.TAILLE,Constantes.TAILLE,Color.BLACK,Color.WHITE,Constantes.OPTIONS,1);
		grille.run();
		Flotte flottemain = new Flotte();
		UtilitaireGrilleGui.montrerFlotte(flottemain, grille);
		
	}

}
