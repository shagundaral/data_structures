package com.map;

import java.util.Comparator;

import com.pojos.Person;

public class CompareAge implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		
		/*if(o1.getAge() > o2.getAge()){
			return 1;
		}else if (o1.getAge() < o2.getAge()){
			return -1;
		}
		
		return 0;*/
		
		return Integer.valueOf(o1.getAge()).compareTo(Integer.valueOf(o2.getAge()));
	}

}
