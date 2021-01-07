package Exo2;

import java.util.Arrays;

public class Word{
	private String word;
	private String sortedWord;
	/**
	 * Constructor of word
	 * @param word -- word that will be stored (string)
	 */
	public Word(String word)
	{
		this.word = word;
		sortWord();
	}
	/**
	 * Function that sort Word letter by letter and store in SortedWord
	 */
	private void sortWord()
	{
		char temp[] = word.toCharArray();
		Arrays.sort(temp);
		sortedWord = new String(temp);
	}
	/**
	 * Getter of SortedWord
	 * @return SortedWord
	 */
	public String getSortedWord()
	{
		return sortedWord;
	}
	/**
	 * Getter of Word
	 * @return Word
	 */
	public String getWord()
	{
		return word;
	}
	/**
	 * Function that return word and sortedWord under a sentence
	 * @return a sentence (String) that give word and sortedWord
	 */
	public String toString()
	{
		return word + " Sorted : " + sortedWord;
	}
}
