package com.datastructures;

public class BFS {
	Node root;
	static int i=0;
	Queue<Node> q = new Queue<Node>();
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
		if(node!=null) {
			if(node.left!=null)
				printTreeAsc(node.left);
			System.out.println(node.data);
			if(node.right!=null)
				printTreeAsc(node.right);
		}
	}
	public void breadthFirst(Node node) {
	    if(q.queueFront()==null && (node.left!=null || node.right!=null)) {
	    	q.enQueue(node);
	    }
	    if(q.queueFront()!=null) {
	    	node = q.deQueue();
		    System.out.print(" "+node.data);
		    if(node.left!=null)
		    	q.enQueue(node.left);
		    if(node.right!=null)
		    	q.enQueue(node.right);
		    breadthFirst(node);
	    }	    
	}
	public static void main(String[] args) {
		BFS bfs = new BFS();
		bfs.root = bfs.insert(6, bfs.root);
		bfs.insert(4,bfs.root);
		bfs.insert(8,bfs.root);
		bfs.insert(3,bfs.root);
		bfs.insert(5,bfs.root);
		bfs.insert(9,bfs.root);
		bfs.insert(7,bfs.root);
		bfs.printTreeAsc(bfs.root);
		bfs.breadthFirst(bfs.root);
	}

}
