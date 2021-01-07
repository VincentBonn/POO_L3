package Exo2;
import java.util.ArrayList;

public class WordManager
{
	/**
	 * Function that create a list of Word from a list of object.
	 * @param filePath -- path of the file that contains the word
	 * @return return a list of word from the file.
	 */
	public static ArrayList<Word> buildWordArrayListFromFilePath(String filePath)
	{
		ArrayList<Word> tempWordArrayList = new ArrayList<Word>();
		ArrayList<String> tempStringArrayList = MyFileReader.loadStringFromFilePath(filePath);
		for(String str: tempStringArrayList)
		{
			tempWordArrayList.add(new Word(str));
		}
		return tempWordArrayList;
	}
	/**
	 * Function that create an ArrayList that contains all the anagram
	 * @param wordArray -- the ArrayList of all the word who will be checked
	 */
	public static ArrayList<ArrayList<Word>> anagramArrayListBuilder(ArrayList<Word> wordArray)
	{
		ArrayList<ArrayList<Word>> tempAnagramArrayList = new ArrayList<ArrayList<Word>>();
		for(Word wrd : wordArray)
		{
			String val = wrd.getSortedWord();
			boolean found = false;
			int counter = tempAnagramArrayList.size();
			while(counter >= 1)
			{
				if(val.contentEquals(tempAnagramArrayList.get(counter-1).get(0).getSortedWord()))
				{
					tempAnagramArrayList.get(counter-1).add(wrd);
					counter = 0;
					found = true;
				}
				else
				{
					counter -= 1;
				}
			}
			if(found == false)
			{
				ArrayList<Word> newRowOfAnagram = new ArrayList<Word>();
				newRowOfAnagram.add(wrd);
				tempAnagramArrayList.add(newRowOfAnagram);
			}
		}
		return tempAnagramArrayList ;
	}
	/**
	 * Function that print all the set of n+ anagram
	 * @param anagramArray -- the ArrayList of all the anagram
	 * @param numberOfAnagram -- the minimum of anagram required to print a row
	 */
	public static void anagramArrayPrinter(ArrayList<ArrayList<Word>> anagramArray, int numberOfAnagram)
	{
		for(ArrayList<Word> wordArray : anagramArray)
		{
			if(wordArray.size() >= numberOfAnagram)
			{
				int length = wordArray.size();
				String tempString = length + ": [";
				for(int i=0; i<length; i++)
				{
					tempString += wordArray.get(i).getWord();
					if(i != length-1)
					{
						tempString += ",";
					}
				}
				tempString += "]";
				System.out.print("\n"+ tempString);
			}

		}
	}
}
