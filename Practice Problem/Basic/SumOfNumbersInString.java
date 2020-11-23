package com.codewar;
import java.util.Scanner;
/*
 Given a string str containing alphanumeric characters, calculate sum of all 
 numbers present in the string.

Input:
	The first line of input contains an integer T denoting the number of test cases.
 	Then T test cases follow. Each test case contains a string containing alphanumeric characters.

Output:
	Print the sum of all numbers present in the string.

Constraints:
	1<=T<=105
	1<=length of the string<=105

Example:
Input:
	4
	1abc23
	geeks4geeks
	1abc2x30yz67
	123abc

Output:
	24
	4
	100
	123

Explanation:
	Testcase 1: 
		1 and 23 are numbers in the string which is added to get the sum as 24.
	Testcase 4: 123 is a single number, so sum is 123.
 * 
 */
public class SumOfNumbersInString {
	private static int number=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			String str = sc.next();	
			int j=1,sum=0;
			for(int i=str.length()-1;i>-1;i--) {
				if(isNumber(str.charAt(i))){
					number*=j;
					sum+=number;
					j*=10;
				}else
					j=1;
			}
			System.out.println(sum);
		}		
	}
	private static boolean isNumber(char ch) {
		if(ch-48>=0 && ch-48<=9) {
			number = ch-48;
			return true;
		}
		return false;
	}

}
