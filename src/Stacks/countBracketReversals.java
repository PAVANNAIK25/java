package Stacks;
import java.util.Scanner;
import java.util.Stack;
public class countBracketReversals {
	
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		int count = countBracketReversals1(input);
		System.out.print(count);
	}
	
	public static int countBracketReversals1(String input) {
		//Your code goes here
        Stack <Character> stack = new Stack<>();
        
        int i=0, count=0;
        
        while(i<input.length()){
            if(input.charAt(i) == '{'){
                stack.push(input.charAt(i));
                
            }else{
                stack.pop();
            }
            i++;
        }
        
        while(!stack.isEmpty()){
            count++;
            stack.pop();
        }
        
        if(count%2==0){
            return count/2;
        }else{
            return -1;
        }
        
	}
}
