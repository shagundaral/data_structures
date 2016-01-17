package com.trees;

import java.util.LinkedList;
import java.util.Queue;

public class ShagunsTree {
	
	private static TreeNode head;
	
	public void add(int i){
		if(null==head){
			this.head = new TreeNode(i);
		}else{
			TreeNode tempNode = this.head;
			
			while(tempNode!=null){
				if(i<tempNode.getValue()){
					if(null == tempNode.getLeft()){
						tempNode.setLeft(new TreeNode(i));
						tempNode = null;
					}else{
						tempNode = tempNode.getLeft();
					}
				}else{
					if(null == tempNode.getRight()){
						tempNode.setRight(new TreeNode(i));
						tempNode = null;
					}else{
						tempNode = tempNode.getRight();
					}
				}
				
			}
			
		}
	}
	
	public void deleteNode(int i){
		
		deleteFromNode(i, head);
		
	}
	

	//TODO: if multiple i in tree
	
	private void deleteFromNode(int i, TreeNode node){
		
		if(null!=node){
			TreeNode temp = node;
			
			if(temp.getValue() == i){
				
				temp = node.getLeft();
				node = node.getRight();
				addTreeToTree(temp, node);
				
			} else if(i < temp.getValue()){
				
				deleteFromNode(i, temp.getLeft());
				
			}else{
				
				deleteFromNode(i, temp.getRight());
				
			}
		}
		
	}

	
	/**
	 * 
	 * add t1 to t2
	 * 
	 * @param t1
	 * @param t2
	 * @return
	 */
	public void addTreeToTree(TreeNode t1, TreeNode t2){
		
		if(null != t1 && null != t2){
			int val = t1.getValue();
			
			TreeNode tempNodePointer = t2;
			
			if(val == tempNodePointer.getValue()){
				
				TreeNode t = tempNodePointer.getRight();
				tempNodePointer.setRight(t1);
				addTreeToTree(t, tempNodePointer.getRight());
				
			}else if (val < tempNodePointer.getValue()){
				
				if(null == tempNodePointer.getLeft()){
					tempNodePointer.setLeft(t1);
				}else{
					addTreeToTree(t1, tempNodePointer.getLeft());
				}
				
			}else if (val > tempNodePointer.getValue()){
				
				if(null == tempNodePointer.getRight()){
					tempNodePointer.setRight(t1);
				}else{
					addTreeToTree(t1, tempNodePointer.getRight());
				}
			}
				
		}
		
	}
	
	
	public boolean isPresent(int i){
		
		if(this.head!=null){
			TreeNode tempNode = this.head;
			while(null!=tempNode){
				if(i == tempNode.getValue()){
					return true;
				}else if (i < tempNode.getValue()){
					tempNode = tempNode.getLeft();
				}else {
					tempNode = tempNode.getRight();
				}
			}
		}
		return false;
	}

	
	public int height(){
		
		int height = 0;
		TreeNode tn = this.head;
		if(null!=tn){
			height = getHeight(tn);
		}
		return height;
		
	}
	
	public int getHeight(TreeNode node){
		int height = 0;
		if(null != node && null == node.getLeft() && null == node.getRight()){
			height = 1;
		}else if(null != node){
			height = 1+Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
		}
		return height;
		
	}
	
	
	public ShagunsTree mirror(){
		ShagunsTree newTree = new ShagunsTree();
		
//		newTree.head = this.head;
		newTree.head = mirrorNode(this.head);
		
		return newTree;
	}

	private TreeNode mirrorNode(TreeNode head2) {
		if(null!=head2){
			
			TreeNode tempNode = mirrorNode(head2.getRight());
			head2.setRight(mirrorNode(head2.getLeft()));
			head2.setLeft(tempNode);
			
		}
		return head2;
	}
	
	
	public void inOrderTraversal(){
		
		TreeNode node = this.head;
		traverseInOrder(node);
		
		
	}

	private void traverseInOrder(TreeNode node) {
		
		if(null!=node){
			
			if(null != node.getLeft()){
				traverseInOrder(node.getLeft());
			}
			if(null != node.getRight()){
				if(null!=node.getP()){
					System.out.println(node.getValue()+" - "+ node.getP().getValue());
				}else{
					System.out.println(node.getValue());
				}
				traverseInOrder(node.getRight());
			}else{
				if(null!=node.getP()){
					System.out.println(node.getValue()+" - "+ node.getP().getValue());
				}else{
					System.out.println(node.getValue());
				}
			}
		}
		
	}
	
