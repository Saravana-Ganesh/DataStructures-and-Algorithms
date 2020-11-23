package com.codewar;
import java.util.Scanner;
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
