package builder.pattern;

public class Bottle implements Packaging {

	@Override
	public String pack() {
		System.out.println("Plastic bottle requested");
		return "Bottle";
	}

}
