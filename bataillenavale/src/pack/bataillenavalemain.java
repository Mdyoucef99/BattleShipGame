package pack;
import java.awt.Color;

public class bataillenavalemain {

	
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		GrilleGui grille = new GrilleGui(Constantes.TAILLE,Constantes.TAILLE,Color.BLACK,Color.WHITE,Constantes.OPTIONS,1);
		grille.run();
		Coord cord1 = new Coord(1,4);
		Coord cord2 = new Coord(1,6);
		Navire nav = new Navire("Porte avion",cord1,cord2,Color.red);
		UtilitaireGrilleGui.montrerNavire(nav, grille);
	}

}
