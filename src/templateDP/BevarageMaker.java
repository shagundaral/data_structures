package templateDP;


public class BevarageMaker{
	
	Bevarage beverage;
	
	public BevarageMaker(Bevarage b) {
		this.beverage = b;
	}
	
	void makeBevarage(){
		if(null!=beverage){
			this.preWork();
			beverage.addBevarage();
			this.postWork();
		}else{
			System.out.println("Please choose a beverage first!");
		}
	}

	/**
	 * 
	 */
	private void postWork() {
		System.out.println("Your beverage is ready!");
	}

	/**
	 * 
	 */
	private void preWork() {
		System.out.println("Prepare for beverage");
	}

}
