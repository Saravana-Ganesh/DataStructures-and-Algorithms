package com.codewar;

public class LinkedListNnodeFromEnd<T> {
	/*
	 * Given a linked list consisting of L nodes and given a number N.
	 * The task is to find the Nth node from the end of the linked list.
	 * Input:
			N = 2
			LinkedList: 1->2->3->4->5->6->7->8->9
			Output: 8
			Explanation: In the first example, there
			are 9 nodes in linked list and we need
			to find 2nd node from end. 2nd node
			from end is 8.  
	 */
	Node head;
	class Node{
		T data;
		Node next;
	}
	void add(T data) {
		if(head==null) {
			head = new Node();
			head.data = data;
			head.next = null;
		}else {
			Node temp = head;
			while(temp.next!=null) {
				temp = temp.next;
			}
			temp.next = new Node();
			temp.next.data = data;
			temp.next.next = null;
		}
	}
	void printList() {
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	int nthNodeFromListEnd(int n) {
		if(head==null)
			return -1;
		Node node1,node2;
		node1=node2=head;
		int i=1;
		while(node2.next!=null && i<n) {
			node2 = node2.next;
			i++;
		}
		if(i<n)
			return -1;
		else {
			while(node2.next!=null) {
				node2 = node2.next;
				node1 = node1.next;
			}
			return (Integer) node1.data;
		}		
	}
	public static void main(String[] args) {
		LinkedListNnodeFromEnd<Integer> l = new LinkedListNnodeFromEnd<Integer>();
		for(int i=1;i<5;i++)
			l.add(i);
		l.printList();
		System.out.println();
		System.out.println(l.nthNodeFromListEnd(5));
	}

}
