package Exo3;

import java.util.Random;
import java.util.TreeSet;

public class MyCollectionPart2
{
	private static final int MAXVALUE = 1000;
	private static Random r = new Random();
	private java.util.TreeSet<Integer> myCollection;
	private int numberOfValue;
	private int counterOfFailure = 0;

	public MyCollectionPart2(int n)
	{
		myCollection = new TreeSet<Integer>();
		numberOfValue = n;
		fulFill(numberOfValue);
	}
	
	private void fulFill(int n)
	{
		int lastVal = 0;
		while(myCollection.size()<n)
		{
			n--;
			myCollection.add(r.nextInt(MyCollectionPart2.MAXVALUE));
			if(lastVal == myCollection.size())
			{
				counterOfFailure++;
			}
			lastVal = myCollection.size();
		}
	}
	public void setCollection(java.util.TreeSet<Integer> collection)
	{
		myCollection = collection;
		
	}
	public java.util.TreeSet<Integer> getCollection()
	{
		return myCollection;
		
	}
	public String toString()
	{
		String str =  "Number of values: " + numberOfValue +", "+counterOfFailure+" Double have been detected while creating the Set.\nValues pool :";
		for(Integer x:myCollection)
		{
			str += "  "+x;
		}
		return str;
	}
	
}