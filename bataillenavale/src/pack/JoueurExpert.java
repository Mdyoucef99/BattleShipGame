import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class JoueurExpert {

    public Vector TableauCoups;

    

    boolean premierdiagonale = true;

    boolean deuxiemediagonale = false;
    boolean premiereLigne = false;
    boolean deuxiemeLigne = false;
    boolean troisiemeLigne = false;
    boolean quatriemeLigne = false;
    

   

    public List<Coord> Adjacent;

    Coord cDiag = new Coord(-1,-1);

   

   

    public JoueurExpert()

    {

                    TableauCoups= new Vector();

                    Adjacent = new ArrayList<Coord>();

    }



   

    public Coord getTir()

    {

                    Coord coord = new Coord(0,0);

                    int index=0;

                   

                   // UtilitaireGrilleGui.pause(1000);
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
                                         

                                                   
                                                       Coord temp= new Coord(cDiag.ligne, cDiag.colonne);
                                                       if(!UtilitaireCollection.tableauContientCoord(TableauCoups, temp)) {


                                                    	   TableauCoups.add(temp);
                                                    	   System.out.println("pas de rep");

                                                    
                                                       }



                                                       
                                            

                                                    if(cDiag.ligne == Constantes.TAILLE)

                                                    {

                                                                    premierdiagonale =false;

                                                                    deuxiemediagonale=true;

                                                                    //début de la deuxième diagonal

                                                                    cDiag = new Coord(-1,10);

                                                    }


                                        
                                    }

                                    if(deuxiemediagonale == true)

                                    {             


                                    	boolean touche1 = false;
                                        Coord temp2= new Coord(cDiag.ligne, cDiag.colonne);
                                        if(!UtilitaireCollection.tableauContientCoord(TableauCoups, temp2)) {

                                        	touche1 = true;
                                     	   System.out.println("pas de repetition");
                                     	  TableauCoups.add(temp2);
                                        }



                                                    cDiag.ligne =cDiag.ligne+1;

                                                    cDiag.colonne=cDiag.colonne-1;




                                                    System.out.println(cDiag.toString());      

                                                   

                                                    if(cDiag.ligne == Constantes.TAILLE) {

                                                                    deuxiemediagonale=false;
                                                                    premiereLigne = true;
                                                                    cDiag = new Coord(0,0);

                                                    }

                                    }

                                   

                                   

                                    if(premiereLigne == true)
                                 
                                    {
                                    	cDiag.ligne = cDiag.ligne +1;


                                    	boolean touche2 =false;
                                        Coord temp3= new Coord(cDiag.ligne, cDiag.colonne);
                                        if(!UtilitaireCollection.tableauContientCoord(TableauCoups, temp3)) {

                                        	touche2 = true;
                                     	   System.out.println("pas de repetition");
                                     	  TableauCoups.add(temp3);                        
                                          if(cDiag.ligne == Constantes.TAILLE) {

     
                                              premiereLigne = false;
                                              deuxiemeLigne = true;
                                              cDiag = new Coord(9,0);

                              }}
                                        
                                    }
                                    if(deuxiemeLigne == true)
                                        
                                    {
                                    	cDiag.colonne = cDiag.colonne +1;


                                    	boolean touche3 =false;
                                        Coord temp4= new Coord(cDiag.ligne, cDiag.colonne);
                                        if(!UtilitaireCollection.tableauContientCoord(TableauCoups, temp4)) {

                                        	touche3 = true;
                                     	   System.out.println("pas de repetition");
                                     	  TableauCoups.add(temp4);                        
                                          if(cDiag.colonne == Constantes.TAILLE) {

     
                                           
                                              deuxiemeLigne = false;
                                              troisiemeLigne = true;
                                              cDiag = new Coord(9,9);
                                              

                              }}
                                        
                                    }
                                    if(troisiemeLigne == true)
                                        
                                    {
                                    	cDiag.ligne = cDiag.ligne -1;


                                    	boolean touche2 =false;
                                        Coord temp3= new Coord(cDiag.ligne, cDiag.colonne);
                                        if(!UtilitaireCollection.tableauContientCoord(TableauCoups, temp3)) {

                                        	touche2 = true;
                                     	   System.out.println("pas de repetition");
                                     	  TableauCoups.add(temp3);                        
                                          if(cDiag.ligne == 0) {

     

                                              troisiemeLigne = false;
                                              quatriemeLigne = true;
                                              cDiag = new Coord(0,9);
                                              

                              }}
                                        
                                        
                                    }
                                    if(quatriemeLigne == true)
                                        
                                    {
                                    	cDiag.colonne = cDiag.colonne -1;


                                    	boolean touche2 =false;
                                        Coord temp3= new Coord(cDiag.ligne, cDiag.colonne);
                                        if(!UtilitaireCollection.tableauContientCoord(TableauCoups, temp3)) {

                                        	touche2 = true;
                         
                                     	  TableauCoups.add(temp3);                        
                                          if(cDiag.colonne == 0) {

     

                         
                                              quatriemeLigne = false;
                                           
                                              

                              }}
                                        
                                        
                                    }
                                    if(premierdiagonale==false && deuxiemediagonale ==false && premiereLigne ==false
                                    		&& deuxiemeLigne == false && troisiemeLigne == false && quatriemeLigne== false)

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
