package Stacks;

public class StackUsingArrayUse {

	public static void main(String[] args) throws StackEmptyException{
		// TODO Auto-generated method stub
		StacksUsingArray stack = new StacksUsingArray();
		
//		System.out.println(stack.top());
		System.out.println(stack.isEmpty());
		stack.push(10);
		stack.push(20);
		stack.push(30);
		System.out.println(stack.size());
		System.out.println(stack.top());
		stack.pop();
		System.out.println(stack.size());
	}

}
