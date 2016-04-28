package sums;

import java.util.ArrayList;
import java.util.List;

public class BB {

	static int[] binaryArray = {1,1,0,0,1,1,1,0,1,1};
	static int arraySize = 4;
	
	
	public static void main(String[] args) {
		//finding number of co-primes of N from 1 to N 
		int[] A = {1,3};
		int[] B = coprimeCount(A);
		for(int i=0;i<B.length;i++){
			System.out.println(B[i]);
		}
		//friend circle question
		String[] friends = {"YYNN","YYYN","NYYN","NNNY"};
		System.out.println(friendCircles(friends));
	}
	
	
	static int friendCircles(String[] friends) {
		int numOfPeople = 0;
		List<List<Integer>> circles = new ArrayList<List<Integer>>();
		int numOfFriendsIncluded = 0;
		int studentIndex = 0;
        for(int i =0; i<friends.length; i++){
            char[] row = friends[0].toCharArray();
            numOfPeople = row.length;
            boolean exists = false;
            for (int j = 0;j<numOfPeople;j++) {//me
            	
            		boolean amIInCircle = false;
                	if(row[j]=='Y' && j!=i){
                		exists = true;
                		//check if j is in any circle
                		for(List<Integer> oneCircle : circles){
                			for(int x : oneCircle){
                				if(x==j){
                					//found a circle
                					amIInCircle = true;
                					oneCircle.add(i);
                				}
                			}
                		}
                	}
                	if(!amIInCircle){
                		//create new circle and add i and j
                		numOfFriendsIncluded += 2;
                		List<Integer> newCircle = new ArrayList<Integer>();
                		newCircle.add(i);
                		newCircle.add(j);
                		circles.add(newCircle);
                		
                	}
                	if(!exists){
                		//make new circle with just me
                		numOfFriendsIncluded += 1;
                		List<Integer> newCircle = new ArrayList<Integer>();
                		newCircle.add(i);
                		circles.add(newCircle);
                	}
                
			}
            
        }
        
        return circles.size();

    }

	
	
	
	
	static int[] coprimeCount(int[] A) {
		
        int length = A.length;
        int[] B = new int[length];
        for(int i=0;i<length;i++){
            int currentA = A[i];
            int count = 1;
            boolean isEven = false;
            if(currentA%2==0){
            	isEven = true;
            }
            for(int j=2;j<currentA;j++){
            	if(!(isEven && j%2==0)){
	                if(gcd(currentA, j) == 1){
	                    count++;
	                }
            	}
            }
            B[i] = count;
        }
        return B;
    }

    static int gcd(int a, int b){
        if(b==0){
            return a;
        }else{
            return gcd(b,a%b);
        }
    }

	
}