	public void setRef(){
		
		TreeNode node = this.head;
		generateP(node, node, node);
		
	}

	private TreeNode generateP(TreeNode node, TreeNode parent, TreeNode lastDisperse) {
		
		if(null!=node){
			
			if(null!=node.getRight()){
				node.setP(getLeftMostNode(node.getRight()));
				if(null == node.getRight().getRight()){
					node.getRight().setP(parent);
				}
				if(null!=node.getLeft()){
					generateP(node.getLeft(), node, lastDisperse);
				}else{
					generateP(node.getRight(), node, parent);
				}
			}else if(null == node.getRight()){
				if(null != parent.getRight() && node.getValue() == parent.getRight().getValue()){
					node.setP(lastDisperse);
				}else{ 
					node.setP(parent);
				}
				if(null!=node.getLeft()){
					generateP(node.getLeft(), node, lastDisperse);
				}
			}
			if(null!=node.getLeft() && null!=node.getLeft().getP()){
				generateP(node.getRight(), node, lastDisperse);
			}
		}
		return lastDisperse;
		
	}

	private TreeNode getLeftMostNode(TreeNode right) {
		if(null!=right){
			TreeNode leftMost = right;
			while(null!=leftMost.getLeft()){
				leftMost = leftMost.getLeft();
			}
			return leftMost;
		}
		return null;
	}
	
	public void printRandom(){
		
		TreeNode node = this.head;
		node = getLeftMostNode(node);
		while(null != node.getP()){
			System.out.println(node.getP().getValue());
			node = node.getP();
		}
	}

	public int[] getCountLevel(){
		
		int[] count = new int[getHeight(head)];
		if(null!=this.head){
			int N=2;
			int n=N;
			TreeNode currentNode = this.head;
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(currentNode);
//			count.add(currentNode.getValue());
//			int currentCountVal = 0;
			while(queue.size() > 0){
				
				if(queue.size()==1 && queue.element().equals(this.head)){
					currentNode = queue.remove();
					count[0] = currentNode.getValue();
				}
/*				if(n==0){
					N = 2*N;
					n=N;
					System.out.println(currentCountVal);
					//count.add(currentCountVal);
					currentCountVal = 0;
				}
*//*				if(n < 0){
					System.out.println("Oh shit!!");
				}*/
				/*if(null == currentNode.getLeft()){
					n -= 1;
				}else */
				if (null != currentNode.getLeft()){
				//	n -= 1;
				//	currentCountVal += currentNode.getLeft().getValue();
					System.out.println(currentNode.getLeft().getValue());
					count[getNodeLevel(currentNode.getLeft(), this.head, 0)] += currentNode.getLeft().getValue();
					queue.add(currentNode.getLeft());
				}
				if(null == currentNode.getRight()){
					currentNode = queue.remove();
//					n -= 1;
				}else if(null != currentNode.getRight()){
	//				currentCountVal += currentNode.getRight().getValue();
					System.out.println(currentNode.getRight().getValue());
					count[getNodeLevel(currentNode.getRight(), this.head, 0)] += currentNode.getRight().getValue();
					queue.add(currentNode.getRight());
		//			n -= 1;
					currentNode = queue.remove();
				}
				
			}
		}
		for(int i=0; i<count.length; i++){
			System.out.println(count[i]);
		}
		return count;
		
	}
	
