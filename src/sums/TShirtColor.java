package sums;

/**
 * 
 * Ben believes a lot in tarot cards. He believes that they are lucky for him. He even decides to wear clothes according to the color predicted by a draw of a card. This irritates his wife, because sometimes he wears the same color t-shirt continuously if his cards so predict.

Now, his wife wants to go on a vacation with him, but she has a condition that she will only go if he wears a different color t-shirt on every day they are on a vacation. Ben really wants to please her, so he found out in advance the color predicted by his cards for the next 
N
N days. Now of these, he wants to find the longest vacation span he can get if he wears a different color t-shirt each day. Also, if there are multiple such occurrences of longest span, he wants to know the earliest such span because his wife will get angry is he delays for too long.

Input:

First line contains 
T
T which is the number of test cases.
Each test case contains 
2
2 lines. 

First line of every test case contains an integer 
N
N where 
N
N is the number of days.
Second line of every test case contains the 
N
N colors which indicate the color of the T-Shirt Ben wore on each day (1-indexed).

Output:

For each test case, output a line containing 
2
2 integers indicating the starting and ending day numbers of the largest span.


Sample Input(Plaintext Link)
2
5
1 2 3 4 5
6
1 2 1 3 1 5

Sample Output(Plaintext Link)
1 5
2 4

 * 
 * 
 * 
 * @author MMT3760
 *
 */
public class TShirtColor {
	
	static int[] dayColors = {1, 2, 1, 3, 1, 5};
	
	public static void main(String[] args) {
		
		int start = 0;
		//int end = dayColors[1];
		int maxWindow = 1;
		int min=dayColors[0];
		int max=dayColors[0];
		
		if(dayColors.length==1){
			System.out.println(maxWindow);
		}
		
		for(int end=1; end<dayColors.length; end++){
			
			if(!(dayColors[end] < min || dayColors[end] > max)){
				//new window
				for(int j=start; j<=end; j++){
					
				}
			}
			
			
			/*if(dayColors[end] <= dayColors[end-1] && dayColors[end] >= dayColors[start]){
				int currentWindow = (end-start);
				System.out.println(currentWindow);
				if(currentWindow > maxWindow){
					maxWindow = currentWindow;
				}
				for(int j=start;j<=end;j++){
					if(dayColors[j]==dayColors[end]){
						start = j+1;
						break;
					}
				}
			}
			System.out.println(maxWindow);*/
			
			
		}
		
	}

}
