package templateDP;

import java.util.Collections;

public class OrderingCounter {

	public static void main(String[] args) {
		BevarageMaker bm = new BevarageMaker(new Coffee());		
		bm.makeBevarage();
		BevarageMaker bm1 = new BevarageMaker(new Juice());
		bm1.makeBevarage();
		Collections.sort(null);
	}
	
}
