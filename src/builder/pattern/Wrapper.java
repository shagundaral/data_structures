package builder.pattern;

public class Wrapper implements Packaging{

	@Override
	public String pack() {
		System.out.println("Requested paper Wrapper");
		return "Foil";
	}

}
