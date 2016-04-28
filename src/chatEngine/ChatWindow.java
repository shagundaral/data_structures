package chatEngine;

import java.util.ArrayList;
import java.util.List;

public class ChatWindow {
	
	public static void main(String[] args) {
		String s= "Ahello 123,78. !20 pqer12,08";
		List<Integer> intList = new ArrayList<Integer>();
		char[] charArray = s.toCharArray();
    	int x =0;
    	int place = 1;
    	
    	for(int i=s.length()-1;i>=0;i--){
    		String str = String.valueOf(charArray[i]);
    		try{
    			int a = Integer.parseInt(str);
    			x+=a*place;
    			place = place*10;
//    			System.out.println(a);
    		}catch(Exception e){
    			//System.out.println(e);
    			place=1;
    			if(x!=0){
    				intList.add(x);
    			}
//    			System.out.println(x);
    			x=0;
    		}
    
    	}
    	
    	if(null!=intList){
    		int[] intArray = new int[intList.size()];
	    	for(int j=intList.size()-1,i=0;j>=0;j--,i++){
	    		intArray[i] = intList.get(j);
	    	}
	    	for(int i : intArray){
	    		System.out.println(i);
	    	}
    	}
    	
    	
    	
	}
	
	public void getNumbers(String s){
    	char[] charArray = s.toCharArray();
    	//int x;
    	for(char c: charArray){
    		String str = String.valueOf(c);
    		try{
    			int a = Integer.parseInt(str);
    			System.out.println(a);
    		}catch(Exception e){
    			System.out.println(e);
    		}
    	}
    }

}
