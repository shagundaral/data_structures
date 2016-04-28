package edit.distance;

public class Runner {
	
	public static void main(String[] args) {
		String str1 = "sunday";
	    String str2 = "saturday";
	 
	    System.out.println(Utility.editDist( str1 , str2 , str1.length(), str2.length()));
	}

}
