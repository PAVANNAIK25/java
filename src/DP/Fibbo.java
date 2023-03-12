package DP;

import java.util.Scanner;

public class Fibbo {
	
	public static int fibboIterative(int n) {
		if(n==0) {
			return n;
		}
		int arr[] = new int[n+1];
		arr[0] = 0;
		arr[1]=1;
		for(int i=2; i<=n; i++) {
			arr[i]=arr[i-1]+ arr[i-2];
		}
		return arr[n];
	}
	
	public static int fibb (int n, int[] dp) {
		if(n==0 || n==1) {
			return n;
		}
		int ans1, ans2;
		
		if(n-1 != -1) {	
			ans1 = fibb(n-1, dp);
			dp[n-1]= ans1;
		}else {
			ans1 = dp[n-1];
		}
		
		if(n-2 != -1) {
			ans2 = fibb(n-2,dp);
			dp[n-2]=ans2;
		}else {
			ans2=dp[n-2];
		}
		
		return ans1+ ans2;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
//		int []dp = new int[n+1];
//		for(int i:dp) {
//			dp[i]=-1;
//		}
//		int ans = fibb(n, dp);
		int ans = fibboIterative(n);
		System.out.println(ans);
	}

}
