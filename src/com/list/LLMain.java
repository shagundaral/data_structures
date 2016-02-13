package com.list;



import java.util.List;

import com.pojos.Node;

public class LLMain {
	
	public static void main(String[] args) {
		
		LinkedList<Node> testList = new LinkedList<Node>();
		for(int i=0;i<10;i++){
			Node n = new Node(i);
			testList.addNode(n);
		}
		testList.skipReversePattern(2,3);
		
		testList.printList();
/*		testList = testList.reverse(testList);
		testList.printList();
*/		
		
		List<String> strings;
	}

}
