package com.practise.datastructures.entities.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean endOfWord;
    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
        endOfWord = false;
    }
}
public class TrieImpl {

	    private final TrieNode root;
	    public TrieImpl() {
	        root = new TrieNode();
	    }

	    /**
	     * Iterative implementation of insert into trie
	     */
	    public void insert(String word) {
	        TrieNode current = root;
	        for (int i = 0; i < word.length(); i++) {
	            char ch = word.charAt(i);
	            TrieNode node = current.children.get(ch);
	            if (node == null) {
	                node = new TrieNode();
	                current.children.put(ch, node);
	            }
	            current = node;
	        }
	        //mark the current nodes endOfWord as true
	        current.endOfWord = true;
	    }

	    /**
	     * Recursive implementation of insert into trie
	     */
	    public void insertRecursive(String word) {
	        insertRecursive(root, word, 0);
	    }


	    private void insertRecursive(TrieNode current, String word, int index) {
	        if (index == word.length()) {
	            //if end of word is reached then mark endOfWord as true on current node
	            current.endOfWord = true;
	            return;
	        }
	        char ch = word.charAt(index);
	        TrieNode node = current.children.get(ch);

	        //if node does not exists in map then create one and put it into map
	        if (node == null) {
	            node = new TrieNode();
	            current.children.put(ch, node);
	        }
	        insertRecursive(node, word, index + 1);
	    }

	    /**
	     * Iterative implementation of search into trie.
	     */
	    public boolean search(String word) {
	        TrieNode current = root;
	        for (int i = 0; i < word.length(); i++) {
	            char ch = word.charAt(i);
	            TrieNode node = current.children.get(ch);
	            //if node does not exist for given char then return false
	            if (node == null) {
	                return false;
	            }
	            current = node;
	        }
	        //return true of current's endOfWord is true else return false.
	        return current.endOfWord;
	    }

	    /**
	     * Recursive implementation of search into trie.
	     */
	    public boolean searchRecursive(String word) {
	        return searchRecursive(root, word, 0);
	    }
	    private boolean searchRecursive(TrieNode current, String word, int index) {
	        if (index == word.length()) {
	            //return true of current's endOfWord is true else return false.
	            return current.endOfWord;
	        }
	        char ch = word.charAt(index);
	        TrieNode node = current.children.get(ch);
	        //if node does not exist for given char then return false
	        if (node == null) {
	            return false;
	        }
	        return searchRecursive(node, word, index + 1);
	    }

	    /**
	     * Delete word from trie.
	     */
	    public void delete(String word) {
	        delete(root, word, 0);
	    }

	    /**
	     * Returns true if parent should delete the mapping
	     */
	    private boolean delete(TrieNode current, String word, int index) {
	        if (index == word.length()) {
	            //when end of word is reached only delete if currrent.endOfWord is true.
	            if (!current.endOfWord) {
	                return false;
	            }
	            current.endOfWord = false;
	            //if current has no other mapping then return true
	            return current.children.size() == 0;
	        }
	        char ch = word.charAt(index);
	        TrieNode node = current.children.get(ch);
	        if (node == null) {
	            return false;
	        }
	        boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

	        //if true is returned then delete the mapping of character and trienode reference from map.
	        if (shouldDeleteCurrentNode) {
	            current.children.remove(ch);
	            //return true if no mappings are left in the map.
	            return current.children.size() == 0;
	        }
	        return false;
	    }
	    //building a compressed suffix trie
    	Map<List<Character>,Boolean> compressedSuffixTrie = new HashMap<List<Character>,Boolean>();
	    private void createCompressedTrie(String word){
	    	List<Character> suffixesList = new ArrayList<Character>(); 
	    	for (char c : word.toCharArray()){
	    		 suffixesList.add(c);
	    	}
	    	compressedSuffixTrie.put(suffixesList, Boolean.valueOf(true));
	    }
	    
