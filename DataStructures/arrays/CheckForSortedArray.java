package com.geeks.arrays;

public class CheckForSortedArray {
	public static boolean isSorted(int arr[]) {
		for(int i=1;i<arr.length;i++) {
			if(arr[i]<arr[i-1])
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(CheckForSortedArray.isSorted(new int[]{1,2,3,5}));
		System.out.println(CheckForSortedArray.isSorted(new int[]{9,10,3,5}));
	}

}
