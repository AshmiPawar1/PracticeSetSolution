package com.synechron.ds;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class RemoveDuplicates{
	public static void main(String[] args) throws IOException  
    { 
        // PrintWriter object for output.txt 
        PrintWriter pw = new PrintWriter("output.txt"); 
          
        // BufferedReader object for input.txt 
        BufferedReader br = new BufferedReader(new FileReader("input.txt")); 
          
        String line = br.readLine(); 
         
        
        LinkedHashSet<String> hs = new LinkedHashSet<String>(); 
        
      
        while(line != null) 
        { 
            // write only if not 
            // present in hashset
        	
        	String[] values = line.split(",");
        	
        
        	if(hs.contains(values[1]+","+values[0]))
        		  line= values[1]+","+values[0];
        		 
        	  if(hs.add(line)) 
                pw.println(line); 
              line = br.readLine(); 
        	 
        } 
       
       
        pw.flush(); 
         
        br.close(); 
        pw.close(); 
          
        System.out.println("File operation performed successfully"); 
    } 
	
	
	

}
