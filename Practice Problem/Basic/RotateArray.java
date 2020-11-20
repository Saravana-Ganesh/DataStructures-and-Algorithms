package com.codewar;
/*
 * This is based on jugglers algorithm
 * Time complexity O(n)
 * Space complexity O(1)
 */
public class RotateArray {
	public static void rotateLeft(int a[],int shiftValue) {
		int gcd = gcd(a.length,shiftValue);
		int temp=0,j=0,k=0;
		for(int i=0;i<gcd;i++) {
			temp = a[i];
			j=i;
			while(true) {
				k=(j+shiftValue)%a.length;
				if(k==i)
					break;
				a[j] = a[k];
				j = k;				
			}
			a[j] = temp;
			
		}
	}
	
	private static int gcd(int a,int b) {
		if(b==0)
			return a;
		return gcd(b,a%b);
	}
	private static void printArray(int[] a) {
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
	}
	public static void main(String[] args) {
		int a[] = {1,2,3,4,5};
		RotateArray.rotateLeft(a,3);
		printArray(a);
		
	}

}
