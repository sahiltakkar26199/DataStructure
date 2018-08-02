package binarytree;

import java.util.LinkedList;
import java.util.Scanner;

public class BinaryTreePractise {

	static Scanner s = new Scanner(System.in);

	static BinaryTreeNode<Integer> constructTree() {
		int data = s.nextInt();
		if (data == -1) {
			return null;
		}
		BinaryTreeNode<Integer> node = new BinaryTreeNode<>(data);
		node.left = constructTree();
		node.right = constructTree();
		return node;
	}

	BinaryTreeNode<Integer> constructTreeQueue() {
		int data = s.nextInt();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);
		LinkedList<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		queue.addLast(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> node = queue.removeFirst();
			int leftChild = s.nextInt();
			if (leftChild != -1) {
				BinaryTreeNode<Integer> leftNode = new BinaryTreeNode<>(
						leftChild);
				node.left = leftNode;
				queue.addLast(leftNode);
			}
			int rightChild = s.nextInt();
			if (rightChild != -1) {
				BinaryTreeNode<Integer> rightNode = new BinaryTreeNode<>(
						rightChild);
				node.right = rightNode;
				queue.addLast(rightNode);
			}
		}
		return root;
	}

	int count(BinaryTreeNode<Integer> root) {
		LinkedList<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		queue.addLast(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> node = queue.removeFirst();
			count++;
			if (node.left != null) {
				queue.addLast(node.left);
			}
			if (node.right != null) {
				queue.addLast(node.right);
			}
		}

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	int height(BinaryTreeNode<Integer> root) {
		LinkedList<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		queue.addLast(root);
		queue.add(null);
		int height = 0;
		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> node = queue.removeFirst();
			if (node == null) {

				if (queue.isEmpty()) {
					break;
				}
				height++;
				queue.addLast(null);
				continue;
			}
			if (node.left != null) {
				queue.addLast(node.left);
			}
			if (node.right != null) {
				queue.addLast(node.right);
			}
		}

	}

	int diameter(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int l = diameter(root.left);
		int r = diameter(root.right);
		int x = height(root.left) + height(root.right) + 1;
		return Math.max(Math.max(l, r), x);
	}

	DiamtereReturnType diameterBetter(BinaryTreeNode<Integer> root) {
		if (root == null) {
			DiamtereReturnType t = new DiamtereReturnType();
			return t;
		}
		DiamtereReturnType l = diameterBetter(root.left);
		DiamtereReturnType r = diameterBetter(root.right);
		int x = l.height + r.height + 1;

		DiamtereReturnType result = new DiamtereReturnType();
		result.diameter = Math.max(Math.max(l.diameter, r.diameter), x);
		result.height = Math.max(l.height, r.height);
		return result;
	}

	static void printBinaryTree(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}

		printBinaryTree(root.left);
		printBinaryTree(root.right);
		System.out.println(root.data);
	}

	// 2 5 3 -1 -1 9 -1 -1 7 6 -1 -1 -1
	public static void main(String[] args) {
		int[] arr = {2,3,4,5,6,7};
		BinaryTreeNode<Integer> root = BSTFromArray(arr, 0, arr.length-1);

		printBinaryTree(root);

	}

	boolean isBST(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return true;
		}
		if (isBST(root.left) && isBST(root.right)) {
			int leftMax = getMax(root.left);
			int rightMin = getMin(root.right);
			if (!(root.data > leftMax && root.data < rightMin)) {
				return false;
			}
		}
	}
	
	
	static BinaryTreeNode<Integer> BSTFromArray(int[] arr, int start, int end){
		if(start>end){
			return null;
		}
		int mid = (start+end)/2;
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(arr[mid]);
		root.left = BSTFromArray(arr,start,mid-1);
		root.right = BSTFromArray(arr, mid+1,end);
		return root;
	}
	
	int preIndex =0;
	BinaryTreeNode<Integer> constructTreeUsingInPre(int[] in, int[] pre, int in_start, int in_end ){
		if(in_end<in_start){
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(pre[preIndex]);
		int index = getIndex(in, pre[preIndex++]);
		root.left= constructTreeUsingInPre(in,pre,in_start,index-1);
		root.right=constructTreeUsingInPre(in,pre,index+1,in_end);
		return root;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	boolean isBSTWithRange(BinaryTreeNode<Integer> root, int min, int max){
		if(root==null){
			return true;
		}
		if(!(root.data>min&&root.data<max)){
			return false;
		}
		return isBSTWithRange(root.left,min,root.data)&&
				isBSTWithRange(root.right,root.data, max);
	}
	
	
	
	
	
	
	
	
	
	
	
	


}

class DiamtereReturnType {
	int height;
	int diameter;
}
