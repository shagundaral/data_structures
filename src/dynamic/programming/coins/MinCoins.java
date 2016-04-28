package dynamic.programming.coins;

public class MinCoins {
	
	static int[] availableCoins = {1, 10, 25};
	static int LARGE_VAL = 99999;
	
	public static void main(String[] args) {
		System.out.println(minCoinReq(37));
	}
	
	private static int minFromAvailableArray(int x){
		int min = LARGE_VAL;
		for(int i=0;i<availableCoins.length;i++){
			if(availableCoins[i]==x){
				return 1;
			}else if (availableCoins[i]<x){
				if(x%availableCoins[i]==0){
					if(x/availableCoins[i]<min){
						min = x/availableCoins[i];
					}
				}
			}
		}
		return min;
	}
	
	static int minCoinReq(int v){
		int min = LARGE_VAL;
		if(v==0){
			return 0;
		}else{
			int previousMinCount = LARGE_VAL;
			int previousMinVal = 0;
			for(int i = 1; i <= v; i++){
				int levelMinVal = previousMinVal + availableCoins[0];//add minimum available coin to previous
				if(levelMinVal <= v){
					min = Math.min(++previousMinCount, Math.min(minFromAvailableArray(i), getMinFromGreedyCombination(i)));
					if(minFromAvailableArray(i) < previousMinCount){
						previousMinCount = min;
					}
					System.out.println(i + " - " +min);
				}
			}
		}
		return min;
	}
	
	static int getMinFromGreedyCombination(int x){
		//try if we can get min from combination from array
		int min = LARGE_VAL;
		if(x==1){
			return min;
		}
		/*int prevMinCount = 0;
		int prevMinVal = LARGE_VAL;
		int coinsPicked;
		for(int i=2; i<x; i++){
			for(int j=0; j<availableCoins.length; j++){
				
			}
		}*/
		int coinsPicked = 0;
		int sumRemaining = x;
		
		for(int i = availableCoins.length-1; i >= 0; i--){
			while(sumRemaining >= availableCoins[i]){
				coinsPicked++;
				sumRemaining = sumRemaining - availableCoins[i];
			}
		}
		if(coinsPicked>1 && sumRemaining == 0){
			min = coinsPicked;
		}
		return min;
	}


}
