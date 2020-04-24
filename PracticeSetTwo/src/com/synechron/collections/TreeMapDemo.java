package com.synechron.collections;

import java.util.*;
import java.util.concurrent.*;

class Student {
	int rollno;
	String name, address;

	public Student(int rollno, String name, String address) {
		this.rollno = rollno;
		this.name = name;
		this.address = address;
	}

	public String toString() {
		return this.rollno + " " + this.name + " " + this.address;
	}
}

class Sortbyroll implements Comparator<Student> {

	public int compare(Student a, Student b) {
		return a.rollno - b.rollno;
	}
}

public class TreeMapDemo {

	public static void main(String[] args) {

		//sortedByNaturalOrderingOfKey
		TreeMap<Integer, Integer> tree_map1 = new TreeMap<Integer, Integer>();
		tree_map1.put(111, 2);
		tree_map1.put(131, 3);
		tree_map1.put(121, 1);
		System.out.println("TreeMap:sortedByNaturalOrderingOfKey " + tree_map1);
		//WE get
/*
 * Exception in thread "main" java.lang.ClassCastException:
 * com.synechron.collections.Student cannot be cast to java.lang.Comparable at
 * java.util.TreeMap.compare(Unknown Source) at java.util.TreeMap.put(Unknown
 * Source) at com.synechron.collections.TreeMapDemo.main(TreeMapDemo.java:34)
 */

		
		//sorting by rollno
		TreeMap<Student, Integer> tree_map = new TreeMap<Student, Integer>(new Sortbyroll());

		tree_map.put(new Student(111, "bbbb", "london"), 2);
		tree_map.put(new Student(131, "aaaa", "nyc"), 3);
		tree_map.put(new Student(121, "cccc", "jaipur"), 1);

		System.out.println("TreeMap:sorting by rollno " + tree_map);

	
	
	}
}
