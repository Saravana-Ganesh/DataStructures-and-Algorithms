package com.datastructures;

import java.util.ArrayList;
import java.util.List;
/*
 * For deletion in tree we have 3 cases
 * case 1:
 * 		deletion at leaf node
 * case 2:
 * 		deletion of node with only one child
 * case 3:
 * 		deletion of node having two children.
 * Time complexity:
 * 		 In best case O(log n)
 * 		 In worst case O(n)
 * Space complexity:
 *       O(1) in both best and worst cases.
 */
public class DeleteNodeInBST {
	Node root;
	public class Node{
		int data;
		Node left;
		Node right;
	}
	public List<Node> search(int ele) {
		List<Node> l= new ArrayList<Node>();
		//Search an element in a binary tree
		Node node = this.root;
		Node parentNode = null;
		while(true) {
			if(node.data==ele)
				break;
			else if(node.data<ele && node.right!=null) {
				parentNode = node;
				node = node.right;	
			}
			else if(node.data>ele && node.left!=null) {
				parentNode = node;
				node = node.left;
			}
			else
				return null;
		}
		l.add(node);
		l.add(parentNode);
		return l;
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
	public void deleteNode(int data) {
		List <Node> l = search(data);
		if(l==null) {
			System.out.println("\nElement "+data+" not present in the tree");
			return;
		}else {			
			Node node = l.get(0);	
			Node parentNode = l.get(1);	
			if(node.left==null && node.right==null){//refer case 1
				if(parentNode.left==node)
					parentNode.left = null;
				else if(parentNode.right==node)
					parentNode.right = null;
			}else if(node.left!=null && node.right==null) {//refer case 2
				if(parentNode==null)
					root = root.left;
				else if(parentNode.right==node) {
					parentNode.right = node.left;
				}else if(parentNode.left==node) {
					parentNode.left = node.left;
				}
			}else if(node.right!=null && node.left==null) {//refer case 1
				if(parentNode==null)
					root = root.right;
				else if(parentNode.right==node) {
					parentNode.right = node.right;
				}else if(parentNode.left==node) {
					parentNode.left = node.right;
				}
			}else {//refer case 3
					Node temp = greatestElement(node.left);
					if(temp==null) {
						temp = node.left;
						node.data = temp.data;
						node.left = temp.left;
					}else {
						node.data = temp.right.data;
						temp.right = temp.right.left;
					}
				}				
			}
			System.out.println();
			//printTreeAsc(root);		
	}
	public Node greatestElement(Node node) {
		if(node.right==null)
			return null;
		while(node.right.right!=null) {
			node = node.right;
		}
		return node;
	}
	public void printTreeAsc(Node node) {
		//Print binary search tree in ascending order...
		if(node!=null) {
			if(node.left!=null)
				printTreeAsc(node.left);
			System.out.print(" "+node.data);
			if(node.right!=null)
				printTreeAsc(node.right);
		}
	}
	public static void main(String[] args) {
		DeleteNodeInBST bst = new DeleteNodeInBST();
		int a[] = {4,16,3,7,14,20,6,11,13,15,17,22,10,9,8,18};
		bst.root = bst.insert(12,null); 
		for(int value:a) {
			bst.insert(value,bst.root);
		}
		bst.printTreeAsc(bst.root);
		for(int i=11;i<30;i++) {
			bst.deleteNode(i);
		}
		bst.printTreeAsc(bst.root);
	}

}
