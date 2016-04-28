package sums;



public class NumberLineSum {
	
	public static void main(String[] args) {
		
		System.out.println(canIReachXOnNL(11));
		
	}

	private static int canIReachXOnNL(int i) {
		
		if(i==0){
			return 0;
		}else{
			
			int[] arr = new int[1];
			arr[0] = 1;
			return checkNextLevel(arr, 1, Math.abs(i));
			
		}
		
	}
	
	static int checkNextLevel(int[] arr, int level, int valToComp){
		int[] nextLevel = new int[arr.length*2];
		int nextArrIndex = 0;
		for(int i=0;i<arr.length;i++){
			int left = arr[i]-(level+1);
			int right = arr[i]+(level+1);
			if(Math.abs(left)==valToComp || Math.abs(right)==valToComp){
				return (level+1);
			}else{
				nextLevel[nextArrIndex++] = left;
				nextLevel[nextArrIndex++] = right;
			}
		}
		return checkNextLevel(nextLevel, level+1, valToComp);
	}

}
