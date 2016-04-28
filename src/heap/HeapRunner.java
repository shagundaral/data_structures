package heap;

import heap.MyHeap.HeapType;

public class HeapRunner {
	
	public static void main(String[] args) {
		MyHeap myHeap = new MyHeap(HeapType.MAX);
		myHeap.newInsert(1);
		myHeap.newInsert(2);
		myHeap.newInsert(3);
		myHeap.newInsert(4);
		
	}

}
