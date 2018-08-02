package arrayListPractise;

import java.util.ArrayList;

public class ArrayListPractise {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("abc");
		list.add("abc");		
		list.add("abc");
		list.add("abc");
		list.add("abc");
		list.add("abc");
		list.add("abc");
		list.add("abc");
		
		list.add(5, "dqwdqwd");
		list.add("q	hdkl	qejqhwe");
		
		list.remove(0);
		
		
		for(String str : list){
			System.out.println(str);
		}
	}
}
