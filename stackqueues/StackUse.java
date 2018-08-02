package stackqueues;

import java.util.Stack;

public class StackUse {
	public static void main(String[] args) throws Exception {
		
		Stack<Integer> st = new Stack<>();
		st.push(7);
		st.pop();
		
		
		
		
		
		
		
		
		
		
		
		
		StackUsingArray stack = new StackUsingArray(10);
		try {
			int i = 400;
			while (i >= 0) {
				stack.push(i);
				i--;
			}
		} catch (OurOwnStackOverFlowException e) {
			throw new Exception();
		}

		while (!stack.isEmpty()) {
			try {
				System.out.println(stack.pop());
			} catch (OurOwnStackUnderFlowException e) {
				e.printStackTrace();
			}
		}

	}

}
