package com.datastructures;
//Linked List Implementation Of Queue..............
public class Queue<T> {
	Node head,tail;
	public class Node{
		T obj;
		Node next;
	}
	public T queueFront() {
		if(head!=null)
			return head.obj;
		return null;
		
	}
	public T queueRear() {
		if(tail!=null)			
			return tail.obj;
		return null;
	}
	public T enQueue(T obj) {
		if(head==null) {
			head = new Node();
			head.obj = obj;
		    tail = head;		    
		}else {
			Node temp = new Node();
			temp.obj = obj;
			temp.next = null;
			tail.next = temp;
			tail = temp;
		}
		return obj;
	}
	
	public T deQueue() {
		Node temp = head;		
		head = head.next;
		temp.next = null;
		return temp.obj;
	}
	public void printQueue() {
		Node temp = head;
		while(temp.next!=null) {
			System.out.println(temp.obj);
			temp = temp.next;
		}
		System.out.println(temp.obj);
	}
}
