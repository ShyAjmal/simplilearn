package Lockers;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Home {
	
   static File folder;
   static Boolean  flagFileOps = false;
    
	public  static void  projectDetails() {
		System.out.println("********************************************************");
		System.out.println("*******************  Lockers Pte Ltd   *****************");
		System.out.println("*************  Developed BY : Shyma Ajmal *************");
		System.out.println("********************************************************");
		System.out.println(" ");
	}
	
	public  static void  displayMainMenu() {
		System.out.println("********************************************************");
		System.out.println("                 ENTER YOUR CHOICE");
		System.out.println("Choose 1: For listing all files");
		System.out.println("Choose 2: For file add/delete/search ");
		System.out.println("Choose 3: Exit ");
		System.out.println("********************************************************");
		System.out.println(" ");
		
	}
	public  static void  displayFileMenu() {
		System.out.println("********************************************************");
		System.out.println("         ENTER YOUR CHOICE FOR FILE OPERATIONS");
		System.out.println("Choose 1: Add new File");
		System.out.println("Choose 2: Search file");
		System.out.println("Choose 3: Delete file");
		System.out.println("Choose 4: Exit file operations");
		System.out.println(" ");
		System.out.println("********************************************************");
		
	}


	public static void getLocation() {
		while(folder == null) {
			try {
				System.out.println("Please enter your folder location :");
				
				Scanner scan = new Scanner(System.in);
				String location = scan.next();
				folder = new File(location);
				if(folder.isDirectory()) {
					return;
				}
				else {
					folder =null;
					System.out.println("Location not Found");
				}
			
			
			}catch(Exception e) {
				System.out.println("Location not found");
			}
	
		}
	}
	
	public static int getNextOption() {
		int option = 0;
		if (flagFileOps == true)
			displayFileMenu();
		else 
			displayMainMenu();
		try {
			Scanner scan = new Scanner(System.in);
			option = scan.nextInt();
		}catch(Exception e) {
			 option = 10;
		}
		return option;
	}

	

	public static void main(String[] args) {
	
		projectDetails();
		int option  = 0;
		option = getNextOption();
			FileOperations fileOps = new FileOperations();		
			
			while (true) {															
				switch (option) {				
				case 1:
						
					getLocation();
					fileOps.ListFiles(folder);
						
					option= getNextOption();
					break;
					
				case 2:
					getLocation();
					flagFileOps = true;
					option= getNextOption();
					while (flagFileOps == true ) {															
						switch (option) {				
						case 1:
			               fileOps.addFile(folder);						
												
							option= getNextOption();
							break;
							
						case 2:
							fileOps.search(folder);
					
							option= getNextOption();
							break;
							
						case 3:
					
							fileOps.deleteFile(folder);
						
							option= getNextOption();
							break;
							
						case 4:
							flagFileOps = false;
							option = getNextOption();
							break;
				
						default:
							System.out.println("Invalid menu option");
							option= getNextOption();
							break;
						}	
					}
					break;
					
					
				case 3:

					folder = null;
					option = getNextOption();
					break;

				default:
					System.out.println("Invalid menu option");
					option= getNextOption();
					break;
				}	
			}
	
		
	}

}
