package heap;

import java.util.LinkedList;
import java.util.Queue;


public class MyHeap {

	public enum HeapType{
		MIN,
		MAX
	}
	
	HeapNode head;
	HeapType heapType;
	
	public MyHeap(HeapType heapType) {
		this.heapType = heapType;
	}
	
	public void insert(int value){
		if(null==head){
			head = new HeapNode(value, null);
		}else{
			//iterate to find appropriate position to add
			locateAndAdd(head, value);
			//addNode(head, value);
		}
	}
	
	Queue<HeapNode> queueForLocation = new LinkedList<HeapNode>();
	
	private void locateAndAdd(HeapNode node, int value) {
		if(node.left == null || node.right == null){
			addNode(node, value);
		}else{
			queueForLocation.add(node.left);
			if(null!=node.right){
				queueForLocation.add(node.right);
			}
			HeapNode nodeToCheck = queueForLocation.poll();
			locateAndAdd(nodeToCheck, value);
		}
		
	}

	void heapify(HeapNode node){
		if(heapType==HeapType.MAX){
			/**
			 * if node.val > node.parent.val :: swap
			 * else return;
			 */
			if(null!=node.parent){
				if(node.val > node.parent.val){
					swap(node);
					heapify(node.parent);
				}else{
					return;
				}
			}
		}else{
			if(null!=node.parent){
				if(node.val < node.parent.val){
					//swap
					swap(node);
					heapify(node.parent);
				}else{
					return;
				}
			}
		}
	}

	/**
	 * @param node
	 */
	private void swap(HeapNode node) {
		int temp = node.val;
		node.val = node.parent.val;
		node.parent.val = temp;
	}

	private void addNode(HeapNode node, int value) {
		if(node.left == null){
			node.left = new HeapNode(value, node);
			heapify(node.left);
		}else{
			//put in right
			node.right = new HeapNode(value, node);
			heapify(node.right);
		}
		
	}
	
	public int peek(){
		int x = -1;
		/*if(null==head){
			return x;
		}else{
			if(null==head.left && null==head.right){
				x = head.val;
				head = null;
				return x;
				
			}else{
				if(null==head.right && null!=head.left){
					x = head.val;
					head = head.left;
					removeNode(head.left);
				}else if(null!=head.right && null==head.left){
					x = head.val;
					head = head.right;
					removeNode(head.right);
				}
			}
		}*/
		
		
		
		
		return x;
	}
	
	public int poll(){
		if(null==head){
			return -1;
		}
		return head.val;
	}
	
	private HeapNode lastParent;
	
	public void newInsert(int v){
		if(null==head){
			HeapNode head1 = new HeapNode(v, null);
			head = head1;
			lastParent = head;
		}else{
			if(null!=lastParent){
				if(null==lastParent.left){
					lastParent.left = new HeapNode(v, lastParent);
					heapify(lastParent);
				}else if(null==lastParent.right){
					lastParent.right = new HeapNode(v, lastParent);
					lastParent = lastParent.parent;
				}else if(null!=lastParent.right){
					lastParent = lastParent.right;
					newInsert(v);
				}
			}
		}
	}
	
}
