package com.prep.functional;

import java.util.ArrayList;
import java.util.List;

public class Huge {
	
	interface Operation{
		int doOperation(int a, int b);
	}

	public static void main(String[] args) {
		
		List<Operation> operations = new ArrayList<Huge.Operation>();
		
		Operation multiply = (a,b) -> {return a*b;};
		Operation subtract = (a,b) -> {return a-b;};
		Operation add = (a,b) -> {return a+b;};
		Operation divide = (a,b) -> {return a/b;};
		
		operations.add(multiply);
		operations.add(add);
		operations.add(subtract);
		operations.add(divide);
		
		operations.stream().map(op -> {return op.doOperation(10, 2);}).forEach(System.out::println);
	}
}
