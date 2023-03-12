package Queue;

import LinkedList.Node;

public class QueueUsingLL<T> {

	private Node<T> front;
	private Node<T> rear;
	private int size;
	
	public QueueUsingLL() {
		front = null;
		rear = null;
		size =0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public void enqueue(T elem) {
		
		Node<T> newNode= new Node<T>(elem);
		if(size==0) {
			front = newNode;
			rear = newNode;
			size++;
		}else {
			
			rear.next=newNode;
			rear = newNode;
			size++;
		}
		
	}
	
	public T dequeue() throws QueueEmptyException {
		if (front ==null) {
			throw new QueueEmptyException();
		}
		
		T temp = front.data;
		front=front.next;
		if (front ==null) {
			rear=null;
		}
		size--;
		return temp;
	}
	
	public T front() throws QueueEmptyException {
		if (front ==null) {
			throw new QueueEmptyException();
		}
		return front.data;
	}
	
	
}
