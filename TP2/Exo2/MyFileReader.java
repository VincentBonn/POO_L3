package Exo2;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MyFileReader
{
	/**
	 * Function that read a txt file and search for word.
	 * @param filePath -- full path of the text file.
	 * @return an ArrayList of string.
	 */
	public static ArrayList<String> loadStringFromFilePath(String filePath)
	{
		ArrayList<String> tempList = new ArrayList<String>();
		try (FileReader reader = new FileReader(filePath))
		{
			int character;
			String temp = "";
			while ((character = reader.read()) != -1)
			{
				if((char) character !=  " ".charAt(0))
				{
					if(character != 13 && character != 10)
					{
						temp += (char) character;
					}
					else
					{
						if(!temp.isEmpty())
						{
							tempList.add(temp);
						}
						temp = "";
					}
				}
			}
			if(!temp.isEmpty())
			{
				tempList.add(temp);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return tempList;
	}

}
