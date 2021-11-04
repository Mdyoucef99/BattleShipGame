package pack;

import java.awt.Color;
/**
 * Solution du tp1A21 inf111
 * 
 * Regroupe tous les SP pour gérer les règles du jeu et maintenir
 * le gui pour aider l'utilisateur à jouer à la bataille navale tel que décrit
 * dans l'énoncé fourni.
 * 
 * @author Pierre Bélisle 
 * @version Copyright A2021
 *
 */
public class UtilitaireGrilleGui {

	/**
	 * Utile pour contrôler le temps de jeu et laisser le temps 
	 * à l'OS de prendre conscience des événements du GUI.
	 * 
	 * @param tempsDeDelai
	 */
	public static void pause (int tempsDeDelai){
	       
			try {
				Thread.sleep(tempsDeDelai);
			} catch (InterruptedException e) {		
				e.printStackTrace();
			}
	}

	/**
	 * Montre les navire de la flotte dans le gui.
	 * 
	 * Change la couleur de fond des cases à la position des navires.
	 * 
	 * @param grilleJeu  La grille contenant les navires
	 * @param gui L'interface graphique à remplir
	 * @param pourc Le pourcentage de la grille à mettre dans le gui
	 */
	
	
	
	/*
	 * Fonction qui permet d'afficher chaque navire dans la flotte et ensuite qui colorie chaque case du navire de debut a la fin
	 * Auteur : Youcef mekki daouadji
	 * 
	 * 
	 * */
	
        public static void montrerFlotte(Flotte flotte, GrilleGui gui)
        {

		/*
		 * Stratégie : Pour chaque Navire de la grille de jeu, on colore le fond
		 * de la position de debut à la position de fin avec la couleur 
		 * du navire.
		 */


		// À vous de jouer
        
        	for(Navire nav : flotte.Navirelist) 
        	{
        		if(nav.debut.ligne==nav.fin.ligne) 
            	{
            		System.out.println("SAME LIGNE ");
            		
            		for(int i=nav.debut.colonne;i<=nav.fin.colonne;i++) 
            		{
            			Coord temp = new Coord(nav.debut.ligne,i);
            			//System.out.println("LES COORDONNES SONT : " + temp.toString());
            			gui.setCouleurFond(temp,nav.couleur);
            			
            		}
            		
            	}
            	
            	else if(nav.debut.colonne==nav.fin.colonne) 
            	{
                        System.out.println("SAME COLONNE ");
            		
            		for(int i=nav.debut.ligne;i<=nav.fin.ligne;i++) 
            		{
            			Coord temp = new Coord(i,nav.debut.colonne);
            			//System.out.println("LES COORDONNES SONT : " + temp.toString());
            			gui.setCouleurFond(temp,nav.couleur);
            			
            		}
            		
            	}
        		
        	}

        	
	  }
        
   
        /*
    	 * Fonction qui permet d'afficher un navire et ensuite qui colorie chaque case du navire de debut a la fin
    	 * Auteur : Youcef mekki daouadji
    	 * 
    	 * 
    	 * */
        //Tester montrer navire 
        public static void montrerNavire(Navire navire, GrilleGui gui)
        {
        	if(navire.debut.ligne==navire.fin.ligne) 
        	{
        		System.out.println("SAME LIGNE ");
        		
        		for(int i=navire.debut.colonne;i<=navire.fin.colonne;i++) 
        		{
        			System.out.print(i);
        			Coord temp = new Coord(navire.debut.ligne,i);
        			System.out.println("LES COORDONNES SONT : " + temp.toString());
        			gui.setCouleurFond(temp,navire.couleur);
        			
        		}
        		
        	}
        	
        	else if(navire.debut.colonne==navire.fin.colonne) 
        	{
                    System.out.println("SAME COLONNE ");
        		
        		for(int i=navire.debut.ligne;i<=navire.fin.ligne;i++) 
        		{
        			Coord temp = new Coord(i,navire.debut.colonne);
        			System.out.println("LES COORDONNES SONT : " + temp.toString());
        			gui.setCouleurFond(temp,navire.couleur);
        			
        		}
        		
        	}
        	
    	}


        
        
        

	/**
	 * Procédure pour changer la valeur d'une case du gui.
	 * 
	 * @param gui
	 * @param coord
	 * @param valeur
	 */
	public static void afficherTir(GrilleGui gui, Coord coord){
		
		gui.setValeur(coord, Constantes.TOUCHE);
	}
	
	/**
	 * Sert  à colorier la case où le tir a touché
	 * @param tir
	 * @param gui
	 */
	public static void afficherNavireTouche(GrilleGui gui, Coord tir){
		
		UtilitaireGrilleGui.setCouleurFondCase(gui, tir,java.awt.Color.RED);
	}
	
	/**
	 * Procédure privée pour réinitialiser le gui et changer la couleur de 
	 * toute une ligne.
	 * 
	 * @param gui
	 * @param ligne
	 * @param couleur
	 */
     private static void changerCouleurFondLigne(GrilleGui gui, 
    		                                     int ligne, 
    		                                     Color couleur){

    	 /**
    	  * Stratégie : On utilise for pour parcourir toutes les colonnes
    	  *  (puisqu'on connait le nombre)             
    	  */
    	 
    	 //Nécessaire à l'appel de gui.setCouleurFond
		Coord coord = new Coord(0,0);

		for(int j = 0; j < gui.getNbColonnes(); j++){
			
			coord.ligne =ligne;
			coord.colonne = j;
			gui.setCouleurFond(coord, couleur);
		}

	}
	
	/**
	 * Change la couleur de fond d'une case du gui
	 * 
	 * @param gui
	 * @param coord La coordonnée de la case à modifier.
	 * @param couleur
	 */
	public static void setCouleurFondCase(GrilleGui gui, 
			                              Coord coord,	
			                              Color couleur){
		
		  gui.setCouleurFond(coord, couleur);
	}

	/**
	 * Remet le texte du gui dans leurs conditions initiales Constantes.VIDE
	 * dans chaque case.
	 * 
	 * @param gui
	 */
	private static void viderCases(GrilleGui gui, int i){
		
		/**
		 * Stratégie : On utilise for pour parcourir toutes les colonnes
		 *  (puisqu'on connait le nombre)             
		 */
		
		 //Nécessaire à l'appel de gui.setValeur
		Coord c = new Coord(0,0);

		for(int j = 0; j < gui.getNbColonnes(); j++){
			
			c.ligne = i;
			c.colonne = j;
			gui.setValeur(c, Constantes.VIDE_GUI);
		}
	}	
	
	/**
	 * Remet les couleurs du gui à Constantes.COULEUR_FOND
	 * 
	 * @param gui
	 */
	public static void reinitialiserGui(GrilleGui gui){
		

		// On utilise les SP prévus à cet effet.
		for(int i = 0; i < gui.getNbLignes(); i++){
			changerCouleurFondLigne(gui,i,Constantes.COULEUR_FOND);
			viderCases(gui,i);
		}
	}
	
}