package HashMap_DS;

import java.util.HashMap;
import java.util.Map;

class Student {
	String name;

	Student(String name) {
		this.name = name;
	}
}

public class HashMapUsage {

	String maxFreqWord(String input) {
		String[] arr = input.split(" ");
		HashMap<String, Integer> map = new HashMap<>();
		for(int i =0;i<arr.length;i++){
			if(!map.containsKey(arr[i])){
				map.put(arr[i], 1);
			}else{
				int timesAppeared = map.get(arr[i]);
				map.put(arr[i], timesAppeared+1);
			}
		}
	}
	
	
	
	
	
	
	
	verticalSum(BinaryTreeNode<Integer> root, HashMap<Integer,Integer>map, int index){
	
		map.put(index,map.get(index)+root.data);
		verticalSum(root.left,map,index-1); 
		verticalSum(root.right,map,index+1); 
	}
	
	
	
	
	
	
	

	public static void main(String[] args) {
//hashmap iterate
		
		HashMap<String, Integer> map = new HashMap<>();
		map.put("sadasd", 8);
		map.put("sadasd", 8);
		map.put("sadasd", 8);
		map.put("sadasd", 8);
		for(String str: map.keySet()){
			System.out.println(str);
		}
		
		for(int value: map.values()){
			System.out.println(value);
		}
		
		
		
//		for(Map.Entry<String, Integer> entry: map.entrySet()){
//			System.out.println(entry.getKey()+" "+entry.getValue());
//		}
		
		
		
		
		
		
		
		// Integer i1 = new Integer(10);
		// Integer i2 = new Integer(10);
		//
		// Student s1 = new Student("Aman");
		// Student s3 = new Student("Amit");
		// Student s4 = new Student("Sumit");
		// Student s5 = new Student("Raman");
		// Student s6 = new Student("Amul");
		// Student s2 = new Student("Aman");
		//
		// HashMap<Student, Integer> map1 = new HashMap<>();
		// map1.put(s1, 2);
		// map1.put(s3, 4);
		// map1.put(s4, 6);
		// map1.put(s5, 8);
		// map1.put(s2, 9);
		//
		// if (s1 == s2) {
		//
		// }
		// if (s1.equals(s2)) {
		//
		// }
		//
		// String s1 = new String("Aman");
		// String s2 = new String("Aman");
		// if (s1 == s2) {
		// System.out.println("==");
		// }
		// if (s1.equals(s2)) {
		// System.out.println("equals");
		// }

		// HashMap<Student, Integer> map1 = new HashMap<>();
		// HashMap<String, Student> map2 = new HashMap<>();
		CustomHashMap<String, Integer> map = new CustomHashMap<>();
		map.put("Aman", 4);
		map.put("Amit", 5);
		map.put("Aman", 6);
		map.put("Raman", 7);
		System.out.println(map.get("Aman"));

	}
}
