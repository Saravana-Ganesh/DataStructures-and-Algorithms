package com.codewar;

public class LeftViewOfBST{
	/*
	 * This program prints the left view of binary search tree. 
	 * This is based on preorder traversal.
	 * Time Complexity: O(N).
	 * Auxiliary Space: O(1).
	 */
	int visitedLevel = -1;
	Node root;
	public class Node{
		int data;
		Node left;
		Node right;
	}
	public Node insert(int data,Node node) {
		//Function to insert element in binary search tree......
		if(node==null) {
			node = new Node();
			node.data = data;
			node.left = node.right = null;
		}else if(node.data>data) {
			node.left = insert(data,node.left);
		}else if(node.data<data) {
			node.right = insert(data,node.right);
		}
		return node;
	}
	public void leftView(Node node,int currentLevel) {
		if(currentLevel>visitedLevel) {
			System.out.print(node.data+" ");
			++visitedLevel;
		}
		if(node.left!=null)
			leftView(node.left,currentLevel+1);
		if(node.right!=null)
			leftView(node.right, currentLevel+1);
	}
	public static void main(String[] args) {
		int arr[] = {15,10,30,5,11,20,35,14};
		LeftViewOfBST bst = new LeftViewOfBST();
		bst.root = bst.insert(arr[0],bst.root);
		for(int i=1;i<arr.length;i++)
			bst.insert(arr[i], bst.root);
		bst.leftView(bst.root, 0);
	}

}
