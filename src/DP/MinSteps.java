package DP;

import java.util.Scanner;

public class MinSteps {
	
	public static int minStepsIterative(int n) {
		if(n==1) {
			return 0;
		}
		
		int dp [] = new int[n+1];
		dp[1]=0;
		
		for(int i =2; i< dp.length; i++) {
			int ans1, ans2, ans3;
			ans1 = Integer.MAX_VALUE;
			ans2 = Integer.MAX_VALUE;
			ans3 = Integer.MAX_VALUE;
			ans3 = 1 + dp[i-1];
			
			if(i%3==0) {
				ans1 = 1 +dp[i/3];
			}
			if(i%2 ==0) {
				ans2 = 1+ dp[i/2];
			}
			
			dp[i] = Math.min(ans1, Math.min(ans2, ans3));
		}
		return dp[n];
	}
	
	public static int countStepsto1 (int n, int[] dp) {
		if(n==1) {
			return 0;
		}
		
		int ans1;
		if(dp[n-1]==-1) {
			ans1 = countStepsto1(n-1, dp);
			dp[n-1]=ans1;
		}else {
			ans1=dp[n-1];
		}
		
		int ans2= Integer.MAX_VALUE;
		if(n%2==0){
			if(dp[n/2]==-1) {
				ans2 = countStepsto1(n/2, dp);
				dp[n/2] = ans2;
			}else {
				ans2 = dp[n/2];
			}
		}
		
		int ans3 = Integer.MAX_VALUE;
		
		if(n%3 ==0) {
			if(dp[n/3]== -1) {
				ans3 = countStepsto1(n/3, dp);
			}else {
				ans3 = dp[n/3];
			}
		}
		int myAns = 1 + (Math.min(ans1, Math.min(ans2, ans3)));
		return myAns;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int dp[] = new int[n+1];
		for(int i=0; i<dp.length; i++) {
			dp[i]=-1;
		}
//		for(int i=0; i<dp.length; i++) {
//			System.out.print(dp[i]);
//		}
//		System.out.print(countStepsto1(n, dp));
		System.out.print(minStepsIterative(n));
	}

}
