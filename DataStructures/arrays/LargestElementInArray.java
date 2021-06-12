package com.geeks.arrays;

public class LargestElementInArray {
	/*
	 * Program to print largest element in Array....
	 * Time complexity O(N)
	 * Auxiliary Space O(1)
	 * 
	 */
	public static void main(String[] args) {		
		int a[] = {8,2,3,7,11,99,100};
		int maxPos=0;
		for(int i=1;i<a.length;i++) {
			if(a[maxPos]<a[i])
				maxPos = i;
		}
		System.out.println("The largest element is in the position = "+maxPos);
		System.out.println("The element in position "+maxPos+" is = "+a[maxPos]);
	}

}
