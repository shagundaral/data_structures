package com.trees;

public class QueueNode {
	
	public QueueNode(TreeNode node, boolean marker) {
		super();
		this.node = node;
		this.marker = marker;
	}
	
	private TreeNode node;
	private boolean marker;
	
	
	
	public TreeNode getNode() {
		return node;
	}
	public void setNode(TreeNode node) {
		this.node = node;
	}
	public boolean isMarker() {
		return marker;
	}
	public void setMarker(boolean marker) {
		this.marker = marker;
	}

}
