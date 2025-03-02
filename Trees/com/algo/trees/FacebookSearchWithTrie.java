package com.algo.trees;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class TrieNode {
    Map<Character, TrieNode> children;
    Set<Integer> postIds;  // Stores post IDs where this word appears

    public TrieNode() {
        children = new HashMap<>();
        postIds = new HashSet<>();
    }
}

class Trie_1 {
    private final TrieNode root;

    public Trie_1() {
        root = new TrieNode();
    }

    // Insert a word into Trie and link it to a post ID
    public void insert(String word, int postId) {
        TrieNode current = root;
        for (char ch : word.toLowerCase().toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
        }
        current.postIds.add(postId); // Link word to post ID
    }

    // Search posts containing a specific word
    public Set<Integer> search(String word) {
        TrieNode current = root;
        for (char ch : word.toLowerCase().toCharArray()) {
            if (!current.children.containsKey(ch)) return new HashSet<>();
            current = current.children.get(ch);
        }
        return current.postIds; // Return linked post IDs
    }
}


public class FacebookSearchWithTrie {
    public static void main(String[] args) {
        Trie_1 trie = new Trie_1();

        // Insert words from posts into the Trie
        trie.insert("football", 101);
        trie.insert("world", 101);
        trie.insert("cup", 101);
        trie.insert("world", 102);
        trie.insert("cup", 102);
        trie.insert("fifa", 103);
        trie.insert("world", 103);
        trie.insert("cup", 103);

        // Search for posts containing the word "world"
        System.out.println("Posts containing 'world': " + trie.search("world"));
        // Output: Posts containing 'world': [101, 102, 103]

        // Search for posts containing "football"
        System.out.println("Posts containing 'football': " + trie.search("football"));
        // Output: Posts containing 'football': [101]

        // Search for "cup"
        System.out.println("Posts containing 'cup': " + trie.search("cup"));
        // Output: Posts containing 'cup': [101, 102, 103]

        // Search for a word that doesn't exist
        System.out.println("Posts containing 'basketball': " + trie.search("basketball"));
        // Output: Posts containing 'basketball': []
    }
}


