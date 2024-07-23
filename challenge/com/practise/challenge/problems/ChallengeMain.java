package com.practise.challenge.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
class Student{
	   private int id;
	   private String fname;
	   private double cgpa;
	   public Student(int id, String fname, double cgpa) {
	      super();
	      this.id = id;
	      this.fname = fname;
	      this.cgpa = cgpa;
	   }
	   public int getId() {
	      return id;
	   }
	   public String getFname() {
	      return fname;
	   }
	   public double getCgpa() {
	      return cgpa;
	   }
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cgpa);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Student))
			return false;
		Student other = (Student) obj;
		if (Double.doubleToLongBits(cgpa) != Double.doubleToLongBits(other.cgpa))
			return false;
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	}

public class ChallengeMain {
	
	private static void performMapOperation(){
		Map<ChallengeEntity,Integer> hashMap = new HashMap<ChallengeEntity,Integer>();
		//creating two entity
		ChallengeEntity obj1 = new ChallengeEntity(1, "One");
		ChallengeEntity obj2 = new ChallengeEntity(2, "two");
		hashMap.put(obj1,1);
		hashMap.put(obj2,2);
		System.out.println(hashMap.size()); //prints 1..as hashcode and equal is overriden
		for (Iterator<Map.Entry<ChallengeEntity, Integer>> itr = hashMap.entrySet().iterator(); itr.hasNext();){
				Map.Entry<ChallengeEntity, Integer> e = itr.next();
				//if (1 == e.getValue() )
						itr.remove();
		}
		System.out.println(hashMap.isEmpty());
		System.out.println(hashMap.get(obj1));
		Set<ChallengeEntity> set = new TreeSet<ChallengeEntity>();
		set.add(obj1);
		set.add(obj2);
		System.out.println(set.size());
		Set<String> set1 = new TreeSet<String>();
		set1.add("hello there");
		set1.add("hello there");
		System.out.println(set1.size());
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		queue.add(2);
		System.out.println(queue);
		List<Student> ls = new ArrayList<Student>();
		ls.add(new Student(1, "samrat", 0));
		ls.add(new Student(2, "s", 0));
		if ( ls.contains(new Student(1, "samrat", 0)))
				System.out.println("contains");
		int[][] matrix = new int[][]{ {1,2,3},{4,5,6}};
		System.out.println(matrix[0].length);
		Map<String,String> map = new ConcurrentHashMap<String, String>();
		System.out.println(map);
	
	}
	
	//convert a string to camel case of string is splitted by _
	private static void convertToCamelCase(String str){
		String[] splitArray = str.split("_");
		StringBuilder  camelCaseString = new StringBuilder();
		for (String s : splitArray){
			//UPPER CAMEL CASE
			//EX : HI_HOW_ARE_YOU //HiHowAreYou
			camelCaseString.append(s.substring(0, 1).toUpperCase()).append(s.substring(1).toLowerCase());
		}
		System.out.println(camelCaseString);
	}
	//Given  two-dimensional points in space, determine whether they lie on some vertical or horizontal line. 
	//If yes, print YES; otherwise, print NO.
	private static void sameLine(){
		Scanner sc = new Scanner(System.in);
		int noOFtestCases = sc.nextInt();
		Map<Integer,Integer> xMap = new HashMap<Integer, Integer>();
		Map<Integer,Integer> yMap = new HashMap<Integer, Integer>();
		for (int i =1 ; i<= noOFtestCases ;i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			xMap.put(x, y);
			yMap.put(y, x);
		}
		if ( xMap.size() == 1 || yMap.size() == 1)
			System.out.println(" lies on same dimesion");
		
	}
	
