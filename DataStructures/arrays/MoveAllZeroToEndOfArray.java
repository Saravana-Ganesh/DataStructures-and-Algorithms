package com.geeks.arrays;

import java.util.Arrays;

public class MoveAllZeroToEndOfArray {
	
	public static void moveZeroToEnd(int arr[]) {
		int j=0;int temp;
		for(int i=1;i<arr.length;i++) {
			if(arr[j]==0) {
				if(arr[i]!=0) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					++j;
				}else {
					continue;
				}
			}else {
				++j;
			}
			
		}
	}
	public static void main(String[] args) {
		int arr[] = {0,1,0,3,12};
		MoveAllZeroToEndOfArray.moveZeroToEnd(arr);
		System.out.println(Arrays.toString(arr));
	}

}
