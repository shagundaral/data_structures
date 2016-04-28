package sums;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class GoogleCodeJam_AllYourBase {
	
	static String[] input={"bbabbbbaaaaababbabbababbaabbbabaabbbabbaabaaaaaaaaaaaaaaaaaa"};
	
	public static void main(String[] args) {
		readInput();
		for(int i=0;i<input.length;i++){
			char[] charArray = input[i].toCharArray();
			Map<Character, Integer> charMap = new LinkedHashMap<Character, Integer>();
			int[] number = new int[charArray.length];
			number[0]=1;
			charMap.put(charArray[0], 1);
			int numberToput = 0;
			for(int j=1;j<charArray.length;j++){
				if(charMap.containsKey(charArray[j])){
					number[j] = charMap.get(charArray[j]);
				}else{
					number[j] = numberToput;
					charMap.put(charArray[j], numberToput);
					if(numberToput==0){
						numberToput=2;
					}else{
						++numberToput;
					}
				}
			}
			int base = charMap.size();
			System.out.println("Case #"+(i+1)+": "+getSecondsToAttack(number, base));
		}
		
	}

	private static void readInput() {
		BufferedReader r = new BufferedReader (new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(r.readLine());
			input = new String[n];
			for(int i=0;i<n;i++){
				input[i] = r.readLine();
			}
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static long getSecondsToAttack(int[] number, int base) {
	    long n = 0;
		for(int i=number.length-1; i>=0; i--){
			n+=number[number.length-i-1]*Math.pow(base==1?2:base, i);
		}
		return n;
	}

}
