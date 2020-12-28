package com.codewar;

public class LinkedListRotate<T> {
	/*
	 * Given a singly linked list of size N. 
	 * The task is to rotate the linked list counter-clockwise by k nodes, 
	 * where k is a given positive integer smaller than or equal to 
	 * length of the linked list.
	 * Input:
			value[] = {1,2,3,4,5,6,7,8}
			k = 4
			Output: 5 6 7 8 1 2 3 4
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
	int linkedListSize() {
		int size=0;
		Node temp = head;
		while(temp!=null) {
			++size;
			temp = temp.next;
		}
		return size;
		
	}
	void rotateLeft(int rotate) {
		if(head!=null) {
			int size = 1;
			Node tail = head;
			while(tail.next!=null) {
				++size;
				tail = tail.next;
			}
			while(rotate>0) {
				Node temp = head;
				head = head.next;
				tail = tail.next = temp;
				tail.next = null;
				--rotate;
			}
		}		
	}
	void printList() {
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	public static void main(String[] args) {
		LinkedListRotate<Integer> l = new LinkedListRotate<Integer>();
		for(int i=1;i<9;i++)
			l.add(i);
		l.printList();
		l.rotateLeft(4);
		System.out.println();
		l.printList();
	}

}
