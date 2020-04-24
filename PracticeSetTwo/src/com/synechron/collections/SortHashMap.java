package com.synechron.collections;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.lang.*; 

public class SortHashMap{ 

	public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) 
	{ 
		List<Map.Entry<String, Integer> > list = 
			new LinkedList<Map.Entry<String, Integer> >(hm.entrySet()); 

		Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() { 
			public int compare(Map.Entry<String, Integer> o1, 
							Map.Entry<String, Integer> o2) 
			{ 
				return (o1.getValue()).compareTo(o2.getValue()); 
			} 
		}); 
		
		HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>(); 
		for (Map.Entry<String, Integer> aa : list) { 
			temp.put(aa.getKey(), aa.getValue()); 
		} 
		return temp; 
	} 

	public static void main(String[] args) 
	{ 
        //JAVA 7
		HashMap<String, Integer> hm = new HashMap<String, Integer>(); 

		hm.put("Math", 98); 
		hm.put("Data Structure", 85); 
		hm.put("Database", 91); 
		hm.put("Java", 95); 
		hm.put("Operating System", 79); 
		hm.put("Networking", 80); 
		Map<String, Integer> hm1 = sortByValue(hm); 

		for (Map.Entry<String, Integer> en : hm1.entrySet()) { 
			System.out.println("Key = " + en.getKey() + 
						", Value = " + en.getValue()); 
		} 
		
		
		//JAVA 8
		HashMap<String, Integer> hm2 = new HashMap<String, Integer>(); 

		hm2.put("Math", 98); 
		hm2.put("Data Structure", 85); 
		hm2.put("Database", 91); 
		hm2.put("Java", 95); 
		hm2.put("Operating System", 79); 
		hm2.put("Networking", 80); 
		
		Map<String, Integer> map1 = hm2.entrySet().stream()
				                    .sorted((m1,m2)->m1.getValue().compareTo(m2.getValue()))
				                    .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
				                    		(e1,e2)->e1,LinkedHashMap::new));
		
	 System.out.println(map1);
	} 
} 
