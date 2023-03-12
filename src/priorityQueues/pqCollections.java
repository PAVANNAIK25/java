package priorityQueues;

import java.util.PriorityQueue;

public class pqCollections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] arr = {4, 5,7,50,23,42,2,6,0};
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for (int i = 0; i < arr.length; i++) {
			pq.add(arr[i]);
		}
		
//		System.out.println(pq.peek());
		
		while (!pq.isEmpty()) {
			System.out.println(pq.peek()); 
			pq.poll();
		}
		
	}

}