	    public void isSuffix(String pattern){
	    	TrieNode current = root;
	    	for (char c : pattern.toCharArray()){
	    		TrieNode node = current.children.get(c);
	    		if ( null == node){
	    				System.out.println(" pattern is not a suffix of the given string");
	    				break;
	    		}
	    		current = node;
	    	}
	    	//is the end of character of pattern points to end of the trie branch
	    	System.out.println(current.endOfWord?"pattern is a suffix of the given string":"pattern is not a suffix of the given string");
	    }
	    public void countOccurrenceOfPattern(String pattern){
	    	int noOfOccurences = 0 ;
	    	//going till the end of the pattern and then counting the child nodes 
	    	// no of child nodes + 1 (length of full pattern)
	    	TrieNode current = root;
	    	boolean patternFound = true;
	    	for (char c : pattern.toCharArray()){
	    		 TrieNode node = current.children.get(c);
	    		 if ( null == node) {
	    			 patternFound = false;
	    			 break;
	    		 }
	    		 current = node;
	    	}
	    	if (patternFound){
	    		if (current.endOfWord == true) ++noOfOccurences;
	    		noOfOccurences+= current.children.size();
	    	}
	    	System.out.println( " No of occurrences of pattern " + pattern + " is " + noOfOccurences);
	    }
    	
	    //Find the deepest node that has at least 2 leaves under it.
	    public void findLongestRepeat(){
	    	// idea is to start from the deepest node 
	    	TrieNode currNode  = root;
	    	// getting the size of the underlying map  of the starting map characters
	    	char deepestNodeChar = ' ' ;
	    	int deepestNodeSize  = Integer.MIN_VALUE;
	    	for (Map.Entry<Character, TrieNode> e : root.children.entrySet()){
	    		  char c = e.getKey();
	    		  TrieNode node = root.children.get(c);
	    		  if (deepestNodeChar == ' '){
	    			  deepestNodeChar = c;
	    			  
	    		  }
	    		  else{
	    			  if ( root.children.size() > deepestNode.children.size())
	    				  deepestNode = node;
	    		  }
	    		  //start from root of deepest node till we find a break out of 2 leaves
	    			  
	    	}
	    }
	    //Find the lexicographically (alphabetically) first suffix:
	    public void lexicographicallyFirstSuffix(){
	    	//Start at the root, and follow the edge labeled with the
	    	//lexicographically (alphabetically) smallest letter.
	    	//sorting the root characters 
	    	Map<Character,TrieNode> rootMap = root.children;
	    	List<Map.Entry<Character, TrieNode>> list = new ArrayList<Map.Entry<Character, TrieNode>>(rootMap.entrySet());
	    	Collections.sort(list, new Comparator<Map.Entry<Character, TrieNode>>(){

				public int compare(Map.Entry<Character, TrieNode> o1, Map.Entry<Character, TrieNode> o2) {
					return o1.getKey().compareTo(o2.getKey());
				}
	    		
	    	});
	    	//picking up the sorted character
	    	Map.Entry<Character, TrieNode> e  = list.get(0);
	    	while (e.getValue() != null){
		    	System.out.println(e.getKey() + " ----> ");
		    	if (e.getValue().children.size() > 1){
		    			Map<Character,TrieNode> m = new TreeMap<Character, TrieNode>(e.getValue().children);
		    	}
	    	}
	    		
	    	
	    }
	    
	    //LCS : between two strings
	    public void longestCommonSubstring(String str1 , String str2){
	    	
	    }
	    public static void main(String args[]){
	    	//insert a phrase into trie.
	    	TrieImpl trie = new TrieImpl();
	    	System.out.println("  Building a Suffie Trie of the word " + "SAMRAT");
	    	String str = "SAMRAT";
	    	for (int i = 0 ; i < str.length() ;i++)
	    				trie.insert(str.substring(i));
	    	System.out.println(trie.root);
	    	//pattern matching
	    	System.out.println(" Find the given pattern in the above suffix tree");
	    	String pattern = "MOM";
	    	trie.search(pattern);
	    	System.out.println(" Checking where pattern "+ pattern + " is a suffix of a  String ");
	    	trie.isSuffix(pattern);
	    	System.out.println("Count occurrences of pattern " + pattern + " in suffix trie of String");
	    	trie.countOccurrenceOfPattern("MOMM");
	    	System.out.println("Find the longest repeating substring  in String ");
	    	System.out.println( " Find Lexicographically First Suffix");
	    	trie.lexicographicallyFirstSuffix();
	    	
	    	
	    	
	    }
	}

