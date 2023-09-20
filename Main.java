package com.vaultofcode.miniproject;
import java.util.*;


public class Main {
	public static void main(String[] args) {
		LinkedListImplementation list = new LinkedListImplementation();
		
		// Load tasks from a file (you can specify the file name).
	    list.loadFromFile("file.txt");
		
		int n,pos;
		String d;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("-------------TODO LIST APPLICATION-------------");
			System.out.println("1. ADD TASK ");
			System.out.println("2. ADD TASK AT POSITION");
			System.out.println("3. UPDATE TASK ");
			System.out.println("4. DELETE TASK ");
			System.out.println("5. DISPLAY TODO LIST ");
			System.out.println("6. SAVE AND EXIT ");
			System.out.println("Enter a Number :  ");
			n = sc.nextInt();
			sc.nextLine();
			switch(n) {
				case 1:
					
					System.out.println("Enter task description :  ");
					d = sc.nextLine();
					list.insertEnd(d);
					break;
					
				case 2:
					
					System.out.println("Enter task description :  ");
					d = sc.nextLine();
					System.out.println("Enter after which task you wish to place this task :  ");
					pos = sc.nextInt();
					list.insertAfter(d,pos);
					break;
					
					
				case 3:
					
					System.out.println("Enter which task you want to update : ");
					pos = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter the new description : ");
					d = sc.nextLine();
					list.update(pos, d);
					break;	
					
					
				case 4:
					System.out.println("Enter the number of which task you want to delete : ");
					pos = sc.nextInt();
					list.delete(pos);
					break;
					
					
				case 5:
					list.printAll();
					break;
					
				case 6:
					 list.saveToFile("file.txt");
					
			}
			
		}while(n!=6);
	}
	
	
}
