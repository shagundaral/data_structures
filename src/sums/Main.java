package sums;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	
	public static void main(String[] args) {
		BufferedReader r = new BufferedReader (new InputStreamReader(System.in));
		try {
			int testCases = Integer.parseInt(r.readLine());
			for(int i=0;i<testCases;i++){
				String inputRow = r.readLine();
				int maxShyness =  Integer.parseInt(inputRow.split(" ")[0]);
				int[] shynessArray =  new int[maxShyness+1];
				char[] shynessCharAray = inputRow.split(" ")[1].toCharArray();
				for(int j=0;j<shynessCharAray.length;j++){
					shynessArray[j] = Integer.parseInt(shynessCharAray[j]+"");
				}
				
				int peopleStanding = 0;
				int peopleNeeded = 0;
				for(int k=0;k<=maxShyness;k++){
					if(k==0){
						peopleStanding = shynessArray[k];
					}else{
						if(peopleStanding >= k){
							peopleStanding+=shynessArray[k];
						}else{
							if(shynessArray[k]>0){
								peopleNeeded+=k-peopleStanding;
								peopleStanding+=peopleNeeded+shynessArray[k];
							}
						}
					}
				}
				System.out.println("Case #"+(i+1)+": "+peopleNeeded);
				
				
			}
			
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
