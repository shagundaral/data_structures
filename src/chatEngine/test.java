package chatEngine;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class test {
	
	public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
*/
		int n=0;
		int m=0;
		int[] firstSortedArray = null;
		int[] secondSortedArray = null;
		
		for(int i=0;i<4;i++){
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = br.readLine();
	        if(i==0){
	        	n=Integer.parseInt(line);
	        }
	        if(i==1){
	        	String[] firstArray = line.split(" ");
	        	firstSortedArray = new int[firstArray.length];
	        	for(int i1=0;i1<firstArray.length;i1++){
	        		firstSortedArray[i1] = Integer.parseInt(firstArray[i1]);
	        	}
	        }
	        if(i==2){
	        	m=Integer.parseInt(line);
	        }
	        if(i==3){
	        	String[] firstArray = line.split(" ");
	        	secondSortedArray = new int[firstArray.length];
	        	for(int i1=0;i1<firstArray.length;i1++){
	        		secondSortedArray[i1] = Integer.parseInt(firstArray[i1]);
	        	}
	        }
	        //System.out.println(line);
		}
        
		int[] resultArray = new int[n+m];
//		int index =0;
		int firstArrayIndex=0;
		int secondArrayIndex=0;
		
		for(int index=0;index<n+m;index++){
			if(secondSortedArray[secondArrayIndex]<firstSortedArray[firstArrayIndex] && secondArrayIndex<m){
				resultArray[index] = secondSortedArray[secondArrayIndex];
				secondArrayIndex++;
			}else if(firstArrayIndex<n){
				resultArray[index] = firstSortedArray[firstArrayIndex];
				firstArrayIndex++;
			}
		}
		
		for(int x=0;x<m+n;x++){
			System.out.print(resultArray[x]+" ");
		}
			
        

    }


}
