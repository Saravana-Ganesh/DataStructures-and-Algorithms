package com.geeks.easy;
/* 
 *Given a Binary Tree. Check whether it is a Sum Tree or not.
 *	Time Complexity: O(N)
	Auxiliary Space: O(Height of the Tree)
	
 *A Binary Tree is a Sum Tree in which value of each node x is equal to sum of nodes 
  present in its left subtree and right subtree.
  
 *An empty tree is also a Sum Tree as sum of an empty tree can be considered to be 0.
  
  A leaf node is also considered as a Sum Tree.
 */
public class SumTree {
	Node head;
	boolean traverse = true;
	class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}
	private void createTree() {
		head = new Node(26);
		head.left = new Node(10);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(6);
		head.right.right = new Node(3);
	}
	boolean isSumTree(Node root)
	{
		callRecursive(root);
		return traverse;
	}
	private int callRecursive(Node node) {
		if(node!=null && traverse) {
			int ltValue=0, rtValue=0;
			if(node.left!=null)
				ltValue = callRecursive(node.left);
			if(node.right!=null)
				rtValue = callRecursive(node.right);
			if((ltValue!=0 || rtValue!=0) && (node.data!=ltValue+rtValue))
				traverse = false;
			return node.data+ltValue+rtValue;
		}
		return 0;
	}
	public static void main(String[] args) {
		SumTree sumTree = new SumTree();
		sumTree.createTree();
		System.out.println(sumTree.isSumTree(sumTree.head));
	}
	

}
