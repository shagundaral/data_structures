package com.prep.functional;

public class MMTReq {

	public String fromCity ;
	public String toCity ;
	public String date;
	
	
	public MMTReq(String fromCity, String toCity, String date) {
		super();
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.date = date;
	}
	public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public String getToCity() {
		return toCity;
	}
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
