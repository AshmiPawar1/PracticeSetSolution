package com.synechron.collections;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetDemo extends Thread { 

	static CopyOnWriteArraySet l = new CopyOnWriteArraySet(); 

	public void run() 
	{ 
		// Child thread trying to add 
		// new element in the Set object 
		l.add("D"); 
	} 
	
	public static void main(String[] args) 
	{ 
		l.add("A"); 
		l.add("B"); 
		l.add("C"); 

		// We create a child thread 
		// that is going to modify 
		// CopyOnWriteArraySet l. 
		CopyOnWriteArraySetDemo t = new CopyOnWriteArraySetDemo(); 
		t.start(); 

		// Wait for the thread to 
		// add the element. 
		try { 
			Thread.sleep(2000); 
		} 
		catch (InterruptedException e) { 
			System.out.println("child going to add element"); 
		} 
		
		System.out.println(l); 
		
		// Now we iterate through the 
		// CopyOnWriteArraySet and we 
		// wont get exception. 
		Iterator itr = l.iterator(); 
		while (itr.hasNext()) 
		{ 
			String s = (String)itr.next(); 
			System.out.println(s); 
		
			if(s.equals("C")) 
			{ 
				// Here we will get 
				// RuntimeException 
				itr.remove(); 
			} 
		} 
	} 
} 
