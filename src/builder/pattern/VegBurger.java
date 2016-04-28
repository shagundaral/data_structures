package builder.pattern;

public class VegBurger extends Burger {

	@Override
	public String name() {
		return "cheese burger";
	}

	@Override
	public float price() {
		return 120;
	}
	
	@Override
	public Packaging packing() {
		System.out.println("Veg burger packaging!");
		return super.packing();
	}

}
