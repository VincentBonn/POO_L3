package main;

import exercice1.*;
import exercice2.*;

public class Main {

	public static void main(String[] args) 
	{
		//Affiche l'Exercice 1
		exercice1();
		exercice2TestCiterne();
		exercice2TestCiterneSecurisee();
		
	}
	/**
	 * Execute plusieurs fois la fonction de test testEgaliteExercice1
	 */
	public static void exercice1() 
	{
		int[] val1 = new int[] {1,2,3,4};
		int[] val2 = new int[] {1,2,3,4};
		int[] val3 = new int[] {1,2,3,5};
		int[] val4 = new int[] {1,2,3,3};
		MonTableau tab1 = new MonTableau(val1);
		MonTableau tab2 = new MonTableau(val2);
		MonTableau tab3 = new MonTableau(val3);
		MonTableau tab4 = new MonTableau(val4);
		MonTableau tab5 = null;
		//Print 0
		testEgaliteExercice1(tab1,tab2);
		//Print -1
		testEgaliteExercice1(tab1,tab3);
		//Print 1
		testEgaliteExercice1(tab1,tab4);
		//Print "NullPointerException"
		testEgaliteExercice1(tab1,tab5);
	}
	/**
	 * Test pour la fonction EstComparable de la classe MonTableau
	 */
	public static void testEgaliteExercice1(MonTableau tab1,MonTableau tab2)
	{
		try
		{
			int val = tab1.compareA(tab2);
			System.out.print("\nResultat de la comparaison : "+val);
		}
		catch (NullPointerException e)
		{
			System.out.print("\n\nNull Pointer Exception found\n\n");
		}
		catch (IllegalArgumentException e)
		{
			System.out.print("\n\nIllegal Argument Exception found\n\n");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void exercice2TestCiterne()
	{
		Citerne c1 = creationCiterne(1000);
		Citerne c2 = creationCiterne(1000);
		System.out.print(c1.toString()+"\n");
		remplirCiterne(c1,Liquid.Eau,100);
		assert(c1.getActualLiquid() == Liquid.Eau && c1.getVolumeActuel() == 100):"C1 est une cuve à eau, remplie de 100 m3";
		assert(c1.getIsClean() == false):"La cuve est sale car elle vient d'être remplie";
		remplirCiterne(c1,Liquid.Vin,100);
		assert(c1.getActualLiquid() == Liquid.Eau && c1.getVolumeActuel() == 100):"C1 est une cuve à eau, remplie de 100 m3, car on n'a pas pu rajouter el vin";
		remplirCiterne(c1,Liquid.Eau,1000);
		assert(c1.getActualLiquid() == Liquid.Eau && c1.getVolumeActuel() == 100):"C1 est une cuve à eau, remplie de 100 m3 car elle n'a pas pu recevoir 1000m3 supplémentaire";
		viderCiterne(c1,1000);
		assert(c1.getActualLiquid() == Liquid.Eau && c1.getVolumeActuel() == 0):"C1 est une cuve à eau, vide";
		remplirCiterne(c1,Liquid.Eau,100);
		assert(c1.getActualLiquid() == Liquid.Eau && c1.getVolumeActuel() == 100):"C1 est une cuve à eau, remplie de 100 m3";
		remplirCiterne(c2,Liquid.Eau,100);
		assert(c2.getActualLiquid() == Liquid.Eau && c2.getVolumeActuel() == 100):"C2 est une cuve à eau, remplie de 100 m3";
		
		assert(c1.getActualLiquid() == c2.getActualLiquid()):"Les deux citernes ont le même liquide";
		assert(c1.getDateCreation().getYear() == c2.getDateCreation().getYear()):"Les deux citernes ont la même année de création";
		assert(c1.getDateCreation().getDayOfYear() == c2.getDateCreation().getDayOfYear()):"Les deux citernes ont le même jour de l'année de création";
		assert(c1.equals(c2)):"Le test d'égalité entre citerne entre c1 et c2 est  vrai";
		

	}
	public static void exercice2TestCiterneSecurisee()
	{
		Citerne tp = new Citerne(1000);
		remplirCiterne(tp,Liquid.Eau,0);
		assert(tp.getActualLiquid() == Liquid.Eau):"On assigne l'eau à la citerne de trop plein";
		CiterneSecurisee C4 = new CiterneSecurisee(1000,tp);
		remplirCiterne(C4,Liquid.Eau,2001);
		assert(C4.getVolumeActuel() + C4.getCiterneSecondaire().getVolumeActuel() == 0):"On vérifie que l'on a bien évité le remplissage en cas de trop grandes quantités";
		System.out.print("\n"+C4.toString()+"\n");
		remplirCiterne(C4,Liquid.Eau,2000);
		System.out.print("\n"+C4.toString()+"\n");
	}
	public static Citerne creationCiterne(int val) 
	{
		Citerne o = null;
		try
		{
			o = new Citerne(val);
		}	
		catch (IllegalArgumentException e) 
		{
			System.out.print("\nUne exception de type IllegalArgumentException a été detectée :\n\n");
			System.out.print(e.getMessage()+"\n\n");
		}
		catch (NullPointerException e) 
		{
			System.out.print("\nUne exception de type NullPointerException a été detectée :\n\n");
			System.out.print(e.getMessage()+"\n\n");
		}
		return o;
	}
	public static void remplirCiterne(Citerne c,Liquid liquid,int volume)
	{
		try
		{
			c.trySetLiquid(Liquid.Eau);
			c.ajouterLiquide(liquid, volume);
		}	
		catch (LogisticErrorException e) 
		{
			System.out.print("\nUne exception de type LogisticErrorException a été detectée :\n\n");
			System.out.print(e.getMessage()+"\n\n");
		}
		catch (IllegalArgumentException e) 
		{
			System.out.print("\nUne exception de type IllegalArgumentException a été detectée :\n\n");
			System.out.print(e.getMessage()+"\n\n");
		}
	}
	public static void viderCiterne(Citerne c,int volume)
	{
		try
		{
			c.enleverLiquide(volume);
		}	
		catch (LogisticErrorException e) 
		{
			System.out.print("\nUne exception de type LogisticErrorException a été detectée :\n\n");
			System.out.print(e.getMessage()+"\n\n");
		}
		catch (IllegalArgumentException e) 
		{
			System.out.print("\nUne exception de type IllegalArgumentException a été detectée :\n\n");
			System.out.print(e.getMessage()+"\n\n");
		}
	}
}
