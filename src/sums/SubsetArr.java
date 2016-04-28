package sums;

import java.util.LinkedHashSet;

public class SubsetArr {
	
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		/*LinkedHashSet myPowerSet = allSubsets(arr);
	     
	       System.out.println(myPowerSet.toString());*/
		
		powersetRec(arr,arr.length, 0, arr[arr.length-1]);
	}
	
	
	static void powersetRec(int[] s, int k, int m, int n) {
	    if (m <= n) {
	        s[k+1] = m ;
	        printSet(s, k+1) ; 
	        powersetRec(s, k+1, m+1, n) ; /* with m */
	        powersetRec(s, k, m+1, n) ; /*  without m */
	    }
	}


	private static void printSet(int[] s, int size) {

		    for (int i=1;i<=size;i++)
		        System.out.print(s[i]);
		    System.out.println("");

		    return;

		
	}
	
	
	/*private static LinkedHashSet allSubsets(int[] set) {
	     
	       LinkedHashSet subsets = new LinkedHashSet();
	     
	       int elements = set.length;
	     
	       int powerElements = (int) Math.pow(2,elements);
	     
	       for (int i = 0; i < powerElements; i++) {
	         
	           String binary = intToBinary(i, elements);
	         
	           LinkedHashSet innerSet = new LinkedHashSet();
	         
	           for (int j = 0; j < binary.length(); j++) {
	               if (binary.charAt(j) == '1')
	                   innerSet.add(set[j]);
	           }
	         
	           subsets.add(innerSet);
	         
	       }
	     
	       return subsets;
	   }
	
	private static String intToBinary(int binary, int digits) {
	     
	       String temp = Integer.toBinaryString(binary);
	       int foundDigits = temp.length();
	       String returner = temp;
	       for (int i = foundDigits; i < digits; i++) {
	           returner = "0" + returner;
	       }
	     
	       return returner;
	   } 
*/
}
