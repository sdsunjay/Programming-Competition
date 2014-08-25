import java.lang.*;
import java.util.*;
import java.lang.StringBuffer;
public class addSpaces{

	
	private Trie trie;
	private char[] words;
	private char[] retString;
	public addSpaces(Trie trie, char[] words)
	{
		this.trie = trie;
		this.words = words;
		retString = new char[1000];
	}
	
	public String addSpace()
	{
		String temp = new String(words);
		int i = 0;
		int start = 0;
		boolean flag;
		flag = false;
		System.out.println("String is: "+temp);	
		while(i < temp.length())
		{
			int j = 0;
			while(j<(temp.length()-i))
			{
				String s = temp.substring(i,temp.length()-j);
				if(trie.isWord(s))
				{
					System.out.println("Substring being added is: "+s);
					start=addToFinalString(start,s,temp);
					flag = true;
					break;
				}
				j++;
			}
			//i = temp.length()-j;
			if(flag == true)
				i = temp.length()-j;
			else
			{	
				i++;
			}
			flag = false;
		}
		return new String(retString);
	}
	public int addToFinalString(int start, String subString, String temp)
	{
		int i;
		for(i = 0; i < subString.length(); i++)
		{
			//System.out.println(subString.charAt(i)); 
			
			retString[start] = subString.charAt(i);
			start++;
		}
			retString[start] = ' ';	
		start++;
		return start;
		
	}
	public String putCharsTogether(char[] word, int start, int end)
	{
		StringBuffer str = new StringBuffer(10);
		for(int i = start; i < end; i++)
		{
			str.append(word[i]);
		}
		return new String("");
	}
}
