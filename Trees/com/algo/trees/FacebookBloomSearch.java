package com.algo.trees;

import java.util.BitSet;
import java.util.Random;

class BloomFilter {
    private BitSet bitArray;
    private int size;
    private int hashCount;

    public BloomFilter(int size, int hashCount) {
        this.size = size;
        this.hashCount = hashCount;
        this.bitArray = new BitSet(size);
    }

    // Hash function
    private int[] getHashes(String word) {
        int[] hashes = new int[hashCount];
        Random random = new Random(word.hashCode()); // this is seed . so that everytime the 
        //the random numbers generated will be consistent
        for (int i = 0; i < hashCount; i++) {
            hashes[i] = Math.abs(random.nextInt(size));
        }
        return hashes;
    }

    // Insert a word into Bloom Filter
    public void insert(String word) {
        for (int hash : getHashes(word.toLowerCase())) {
            bitArray.set(hash);
        }
    }

    // Check if a word might be present
    public boolean mightContain(String word) {
        for (int hash : getHashes(word.toLowerCase())) {
            if (!bitArray.get(hash)) {
                return false; // Definitely not present
            }
        }
        return true; // Might be present
    }
}
public class FacebookBloomSearch {
    public static void main(String[] args) {
    	
        // Create a Bloom Filter (size = 1000 bits, 3 hash functions)
        BloomFilter filter = new BloomFilter(1000, 3);

        // Example posts
        String[] posts = {
            "The Election 2024 debates start next week!",
            "Tech innovations are booming in 2024.",
            "The World Cup 2026 will be historic!",
            "Politics is heating up before the elections."
        };

        // Insert keywords into Bloom Filter
        for (String post : posts) {
            for (String word : post.split(" ")) {
                filter.insert(word);
            }
        }

        // Search for keywords using Bloom Filter
        String query1 = "Election";
        String query2 = "Bitcoin";

        System.out.println("Might contain 'Election'? " + filter.mightContain(query1)); // true (possible false positive)
        System.out.println("Might contain 'Bitcoin'? " + filter.mightContain(query2));  // false (definitely not)
    }
}
