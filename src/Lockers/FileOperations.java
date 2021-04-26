package Lockers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FileOperations {

	public void ListFiles(File dir) {
		 String[] files;
		 files = dir.list();
		 
		 if(files.length == 0) {
			   System.out.println("No files ..."); 
			   return;
		 }
			 
		  Arrays.sort(files);
		  System.out.println("*************************Files*************************");
		  for (String file : files) {
		        System.out.println(file);
		    }
		  System.out.println("********************************************************");
			
	}
	
	public void search(File dir) {
		System.out.println("Please enter your filename to search :");

		Scanner scan = new Scanner(System.in);
		String fileName = scan.next();	
		String filePath = dir + File.separator + fileName ;
		File file = new File(dir + File.separator + fileName);
		try {
			if(file.exists() && file.getCanonicalPath().equals(filePath)){
				 System.out.println(fileName + " Found");
			}else {
				 System.out.println(fileName + " Not Found");

			}
		} catch (IOException e) {

			e.printStackTrace();
		}
		
}

	public void addFile(File dir) {
		System.out.println("Please enter your filename to create :");

		Scanner scan = new Scanner(System.in);
		String fileName = scan.next();		
		try {
		      File newFile = new File(dir + File.separator + fileName);
		      if (newFile.createNewFile()) {
		        System.out.println("File created: " + newFile.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("Error while creating new file.");
		      e.printStackTrace();
		    }
		
}
	public void deleteFile(File dir) {
		System.out.println("Please enter your filename to delete :");

		Scanner scan = new Scanner(System.in);
		String fileName = scan.next();		
		
		try {
			  String filePath = dir+File.separator+fileName ;
			  File file = new File(dir+File.separator+fileName);
			  if(file.exists() && file.getCanonicalPath().equals(filePath)){
				  if (file.delete()) {
			        System.out.println( file.getName()+ " deleted");
			      } else {
			        System.out.println( file.getName()+ " not deleted");
			      }
			   }else{
		
				 System.out.println(fileName + " Not Found");

			}
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
}
	
}
