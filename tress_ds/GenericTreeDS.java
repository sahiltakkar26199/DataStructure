package tress_ds;

import java.util.LinkedList;
import java.util.Scanner;

public class GenericTreeDS {
	// 1 2 2 2 4 0 5 0 3 0
	static Scanner s = new Scanner(System.in);

	static TreeNode<Integer> constructTree() {
		System.out.println("Enter data");
		int data = s.nextInt();
		TreeNode<Integer> nyaNode = new TreeNode<>(data);
		System.out.println("No of children");
		int noOfChildren = s.nextInt();
		for (int i = 0; i < noOfChildren; i++) {
			nyaNode.childrenList.add(constructTree());
		}
		return nyaNode;
	}

	void printTree(TreeNode<Integer> root) {
		System.out.println(root.data);
		for (int i = 0; i < root.childrenList.size(); i++) {
			printTree(root.childrenList.get(i));
		}
	}

	void printTreeUsingQueue(TreeNode<Integer> root) {
		LinkedList<TreeNode<Integer>> queue = new LinkedList<>();
		queue.addLast(root);
		while (!queue.isEmpty()) {
			TreeNode<Integer> current = queue.removeFirst();
			System.out.println(current.data);
			for (int i = 0; i < current.childrenList.size(); i++) {
				queue.addLast(current.childrenList.get(i));
			}
		}
	}

	TreeNode<Integer> constructTreeUsingQueue() {
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		TreeNode<Integer> root = new TreeNode<>(data);
		LinkedList<TreeNode<Integer>> queue = new LinkedList<>();
		queue.addLast(root);
		while (!queue.isEmpty()) {
			TreeNode<Integer> current = queue.removeFirst();
			System.out.println("Enter no of children");
			int noOfChildren = s.nextInt();
			for (int i = 0; i < noOfChildren; i++) {
				System.out.println("Enter child data");
				int childData = s.nextInt();
				TreeNode<Integer> child = new TreeNode<>(childData);
				current.childrenList.add(child);
				queue.addLast(child);

			}
		}
		return root;
	}


	int height(TreeNode<Integer> root) {

		int maxHeight = 0;
		for (int i = 0; i < root.childrenList.size(); i++) {
			int height = height(root.childrenList.get(i));
			if (height > maxHeight) {
				maxHeight = height;
			}
		}
		return maxHeight + 1;
	}

	int countNodes(TreeNode<Integer> root) {

		int count = 0;
		for (int i = 0; i < root.childrenList.size(); i++) {
			count = count + countNodes(root.childrenList.get(i));
		}
		return count + 1;
	}

	int sum(TreeNode<Integer> root) {

		int sum = 0;
		for (int i = 0; i < root.childrenList.size(); i++) {
			sum = sum + sum(root.childrenList.get(i));
		}
		return sum + root.data;
	}

	public static void main(String[] args) {
		// /TreeNode<Integer> root = constructTree();
		TreeNode<Integer> root = new TreeNode<>(1);
		root.childrenList.add(new TreeNode<>(2));
		root.childrenList.add(new TreeNode<>(3));
		root.childrenList.add(new TreeNode<>(4));
		root.childrenList.get(0).childrenList.add(new TreeNode<>(5));
		root.childrenList.get(1).childrenList.add(new TreeNode<>(6));

	}

	int heightUsingQueue(TreeNode<Integer> root) {
		LinkedList<TreeNode<Integer>> queue = new LinkedList<>();

		queue.addLast(root);
		queue.addLast(null);
		int height = 0;
		while (!queue.isEmpty()) {
			TreeNode<Integer> current = queue.removeFirst();
			if (current == null) {

				if (queue.isEmpty()) {
					break;
				}
				height++;
				queue.add(null);
				continue;
			}
			for (int i = 0; i < current.childrenList.size(); i++) {
				queue.addLast(current.childrenList.get(i));
			}
		}
		return height;
	}

}
