package builder.pattern;

public class NonVegBurger extends Burger {

	@Override
	public String name() {
		System.out.println("NonVegBurger name");
		return "Chicken burger";
	}

	@Override
	public float price() {
		return 150;
	}

}
