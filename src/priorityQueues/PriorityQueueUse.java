package priorityQueues;

import java.io.PipedWriter;

public class PriorityQueueUse {

	public static void main(String[] args)throws PriorityQueueException {
		// TODO Auto-generated method stub
		PriorityQueue<String> pq = new PriorityQueue<>();
		pq.insert("abc", 15);
		pq.insert("def", 50);
		pq.insert("jkh", 34);
		pq.insert("rth", 150);
		pq.insert("oiu", 11);
		
		while(!pq.isEmpty()) {
			System.out.println(pq.getMin());
			pq.removeMin();
		}
			
	}

}
