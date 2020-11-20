package com.datastructures;

public class BinarySearchTree {
	Node root;
	int prevValue =  Integer.MIN_VALUE;
	boolean isBST = true;
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
	public void printTreeAsc(Node node) {
		//Print binary search tree in ascending order...
		if(node!=null) {
			if(node.left!=null)
				printTreeAsc(node.left);
			System.out.println(node.data);
			if(node.right!=null)
				printTreeAsc(node.right);
		}
	}
	public void printTreedesc(Node node) {
		//Print binary search tree in descending order...
		if(node!=null) {			
			if(node.right!=null)
				printTreedesc(node.right);
			System.out.println(node.data);
			if(node.left!=null)
				printTreedesc(node.left);
		}
	}
	public boolean search(int ele) {
		//Search an element in a binary tree
		Node node = this.root;
		while(true) {
			if(node.data==ele)
				return true;
			else if(node.data<ele && node.right!=null)
				node = node.right;	
			else if(node.data>ele && node.left!=null)
				node = node.left;
			else
				return false;			
		}
	}
	public int findLongestPath(Node node) {
		//Function to find the longest path in a binary tree
		int leftSide = 0,rightSide = 0;
		if(node.left!=null) {
			leftSide = findLongestPath(node.left);
			++leftSide;
		}
		if(node.right!=null) {
			rightSide = findLongestPath(node.right);
			++rightSide;
		}
		return max(leftSide,rightSide);		
	}
	public int max(int a,int b) {
		if(a>b)
			return a;
		else if(b>a)
			return b;
		return a;
	}
	public boolean isBinarySearchTree(Node node) {
		//Check whether the given tree is binary search tree or not
		if(node!=null && isBST) {
			if(node.left!=null)
				if(!isBinarySearchTree(node.left))
					return false;
			if(node.data>prevValue)
				prevValue = node.data;
			else
				return false;
			if(node.right!=null)
				return isBinarySearchTree(node.right);
		}
		return true;
	}
}

