package com.list;

import java.util.Iterator;
import java.util.List;

import com.pojos.Node;

public class LinkedList<T> implements Iterable<T>{
	
	private T t;
	
	private Node head;
	private int length=0;
	
	
	
	public void addNode(Node i){
		if(null==head){
			head = i;
		}else{
			Node tempNode = this.head;
			while(null!=tempNode.getNext()){
				tempNode = tempNode.getNext();
			}
			tempNode.setNext(i);
		}
		length++;
	}
	
	public void printList(){
		
		if(null!=this.head){
			Node tempNode = this.head;
			while(null != tempNode){
				System.out.print(tempNode.getValue()+" - ");
				tempNode = tempNode.getNext();
			}
//			System.out.println(tempNode.getValue());
		}
		
	}
	
	public int getIndexOf(T i){
		
		int index = 0;
		if(null != this.head){
			Node tempNode = this.head;
			while(null!=tempNode){
				if(tempNode.getValue().equals(i)){
					return index;
				}
				index++;
				tempNode = tempNode.getNext();
			}
			
		}
		return -1;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public void skipReversePattern(int skip, int reverse) {
		
		if(null!=this.head){
			/*Node pointer1 = this.head;
			Node pointer2 = this.head;
			LinkedList<T> responseList = new LinkedList<T>();*/
			for(int i=0;i<this.length+skip+reverse;i+=skip+reverse){printList();
				skipReverseList(this, skip, reverse, i);
			}
		}
		
		
	}

	private void skipReverseList(LinkedList<T> linkedList, int skip,
			int reverse, int i) {
		
		int x = 0;
		Node n = head;
		while(x < i+skip-1){
			n = n.getNext();
			x += 1;
		}
		Node reverseIndex = n;
		while(x < i+skip){
			reverseIndex = reverseIndex.getNext();
			x += 1;
		}
		LinkedList<T> localReversedList = new LinkedList<T>();
		localReversedList = getReversedList(reverseIndex, reverse);
		Node temp = n.getNext();
		x=0;
		while(x < reverse){
			temp = temp.getNext();
			x += 1;
		}
		n.setNext(localReversedList.head);
		while(null != n.getNext()){
			n = n.getNext();
		}
		n.setNext(temp);
		
		
	}

	private LinkedList<T> getReversedList(Node reverseIndex, int reverse) {
		
		LinkedList<Integer> reversedList = new LinkedList<Integer>();
		Node k = this.head;
		Integer i=0;
		/*reversedList.head = k;
		
		while(!reversedList.head.getValue().equals(reverseIndex) && null != reversedList.head){
			reversedList.head = reversedList.head.getNext();
		}
		Node temp = reversedList.head;
		while(null != reversedList.head && i < reverse){
			temp = temp.getNext();
		}
		temp.setNext(null);
		
		*/
		
		
		while(i <= (Integer)reverseIndex.getValue()){
			reversedList.addNode(new Node(0));
			i += 1;
		}
		return (LinkedList<T>) reversedList;
	}
	
	
	public LinkedList<Node> reverse(LinkedList<Node> list){
		
		Node first = list.head;
		
		if(null != first.getNext()){
			Node second = first.getNext();
			first.setNext(null);
			if(null==second.getNext()){
				list.head = second;
				second.setNext(first);
			}else{
				Node third = second.getNext();
				while(third != null){
					list.head = second;
					second.setNext(first);
					second = third;
					first = list.head;
					third = third.getNext();
				}
			}
		}
		
		return list;
	}
	
	

	@Override
	public Iterator<T> iterator() {
		
		
		return new Iterator<T>() {

			private Node iteratePoint = head;
			
			@Override
			public boolean hasNext() {
				if(null!=iteratePoint){
					if(null!=iteratePoint.getNext()){
						return true;
					}
				}else {
					throw new NullPointerException();
				}
				return false;
			}

			@Override
			public T next() {
				return (T)iteratePoint.getNext();
			}

			@Override
			public void remove() {
				
				if(iteratePoint.getNext() == null){
					iteratePoint = null;
				}else{
					throw new IllegalStateException();
				}
				
			}
			
		};
	}
	
	
	/*public LinkedList<Integer> reverseMyList(LinkedList<Integer> inputList){
		
		
		if(inputList == null || inputList.length < 2){
			return inputList;
		}
		if (inputList.length == 2){
			inputList.head.getNext()
		}
		
		Integer i = inputList.get(0);
		Integer j = inputList.get(1);
		Integer k = inputList.get(2);
		
		
		return inputList;
	}*/
	

}
