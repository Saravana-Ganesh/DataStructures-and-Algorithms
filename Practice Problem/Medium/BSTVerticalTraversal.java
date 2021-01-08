package com.geeks.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;
/*
 * Vertical Traversal of Binary Tree 
 * Time Complexity: O(N).
 * Auxiliary Space: O(N).
 */
public class BSTVerticalTraversal {
	static TreeMap<Integer,ArrayList<Integer>> treeMap;	
	Node root;
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
	static ArrayList <Integer> verticalOrder(Node root)
    {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		if(root!=null) {			
			treeMap = new TreeMap<Integer,ArrayList<Integer>>();
			
			BSTVerticalTraversal.levelOrder(root,0);
			for(ArrayList<Integer> l1 : treeMap.values()) {
				arrayList.addAll(l1);
			}
			return arrayList;
		}		
		return arrayList;
    }
	static void levelOrder(Node node,int current) {
		class QueueObj{
			int pos;
			Node node;
			QueueObj(int pos,Node node){
				this.pos = pos;
				this.node = node;
			}
		}
		Queue<QueueObj> queue = new LinkedList<QueueObj>();
		QueueObj qObj = new QueueObj(1,node);
		queue.add(qObj);
		while(!queue.isEmpty()) {
			qObj = queue.remove();
			addHashTable(qObj.pos,qObj.node.data);
			if(qObj.node.left!=null)
				queue.add(new QueueObj(qObj.pos-1, qObj.node.left));
			if(qObj.node.right!=null)
				queue.add(new QueueObj(qObj.pos+1,qObj.node.right));
		}
	}
	static void addHashTable(int key,int data) {
		ArrayList<Integer> l;
		if(treeMap.get(key)==null) {
			l = new ArrayList<Integer>();
			l.add(data);
			treeMap.put(key,l);
		}else {
			l = treeMap.get(key);
			l.add(data);
			treeMap.put(key, l);
		}
	}
	public static void main(String[] args) {
		int a[] = {10,5,30,20,40,15,25};
		BSTVerticalTraversal bst = new BSTVerticalTraversal();
		bst.root = bst.insert(a[0],null);
		for(int i=1;i<a.length;i++) {
			bst.insert(a[i], bst.root);
		}
		System.out.println(BSTVerticalTraversal.verticalOrder(bst.root));

	}

}
