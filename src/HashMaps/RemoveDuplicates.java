package HashMaps;

import java.util.ArrayList;
import java.util.HashMap;

public class RemoveDuplicates {
	
	public static ArrayList<Integer> removeDuplicates(int arr[]){
		ArrayList<Integer> output = new ArrayList<>();
		HashMap<Integer, Boolean> map = new HashMap<>();
		for(int i=0; i<arr.length;i++) {
			if(map.containsKey(arr[i])) {
				continue;
			}
			map.put(arr[i], true);
			output.add(arr[i]);
		}
		return output;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {1,2,2,3,4,5,5,6,2,7,4,8, 9, 10, 10};
		ArrayList<Integer> output = removeDuplicates(arr);
		
		for(int i=0; i<output.size(); i++) {
			System.out.print(output.get(i)+ " ");
		}
	}

}
