package builder.pattern;

public abstract class Burger implements Item {


	@Override
	public Packaging packing() {
		System.out.println("Burger's packaging");
		return new Wrapper();
	}

}
