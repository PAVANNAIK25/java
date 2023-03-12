package Stacks;

import LinkedList.Node;

public class StacksUsingLL <T>{
	
	private Node <T> head;
	private int size;
	
	public StacksUsingLL() {
		head=null;
		size=0;
		
	}
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return head==null;
	}
	
	public void push(T elem) {
		if(head==null) {
			head = new Node<T>(elem); 
		}
		Node <T> temp = new Node<T>(elem); 
		temp.next = head;
		head=temp;
		size++;
	}
	
	public T top() {
		return head.data;
	}
	
	public T pop() {
		Node <T> temp = head.next;
		head=head.next;
		size--;
		return temp.data;
	}
	
	
}
