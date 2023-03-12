package HashMaps;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class inbult {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<>();
		
//		insert
		map.put("abc", 10);
		map.put("ghi", 40);
		
//		getValue
		System.out.println(map.get("abc"));
		
//		size
		System.out.println(map.size());
		
//		remove
		map.remove("abc");
		map.put("abc", 10);
		map.put("def", 50);
		map.put("rgd", 30);
	
//		keySet
		Set<String> keys = map.keySet();
		
		for(String s:keys) {
			System.out.println(map.get(s));
			
		}
	}

}
