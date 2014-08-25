import java.util.List;
import java.util.ArrayList;
public class Trie
{
 	private TrieNode root;
	public Trie()
	{
		root = new TrieNode();
	}
	public String toString()
	{
		return root.getWords().toString();
	}
	public boolean addWord(String word)
	{
		//check is word is only made up of letter
		boolean hasNonAlpha = word.matches("^.*[^a-zA-Z].*$");	
		if(!hasNonAlpha)
		{
			if(!word.isEmpty())
			{
				root.addWord(word.toLowerCase());
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	/*
	* Get the words in the Trie with the given prefix
	* @param prefix
	* @return a List containing String objects, which contain the words in the Trie with the given prefix
	*/
	public List<String> getWords(String prefix)
	{
		prefix = new String(prefix.toLowerCase());
		// Find the node which represents the last letter of the prefix
		TrieNode lastNode = root;
		try
		{
		for(int i = 0; i < prefix.length(); i++)
		{
		
			lastNode = lastNode.getNode(prefix.charAt(i));
			if (lastNode == null)
			{
				return new ArrayList<String>();
			}
			
			return lastNode.getWords();
		}
		}
		catch(Exception e)
		{
			return new ArrayList<String>();
		}
			return lastNode.getWords();
	}
/*
	public boolean isWord(String word)
	{
		if(word.equals("an"))
			return true;
		else if(word.equals("apple"))
			return true;
		return false;
	}
*/
	/*
	* Determine is a given set of characters is a word or not in the Trie.
	* @param word - the String for which we are trying to determine exists or not.
	* @return true - if the word exists, other false.
	*/
	public boolean isWord(String word)
	{
		word = new String(word.toLowerCase());
		return root.isWord(word);
	}
}
