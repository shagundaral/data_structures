package com.trees;

public class TreeNode {
	
	private int value;
	private TreeNode left;
	private TreeNode right;
	private TreeNode p;
	
	
	public TreeNode(int i) {
		this.value = i;
		this.left = null;
		this.right = null;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}
	public TreeNode getP() {
		return p;
	}
	public void setP(TreeNode p) {
		if(null==this.p && p.getValue()>this.getValue()){
			this.p = p;
		}
	}

}
