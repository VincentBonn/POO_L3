import java.util.ArrayList;

import Exo1.*;
import Exo2.*;
import Exo3.*;
import Exo4.*;

public class main
{
	
	final static String filepath = "C:\\Users\\Vincent Bonnemayre\\Projet_UI\\TP2 JAVA L3S1\\src\\dictionary.txt";
	
	public static void main(String[] args)
	{
		//testExo1();
		//testExo2();
		//testExo3();
		testExo4(args);
	}
	public static void testExo1()
	{
		Integer i = 2;
		String str = new String("AAAAAAH");
		GeneriqueClass<Integer,String> generiquepair = new GeneriqueClass<Integer, String>(i,str);
		System.out.print("Premier objet de classe:    "+ generiquepair.getFirst().getClass() +" || Valeur : "+ generiquepair.getFirst().toString());
		System.out.print("\nSecond objet de classe:    "+ generiquepair.getSecond().getClass()+" || Valeur : "+ generiquepair.getSecond().toString());
		Integer i2 = 4;
		String str2 = new String("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAH");
		generiquepair.setFirst(i2);
		generiquepair.setSecond(str2);
		System.out.print("\n\nPremier objet de classe:    "+ generiquepair.getFirst().getClass() +" || Valeur : "+ generiquepair.getFirst().toString());
		System.out.print("\nSecond objet de classe:    "+ generiquepair.getSecond().getClass()+" || Valeur : "+ generiquepair.getSecond().toString());
	}
	public static void testExo2()
	{

		ArrayList<Word> wordArray = WordManager.buildWordArrayListFromFilePath(filepath);
		ArrayList<ArrayList<Word>> anagramArray = WordManager.anagramArrayListBuilder(wordArray);
		WordManager.anagramArrayPrinter(anagramArray, 10);
	}
	public static void testExo3()
	{
		//Part 1
		MyCollectionPart1 myCollection1 = new MyCollectionPart1(25);
		System.out.print(myCollection1.toString());
		myCollection1.sortCollection();
		System.out.print("\n"+myCollection1.toString());
		
		//Part 2
		MyCollectionPart2 myCollection2 = new MyCollectionPart2(800);
		System.out.print("\n"+myCollection2.toString());
	}
	public static void testExo4(String[] args)
	{
		if(!(args.length == 0))
		{
			System.out.print("\nIl y a "+args.length+" arguments");
			String validity = WordBisSorter.validity(args[0]);
			System.out.print("\nLe mode choisi est "+validity+":\n");
			if(validity.contentEquals("militaire"))
			{
				WordBisSorter.militaireSortAndPrint(args);
			}
			else if (validity.contentEquals("lexicographique"))
			{
				WordBisSorter.lexicographiqueSortAndPrint(args);
			}
			else if (validity.contentEquals("inverse"))
			{
				WordBisSorter.inverseSortAndPrint(args);
			}
		}
		else
		{
			System.out.print("\nAucun argument n'a été entré en paramètre");
		}
	}

}
