package Exo4;


public class WordBis implements Comparable
{
	private String word;
	
	public WordBis(String word)
	{
		this.word = word;
	}
	public WordBis(WordBis w)
	{
		this(w.getWord());
	}
	
	@Override
	public int compareTo(Object o)
	{
		int result = -2;
		if(o != null && o instanceof WordBis)
		{
			WordBis temp = (WordBis) o;
			char[] list1 = this.word.toCharArray();
			char[] list2 = temp.getWord().toCharArray();
			int thisLength = word.length();
			int otherLength = temp.word.length();
			boolean checking = true;
			int counter = 0;
			while(counter < thisLength && counter < otherLength && checking)
			{
				if( (int) list1[counter] > (int) list2[counter])
				{
					checking = false;
					result = -1;
				}
				else if((int) list1[counter] < (int) list2[counter])
				{
					checking = false;
					result = 1;
				}
				else
				{
					result = 0;
				}
				counter++;
			}
			if(checking == true)
			{
				if(thisLength < otherLength)
				{
					result = 1;
				}
				if(thisLength == otherLength)
				{
					result = 0;
				}
				else
				{
					result = -1;
				}
			}
		}
		return result;
	}
	public String getWord()
	{
		return word;
	}
}
