package heap;

public class HeapNode {
	
	int val;
	HeapNode parent;
	HeapNode left;
	HeapNode right;
	
	public HeapNode(int val, HeapNode parent) {
		this.val = val;
		this.parent = parent;
	}

}
