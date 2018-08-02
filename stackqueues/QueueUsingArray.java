package stackqueues;

public class QueueUsingArray {

	private int[] data;
	private int front;
	private int rear;
	private int size;

	public QueueUsingArray() {
		data = new int[5];
		front = rear = -1;
		size = 0;
	}

	public QueueUsingArray(int size) {
		data = new int[size];
		front = rear = -1;
		size = 0;
	}

	void enqueue(int data) throws OurOwnQueueFullException {
		if (isFull()) {
			throw new OurOwnQueueFullException();
		}
		if (isEmpty()) {
			front++;
		}
		rear = (rear + 1) % this.data.length;
		this.data[rear] = data;
		size++;
	}

	int dequeue() throws QueueEmptyException {
		if (isEmpty()) {
			throw new QueueEmptyException();
		}
		int temp = data[front];
		front = (front + 1) % data.length;
		size--;
		if (size == 0) {
			front = rear = -1;
		}
		return temp;
	}

	boolean isFull() {
		return size == data.length;
	}

	boolean isEmpty() {
		return size == 0;
	}

}
