package Exo3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MyCollectionPart1
{
	private static final int MAXVALUE = 1000;
	private static Random r = new Random();
	private java.util.List<Integer> myCollection;
	private int numberOfValue;

	public MyCollectionPart1(int n)
	{
		myCollection = new ArrayList<Integer>();
		numberOfValue = n;
		fulFill(numberOfValue);
	}
	
	private void fulFill(int n)
	{
		while(n>0)
		{
			n--;
			myCollection.add(r.nextInt(MyCollectionPart1.MAXVALUE));
		}
	}
	public void sortCollection()
	{
		Collections.sort(myCollection);
	}
	public void setCollection(java.util.List<Integer> collection)
	{
		myCollection = collection;
		
	}
	public java.util.List<Integer> getCollection()
	{
		return myCollection;
		
	}
	public String toString()
	{
		String str =  "Number of values: " + numberOfValue +"\nValues pool :";
		for(Integer x:myCollection)
		{
			str += "  "+x;
		}
		return str;
	}
	
}
