package stackqueues;

class OurOwnStackOverFlowException extends Exception {

}

class OurOwnStackUnderFlowException extends Exception {

}

public class StackUsingArray {
	private int[] data;
	private int top;

	public StackUsingArray() {
		top = -1;
		data = new int[5];
	}

	public StackUsingArray(int size) {
		top = -1;
		data = new int[size];
	}

	public void push(int data) throws OurOwnStackOverFlowException {
		if (isFull()) {
			//throw new OurOwnStackOverFlowException();
			grow();
		}
		System.out.println("data pushed");
		this.data[++top] = data;
	}

	private void grow() {
		int[] temp = data;
		data = new int[data.length*2];
		for(int i =0;i<temp.length;i++){
			data[i] = temp[i];
		}
		System.out.println("Grow from "+ temp.length +" to "+data.length);
	}

	public int pop() throws OurOwnStackUnderFlowException {
		if (isEmpty()) {
			throw new OurOwnStackUnderFlowException();
		}
		int temp = data[top];
		top--;
		System.out.println("poped");
		return temp;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == data.length - 1;
	}

	public int size() {
		return top + 1;
	}
}
