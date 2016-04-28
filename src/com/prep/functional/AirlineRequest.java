package com.prep.functional;

public class AirlineRequest {
	
	public String fromCity ;
	public String toCity ;
	public String date;
	
	public String airline;

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

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	@Override
	public String toString() {
		return "AirlineRequest [fromCity=" + fromCity + ", toCity=" + toCity
				+ ", date=" + date + ", airline=" + airline + "]";
	}
	

}
