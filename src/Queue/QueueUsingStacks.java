package Queue;
import java.util.Stack;

public class QueueUsingStacks<T> {
	
	Stack<T> s1;
	Stack<T> s2;
	
	public QueueUsingStacks() {
		s1=new Stack<>();
		s2 = new Stack<>();
		
	}
	
	public int size () {
		return s1.size();
	}
	
	public boolean isEmpty() {
		return s1.isEmpty();
	}
	
	public void enqueue (T elem) {
		
		s1.push(elem);
		
	}
	
	public T dequeue () throws QueueEmptyException {
		if(s1.isEmpty()) {
			throw new QueueEmptyException();
		}else {
		
			while(!s1.isEmpty()) {
				s2.push(s1.pop());
			}
			T temp = s2.pop();
			while(!s2.isEmpty()) {
				s1.push(s2.pop());
			}
			
			return temp;
		}
		
	}
	
	public T front() throws QueueEmptyException {
		if(s1.isEmpty()) {
			throw new QueueEmptyException();
		}else {
			
			while(!s1.isEmpty()) {
				s2.push(s1.pop());
			}
			T temp = s2.peek();
			while(!s2.isEmpty()) {
				s1.push(s2.pop());
			}
			
			return temp;
		}
	}
	
	
}
