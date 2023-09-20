package com.vaultofcode.miniproject;

import java.io.*;

public class LinkedListImplementation {
	Node head;
	
	class Node {
		String data;
		Node next;
		
		Node(String data){
			this.data = data;
			next = null;
		}
	}
	
	public void insertEnd(String data) {
		
		Node newNode = new Node(data);
		
		if(head == null) {
			head = new Node(data);
			return;
		}
		
		Node temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;		
	}
	
	public void insertAfter(String data, int pos) {
		
		Node newNode = new Node(data);
		Node temp=head;
		int cur=1;
		while(cur != pos) {
			temp = temp.next;
			cur++;
		}
		newNode.next = temp.next;
		temp.next = newNode;
	}
	
	public void delete(int pos) {
		if(pos == 1) {
			head = head.next;
			return;
		}
		Node temp=head;
		int cur=1;
		while(cur != pos-1) {
			temp = temp.next;
			cur++;
		}
		
		temp.next = temp.next.next;
		
	}
	
	public void update(int pos, String d) {
		Node temp = head;
		int cur = 1;
		while(cur != pos) {
			temp = temp.next;
			cur++;
		}
		temp.data = d;
	}
	
	public void saveToFile(String fileName) {
	    try {
	    	 FileWriter writer = new FileWriter(fileName);
	         BufferedWriter bufferedWriter = new BufferedWriter(writer); 

	        Node current = head;
	        while (current != null) {
	            bufferedWriter.write(current.data);
	            bufferedWriter.newLine();
	            current = current.next;
	        }
                bufferedWriter.close();
	        System.out.println("To-Do list saved to " + fileName);
	    } 
	    catch (IOException e) {
	        System.err.println("Error saving to file: " + e.getMessage());
	    }
	}
	
	public void loadFromFile(String fileName) {
	    try {
	    	FileReader reader = new FileReader(fileName);
	        BufferedReader bufferedReader = new BufferedReader(reader);

	        String line;
	        while ((line = bufferedReader.readLine()) != null) {
	            insertEnd(line); // Assuming each line in the file represents a task.
	        }

	        System.out.println("To-Do list loaded from " + fileName);
	    } 
	    catch (IOException e) {
	        System.err.println("Error loading from file: " + e.getMessage());
	    }
	}


	public void printAll(){
		int number=1;
		if(head == null) {
			System.out.println("NULL");
		}
       		 Node t = head;
        	while(t!=null){
            		System.out.println(number + " " +  t.data + " ");
            		t=t.next;
            		number++;
        	}
      }
	
}
