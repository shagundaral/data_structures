package sums;


/**
 * 
 * @author MMT3760
 *
 */
public class FlipZeroSum {

	static int[] binaryArray = {1,1,0,0,1,1,1,0,1,1};
	
	
	public static void main(String[] args) {
		System.out.println(maxConsecutiveOnes(0));
	}
	
	private static int maxConsecutiveOnes(int x){
		int start=0,end=0,max=0,xExhausted=x,arraySize=binaryArray.length;
		
		for(int i=0; i<arraySize; i++){
			if(binaryArray[i]==1){
				end+=1;
			}else{
				if(xExhausted==0){
					if(end-start>max){
						max=end-start;
					}else{
						start=i;
						end=i;
					}
				}else{
					end++;
					xExhausted--;
				}
			}
		}
		if(max==0){
			max=end-start;
		}
		return max;
	}
	
}
