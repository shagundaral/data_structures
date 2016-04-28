package sums.gen;

public class Mic {
	
	public static void main(String[] args) {
		System.out.println(isPowerOf(4,2));//is 4 power of 2
	}

	private static boolean isPowerOf(int i, int j) {
		return j & j-1;
	}

	
	
}
