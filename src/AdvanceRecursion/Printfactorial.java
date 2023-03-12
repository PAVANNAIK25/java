package AdvanceRecursion;

public class Printfactorial {
	
	public static void factorial(int input, int ans) {
		if(input==0) {
			System.out.print(ans);
			return;
		}
		
		ans = ans * input;
		factorial(input-1, ans);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		factorial(5, 1);
	}

}
