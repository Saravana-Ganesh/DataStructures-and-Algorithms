package com.codewar;

import java.util.Scanner;

public class StackMin {
	/*
	 * Time Complexity : O(1) for all the 3 methods.
	 * Space Complexity: O(1) for all the 3 methods.
	 */
	int i=-1;
	int min = 0;
	int stack[] = new int[100];
	void push(int ele) {
		if(i==-1){
			stack[++i] = ele;
			min = ele;
		}
		else if(ele<=min) {
			stack[++i] = (ele*2)-min;		
			min = ele;
		}else
			stack[++i] = ele;
	}
	int pop() {
		if(i==-1) {
			min = -1;
			//return -1;
		}
		if(stack[i]<=min) {
			min = (min*2)-stack[i];
			return stack[i--];			
		}			
		else
			return stack[i--];
	}
	void printStack() {
		int tempMin = min,j=i;
		System.out.println("Printing Elements in Stack...");
		for(j=i;j>-1;j--) {
			if(stack[j]<=tempMin) {
				System.out.println(tempMin);
				tempMin = (tempMin*2)-stack[j];				
			}else
				System.out.println(stack[j]);	
		}			
	}
	int getmin() {
		if(i==-1)
            min = -1;
		System.out.println("min="+min);
		return min;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StackMin stack = new StackMin();
		while(true) {
			System.out.println("\nEnter the operation\n1.Push\n2.Pop\n3.Get Min Element from the stack\n4.exit");
			int operation = sc.nextInt();
			switch(operation) {
				case 1:
					System.out.println("\nEnter the element to push in stack...");
					stack.push(sc.nextInt());
					stack.printStack();
					stack.getmin();
					break;
				case 2:
					stack.pop();
					stack.printStack();
					stack.getmin();
					break;
				case 3:
					stack.getmin();
					break;
				default:
					System.exit(0);
					
			}
		}
	}
}
