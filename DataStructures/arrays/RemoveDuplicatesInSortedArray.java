package com.geeks.arrays;

import java.util.Arrays;

public class RemoveDuplicatesInSortedArray {
	public static void printArray(int arr[],int size) {
		for(int i=0;i<size;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	public static void main(String[] args) {
		int arr[] = {10,20,30};
		System.out.println(Arrays.toString(arr));
		int size = RemoveDuplicatesInSortedArray.removeDuplicates1(arr);
		System.out.println(Arrays.toString(arr));
		RemoveDuplicatesInSortedArray.printArray(arr,size);
	}
	public static int removeDuplicates1(int[] arr) {
		int res = 1;
		for(int i=1;i<arr.length;i++) {
			if(arr[i]!=arr[res-1]) {
				arr[res++] = arr[i];
			}
		}
		return res;
	}
	public static int removeDuplicates(int[] arr) {
		int elementTobeChange = 1,size=0;
		boolean isDuplicatePresent = false;
		for(int i=0;i<arr.length;i++) {
			if(isDuplicatePresent) {
				if(arr[i]>arr[elementTobeChange-1]) {
					arr[elementTobeChange] = arr[i];
					++elementTobeChange;
					isDuplicatePresent = false;
				}
			}else if(arr[elementTobeChange]<=arr[elementTobeChange-1]) {
				isDuplicatePresent = true;
				--i;
			}else if(arr[elementTobeChange]>arr[elementTobeChange-1]) {
				++elementTobeChange;
			}
		}
		
		return elementTobeChange;
	}
}	
