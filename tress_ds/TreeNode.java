package tress_ds;

import java.util.ArrayList;

public class TreeNode<T> {

	T data;
	ArrayList<TreeNode<T>> childrenList;
	
	TreeNode(T data){
		this.data = data;
		this.childrenList = new ArrayList<TreeNode<T>>();
	}
}
