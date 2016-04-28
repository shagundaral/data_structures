package com.trees;



public class TreeMain {
	
	public static void main(String[] args) {
		
		ShagunsTree tree = new ShagunsTree();
		/*tree.add(30);
		tree.add(19);
		tree.add(28);
		tree.add(25);
		
		tree.add(20);
		tree.add(23);
		tree.add(27);
		tree.add(29);
		tree.add(21);
		tree.add(22);
		tree.add(40);
		tree.add(38);
		tree.add(26);
		tree.add(41);
		tree.add(33);
		tree.add(39);
		tree.add(36);
		tree.add(35);
		tree.add(37);*/
		
		tree.add(10);
		tree.add(5);
		tree.add(4);
		tree.add(20);
		tree.add(12);
		tree.add(15);
		tree.add(22);
		tree.removeHalfNodeGv(tree.head,null);
		tree.inOrderTraversal();
		
//		System.out.println(tree.isBST());
		
		/*
		System.out.println(tree.hasPathSum(52));
		tree.getCountLevel_new();//print sum of node values by level
		tree.inOrderTraversal();//in order traversal
		tree.printRandom();//random is a pointer in every node that points to the next node by logical in order traversal
		tree.isPresent(2);//check if a node is present
		tree.deleteNode(2);//delete a node
		tree.mirror();//mirror a tree
		*/

	}


}

