package com.pojos;

public class dumyobject implements Comparable<dumyobject>{
	
	private int price;
	private String category;
	private int minPriceInCat;
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getMinPriceInCat() {
		return minPriceInCat;
	}
	public void setMinPriceInCat(int minPriceInCat) {
		this.minPriceInCat = minPriceInCat;
	}
	@Override
	public int compareTo(dumyobject arg0) {
		if(minPriceInCat == 0){
			this.minPriceInCat = price;
		}
		if(arg0.getMinPriceInCat()==0){
			arg0.setMinPriceInCat(arg0.getPrice());
		}
		if(category.equalsIgnoreCase(arg0.getCategory())){
			minPriceInCat = Math.min(arg0.getPrice(), price);
			this.setMinPriceInCat(minPriceInCat);
			arg0.setMinPriceInCat(minPriceInCat);
		}
		if(null!=arg0){
			if(price > arg0.getPrice()){
				return 1;
			}else if (price == arg0.getPrice()){
				return 0;
			}else{
				return -1;
			}
		}
		return -1;
	}
	
	

}
