package com.algo.trees;

public class Trie {
	private class TrieNode{
		private int wordCount; //This variable will store the count of the strings in the Trie which are the same as that of the prefix represented by that node of the Trie
		private TrieNode[] childNodes; //Each TrieNode will have 26 children from a-z represented by a character pointer array.
	
		private TrieNode() {
			childNodes = new TrieNode[26];
		}
	
	}
	private TrieNode root = new TrieNode();
	//insert into trienode
	private TrieNode insert(final String str) {
		//starting from root
		TrieNode currTrieNode = root;
		for(final char c : str.toCharArray()) {
			TrieNode childTrieNode = currTrieNode.childNodes[c-'a'];
			if ( childTrieNode == null ) {
				 //insert new trienode
				 childTrieNode = new TrieNode();
			}
			currTrieNode = childTrieNode;
		}
		currTrieNode.wordCount = 1;
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Trie obj = new Trie();
		TrieNode root = obj.insert("tea");
		System.out.println(root);
	}

}
