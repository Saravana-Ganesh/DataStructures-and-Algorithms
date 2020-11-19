package com.datastructures;

public class BinarySearchTree {
	Node root;
	static int i=0;
	public class Node{
		int data;
		Node left;
		Node right;
	}
	public Node insert(int data,Node node) {
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
		++i;
		if(node!=null) {
			if(node.left!=null)
				printTreeAsc(node.left);
			System.out.println(node.data);
			if(node.right!=null)
				printTreeAsc(node.right);
		}
	}
	public void printTreedesc(Node node) {
		++i;
		if(node!=null) {			
			if(node.right!=null)
				printTreedesc(node.right);
			System.out.println(node.data);
			if(node.left!=null)
				printTreedesc(node.left);
		}
	}
	public boolean search(int ele) {
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
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();		
		bst.root = bst.insert(5,bst.root);
		bst.insert(1000, bst.root);
		bst.insert(2000, bst.root);
		bst.insert(1500, bst.root);
		bst.insert(987, bst.root);
		bst.insert(950, bst.root);
		bst.insert(1111, bst.root);
		bst.insert(4, bst.root);
		bst.insert(1, bst.root);
		bst.insert(3, bst.root);
		bst.insert(2, bst.root);
		bst.insert(6, bst.root);
		bst.insert(8, bst.root);
		bst.insert(7, bst.root);
		bst.insert(9, bst.root);
		bst.insert(100, bst.root);
		bst.insert(11, bst.root);
		bst.insert(19, bst.root);
		bst.insert(94, bst.root);
		bst.insert(93, bst.root);
		bst.printTreeAsc(bst.root);
		System.out.println("\ni="+i);
		i=0;
		bst.printTreedesc(bst.root);
		System.out.println("\ni="+i);
		for(int i=0;i<100;i++) {
			System.out.println(i+" is "+bst.search(i));
		}
	}
}

