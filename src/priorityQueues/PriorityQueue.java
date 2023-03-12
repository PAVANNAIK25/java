package priorityQueues;

import java.util.ArrayList;

public class PriorityQueue<T> {
	
	private ArrayList<Element<T>> heap;
	
	public PriorityQueue() {
		heap = new ArrayList<Element<T>>();
	}
	
	public void insert (T value, int priority) {
		Element<T> e = new Element<T>(value, priority);
		heap.add(e);
		
		int childInd = heap.size()-1;
		int parentInd = (childInd-1)/2;
		
		while(childInd>0) {
			if(heap.get(childInd).priority < heap.get(parentInd).priority) {
				Element<T> temp = heap.get(childInd);
				heap.set(childInd, heap.get(parentInd));
				heap.set(parentInd, temp);
				childInd = parentInd;
				parentInd = (childInd-1)/2;
			}else {
				return;
			}
		}
		
	}
	
	public T getMin() throws PriorityQueueException {
		if(isEmpty()) {
			throw new PriorityQueueException();
		}
		return heap.get(0).value;
	}
	
	public T removeMin() throws PriorityQueueException {
		
		if(heap.isEmpty()){
			throw new PriorityQueueException();
		}
		
		T ans = heap.get(0).value;
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		int parentInd = 0;
		int leftChildInd = 2*parentInd +1;
		int rightChildInd = 2*parentInd +2;
		
		while(leftChildInd<heap.size()) {
			int minInd = parentInd;
			if(leftChildInd<minInd) {
				minInd = leftChildInd;
			}
			
			if(rightChildInd<heap.size() &&(rightChildInd<minInd)) {
				minInd=rightChildInd;
			}
			if(minInd==parentInd) {
				break;
			}
			Element<T> temp = heap.get(minInd);
			heap.set(minInd, heap.get(parentInd));
			heap.set(parentInd, temp);
			parentInd=minInd;
			leftChildInd = 2*parentInd +1;
			rightChildInd = 2*parentInd +2;
			
		}
		
		
		return ans;		
		
	}
	
	public int size() {
		return heap.size();
	}
	
	public boolean isEmpty() {
		if(heap.size()==0) {
			return true;
		}else {
			return false;
		}
	}
}
