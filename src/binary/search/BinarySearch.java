package binary.search;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class BinarySearch {
	
	private static int[] searchArray = {1,2,3,10,11,20,21,34,36};
	
	public static void main(String[] args) {
		System.out.println(longestPalendrome("asasassaabmadam"));
		System.out.println(getIndexOf(20, 0, searchArray.length-1));
		System.out.println(getMaxProfit(24));
	}

	private static int longestPalendrome(String string) {
		char[] chars = string.toCharArray();
		int max=0;
		for(int i=1;i<chars.length-1; i++){
			int palLength = 0;
			if(chars[i+1]==chars[i-1]){
				palLength=1;
				for(int j=i-1,k=i+1; j>=0 && k < chars.length; j--,k++){
					if(chars[j]==chars[k]){
						palLength+=2;
					}else{
						break;
					}
				}
				if(palLength>max){
					max = palLength;
				}
			}else if(chars[i+1]==chars[i]){
				palLength=2;
				for(int j=i-1,k=i+2; j>=0 && k < chars.length; j--,k++){
					if(chars[j]==chars[k]){
						palLength+=2;
					}else{
						break;
					}
				}
				if(palLength>max){
					max = palLength;
				}
			}
		}
		return max;
	}

	private static int getIndexOf(int val, int start, int end) {
		System.out.println("I");
		if(end!=start){
			int mid = start + (end-start)/2;
			if(val==searchArray[mid]){
				return mid;
			}else if(val<searchArray[mid]){
				return getIndexOf(val, start, mid-1);
			}else{
				return getIndexOf(val, mid+1, end);
			}
		}else if(searchArray[start]==val){
			return start;
		}
		return -1;
	}
	
	
	private static int getMaxProfit(int x){
		if(x==1){
			return 1;
		}else{
			int by2 = x/2;
			int by3 = x/3;
			int by4 = x/4;
			if(by2+by3+by4 <= x){
				return x;
			}else{
				return getMaxProfit(by2)+getMaxProfit(by3)+getMaxProfit(by4);
			}
			
		}
	}
	
	

}
