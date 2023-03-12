package Stacks;

public class StacksUsingArray {

	private int data[];
	private int topIndex = -1;
	
	public StacksUsingArray() {
		data= new int[2];
	}
	
	public int size() {
		return topIndex + 1;
	}
	
	public boolean isEmpty(){
//		if(topIndex==-1) {
//			return true;
//		}else {
//			return false;
//		}
		
		return topIndex == -1;
	}
	
	public int top() throws StackEmptyException{
		if(topIndex ==-1) {
			throw new StackEmptyException();
			
		}
		return data[topIndex];
	}
	
	public void push(int elem) { //throws StackLimitExceeded  {
		
		if(topIndex==(data.length-1)) {
//			StackLimitExceeded e = new StackLimitExceeded();
//			throw e;
//			throw new StackLimitExceeded();
			addMoreIndex();
		}
		
		data[++topIndex]=elem;
	}
	
	public void pop() {
		topIndex--;
	}
	
	private void addMoreIndex() {
		int [] temp = data;
		data = new int [2*data.length];
		
		for (int i=0; i<temp.length; i++) {
			data[i]= temp[i];
		}
	}
}