	private int getNodeLevel(TreeNode node, TreeNode currentNode, int level){
		
		//TreeNode temp = this.head;
		if(node.equals(currentNode)){
			return level;
		}else if(node.getValue() < currentNode.getValue()){
			return getNodeLevel(node, currentNode.getLeft(), level++)+1;
		}else if(node.getValue() > currentNode.getValue()){
			return getNodeLevel(node, currentNode.getRight(), level++)+1;
		}
		return 0;
	}
	
	
	public int[] getCountLevel_new(){
		int[] count = new int[getHeight(head)];
		if(null!=this.head){
			int i = 0;
			TreeNode currentNode = this.head;
			Queue<QueueNode> queue = new LinkedList<QueueNode>();
			queue.add(new QueueNode(currentNode, false));
			queue.add(new QueueNode(null, true));
			while(queue.size() > 0 && i < count.length){
				
				QueueNode queueNode = queue.remove();
				if(!queueNode.isMarker()){
					//sum its value to count at i
					count[i] += queueNode.getNode().getValue();
					//add left and right node to queue, with right as marker
					if(null!=queueNode.getNode().getLeft()){
						queue.add(new QueueNode(queueNode.getNode().getLeft(), false));
					}
					if(null!=queueNode.getNode().getRight()){
						queue.add(new QueueNode(queueNode.getNode().getRight(), false));
					}
				}else{
					queue.add(new QueueNode(null, true));
					System.out.println(count[i]);
					i += 1;
				}
				
			}
		}/*
		for(int i=0; i<count.length; i++){
			System.out.println(count[i]);
		}*/
		return count;
		
	}

	
	public boolean isBST(){
		return isBST(head, head.getValue(), head.getValue());
	}
	
	private boolean isBST(TreeNode node, int min, int max) {
		if(node.getLeft() == null && node.getRight()==null){
			return true;
		}else {
			if(null!=node.getLeft()){
				if(node.getLeft().getValue() < min){
					if(null!=node.getRight()){
						if(node.getRight().getValue() > max){
							if(node.getValue()>max){
								max = node.getValue();
							}
							if(node.getValue()<min){
								min = node.getValue();
							}
							return (isBST(node.getRight(), min, max) && isBST(node.getLeft(), min, max));
						}else{
							return false;
						}
					}else{
						if(node.getValue()>max){
							max = node.getValue();
						}
						if(node.getValue()<min){
							min = node.getValue();
						}
						return isBST(node.getLeft(), min, max);
					}
				}else{
					return false;
				}
			}
			if(null!=node.getRight() && node.getRight().getValue() > node.getValue()){
				if(node.getValue()>max){
					max = node.getValue();
				}
				if(node.getValue()<min){
					min = node.getValue();
				}
				return isBST(node.getRight(), min, max);
			}
		}
		return false;
	}

	public boolean hasPathSum(int targetSum){
		return hasPathSum(head, targetSum);
	}
	
	public boolean hasPathSum(TreeNode node, int sum){
		if(node == null){
			return (sum == 0);
		}else{
			sum -= node.getValue();
			return (hasPathSum(node.getLeft(), sum) || hasPathSum(node.getRight(), sum));
		}
	}
	
	

	public boolean hasSum(int targetSum) {
		
		Queue<NodeSum> q = new LinkedList<NodeSum>();
		if(null != this.head){
			return hasSumFromNode(targetSum, head, head.getValue(), q);
		}
		
		return false;
	}
	
	public boolean hasSumFromNode(int targetSum, TreeNode currentNode, int sum, Queue<NodeSum> q){
		if(null != currentNode){
			//is leaf node
			if(null == currentNode.getLeft() && null == currentNode.getRight()){
				if(sum == targetSum){
					return true;
				}else if(null != q && !q.isEmpty()){
					NodeSum ns = q.poll();
					return hasSumFromNode(targetSum, ns.getNode(), ns.getSumTillNow(), q);
				}
			}else if (null != currentNode.getLeft()){
				if(null!=currentNode.getRight()){
					NodeSum ns = new NodeSum(sum+currentNode.getRight().getValue(), currentNode.getRight());
					q.add(ns);
				}
				return hasSumFromNode(targetSum, currentNode.getLeft(), sum+currentNode.getLeft().getValue(), q);
			}else if(null != currentNode.getRight()){
				return hasSumFromNode(targetSum, currentNode.getRight(), sum+currentNode.getRight().getValue(), q);
			}
			
		}
		return false;
	}
	
	
	
	public class NodeSum{
		
		public NodeSum(int sumTillNow, TreeNode node) {
			super();
			this.sumTillNow = sumTillNow;
			this.node = node;
		}
		
		private int sumTillNow;
		private TreeNode node;
		
		public int getSumTillNow() {
			return sumTillNow;
		}
		public void setSumTillNow(int sumTillNow) {
			this.sumTillNow = sumTillNow;
		}
		public TreeNode getNode() {
			return node;
		}
		public void setNode(TreeNode node) {
			this.node = node;
		}
		
		
		
	}
	
	
}
