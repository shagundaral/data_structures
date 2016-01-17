package com.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import com.pojos.Father;
import com.pojos.Person;
import com.pojos.dumyobject;





public class ProcedureTester {
	
	
	
	public static void main(String[] args) {/*
		List<dumyobject> dummyList = new ArrayList<dumyobject>();
		dummyList = makeFunnyList(dummyList);
		for (dumyobject dumyobject : dummyList) {
			System.out.println(dumyobject.getCategory()+"__"+dumyobject.getPrice()+"__"+dumyobject.getMinPriceInCat());
		}
		System.out.println("****************************************************");
		Collections.sort(dummyList);
		for (dumyobject dumyobject : dummyList) {
			System.out.println(dumyobject.getCategory()+"__"+dumyobject.getPrice()+"__"+dumyobject.getMinPriceInCat());
		}
	*/
//		testHashMap();
//		testTreeMap();
		
		
//		testSynchronization();
		//testSet();
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(2, "a");
		map.put(6, "f");
		map.put(4, "b");
		map.put(0, "j");
		map.put(10, "t");
		map.put(20, "s");
		getSortedMap(map);
		
	}

	private static void testSynchronization() {
		Father father = new Father("puppa",60);
		Person p1 = new Person("person1", 12, 100,father);
		Person p2 = new Person("person2", 12, 100,father);
		Person p3 = new Person("person3", 12, 100,father);
		Person p4 = new Person("person2", 12, 100,father);
		Person p5 = new Person("person5", 12, 100,father);
		
		List<Person> list = new ArrayList<Person>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		Collections.sort(list);
		
		try {
			Person p6 = p5.clone();
			System.out.println(p6);
			p5.getInfather().setName("new p5 father");
			System.out.println(p6);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		testMethod(list);
//		System.out.println(list);
		
		/*
		p1.testThis();
		List<Person> people = new ArrayList<Person>();
		p2.testThis();
		p2.setFriend("new friend");
		p3.testThis();*/
		
		
	}

	private static void testMethod(List<Person> list) {
		
		List<Person> newList = list;
		Father father = new Father("dad",60);
		newList.add(0, new Person("person10", 12, 100,father));
//		System.out.println(list);
		
	}

	private static void testSet() {
		
		Set<Person> persons = new HashSet();
		
		Father father = new Father("puppa",60);
		persons.add(new Person("person1", 12, 100,father));
		persons.add(new Person("person1", 12, 100,father));
		persons.add(new Person("person1", 12, 100,father));
		
		Iterator itr = persons.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next().toString()+"");
		}
	}

	/**
	 * 
	 */
	private static void testHashMap() {
		Map<Person, String> personMap = new ConcurrentHashMap<Person, String>();
		Father father = new Father("puppa",60);
		Person p1 = new Person("person1", 12, 100,father);
		Person p2 = new Person("person2", 12, 100,father);
		Person p3 = new Person("person3", 12, 100,father);
		Person p4 = new Person("person2", 12, 100,father);
		Person p5 = new Person("person5", 12, 100,father);
		
		
		personMap.put(p1, "p1");
		personMap.put(p2, "p2");
		personMap.put(p3, "p3");
		personMap.put(p4, "p4");
		personMap.put(p5, "p5");
		
		father.setName("papa");
		//p1.setName("shagun");
		
		System.out.println(personMap.get(p1));
	}

	/**
	 * 
	 */
	private static void testTreeMap() {
		TreeMap<Person, String> testTree = new TreeMap<Person, String>(new CompareAge());
		
		Father father = new Father("puppa",60);
		Person p1 = new Person("person1", 15, 100,father);
		Person p2 = new Person("person2", 13, 100,father);
		Person p3 = new Person("person3", 14, 100,father);
		
		testTree.put(p1, "first");
		testTree.put(p2, "second");
		testTree.put(p3, "third");
		
		for (Person treeVal : testTree.keySet()) {
			System.out.println(treeVal.getName() + " :: " + testTree.get(treeVal));
		}
		
	}

	private static List<dumyobject> makeFunnyList(List<dumyobject> dummyList) {
		dumyobject d1 = new dumyobject();
		d1.setPrice(120);
		d1.setCategory("cat1");
		
		dumyobject d2 = new dumyobject();
		d2.setPrice(150);
		d2.setCategory("cat2");
		
		dumyobject d3 = new dumyobject();
		d3.setPrice(220);
		d3.setCategory("cat1");
		
		dumyobject d4 = new dumyobject();
		d4.setPrice(100);
		d4.setCategory("cat2");
		
		dumyobject d5 = new dumyobject();
		d5.setPrice(300);
		d5.setCategory("cat1");
		
		dummyList.add(d1);
		dummyList.add(d2);
		dummyList.add(d3);
		dummyList.add(d4);
		dummyList.add(d5);
		
		return dummyList;
	}
	
	public static ConcurrentHashMap<Integer, String> getSortedMap(HashMap<Integer, String> map){

		Set<Entry<Integer,String>>  entries =map.entrySet();
		List<Entry<Integer,String>> entryList = new ArrayList<Map.Entry<Integer,String>>(entries);
		Collections.sort(entryList,new Comparator<Entry<Integer,String>>() {

			@Override
			public int compare(Entry<Integer, String> o1,
					Entry<Integer, String> o2) {
				
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		
		for(Entry entry:entryList){
			System.out.println("Key"+entry.getKey() + "  Value "+entry.getValue());;
		}
		
		
		
		
		
		
		
		
		/**
		 * Thats how it should not be done.
		 * 
		 * for (Entry<Integer, String> entry : map.entrySet()) {
			System.out.println(entry.getKey()+" : "+entry.getValue());
			sortedMap.put(entry.getValue(), entry.getKey());
		}
		
		
		System.out.println("-----------------------------------------------------");
		ConcurrentHashMap<Integer, String> response = new ConcurrentHashMap<Integer, String>();
		for (Entry<String, Integer> e : sortedMap.entrySet()) {
			System.out.println(e.getKey()+" : "+e.getValue());
			response.put(e.getValue(), e.getKey());
		}*/
		return null;
		
	}
	

}
