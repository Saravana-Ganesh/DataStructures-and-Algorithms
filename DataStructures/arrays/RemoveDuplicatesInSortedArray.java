package com.geeks.arrays;

import java.util.Arrays;

public class RemoveDuplicatesInSortedArray {
	/*public static int removeDuplicates(int[] arr) {
		int size = 0;
		boolean isDuplicateOccured = false;
		int elementTobeChanged = 1;
		for(int i=0;i<arr.length;i++) {
			if(isDuplicateOccured) {
				if(arr[elementTobeChanged]<arr[i]) {
					arr[elementTobeChanged] = arr[i];
					++elementTobeChanged;
					++size;
					isDuplicateOccured = false;
					continue;
				}
				//arr[i] = Integer.MIN_VALUE;
				continue;
			}			
			
			if(arr[i]!=arr[elementTobeChanged]) {
				++size;
				++elementTobeChanged;
				continue;
			}else {
				isDuplicateOccured = true;
				continue;
			}
		}
		return size;
	}*/
	public static void printArray(int arr[],int size) {
		for(int i=0;i<size;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	public static void main(String[] args) {
		int arr[] = {2,2,2,2,2,2,2,2,22};
		System.out.println(Arrays.toString(arr));
		int size = RemoveDuplicatesInSortedArray.removeDuplicates(arr);
		System.out.println(Arrays.toString(arr));
		RemoveDuplicatesInSortedArray.printArray(arr,size);
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
