package com.geeks.arrays;

public class SecondLargestElementInArray {
	/*
	 * Program to print second largest element in Array....
	 * Time complexity O(N)
	 * Auxiliary Space O(1)
	 * 
	 */
	public static void main(String[] args) {
		int a[] = {10,10,10};
		int max = 0,secondMax = Integer.MIN_VALUE;
		for(int i=0;i<a.length;i++) {			
			if(secondMax==Integer.MIN_VALUE) {
				if(i+1==a.length)
					break;
				if(a[i]==a[i+1])
					continue;				
				max = a[i]>a[i+1]?i:i+1;
				secondMax = a[i]<a[i+1]?i:i+1;				
			}
			if(a[i]>a[max]) {
				secondMax = a[secondMax]<a[max]?max:secondMax;
				max = i;
			}else {
				secondMax = (a[i]>a[secondMax]) && (a[i]<a[max])?i:secondMax;
			}
			
		}
		if(secondMax!=Integer.MIN_VALUE) {
			System.out.println(a[max]);
			System.out.println("Second Largest Element = "+a[secondMax]);
		}else {
			System.out.println(-1);
		}
		
	}
}	
