package Exo4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WordBisSorter
{
	private final static List<String> validityList = Arrays.asList("militaire","lexicographique","inverse");
	public static String validity(String str)
	{
		String result ="Aucun mode valide choisi";
		if(validityList.contains(str))
		{
			result = str;
		}
		return result;
	}
	public static void militaireSortAndPrint(String[] args)
	{
		ArrayList<WordBis> temp = fillWithArg(args);
		List<ArrayList<WordBis>> splitArray = new ArrayList<ArrayList<WordBis>>();
		for(WordBis wrd:temp)
		{
			int length = wrd.getWord().length();
			boolean found = false;
			for(ArrayList<WordBis> wordArray:splitArray)
			{
				if(wordArray.get(0).getWord().length()==length)
				{
					found = true;
					wordArray.add(wrd);
				}
			}
			if(!found)
			{
				splitArray.add(new ArrayList<WordBis>());
				splitArray.get(splitArray.size()-1).add(wrd);
			}
		}
		for(ArrayList<WordBis> wordArray:splitArray)
		{
			printAll(sortArrayListWord(wordArray));
		}
	}
	public static void lexicographiqueSortAndPrint(String[] args)
	{
		ArrayList<WordBis> temp = sortArrayListWord(fillWithArg(args));
		printAll(temp);
	}
	public static void inverseSortAndPrint(String[] args)
	{
		ArrayList<WordBis> tempArray = sortArrayListWord(fillWithArg(args));
		Collections.reverse(tempArray);
		printAll(tempArray);
	}
	private static ArrayList<WordBis> fillWithArg(String[] args)
	{
		ArrayList<WordBis> tempArray = new ArrayList<WordBis>();
		if(args.length>2)
		{
			for(int i=1;i<args.length;i++)
			{
				tempArray.add(new WordBis(args[i]));
			}
		}
		return tempArray;
	}
	private static void printAll(ArrayList<WordBis> arrayList)
	{
		String tempStr = "";
		for(WordBis wrd : arrayList)
		{
			tempStr +=" "+wrd.getWord();
		}
		System.out.print(tempStr);
	}
	private static ArrayList<WordBis> sortArrayListWord(ArrayList<WordBis> temp)
	{
		int length = temp.size();
		for(int i=0;i<length;i++)
		{
			for(int j=0;j<length-1;j++)
			{
				int res = temp.get(j).compareTo(temp.get(j+1));
				if(res == -1)
				{
					WordBis temporary = new WordBis(temp.get(j));
					temp.set(j, temp.get(j+1));
					temp.set(j+1, temporary);
				}
			}
		}
		return temp;
	}
}
