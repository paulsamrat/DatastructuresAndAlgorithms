package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jdk.internal.joptsimple.internal.Strings;

public class GroupAnagrams {
	//https://leetcode.com/problems/group-anagrams/description/
	//Given an array of strings strs, group the anagrams together. You can return the answer in any order.
	
	//brute force
	private static List<List<String>> groupAnagrams_bf(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        
        for (int i = 0 ; i <strs.length ; i++) {
        	 if(strs[i] == Strings.EMPTY)continue;
        	 List<String> groups = new ArrayList<String>();
        	 groups.add(strs[i]);
        	 for (int j = i+1 ; j < strs.length ; j++) {
        		 
        		 
        		 boolean isAnagram  = isAnagram(strs[i] ,strs[j]);
        		 if (isAnagram) {
        			 groups.add(strs[j]);
        			 strs[j] = Strings.EMPTY;
        		 }
        	 }
        	 result.add(groups);
        }
        return result;
    }
	
	private static boolean isAnagram(final String str1 , final String str2) {
		if ((str1 != null && str2 != null ) && (str1.length() != str2.length())) return false;
		Map<Character,Integer> m = new HashMap<Character, Integer>();
		for (int i = 0 ; i <  str1.length() ; i++) {
			if (m.containsKey(str1.charAt(i))) {
				m.put(str1.charAt(i), m.get(str1.charAt(i))-1);
				if (m.get(str1.charAt(i)) == 0) m.remove(str1.charAt(i));
			}
			else
				m.put(str1.charAt(i), 1);
			
			if (m.containsKey(str2.charAt(i))) {
				m.put(str2.charAt(i), m.get(str2.charAt(i))-1);
				if (m.get(str2.charAt(i)) == 0) m.remove(str2.charAt(i));
			}else {
				m.put(str2.charAt(i),1);
			}
		}
		return m.isEmpty();
	}
	
	
	//sorting approach
	private static List<List<String>> groupAnagrams(String[] strs) {
		Map<String,List<String>> m = new HashMap<String, List<String>>();
		for (String str : strs) {
			final char[] strChars = str.toCharArray();
			Arrays.sort(strChars);
			final String sortedStr =  new String(strChars);
			m.putIfAbsent(sortedStr, new ArrayList<String>());
			m.get(sortedStr).add(str);
		}
		//System.out.println(m.values());
		return new ArrayList<List<String>>(m.values());
	}
	
	//one more approach
	
	// without even sorting . take hints all characters are from lowercase characters
	// so instead sorting . fill every string in char array and then convert the char array into a string key of hashmap
	 private static void init(String[] strs) {
		 Map<String, List<String>> map = new HashMap<>();
         for (String s: strs) {
             char[] keys = new char[26];
             for (int i = 0; i < s.length(); i++) {
                 keys[s.charAt(i) - 'a']++;
             }

             String key = new String(keys);
             System.out.println(key);
             List<String> list = map.get(key);
             if (list == null) {
                 map.put(key, new ArrayList<>());
             }

             map.get(key).add(s);
         }
         System.out.println(new ArrayList<>(map.values()));
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));
		//init(new String[] {"eat","tea","tan","ate","nat","bat"});
		//System.out.println(groupAnagrams(new String[] {"abbbbbbbbbbb","aaaaaaaaaaab"}));
		
	}

}
