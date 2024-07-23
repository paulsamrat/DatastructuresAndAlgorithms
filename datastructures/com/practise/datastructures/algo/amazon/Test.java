package com.practise.datastructures.algo.amazon;

import java.util.LinkedList;
import java.util.Queue;

public class Test {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int arr[] = {1,4,0,5,9,1};
        int n=6;
        int k=0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=1;i<n;i++){
            if(arr[i]>arr[k]){
                while(k<i){
                queue.add(arr[i]);
                k++;
                }
            }
        }
        while(k<n){
            queue.add(-1);
            k++;
        }
       System.out.println(queue);
       find_max_length_substring_with_max_unique_chars();
    }
    
    public static void find_max_length_substring_with_max_unique_chars(){
        final String inputString = "abeiefdeg";
        int max=0;
        int start=0;
        //int end=0;
        int currVal=0;
        //HashMap<Charcter,Integer> count=new HashMap<Charcter,Integer>();//16 buckets->32buckets
        int count[]=new int[26];
        //final char[] charArr = inputString.toCharArr();
        for(int i=0;i<inputString.length();i++)
        {
            char c=inputString.charAt(i);
            if(count[c-'a']==0)
            {
                currVal++;
                count[c-'a']++;
                max=Math.max(max,currVal);
            }
            else{
                count[inputString.charAt(start)-'a']=0;
                start++;
               // i=start;
                currVal--;
                i--;
            }
            
        }
        
        System.out.println(max);
        
    }
}
