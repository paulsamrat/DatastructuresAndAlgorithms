package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LongestCommonPrefix {
	//find the longest common prefix - no common prefix return ""
	private static void longestCmnPrefix(final String[] strings) {
		//final Map<Integer,String> map = new HashMap<Integer,String>();
		Arrays.sort(strings, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				// TODO Auto-generated method stub
				return s1.length()-s2.length();
			}
		});
		final int[] arr = new int[26];
		//pre process
		// this is also correct approach
		/**
		for (char c : strings[0].toCharArray())
			arr[c-'a']=1;
		for (int i = 1 ; i < strings.length ; i++) {
			 int tillIndex = strings[0].length();
			 final String currString = strings[i];
			 int m = 0 ;
			 while(m < tillIndex) {
				 if (arr[currString.charAt(m)-'a'] == 0 ) break;
				 arr[currString.charAt(m)-'a'] = arr[currString.charAt(m)-'a'] + 1;
				 m++;
			 }
		}**/
		
		//another approach
		//accepted - but not efficient
		final String smallestString = strings[0];
		String longestCmnPrefix = "";
		for (int i = 1 ; i < strings.length ; i++) {
			final String currString = strings[i];
			String tempLongestCmnPrefix =  "";
			for (int m = 0 ; m < smallestString.length() ; m++) {
				if (smallestString.charAt(m)==currString.charAt(m))
					tempLongestCmnPrefix+=smallestString.charAt(m);
				else
					break;
			}
			if (!longestCmnPrefix.isEmpty())
				longestCmnPrefix = tempLongestCmnPrefix.length() > longestCmnPrefix.length() ? longestCmnPrefix :  tempLongestCmnPrefix;
			else
				longestCmnPrefix = tempLongestCmnPrefix;
			if (longestCmnPrefix.isEmpty())
				System.out.println("");
				return;
		}
		System.out.println(longestCmnPrefix);
	}
	
	
	//efficient way use index of operator
	
	// indexof operator returns the starting index of the searched string inside the given string
	public static void longestCommonPrefix(String[] strings) {
		if (strings == null ||  strings.length == 0 )
			System.out.println("");
		//lets consider the first string as the longest prefix
		String prefix = strings[0];
		for (int i = 1 ; i<strings.length ; i++) {
			//two scenarios.
			// indexof return non negative . curr string is contained within the prefix string 
			// now we need to figure out what portion of the curr string is contained 
			while(prefix.indexOf(strings[i]) != 0 ) {
				strings[i] = strings[i].substring(0,strings[i].length()-1);
			}
			// indexof returns negative . that means the current string is not contained within the prefix string
			
			if (strings[i].isEmpty()) {
				System.out.println("");
				return;
			}
		}
		System.out.println(prefix);
	}
	
	private static void indexOf(String str , String prefix) {
		while (prefix.indexOf(str) != 0) {
			 	str = str.substring(0, str.length()-1);
		}
		System.out.println(str.length());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		longestCmnPrefix(new String[] {"flower","flow","flight"});
		longestCmnPrefix(new String[] {"dog","racecar","car"});
		longestCmnPrefix(new String[] {"c","acc","ccc"});
		//indexOf("flower","flow");
		longestCommonPrefix(new String[] {"flower","flow","flight"});
		longestCommonPrefix(new String[] {"dog","racecar","car"});
		longestCommonPrefix(new String[] {"c","acc","ccc"});
	}

}
