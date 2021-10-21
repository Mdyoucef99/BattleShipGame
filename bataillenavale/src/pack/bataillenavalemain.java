package pack;
import java.awt.Color;

public class bataillenavalemain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		GrilleGui grille = new GrilleGui(Constantes.TAILLE,Constantes.TAILLE,Color.BLACK,Color.WHITE,Constantes.OPTIONS,1);
		grille.run();
		
		//Tester pour ajouter different navire avec la methode montrer navire 
		Coord cord1 = new Coord(1,4);
		Coord cord2 = new Coord(3,4);
		Navire nav = new Navire("Porte avion",cord1,cord2,Color.red);
		Coord cord3 = new Coord(1,2);
		Coord cord4 = new Coord(1,5);
		Navire nav2 = new Navire("avion",cord3,cord4,Color.BLUE);
		UtilitaireGrilleGui.montrerNavire(nav2, grille);
		UtilitaireGrilleGui.montrerNavire(nav, grille);
		
	}

}
