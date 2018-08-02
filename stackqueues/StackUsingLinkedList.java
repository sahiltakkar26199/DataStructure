package stackqueues;


class Node<T>{
	T data;
	Node<T> next;
	Node(T data){
		this.data = data;
	}
}
public class StackUsingLinkedList<T> {
	static final int MAX_SIZE = 100000000;
	private Node<T> top ;
	private int size ;
	public StackUsingLinkedList() {
		top = null;
		size =0;
	}
	
	void push(T data){
		if(size==MAX_SIZE){
			
		}
		Node<T> node = new Node<>(data);
		if(top ==null){
			top = node;
			return;
		}
		size++;
		node.next = top;
		top = node;
	}
	
	T pop() throws OurOwnStackUnderFlowException{
		if(size()==0){
			throw new OurOwnStackUnderFlowException();
		}
		size--;
		Node<T> temp = top;
		top = top.next;
		return temp.data;
	}
	int size(){
		return size;
	}
	
	boolean isEmpty(){
		return size==0;
	}

	
}
