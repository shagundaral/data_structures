package com.problems;

import java.util.HashSet;
import java.util.Set;

public class StringProgrammer {
	
	
	public static void permutation(String str) { 
	    permutation("", str); 
	}

	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
	
	
	
	public static Set<String> stringPermutations(char[] c){
		Set<String> finalSet = new HashSet<String>();
		String s = permute(c, finalSet);
/*		if(null != finalSet){
			for (String string : finalSet) {
				System.out.println(string);
			}
		}*/
		return finalSet;
	}
	
	
	public static String permute(char[] chars, Set<String> finalSet){
		
		String k = null;
		if(chars.length>0){
			if(chars.length == 1){
				k = String.valueOf(chars[0]);
				return k;
			}else{
				for(int i=0; i<chars.length; i++){
					char[] remainigChars = new char[chars.length-1];
					for(int j=0; j<chars.length; j++){
						if (j < i) {
							remainigChars[j] = chars[j];
							finalSet.add(k = chars[i]+permute(remainigChars, finalSet));
						} else if (j > i){
							remainigChars[j-1] = chars[j];
							finalSet.add(k = chars[i]+permute(remainigChars, finalSet));
						}
					}
//					finalSet.add(chars[i]+permute(remainigChars, finalSet));
					
				}
			}
		}
		return k;
	}


}
