package com.datastructures;

public class InOrderSuccessorBST {
	/*
	 * Time Complexity:
	 * 		O(h) 
	 * 		where h is the height of binary tree
	 * Space Complexity:
	 * 		O(1)
	 * There are two cases for In-order successor
	 * 		case 1:
	 *			When the current node contains right child.
	 *		case 2:
	 *			When the current node does not contains right child.
	 */
	Node root;
	class Node{
		int data;
		Node left;
		Node right;
	}
	public Node findInorderSucessor(Node current) {
		if(current.right!=null)// refer case 1
			return current.right;
		else {                 // refer case 2
			Node ancestor = null;
			Node temp = root;
			while(temp!=null) {
				if(temp.data>current.data) {
					ancestor = temp;
					temp = temp.left;
				}else
					temp = temp.right;
			}
			return ancestor;
		}
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
	public Node findNode(int data) {
		Node temp = root;
		while(temp!=null) {
			if(temp.data>data)
				temp = temp.left;
			else if(temp.data<data)
				temp = temp.right;
			else
				return temp;
		}
		return null;
	}
	
	public static void main(String[] args) {
		int arr[] = {4,16,3,7,14,20,6,11,13,15,17,22,10,9,8,18};
		InOrderSuccessorBST bst = new InOrderSuccessorBST();
		bst.root = bst.insert(12, null);
		for(int i:arr) {
			bst.insert(i,bst.root);
		}
		Node current = bst.findNode(3);
		if(current!=null) {
			if(bst.findInorderSucessor(current)!=null)
				System.out.println("Sucessor is "+bst.findInorderSucessor(current).data);
			else
				System.out.println("No successor found for "+current.data);
		}else {
			System.out.println("Element not found");
		}
	}

}
