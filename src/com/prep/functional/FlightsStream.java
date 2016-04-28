package com.prep.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlightsStream {
	
	static List<String>  response = new ArrayList<String>();
	
	public static void main(String[] args) {
		MMTReq mmtReq = new MMTReq("DEL","BOM","2016-03-23");
		String[] airlines ={"6E","SG","G8","AI"};
		List<String> alList = Arrays.asList(airlines);
		
		alList.stream().map(s->{
			return FlightsStream.getAirLineRequest(s, mmtReq);
		}).flatMap(alReq->{
			List<String> flights = new ArrayList<String>();
			for(int i=0;i<3;i++){
				flights.add(alReq.getAirline() +"_"+i);
			}
			return flights.stream();
		}).
		forEach(FlightsStream::aggregate);
		
		
		
		
		for(String flt:response){
			System.out.println(flt);
		}
		
	}
	
	
	
	
	public static AirlineRequest getAirLineRequest(String airline,MMTReq req){
		AirlineRequest alReq =  new AirlineRequest();
		alReq.setAirline(airline);
		alReq.setFromCity(req.getFromCity());
		alReq.setToCity(req.getToCity());
		alReq.setDate(req.getDate());
		
		
		return alReq;
	}

	public static void aggregate(String flt){
		response.add(flt);
	}
	
	
}
