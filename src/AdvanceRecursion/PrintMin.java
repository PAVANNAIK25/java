package AdvanceRecursion;

public class PrintMin {
	
	public static void printMinArr(int [] arr, int startIndex, int minSoFar) {
		if(startIndex==arr.length) {
			System.out.print(minSoFar);
			return;
		}
//		int newMin = minSoFar;
		
		if(arr[startIndex]< minSoFar) {
			minSoFar = arr[startIndex];
		}
		printMinArr(arr, startIndex+1, minSoFar);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {9,5,8,9,4,2,0};
		printMinArr(arr, 0, Integer.MAX_VALUE);
		
	}

}
