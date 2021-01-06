package com.datastructures;

public class BSTDiameter {
	/*
	 * Time Complexity: O(N).
	 * Space: O(Height of the Tree).
	 */
	Node root;
	int currentDiameter = -1;
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
	int diameterOfTree(Node node) {
		int a = 0,b = 0;
		if(node!=null) {
			if(node.left!=null) {
				a = diameterOfTree(node.left);
			}
			if(node.right!=null) {
				b = diameterOfTree(node.right);
			}
			currentDiameter = (a+b)>currentDiameter?(a+b):currentDiameter;
			return (a>b?a:b)+1;
		}
		return 0;
	}
	public static void main(String[] args) {
		BSTDiameter bst = new BSTDiameter();
		int a[] = {35,20,40,15,22,36,53,21,23,24,25,7,5,9,3,6,1,4};
		bst.root = bst.insert(a[0],null);
		for(int i=1;i<a.length;i++) {
			bst.insert(a[i], bst.root);
		}
		bst.diameterOfTree(bst.root);
		System.out.println(bst.currentDiameter);
	}

}
