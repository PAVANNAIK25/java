package Stacks;

public class StacksUsingLLUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StacksUsingLL<Integer> stack = new StacksUsingLL<Integer>();
		
//		System.out.println(stack.top());
		System.out.println(stack.isEmpty());
		stack.push(10);
		stack.push(20);
		stack.push(30);
		System.out.println(stack.size());
		System.out.println(stack.top());
		System.out.println(stack.pop());
		System.out.println(stack.size());
		
	}

}
