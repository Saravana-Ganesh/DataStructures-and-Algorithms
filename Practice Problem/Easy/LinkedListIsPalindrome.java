package com.codewar;


public class LinkedListIsPalindrome<T> {
	/*
	 * Given a singly linked list of size N of integers.
	 * The task is to check if the given linked list is palindrome or not.
	 * Time Complexity: O(N):
	 * Auxialliary Space: O(1),(ie, we should not use the recursive stack space as well)
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
	int length() {
		Node temp = head;
		int i=0;
		while(temp!=null) {
			temp = temp.next;
			i++;
		}
		return i;
	}
	Node findMiddleNode(int midPoint) {
		int position = 1;
		Node temp = head;
		while(position<midPoint) {
			temp = temp.next;			
			++position;			
		}
		return temp;
	}
	Node changeNodeToReverseDirection(Node node) {
		Node current=node.next, previous=node,temp=node;
		while(temp!=null) {
			temp = current.next;
			current.next = previous;
			previous = current;
			current = temp;
		}
		return previous;
	}
	boolean isPalindrome() {
		int length = length();
		int midPoint = length%2==0?(length/2):(length/2)+1;
		Node middleNode = findMiddleNode(midPoint);
		Node tail = changeNodeToReverseDirection(middleNode);
		Node start = head;
		while(true) {			
			if(!start.data.equals(tail.data))
				return false;
			if(start==middleNode)
				break;
			start = start.next;
			tail = tail.next;
		}
		return true;
		
	}
	
	public static void main(String[] args) {
		LinkedListIsPalindrome<Integer> l = new LinkedListIsPalindrome<Integer>();
		for(int i=1;i<4;i++)
			l.add(i);
		for(int i=4;i>0;i--) {
			l.add(i);
		}			
		l.print();
		System.out.println(l.isPalindrome());
	}

}
