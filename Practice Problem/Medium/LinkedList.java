package com.datastructures;

public class LinkedList<T> {
	Node head,tail;
	class Node{
		T data;
		Node next;
	}
	public void insert(T data) {
		if(head==null) {
			head = new Node();
			head.data = data;
		}else {
			Node temp=head;
			while(temp.next!=null) {
				temp = temp.next;
			}
			temp.next = new Node();
			tail = temp.next;
			tail.data = data;
		}
	}
	public void print(){
		Node temp = head;
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}	
		System.out.println();
	}
	public void createLoop(int pos) {
		Node temp = head;
		int i=1;
		while(i<pos) {
			temp = temp.next;
			++i;
		}
		tail.next = temp;
	}
	public void detectLoop() {
		Node temp = head;
		Node slowPointer,fastPointer;
		slowPointer = temp.next;
		fastPointer = temp.next.next;
		while(slowPointer!=null && fastPointer!=null && slowPointer!=fastPointer) {
			temp = slowPointer;
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next!=null?fastPointer.next.next:fastPointer;
		}
		if(fastPointer==slowPointer && slowPointer!=null) {
			System.out.println("Loop Detected...");
			removeLoop(fastPointer);
		}else
			System.out.println("No Loop Detected...");
	}
	public void removeLoop(Node pos) {
		Node temp = head;
		Node prev = null;
		/*while(temp!=pos) {
			prev = pos;
			temp = temp.next;
			pos = pos.next;
		}
		prev.next = null;*/
		if(temp==pos){
		    while(true){
		        prev = pos;
		        pos = pos.next;
		        if(pos==temp)
		            break;
		    }
		}else{
		    while(temp!=pos) {
    			prev = pos;
    			temp = temp.next;
    			pos = pos.next;
	    	}    
		}
		if(prev!=null)
		    prev.next = null;
		System.out.println("Loop Removed...");
	}
	public static void main(String[] args) {
		LinkedList<Integer> l = new LinkedList<Integer>();
		for(int i=1;i<10;i++) {
			l.insert(i);
		}
		l.print();
		l.createLoop(1);
		l.detectLoop();
		l.print();
	}

}
