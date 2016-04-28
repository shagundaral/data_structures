package com.prep.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Streams {

	public static void main(String[] args) {
		Integer[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		List<Integer> numbList = new ArrayList<Integer>();
		numbList.addAll(Arrays.asList(numbers));
		Calculator calc = (i,k) -> {
			i = k * 100;
			i = (int) Math.pow(i, 2);
			return i * 5;};
			
		numbList.stream().map(i->calc.doMathematicalShit(i,i+1)).forEach(System.out::println);
		
		

		/*List<String> names = new ArrayList<String>();
		names.add("Shagun");
		names.add("Gaurav");
		names.add("Gauri");
		names.add("Shaggy");
		names.add("Kunal");
		names.add("Sachin");*/

		/*
		 * numbList.stream(). sorted(). map( s -> s*5). filter(s->s%2==0).
		 * forEach(System.out::println);
		 */

		/*names.stream().filter(s -> {
			//System.out.println("filter " + s);
			return s.length() > 0;
		}).map(s -> {
			//System.out.println("map " + s);
			return Streams.append(s, " Daral ");
		}).map(s -> {
			return Streams.append(s, " gv");
		}).
*/
		//forEach(System.out::println);

	}

	public static String append(String base, String suffix) {
		return base + " " + suffix;
	}

}
