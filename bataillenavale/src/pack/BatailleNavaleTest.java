package pack;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

class BatailleNavaleTest {

	
	@Test
	void test_dejaRecuTir() //test unitaire pour voir si le tir à déjà touché le navire @Youcef mekki daouadji
	{
		Coord debut = new Coord(2,1);
        Coord fin = new Coord(4,1);
		Navire test1 = new Navire("La perle noire",debut,fin,Color.BLACK);
		Coord tir = new Coord(3,1);
		assertEquals(false,test1.dejaRecuTir(tir));
		
	} 
	
	@Test
	void test_chevauche() //test unitaire pour voir si 2 bateaux ce chevauche @Youcef mekki daouadji
	{
		 Coord debut = new Coord(2,1);
         Coord fin = new Coord(6,1);
         Coord debut1 = new Coord(5,1);
         Coord fin2 = new Coord(7,1);
         
		Navire test1 = new Navire("La perle noire",debut,fin,Color.BLACK);
	    Navire test2 = new Navire("La perle noire",debut1,fin2,Color.BLACK);
		
	    assertEquals(true,test1.chevauche(test2));
		
	}
	
	@Test
	void test_estcoule() //Test unitaire pour voir si le navire est coulé @Youcef mekkid daouadji
	{
		 Coord debut = new Coord(2,1);
         Coord fin = new Coord(4,1);
         Coord millieu = new Coord(3,1);
         Navire test1 = new Navire("La perle noire",debut,fin,Color.BLACK);
         
         test1.list.add(debut);
         test1.list.add(fin);
         test1.list.add(millieu);
         assertEquals(true,test1.estCoule());
         
	
	}
	
	@Test
	void test_tiratouche() //Test pour voir si la coord donné touche le navire sans le repéter @Youcef mekki daouadji
	{
		
		Coord debut = new Coord(2,1);
        Coord fin = new Coord(4,1);
		Navire test1 = new Navire("La perle noire",debut,fin,Color.BLACK);
	    Coord tir = new Coord(2,1);
	    Coord tir2 = new Coord(2,1);
	    test1.list.add(tir);
		assertEquals(true,test1.tirAtouche(tir2));
		
	}
	
	
	
	
	@Test
	void test_tiratoucheFlotte() //test unitaire pour voir si le tir a touche un tavire de la flotte @Youcef mekki daouadji
	{
		Coord debut = new Coord(2,1);
        Coord fin = new Coord(4,1);
		Navire test1 = new Navire("La perle noire",debut,fin,Color.BLACK);
		Flotte flotte =  new Flotte();
		Coord tir = new Coord(2,1);
		flotte.Navirelist.add(test1);
		assertEquals(true,test1.tirAtouche(tir));
		
	}
	
	
	
	@Test
	void test_GetTabNavire()  //test unitaire qui pour retourner le tableau de navire  @Youcef mekki daouadji
	{
		Coord debut = new Coord(2,1);
        Coord fin = new Coord(4,1);
		Navire test1 = new Navire("La perle noire",debut,fin,Color.BLACK);
		Flotte flotte =  new Flotte();
		flotte.Navirelist.add(test1);
		Navire[] array = new Navire[1];
		array[0] = test1;
		Navire[] array2 = flotte.getTabNavires();
		
		assertEquals(array[0].nom,array2[5].nom);
		
	}
	


}
