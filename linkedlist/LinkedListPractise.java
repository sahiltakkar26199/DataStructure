package linkedlist;

import java.util.Scanner;

public class LinkedListPractise {

	void printRec(Node<Integer> head) {
		if (head == null) {
			return;
		}

		printRec(head.next);
		System.out.println(head.data);
	}

	Node<Integer> reverseLinkedListRec(Node<Integer> head) {
		if (head.next == null) {
			return head;
		}
		Node<Integer> finalHead = reverseLinkedListRec(head.next);
		head.next.next = head;
		head.next = null;
		return finalHead;
	}

	Node<Integer> insertIthPos(int pos, int data, Node<Integer> head) {
		if (pos == 0) {
			Node<Integer> nyaNode = new Node<>(data);
			nyaNode.next = head;
			return nyaNode;
		}
		head.next = insertIthPos(--pos, data, head.next);
		return head;
	}

	Node<Integer> merge(Node<Integer> head1, Node<Integer> head2) {

		Node<Integer> head = null;
		Node<Integer> tail = null;

		if (head1.data.compareTo(head2.data) < 0) {
			head = head1;
			tail = head1;
			head1 = head1.next;
		} else {
			head = head2;
			tail = head2;
			head2 = head2.next;
		}

		while (head1 != null && head2 != null) {
			if (head1.data < head2.data) {
				tail.next = head1;
				head1 = head1.next;
				tail = tail.next;
			} else {
				tail.next = head2;
				head2 = head2.next;
				tail = tail.next;
			}
		}

		tail.next = head1 == null ? head2 : head1;

		return head;

	}

	Node reverseLinkedListRec(Node head, Node prev) {
		if (head.next == null) {
			head.next = prev;
			return head;
		}
		Node nextHead = head.next;
		head.next = prev;
		return reverseLinkedListRec(nextHead, head);
	}

	Node reverseLinkedList(Node head) {
		Node curr = head;
		Node prev = null;
		while (curr != null) {
			Node fwd = curr.next;
			curr.next = prev;
			prev = curr;
			curr = fwd;
		}
		return prev;

	}

	static void printLinkedList(Node head) {
		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}

	}

	static Node createLinkedList() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter data");
		int data = s.nextInt();
		Node head = null;
		Node tail = null;
		while (data != -1) {
			Node nyaNode = new Node(data);
			if (head == null) {
				head = nyaNode;
				tail = nyaNode;
			} else {
				tail.next = nyaNode;
				tail = tail.next;
			}
			System.out.println("Enter data");
			data = s.nextInt();
		}
		return head;
	}

	Node<Integer> mergeSort(Node<Integer> head) {
		if (head.next == null) {
			return head;
		}
		Node<Integer> mid = getMid(head);
		Node<Integer> second = mid.next;
		mid.next = null;
		Node<Integer> first = head;
		first = mergeSort(first);
		second = mergeSort(second);
		return merge(first, second);
	}
	
	
	bubbleSort(Node<Integer> head){
		int length = getLength(head);
		for(int i=0;i<length;i++){
			Node<Integer> first = head;
			Node<Integer> second = head.next;
			for(int j =1;j<length-i;j++){
				if(first.data <second.data){
					//update
				}else{
					//swap
					2 case 
					//1. head change
					//2. head not change			
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {

		// Node head = createLinkedList();
		//
		// printLinkedList(head);
		// printLinkedList(head);

		Node<Integer> head = new Node<>(1);
		head.next = new Node<>(5);
		head.next.next = new Node<>(9);

		Node temp = head.next;
		System.out.println(temp.next.data);

		System.out.println(head.data);
		System.out.println(head.next.data);

		System.out.println(head.next.next.next.next.next.data);

	}
}
