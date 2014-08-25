import java.lang.String;
import java.lang.StringBuilder;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver{

	public Driver()
	{
	}
	public static void main(String[] args)
	{
		System.out.println("This is the main");
		Trie trie = new Trie();
		addWords(args[0], trie);
	//find all words beginning is the letter 'm'
	        System.out.println(trie.getWords("m"));
		char[] word = {'a','n','z','p','p','l','e'};
		System.out.println("Trie: "+trie.toString());
		isWords(trie);
	//	addSpaces addSpace = new addSpaces(trie,word);		
	//	System.out.println("old word: anzpple\nNew Word: "+addSpace.addSpace());
	}
	public static void isWords(Trie trie )
	{

		System.out.println("'me' is in the trie: "+trie.isWord("me"));
		System.out.println("'Me' is in the trie: "+trie.isWord("Me"));
		System.out.println("'e' is in the trie: "+trie.isWord("e"));
		System.out.println("'a' is in the trie: "+trie.isWord("e"));
		System.out.println("'an' is in the trie: "+trie.isWord("an"));
		System.out.println("'anzpple' is in the trie: "+trie.isWord("anzpple"));
	/*	System.out.println("'z' is in the trie: "+trie.isWord("z"));
		System.out.println("'because' is in the trie: "+trie.isWord("because"));
		System.out.println("'anapple' is in the trie: "+trie.isWord("anapple"));
		System.out.println("'a' is in the trie: "+trie.isWord("a"));
		System.out.println("'an' is in the trie: "+trie.isWord("an"));
		System.out.println("'appl' is in the trie: "+trie.isWord("appl"));
		System.out.println("'pple' is in the trie: "+trie.isWord("pple"));
		System.out.println("'apple' is in the trie: "+trie.isWord("apple"));
		System.out.println("'Apple' is in the trie: "+trie.isWord("Apple"));
	*/
	}	
	public static void addWords(String fileName, Trie trie)
	{
	
		try{
			File file = new File(fileName);
			Scanner scan = new Scanner(file);
			System.out.println("Reading from " + fileName); 
			while(scan.hasNext())
			{
				String word = scan.next();
				if(!trie.addWord(word))	
				{
					System.err.println("An error occurred with "+word+".");
					break;
				}
				else
				{
					System.out.println("Added "+word);
				}
			}
		}
		catch( Exception e)
		{
			System.err.println(e.getCause());
			e.printStackTrace();	
		}
		System.out.println("All words added");
	}	

}
