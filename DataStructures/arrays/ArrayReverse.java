package com.geeks.arrays;

import java.util.Arrays;

public class ArrayReverse {
	public static void reverseArray(int[] arr) {
		int j = arr.length-1;
		for(int i=0;i<arr.length/2;i++,j--) {
			swap(arr,i,j);
		}
	}
	public static void swap(int[] arr,int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void main(String[] args) {
		int[] arr1 = {1,2,3,4};
		int[] arr2 = {1,2,3,4,5};
		ArrayReverse.reverseArray(arr1);
		ArrayReverse.reverseArray(arr2);
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
	}
}
