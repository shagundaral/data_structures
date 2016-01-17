package com.string;

public class MainTester {
	
	public static void main(String[] args) {
		
		String stringToRev = "today is monday and tomorrow will be tuesday";
		String s = stringReverser(stringToRev, stringToRev.length(), stringToRev.length()-1);
		
	}

	
	private static String stringReverser(String input, int k, int p){
		
		if(input.charAt(p) == ' '){
			input = input.substring(0, p) + input.substring(k, input.length()) + input.substring(p, k);
			k=p;
			System.out.println(" 2: "+input);
			return stringReverser(input, k, p-1);
		}
		if(p==0){
			input = input.substring(k+1,input.length()) + " " + input.substring(0, k);
			System.out.println(" 3: "+input);
			return input;
		}
		return stringReverser(input, k, p-1);
		
	}
	
}
