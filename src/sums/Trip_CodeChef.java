package sums;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * You are starting out on a long (really long) trip. On the way, there are N gas stations, the locations of which are given as a_1,a_2,...,a_N. Initially you are located at the gas station at a_1, and your destination is at location a_N. Your car can only store enough fuel to travel atmost M units without refilling. You can stop at any station and refill the car by any amount. Now you wish to plan your trip such that the number of intermediate stops needed to reach the destination is minimum, and also how many ways are there to plan your trip accordingly.
Input :

The first line two space seperated integers N and M. N lines follow, and the ith line has the value a_i (0 <= a_i <= 1000000000). The input will be such that a solution will always exist.
Output :

Output two space seperated integers : The least number of stops, and the number of ways to plan the trip which uses the least number of stops. Output this value modulo 1000000007.
Sample Input :

6 3
0
1
3
4
7
10
Sample Output :

3 2
Constraints :

2 <= N <= 1000000
1 <= M <= 1000
a_1 < a_2 < .. < a_N

 * @author MMT3760
 *
 */


public class Trip_CodeChef {
	
	
	static int m=3;
	static int[] stations = {};
	static int n = stations.length;
	
	public static void main(String[] args) {
		new Trip_CodeChef().run();
		
	}
	
	void run(){
		readInput();
		int minStops = getLeastNumberOfStops(0,1,0);
		System.out.print(minStops);
		System.out.print(" ");
		System.out.print(getNumberOfPathsWithMinStops(minStops)%1000000007);
		
	}
	

	private static void readInput() {
		BufferedReader r = new BufferedReader (new InputStreamReader(System.in));
		String s=null;
		try {

			String[] firstLine = r.readLine().split(" ");
			n = Integer.parseInt(firstLine[0]);
			m = Integer.parseInt(firstLine[1]);
			stations = new int[n];
			for(int i=0;i<n;i++){
				stations[i] = Integer.parseInt(r.readLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}

	private static int getNumberOfPathsWithMinStops(int minStops) {
		int ways=0;
		int stops = 0;
		for(int i=1;i<n;i++){
			int[] preArr = new int[i];
			for(int j=0;j<i;j++){
				preArr[j] = stations[j];
			}
			int pre = getLeastNumberOfStops_1(0, 1, 0, preArr);
			if(pre!=-1){
				int[] postArr = new int[n-i];
				for(int k=0, j=i;j<n; j++,k++){
					postArr[k] = stations[j];
				}
				int post = getLeastNumberOfStops_1(0, 1, 0, postArr);
				if(post!=-1){
					stops = pre+1+post;
					if(stops==minStops){
						ways+=1;
					}
				}
			}
		}
		return ways;
	}

	private static int getLeastNumberOfStops(int start, int current, int stops) {
		if(current==n-1){
			return stops;
		}
		else if(stations[current]-stations[start] < m){
			return getLeastNumberOfStops(start, current+1, stops);
		}else if(stations[current]-stations[start] == m){
			return getLeastNumberOfStops(current, current+1, stops+1);
		}else if(stations[current]-stations[start] > m && current-1 == start){
			return -1;
		}else if(stations[current]-stations[start] > m){
			return getLeastNumberOfStops(current-1, current, stops+1);
		}
		return 0;
	}

	
	private static int getLeastNumberOfStops_1(int start, int current, int stops, int[] arr) {
		int n=arr.length;
		if(n==1){
			return 0;
		}
		/*System.out.println(start+ " " +current+ " "+arr);
		for(int x:arr){
			System.out.print(x+" ");
		}
		System.out.println("");*/
		if(current==n-1){
			return stops;
		}
		else if(arr[current]-arr[start] < m){
			return getLeastNumberOfStops_1(start, current+1, stops, arr);
		}else if(arr[current]-arr[start] == m){
			return getLeastNumberOfStops_1(current, current+1, stops+1, arr);
		}else if(arr[current]-arr[start] > m && current-1 == start){
			return -1;
		}else if(arr[current]-arr[start] > m){
			return getLeastNumberOfStops_1(current-1, current, stops+1, arr);
		}
		return 0;
	}

	
	
}
