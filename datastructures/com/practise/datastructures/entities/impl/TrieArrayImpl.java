package com.practise.datastructures.entities.impl;

public class TrieArrayImpl {
	 
    // we are only dealing with keys with chars 'a' to 'z'
    final static int ALPHABET_SIZE = 26;
    final static int NON_VALUE = -1;
     
    class TrieNode
    {
        boolean isLeafNode;
        int value;
         
        TrieNode[] children;
                 
        TrieNode(boolean isLeafNode, int value)
        {
            this.value = value;
            this.isLeafNode = isLeafNode;
            children = new TrieNode[ALPHABET_SIZE];
        }
         
        public void markAsLeaf(int value)
        {
            this.isLeafNode = true;
            this.value = value;
        }
    }
 
    TrieNode root;
    TrieArrayImpl()
    {
        this.root = new TrieNode(false, NON_VALUE);
    }
 
    private int getIndex(char ch)
    {
        return ch - 'a';
    }
 
    public int search(String key)
    {
        // null keys are not allowed
        if (key == null)
        {
            return NON_VALUE;
        }
         
        TrieNode currentNode = this.root;
        int charIndex = 0;
         
        while ((currentNode != null) && (charIndex < key.length()))
        {
            int childIndex = getIndex(key.charAt(charIndex));
             
            if (childIndex < 0 || childIndex >= ALPHABET_SIZE)
            {
                return NON_VALUE;
            }
            currentNode = currentNode.children[childIndex];
             
            charIndex += 1;
             
        }
         
        if (currentNode != null)
        {
            return currentNode.value;
        }
         
        return NON_VALUE;
    }
 
    public void insert(String key, int value)
    {
        // null keys are not allowed
        if (key == null) return;
         
        key = key.toLowerCase();
         
        TrieNode currentNode = this.root;
        int charIndex = 0;
         
        while (charIndex < key.length())
        {
            int childIndex = getIndex(key.charAt(charIndex));
 
            if (childIndex < 0 || childIndex >= ALPHABET_SIZE)
            {
                System.out.println("Invalid Key");
                return;
            }
             
            if (currentNode.children[childIndex] == null)
            {
                currentNode.children[childIndex] = new TrieNode(false, NON_VALUE);
            }
             
            currentNode = currentNode.children[childIndex];
            charIndex  += 1;
        }
         
        // mark currentNode as leaf
        currentNode.markAsLeaf(value);
    }
 
    public static void main(String[] args)
    {
        TrieArrayImpl tr = new TrieArrayImpl();
 
        tr.insert("aab", 3);
        int value = tr.search("aab");
         
        System.out.println(value);
    }
}