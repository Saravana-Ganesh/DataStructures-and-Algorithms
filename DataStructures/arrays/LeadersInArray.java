package com.geeks.arrays;

/*
 * Given an array A of positive integers. 
 * Your task is to find the leaders in the array. 
 * An element of array is leader if it is greater than 
 * all the elements to its right side.
 * The rightmost element is always a leader. 
 */
public class LeadersInArray {
	public static void printLeaders(int arr[]) {
		int currentLeader = arr[arr.length-1];
		System.out.print(currentLeader+" ");
		for(int i = arr.length-2; i > -1; i--) {
			if(arr[i]>currentLeader) {
				currentLeader = arr[i];
				System.out.print(currentLeader+" ");			
			}
		}
	}
	public static void main(String[] args) {
		int arr[] = {7,10,4,10,6,5,2};
		LeadersInArray.printLeaders(arr);
	}
}
