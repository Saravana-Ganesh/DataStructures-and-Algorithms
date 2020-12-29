package com.codewar;


public class LinkedListIntersect<T> {
	/*
	 * Intersection Point in Y Shapped Linked Lists 
	 * Given two singly linked lists of size N and M, 
	 * write a program to get the point where two linked lists intersect each other.
	 */
	Node head;
	class Node{
		T data;
		Node next;
	}
	public void add(T data) {
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
	@SuppressWarnings("unchecked")
	LinkedListIntersect<Integer> makeIntersect(int i,LinkedListIntersect<Integer> node2) {
		Node temp = head;
		while(i-->0&&temp!=null) {
			temp = temp.next;
		}
		node2.head = (LinkedListIntersect<Integer>.Node) new Node();
		node2.head.data = 10;
		node2.head.next = (LinkedListIntersect<Integer>.Node) temp;
		return node2;
	}
	int listSize(Node node) {
		int size=0;
		while(node!=null) {
			++size;
			node = node.next;
		}
		return size;
	}
	int intersectPoint(Node head1,Node head2) {
		int head1Size = listSize(head1),head2Size=listSize(head2);
		if(head1Size==0 || head2Size==0) {			
				return -1;				
		}
		else if(head1Size>head2Size) {
			int skip = head1Size-head2Size;
			while(skip-->0) {
				head1 = head1.next;				
			}			
		}
		else if(head1Size<head2Size) {
			int skip = head2Size-head1Size;
			while(skip-->0) {
				head2 = head2.next;				
			}			
		}
		while(head1!=null&&head2!=null) {
			if(head1.data==head2.data)
				return (Integer) head1.data;
			else {
				head1 = head1.next;
				head2 = head2.next;
			}				
		}
		return -1;
	}
	public void print(){
		Node temp = head;
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}	
		System.out.println();
	}
	public static void main(String[] args) {
		LinkedListIntersect<Integer> node1 = new LinkedListIntersect<Integer>();
		LinkedListIntersect<Integer> node2 = new LinkedListIntersect<Integer>();
		node1.add(3);node1.add(6);node1.add(9);node1.add(15);node1.add(30);
		node2 = node1.makeIntersect(3, node2);
		node1.print();
		System.out.println();
		node2.print();
		System.out.println(node1.intersectPoint(node1.head, node2.head));
	}

}
