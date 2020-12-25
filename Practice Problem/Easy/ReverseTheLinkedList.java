package com.codewar;

public class ReverseTheLinkedList<T> {
	/*
	 * Given a linked list of N nodes. 
	 * The task is to reverse this list
	 * Time Complexity: O(N)
	 * Auxiliary Space: O(1).
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
	void print() {
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	void reverseLinkedList() {
		Node current=null,previous=null,temp=head;
		while(temp!=null) {
			current = temp;
			if(current==head) {
				temp = current.next;
				current.next = null;
				previous = current;
			}else {
				temp = current.next;
				current.next = previous;
				previous = current;				
			}
		}
		head = current;
		
	}
	
	
	public static void main(String[] args) {
		ReverseTheLinkedList<Integer> l = new ReverseTheLinkedList<Integer>();
		for(int i=1;i<11;i++)
			l.add(i);
		l.print();
		l.reverseLinkedList();
		System.out.println();
		l.print();
	}

}
