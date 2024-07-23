package com.practise.datastructures.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DisjointSetsImpl 
{
    private List<Map<Integer, Set<Integer>>> disjointSet;
    
    private int arrayOfDisjointSets[] = new int[10];
    public DisjointSetsImpl()
    {
        disjointSet = new ArrayList<Map<Integer, Set<Integer>>>();
    }
    //Array Implementation
    // initialize a set a numbers from 1 to 10 . Each is basically a disjoint set containing one element
    public void initializeDisjointSets(){
    	for (int i=0 ; i < 9 ; i++)
    		  arrayOfDisjointSets[i]=i;
    }
    
    // Map Implementation
    public void create_set(int element)
    {
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        Set<Integer> set = new HashSet<Integer>();
        set.add(element);
        map.put(element, set);
        disjointSet.add(map);
    }
 
    public void union(int first, int second)
    {
        int first_rep = find_set(first);
        int second_rep = find_set(second);
 
        Set<Integer> first_set = null;
        Set<Integer> second_set = null;
 
        for (int index = 0; index < disjointSet.size(); index++)
        {
            Map<Integer, Set<Integer>> map = disjointSet.get(index);
            if (map.containsKey(first_rep))
            {
                first_set = map.get(first_rep);
            } else if (map.containsKey(second_rep))
            { 
                second_set = map.get(second_rep);
            }
        }
 
        if (first_set != null && second_set != null)
        first_set.addAll(second_set);
 
        for (int index = 0; index < disjointSet.size(); index++)
        {
            Map<Integer, Set<Integer>> map = disjointSet.get(index);
            if (map.containsKey(first_rep))
            {
                map.put(first_rep, first_set);
            } else if (map.containsKey(second_rep))
            {
                map.remove(second_rep);
                disjointSet.remove(index);
            }
        }
 
        return;
    }
 
    public int find_set(int element)
    {
        for (int index = 0; index < disjointSet.size(); index++)
        {
            Map<Integer, Set<Integer>> map = disjointSet.get(index);
            Set<Integer> keySet = map.keySet();
            for (Integer key : keySet)
            {
                Set<Integer> set = map.get(key);
                if (set.contains(element))
                {
                    return key;
                }
            }
        }
        return -1;
    }
 
    public int getNumberofDisjointSets()
    {
        return disjointSet.size();
    }
    
    //union function
    //Union(A,B) :  Connect A to B and assign the value of Arr[B] to that of Arr[A] i.e; Arr[A]=Arr[B]
    
    //O(N2) . for one element union is does a full array scan i.e N i.e for N elements it is NXN
    public void doUnion(int srcElementIdx , int destElementIdx){
    	  int temp = arrayOfDisjointSets[srcElementIdx];
    	  for ( int i = 0 ; i < arrayOfDisjointSets.length ; i++)
    	  {
    		  if (arrayOfDisjointSets[i] == temp) arrayOfDisjointSets[i] = arrayOfDisjointSets[destElementIdx];
    	  }
    	
    }
    
    //find function :  tells about connectedness 
    //if both are having the same parent i.e they are connected , simply check if Arr[A]==Arr[B]
    
    public boolean doFind(int element1 , int element2){
    	//Again need to find the index , until and unless we project this algo with indexes rather than element value .
    	int element1Idx = Integer.MAX_VALUE;
    	int element2Idx = Integer.MAX_VALUE;
    	for (int i = 0 ; i < arrayOfDisjointSets.length ; i++){
    		 if (element1==arrayOfDisjointSets[i]) element1Idx = i;
    		 else if (element2 == arrayOfDisjointSets[i]) element2Idx = i ;
    	}
    	return arrayOfDisjointSets[element1Idx] == arrayOfDisjointSets[element2Idx];
    }
    
    //using root technique
    public void doUnionUsingRoot(int srcElementIdx , int destElementIdx){
    	
    	//initially all elements will be root of itself
    	// run union root algo 
    	// connect src element to dest element and assign the dest element root value to src element root value
    	int srcElementRootIdx = findRootElementIdx(srcElementIdx);
    	int destElementRootIdx = findRootElementIdx(destElementIdx);
    	arrayOfDisjointSets[srcElementRootIdx] = arrayOfDisjointSets[destElementIdx]; // or destElementIdx   	
    }
    
    //root is found whenever the A[i] == i 
    public int findRootElementIdx(int elementIdx){
    	while (arrayOfDisjointSets[elementIdx] != elementIdx){
    		  elementIdx = arrayOfDisjointSets[elementIdx];
    	}
    	return elementIdx; 
    }
    public boolean doFindUsingRoot(int srcElementIdx , int destElementIdx){
    	//if both the element has same root value . that means both are in the same subset and connected.
    	return findRootElementIdx(srcElementIdx) == findRootElementIdx(destElementIdx);
    }
    public static void main(String... arg)

    {
        DisjointSetsImpl disjointSet = new DisjointSetsImpl();
 
        for (int i = 1; i <= 5; i++)
        {
            disjointSet.create_set(i);
        }
 
        System.out.println("ELEMENT : REPRESENTATIVE KEY");
        for (int i = 1; i <= 5; i++)
        {
            System.out.println(i + "\t:\t" + disjointSet.find_set(i));
        } 
 
        disjointSet.union(1, 5);
        disjointSet.union(5, 3);
        
        System.out.println("\nThe Representative keys after performing the union operation\n");
        System.out.println("Union of (1 and 5)  and (5 and 3) ");
 
        System.out.println("ELEMENT : REPRESENTATIVE KEY");
        for (int i = 1; i <= 5; i++)
        {
            System.out.println(i + "\t:\t" + disjointSet.find_set(i));
        }
 
        System.out.println("\nThe number of disjoint set : "+ disjointSet.getNumberofDisjointSets());
    }
}
