package sums;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets {
	
	static Set<Integer> arr;
	
	public static void main(String[] args) {
		//getAllSubsets(arr, arr.length);
		
		
		
		
		int desiredSum = 9;
		arr = new HashSet<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(6);
		arr.add(9);
		
		/*while(arr.size()>0){
			getAllSubsets(arr);
			System.out.println("-------------------------------");
			List<Integer> list = new ArrayList<Integer>(arr);
		    Integer head = list.get(0);
		    arr = new HashSet<Integer>(list.subList(1, list.size()));
		}*/
		//getAllSubsets(arr);
		for (Set<Integer> s : getAllSubsets(arr)) {
		     System.out.println(s);
		}
		
		//allsubsets(arr);
		/*for (Set<Integer> s : allsubsets(arr)) {
		     System.out.println(s);
		     int sum = 0;
		     for (Integer num : s) {
				sum += num;
			}
		    if(sum == desiredSum){
		    	System.out.print("sum can be obtained from: ");
		    	System.out.println(s);
		    }
		 }*/
	}
	
	
	public static Set<Set<Integer>> allsubsets(Set<Integer> originalSet) {
	    Set<Set<Integer>> sets = new HashSet<Set<Integer>>();
	    if (originalSet.isEmpty()) {
	    	sets.add(new HashSet<Integer>());
	    	return sets;
	    }
	    List<Integer> list = new ArrayList<Integer>(originalSet);
	    Integer head = list.get(0);
	    Set<Integer> rest = new HashSet<Integer>(list.subList(1, list.size())); 
	    for (Set<Integer> set : allsubsets(rest)) {
	    	Set<Integer> newSet = new HashSet<Integer>();
	    	newSet.add(head);
	    	newSet.addAll(set);
	    	sets.add(newSet);
	    	sets.add(set);
	    }	
	    //System.out.println(sets);
	    return sets;
	}
	
	
	private static void getAllSubsets1(int[] arr, int length) {
		
		List<Node> intArrList = new ArrayList<Node>();
		//int size = (int) Math.pow(2, arr.length);
		printCombination(arr, 3, arr.length);
		for(int i=0;i<length;i++){
			int[] subArr = new int[length-i-1];
			for(int k=0; k<subArr.length+1; k++){
				//for(int j=0; j<arr[]; )
			}
		}
		
		
	}
	
	
	static void combinationUtil(int arr[], int n, int r, int index, int data[],
			int i) {
		if (index == r) {
			for (int j = 0; j < r; j++)
				System.out.print(data[j] + " ");
			System.out.println("");
			return;
		}

		if (i >= n)
			return;

		data[index] = arr[i];
		combinationUtil(arr, n, r, index + 1, data, i + 1);

		combinationUtil(arr, n, r, index, data, i + 1);
	}

	static void printCombination(int arr[], int n, int r) {
		int data[] = new int[r];

		combinationUtil(arr, n, r, 0, data, 0);
	}
	
	
	
	private static void getAllSubArrayOfSize(int i, int[] subArr,
			List<Node> intArrList, int k) {
		
		int[] subArray = new int[k];
		subArr[0] = i;
		for(int x=1; x<k; x++){
			//subArr[x] = getSubarray(subArr,  );
		}
	}



	class Node{
		
		int[] inrArr;
	}
	
	
	static Set<Set<Integer>> getAllSubsets(Set<Integer> arr){
		int length = arr.size();
		Set<Set<Integer>> sets = new HashSet<Set<Integer>>();
		
		Set<Set<Integer>> previousSets = new HashSet<Set<Integer>>();
		
		for(int i=0; i<length; i++){
			
			Set<Set<Integer>> newSets = new HashSet<Set<Integer>>();
			Set<Integer> s = new HashSet<Integer>();
			
			for(Integer e : arr){
				if(!previousSets.isEmpty()){
					for(Set<Integer> p : previousSets){
						if(p.size() == i){
							s = new HashSet<Integer>(p);
							s.add(e);
							sets.add(s);//System.out.println(s);
							newSets.add(s);
						}
					}
				}else{
					s=new HashSet<Integer>();
					s.add(e);
					sets.add(s);//System.out.println(s);
					newSets.add(s);
				}
			}
			
			previousSets = new HashSet<Set<Integer>>(newSets);
			sets.addAll(previousSets);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		
		for(int i=1; i<length; i++){
			Set<Integer> subSet = new HashSet<Integer>();
			Integer lastAdded = 0;
			for(Integer element : arr){
				if(subSet.size() < i && !subSet.contains(element)){
					subSet.add(element);
					lastAdded = element;
				}else if (subSet.size()==i){
					sets.add(subSet);
					System.out.println(subSet);
					subSet.remove(lastAdded);
					subSet.add(element);
				}
			}
		}*/
		return sets;
	}
	
	
	

}
