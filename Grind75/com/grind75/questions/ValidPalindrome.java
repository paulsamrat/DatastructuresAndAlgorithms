package com.grind75.questions;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/valid-palindrome/
public class ValidPalindrome {
	List<Character> list = new ArrayList<Character>();
	public boolean isPalindrome_1(String s) {
		
		for (char c : s.toCharArray()) {
			 final char c1  = Character.toLowerCase(c);
			 if ((c1-'a'>= 0 && c1-'a' < 26) ||  (c1-'0' >= 0 && c1-'0' <= 9 )) {
				 list.add(c1);
			 }
		}
		int frdIndx = 0 , backIndx = list.size()-1;
		while(!(backIndx < frdIndx)) {
			if (list.get(backIndx) != list.get(frdIndx))
					return false;
			++frdIndx;
			--backIndx;
		}
		return true;
	}
	
	public boolean isPalindrome(String s) {
        int startIdx = 0 , endIdx = s.length()-1;
        
        while (startIdx < endIdx){


            while((startIdx < endIdx) && !isDigitOrCharacter(s.charAt(startIdx)))
                ++startIdx;
            while((startIdx < endIdx) && !isDigitOrCharacter(s.charAt(endIdx)))
                --endIdx;

            char c1 = s.charAt(startIdx);
            char c2  = s.charAt(endIdx);
            c1 = convertToLowerCase(c1);
            c2 = convertToLowerCase(c2);

            if (c1 != c2)
                return false;
            ++startIdx;
            --endIdx;
        }
        return true;
    }

    private char convertToLowerCase(final char c){
        if (c >= 'A' && c <= 'Z')
            return (char)(c-'A'+'a');
        return c;
    }
    private boolean isDigitOrCharacter(final char c){
        if ((c >= 'a' && c <= 'z') || ( c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z'))
            return true;
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidPalindrome obj = new ValidPalindrome();
		System.out.println(obj.isPalindrome(".,"));
	}

}
