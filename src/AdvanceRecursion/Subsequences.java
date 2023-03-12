package AdvanceRecursion;

import java.util.Scanner;

public class Subsequences {
	
	public static void printSubsequences(String str, String stringSofar) {
		if(str.length()==0) {
			System.out.println(stringSofar);
			return;
		}
		
		String smallInput = str.substring(1);
		
		printSubsequences(smallInput, stringSofar);
		printSubsequences(smallInput, stringSofar + str.charAt(0));
		
	}
	
	
	public static String[] returnSubsequences(String str) {
		if(str.length()==0) {
			String [] output = new String[1];
			output[0]= "";
			return output;
		}
		
		String[] smallOutput =  returnSubsequences(str.substring(1));
		
		String[] ans = new String[smallOutput.length*2];
		
		
		for(int i=0; i < smallOutput.length; i++) {
			ans[i] = smallOutput[i];
		}
		
		for(int i=0; i<smallOutput.length; i++) {
			ans[smallOutput.length+i] = str.charAt(0)+ smallOutput[i];
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter String: ");
		String input = sc.next();
		printSubsequences(input,"");
//		String[] str = returnSubsequences(input);
//		for(String item: str) {
//			System.out.println(item);
//		}
	}

}
