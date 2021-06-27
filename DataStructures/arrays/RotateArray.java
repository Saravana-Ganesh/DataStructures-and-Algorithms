package com.geeks.arrays;

public class RotateArray {
	
	public static void rotateLeftWithGCD(int a[],int shiftValue) {
		/*
		 * This is based on jugglers algorithm
		 * Time complexity O(n)
		 * Auxiliary Space O(1)
		 */
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
	private static void rotateLeftWithoutGCD(int a[],int shiftValue) {
		/*
		 *	Time complexity O(n) where n is the size of array.....
		 *  Auxiliary Space O(1)
		 *  Here instead of GCD we are incrementing count value when shifting occurs..
		 *  When the count reaches the length of the array the loop will break...
		 */
		int temp = 0, count = 0;
		for(int i=0;count<a.length;i++) {
			temp = a[i];
			int j = i;
			while(true) {
				int k = (j+shiftValue)%(a.length);
				if(k==i) {
					a[j] = temp;
					++count;
					break;
				}					
				a[j] = a[k];
				++count;
				j=k;
			}
		}
	}
	private static void printArray(int[] a) {
		System.out.println("");
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
	}
	public static void main(String[] args) {
		int a[] = {1,2,3,4,5,6,7};
		RotateArray.rotateLeftWithGCD(a,3);
		RotateArray.printArray(a);
		int b[] = {1,2,3,4,5,6,7};
		RotateArray.rotateLeftWithoutGCD(b,3);
		RotateArray.printArray(b);
	}

}