	/*
	 * You are given a list of student information: ID, FirstName, and CGPA. 
	 * Your task is to rearrange them according to their CGPA in decreasing order. 
	 * If two student have the same CGPA, then arrange them according to their first name in alphabetical order. 
	 * If those two students also have the same first name, then order them according to their ID. No two students have the same ID.
	 */
	public static void comparatorTest(){
		Scanner in = new Scanner(System.in);
		int testCases = 5; //Integer.parseInt(in.nextLine());

		List<Student> studentList = new ArrayList<Student>();
		while(testCases>0){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();

			Student st = new Student(id, fname, cgpa);
			studentList.add(st);

			testCases--;
		}
		Collections.sort(studentList, new Comparator<Student>(){
			public int compare(Student s1 , Student s2){
				if (s2.getCgpa() == s1.getCgpa()){
					int fnameRst = s1.getFname().compareTo(s2.getFname());
					if (fnameRst ==0)
						return s1.getId() - s2.getId();
					else
						return fnameRst;
				}
				else{
					 double d=s2.getCgpa()-s1.getCgpa();
                if(d<0)
                    return -1;
                else
                    return 1;
				}
			} 
		});

		for(Student st: studentList){
			System.out.println(st.getFname());
		}
	}
	
	// you are given  integers. You need to find the maximum number of unique integers among all the possible contiguous subarrays of size .
	//Print the maximum number of unique integers among all possible contiguous subarrays of size m .
	public static void maxUniqueIntegersInSubArray(){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(); // array length
        int m = in.nextInt();  // subarrays length
        int[] arr = new int[n];
        int maxCountUniqueInteger = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) 
            arr[i] =  in.nextInt();
        for (int i = 0 ; i <=n-m ; i++){
        	   Set<Integer> set = new HashSet<Integer>();
        	   int tmpCount = 0;
        	   for(int j=i;j< i+m ;j++)
        		    if(set.add(arr[j])) ++tmpCount;
        	   if (tmpCount > maxCountUniqueInteger) maxCountUniqueInteger = tmpCount;
        }
        System.out.println(maxCountUniqueInteger);   
        
	}
	//Given an array of integers, find two numbers such that they add up to a specific target number.

    //The function twoSum should return indices of the two numbers such that they add up to the target, 
	//where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
	public static void twoSumMap(int[] numbers, int target){
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		int[] result = new int[2];
		for (int i=0 ; i < numbers.length ;i++){
			if (map.containsKey(numbers[i])){
				 result[0] = i;
				 result[1] = map.get(numbers[i]);
			}else
				map.put(target - numbers[i],i);
		}
		System.out.println( "Adding Indexes  " + result[0] + " and " + result[1] + " makes " + target);
	}
	/*
	 *  Design and implement a TwoSum class. It should support the following operations: add and find.
		add - Add the number to an internal data structure.
		find - Find if there exists any pair of numbers which sum is equal to the value.
	 */
	public static void twoSumOperation(int[] numbers, int target){
		//adding data to map
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0 ; i < numbers.length ; i++)
				map.put(numbers[i], i);
		//finding target where any pair of numbers which sum is equal to the value.
		for (Map.Entry<Integer, Integer> e : map.entrySet()){
			 int val = target - e.getKey();
			 if (map.containsKey(val)){
				     if (val + e.getKey() == target){
				    	 	System.out.println( "Adding Indexes  " + e.getValue() + " and " + map.get(val) + " makes " + target);
				    	 	break;
				     }
			 }
		}
		
	}
	//Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
	//Find all unique triplets in the array which gives the sum of zero.
	public static void uniqueTriplets(int[] numbers){
		//to do using hash map
	}
	public static void addingTwoNumbersWOSum(int x , int y){
		// Iterate till there is no carry  
	    while (y != 0)
	    {
	        // carry now contains common set bits of x and y
	        int carry = x & y;  
	 
	        // Sum of bits of x and y where at least one of the bits is not set
	        x = x ^ y; 
	 
	        // Carry is shifted by one so that adding it to x gives the required sum
	        y = carry << 1;
	    }
	    System.out.println(x);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		performMapOperation();
		//convertToCamelCase("HI_SAMRAT_HOW_R_U");
		//sameLine();
		//isBalancedParenthesis();
		//comparatorTest();
		//maxUniqueIntegersInSubArray();
		
		twoSumMap(new int[]{1,2,3,4,5},5);
		twoSumOperation(new int[]{1,2,4,10,5},9);
		uniqueTriplets(new int[]{-1,0,1,2,-1,-4});
		byte b =10;
		byte b1 = 11;
		byte c = (byte) (b+b1);
		addingTwoNumbersWOSum(38,2);
	}

}
