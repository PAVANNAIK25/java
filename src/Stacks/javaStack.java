package Stacks;
import java.util.Stack;

public class javaStack {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Stack <String> stack = new Stack<String>();
//		
//		String [] arr = {"a", "b","c","d","e"};
//		
//		for (int i=0; i<arr.length; i++) {
//			stack.push(arr[i]);
//		}
//		
//		System.out.println(stack.size());
//		System.out.println(stack.peek());
//	}
	
	public static void main (String[] args) {
        Stack<Integer> stack=new Stack<Integer>();
        stack.push(5);
        stack.push(10);
        stack.push(15);
        System.out.print(stack.pop()+stack.size());
    }
}
