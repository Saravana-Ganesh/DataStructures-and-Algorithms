package com.geeks.arrays;

public class MaximumDifferenceProblemWithOrder {
	/*
	 * Given an array arr[] of integers, 
	 * find out the maximum difference between 
	 * any two elements such that larger 
	 * element appears after the smaller number.
	 * maxDifference = arr[j]-arr[i]
	 * where j should be greater than i.
	 * Example:
	 * 	  Input : arr = {2, 3, 10, 6, 4, 8, 1}
	 * 	  Output : 8
	 *    Explanation : The maximum difference is between 10 and 2.
	 *    
	 *    Input : arr = {7, 9, 5, 6, 3, 2}
	 *    Output : 2
	 *    Explanation : The maximum difference is between 9 and 7.
	 * 
	 * Time Complexity: O(n), Where n is the size of array.
	 * Auxiliary Space: O(1)
	 *
	 *      
	 */
	private static int maxDifference(int arr[]) {
		if(arr.length>1) {
			int minElement=findMin(arr[0],arr[1]),maxDiff=arr[1]-arr[0];
			int tempMinElement,tempMaxDiff;
			for(int i=2;i<arr.length;i++) {
				tempMinElement = findMin(arr[i],arr[i-1]);
				tempMaxDiff = arr[i]-minElement;
				maxDiff = tempMaxDiff>maxDiff?tempMaxDiff:maxDiff;
				minElement = tempMinElement<minElement?tempMinElement:minElement;
			}
			return maxDiff;
		}
		return arr[0];
	}
	private static int findMin(int a, int b) {
		if(a<b)
			return a;
		return b; 
	}
	public static void main(String[] args) {
		int arr1[] = {2, 3, 10, 6, 4, 8, 1};
		int arr2[] = {7, 9, 5, 6, 3, 2};
		int arr3[] = {34, 8, 10, 3, 2, 80, 30, 33, 1};
		int arr4[] = {10,20,30};
		int arr5[] = {30,10,8,2};
		System.out.println(maxDifference(arr1));
		System.out.println(maxDifference(arr2));
		System.out.println(maxDifference(arr3));
		System.out.println(maxDifference(arr4));
		System.out.println(maxDifference(arr5));
	}

}
