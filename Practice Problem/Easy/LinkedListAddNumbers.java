package com.geeks.easy;
/*
 * Add two numbers represented by linked lists 
 * 
 * Given two numbers represented by two linked lists of size N and M. 
 * The task is to return a sum list. 
 * The sum list is a linked list representation of the addition of two input numbers.
 * 
 * Expected Time Complexity: O(N+M)
 * Expected Auxiliary Space: O(Max(N,M))
 */
public class LinkedListAddNumbers {
	static boolean carry=false;
	Node head;
	class Node{
		int data;
		Node next;
	}
	public void add(int data) {
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
	public static void print(Node head){
		Node temp = head;
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}	
		System.out.println();
	}
	public static void createNewList(LinkedListAddNumbers l,int array[]) {
		for(int i=0;i<array.length;i++)
			l.add(array[i]);
	}
	static Node addTwoLists(Node first, Node second){
		int sum=0;
		Node l=null;	
		carry=false;
		while(first!=null || second!=null) {
			sum = (first!=null?first.data:0)+(second!=null?second.data:0);
			l = createList(sum,l);			
			first = first!=null?first.next:null;
			second = second!=null?second.next:null;
		}
		if(carry)
			l = createList(0,l);
		print(l);
		return l;
	}
	private static Node createList(int sum, Node l) {
		if(carry)
			++sum;
		carry = sum>9;
		sum = sum>9?sum-10:sum;		
		Node temp = new LinkedListAddNumbers().new Node();
		temp.data = sum;
		if(l==null)
			return temp;
		else
			temp.next = l;
		return temp;
	}
	private static Node reverseList(Node node) {
		if(node!=null && node.next!=null) {
			Node current=node,prev=node.next,temp=prev.next,head=node;
			while(prev!=null) {
				prev.next = current;
				current = prev;
				prev = temp;
				temp = temp!=null?temp.next:null;
			}
			head.next = null;
			return current;
		}
		return node;
	}
	public static void main(String[] args) {
		int a[] = {1,7,8,3,6,9,4};
		int b[] = {8,4,8,5,7,2,3,8,3};
		/*int a[] = {9,9};
		int b[] = {1};*/
		LinkedListAddNumbers l1 = new LinkedListAddNumbers();
		LinkedListAddNumbers l2 = new LinkedListAddNumbers();
		createNewList(l1,a);
		createNewList(l2,b);
		System.out.print("    ");
		print(l1.head);
		print(l2.head);		
		l1.head = reverseList(l1.head);
		l2.head = reverseList(l2.head);
		addTwoLists(l1.head,l2.head);
	}

}
