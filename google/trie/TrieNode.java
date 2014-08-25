import java.util.ArrayList;
import java.util.List;

public class TrieNode
{
	private TrieNode parent;
	private TrieNode[] children;
	private boolean isLeaf;		//Quick way to check if any children exist
	private boolean isWord;		//Does this node represent the last character of a word
	private char character;		//The character this node represents	

	/*
	* Constructor for the top level root node.
	*/


	public TrieNode()
	{
		children = new TrieNode[26];
		isLeaf = true;
		isWord = false;
	}
	
	/*
	* Constructor for the child node.
	*/
	public TrieNode(char character)
	{
		this();
		this.character = character;
	}
	/**
	* Adds a word to this node. This method is called recursively and adds child nodes for each successive letter in the word, therefore recursive calls will be made with partial word.s
	* @param word - the word to add.
	*
	*/
	protected void addWord(String word)
	{
		isLeaf = false;
		int charPos = word.charAt(0) - 'a';
		if (children[charPos] == null)
		{
			children[charPos] = new TrieNode(word.charAt(0));
			children[charPos].parent = this;
		}
		if (word.length() > 1 )
		{
			//call addWord on the word, minus the first character
			//which is why we need a minimum of two characters
			children[charPos].addWord(word.substring(1));
		}
		else
		{
			//System.out.println("character at "+ charPos+" got set to true for being a word");
			System.out.println(word + " is a word.");  
			children[charPos].isWord = true;
		}
		
	}
	/**
	* Returns the child TrieNode representing the given char,
	* or null if no node exists.
	* @param c
	* @return TrieNode for the given character.
	*/
	protected TrieNode getNode(char c) throws Exception
	{
		if( (c - 'a') < 0)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		else
		{
			return children[c - 'a'];
		}
	}
	
	/**
	* Returns a List of String object which are lower in the 
	* hierarchy than this node.
	* @return the list of Strings below this node in the tree.
	*/
	protected List getWords()
	{
		//Create a list to return.
		List retList = new ArrayList();
		
		//if this node represents a word, add it
		if (isWord)
		{
			retList.add(toString());
		}
		
		//If the node has any children
		if (!isLeaf)
		{
			//Add any words belonging to any children
			for (int i = 0; i < children.length; i++)
			{
				if (children[i] != null)
				{
					retList.addAll(children[i].getWords());
				}
			}
		}
	return retList;
	}
	
	/**
	* Get the String that this node represents.
	*
	* For example, if this node represents the character t, 
	* whose parent represents the character a,
	* whose parent represents the character c,
	* then the String would be "cat".
	* @return The word this node presents.
	*/ 	
	public String toString()
	{
		if (parent == null)
		{
			return "";
		}
		else
		{
			return parent.toString() + new String(new char[] {character});
		}
	}
	/** this method is fucked **/
	protected boolean isWord(String word)
	{
	
		int charPos = word.charAt(0) - 'a';
		boolean flag = false;
		if (children[charPos] == null)
		{
			return false;
		}
		else if (word.length() > 1 )
		{
			System.out.println("Checking " +word.substring(1));
			//call addWord on the word, minus the first character
			//which is why we need a minimum of two characters
			return children[charPos].isWord(word.substring(1));
		}
		return isWord;
	}
}	
