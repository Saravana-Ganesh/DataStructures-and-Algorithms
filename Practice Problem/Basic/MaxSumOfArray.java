package com.codewar;
public class MaxSumOfArray {
	/*
	 * 
	The maximum sum subarray problem consists in finding the maximum sum
	of a contiguous subsequence in an array or list of integers:

	Max.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
	// should be 6: {4, -1, 2, 1}
	Easy case is when the list is made up of only positive numbers
	and the maximum sum is the sum of the whole array. 
	If the list is made up of only negative numbers, return 0 instead.

	Empty list is considered to have zero greatest sum. 
	Note that the empty list or array is also a valid sublist/subarray.
	 */
  public static int sequence(int[] arr) {
	  /*
	   * This is based on Kadane's  algorithm
	   * Time complexity O(n)
	   * Space complexity O(1)
	   */
	int maxSum = Integer.MIN_VALUE, currentSum = 0, negativeCount=0;
	if(arr.length==0)
		return 0;
	for(int i=0;i<arr.length;i++) {
		currentSum = currentSum+arr[i];
		maxSum = currentSum>maxSum?currentSum:maxSum;
		currentSum = currentSum<0?0:currentSum;	
		if(arr[i]<0)
			negativeCount++;
	}
	if(negativeCount==arr.length)
		return 0;
	else
		return maxSum;
  }
}