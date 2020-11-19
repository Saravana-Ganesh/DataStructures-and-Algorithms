package com.datastructures;

public class BST {
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
		BST bst = new BST();		
		bst.root = bst.insert(35,bst.root);
		bst.insert(20, bst.root);
		bst.insert(40, bst.root);
		bst.insert(15, bst.root);
		bst.insert(22, bst.root);
		bst.insert(36, bst.root);
		bst.insert(53, bst.root);
		bst.insert(7, bst.root);
		bst.insert(6, bst.root);
		bst.insert(9, bst.root);
		/*bst.insert(10, bst.root);
		bst.insert(39, bst.root);
		bst.insert(52, bst.root);
		bst.insert(51, bst.root);
		bst.insert(50, bst.root);
		bst.insert(49, bst.root);
		bst.insert(48, bst.root);*/
		//bst.printTreeAsc(bst.root);
		System.out.println(bst.findLongestPath(bst.root));
	}

}
