package DP;

import java.util.Scanner;

public class MinimunSquares {
	
	public static int minSquaresIterative (int n) {
		int dp[] = new int[n+1];
		dp[0]=0;
		int minAns;
		for(int i=1; i<dp.length; i++) {
			minAns=Integer.MAX_VALUE;
			for(int j=1; j*j<=i; j++) {
				int currAns = dp[i-(j*j)];
				if(currAns < minAns) {
					minAns=currAns;
				}
			}
			dp[i]=1+minAns;
		}
		
		return dp[n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.print(minSquaresIterative(n));

	}

}
