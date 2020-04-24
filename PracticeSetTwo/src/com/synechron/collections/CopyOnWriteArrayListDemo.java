package com.synechron.collections;

import java.util.concurrent.CopyOnWriteArrayList; 
import java.util.*; 

class CopyOnWriteArrayListDemo extends Thread { 

	static CopyOnWriteArrayList l = new CopyOnWriteArrayList(); 

	public void run() 
	{ 
		// Child thread trying to 
		// add new element in the 
		// Collection object 
		l.add("D"); 
	} 

	public static void main(String[] args) 
		throws InterruptedException 
	{ 
		l.add("A"); 
		System.out.println("CopyOnWriteArrayList hashCode Before :" +l.hashCode());
		l.add("B"); 
		System.out.println("CopyOnWriteArrayList hashCode Before :" +l.hashCode());
		l.add("c"); 
        System.out.println("CopyOnWriteArrayList hashCode Before :" +l.hashCode());
        
        
        
		// We create a child thread 
		// that is going to modify 
		// ArrayList l. 
		CopyOnWriteArrayListDemo t = new CopyOnWriteArrayListDemo(); 
		t.run(); 

		 System.out.println("CopyOnWriteArrayList hashCode Before :" +l.hashCode());
		 //2926499
		Thread.sleep(1000); 

		// Now we iterate through 
		// the ArrayList and get 
		// exception. 
		Iterator itr = l.iterator(); 
		while (itr.hasNext()) { 
			String s = (String)itr.next();
			//itr.remove();
			//Exception in thread "main" java.lang.UnsupportedOperationException
			System.out.println(s); 
			Thread.sleep(1000); 
		} 
		System.out.println(l); 
	} 
} 
