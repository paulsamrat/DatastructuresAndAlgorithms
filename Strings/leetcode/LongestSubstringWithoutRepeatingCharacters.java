package leetcode;

public class LongestSubstringWithoutRepeatingCharacters {
	//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
	
	private static int lengthOfLongestSubstring(String s) {
        int startIdx = 0 ;
        int endIdx = 0 ;
        int[] c = new int[256];
        int lenLongSubString = 0 ;
        while(endIdx < s.length()) {
        	  if (c[s.charAt(endIdx)] == 0 ) //this character is not seen before
        		  c[s.charAt(endIdx)] = 1;
        	  else {
        		  lenLongSubString = ((endIdx-1)-startIdx)+1 > lenLongSubString ?  ((endIdx-1)-startIdx)+1  : lenLongSubString;
        		  c[s.charAt(endIdx)] = 2;
        		  //look for index where the repetative char is found
        		  while(c[s.charAt(startIdx)] = 0 ) {
        			  
        		  }
        		  
        	  }
        	  ++endIdx;
        }
        return lenLongSubString;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}

}
