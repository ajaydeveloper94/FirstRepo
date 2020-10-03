package root;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BusinessLogic {

	public String Filedetails()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the filename");
		String userfilename = input.next();
		
		return userfilename;
	}
	
	
	public File[] FileArray() throws IOException
	{
		  Path directorypath = Paths.get("root");
	 	  Path createdirectory = Files.createDirectories(directorypath);
	 	  
		  String directorypathtostring = createdirectory.toString();
		  
		  
		  File retreivefiles = new File(directorypathtostring);
		  File files[] = retreivefiles.listFiles();
		  return files;	
	}
	
	
	
	public void CreateFile(String userfilename) throws IOException
	{   
	
		Path directorypath = Paths.get("root");
 		Path createdirectory =Files.createDirectories(directorypath);
 		Path filepath = Paths.get(directorypath +File.separator + userfilename);
 		Path createfile = Files.createFile(filepath);
 		
	 	  
 		if(Files.exists(createdirectory))
 		{

 			if(Files.exists(createfile))
 			{
 				System.out.println("File is created successfully.");
 			}
 			else
 			{
 				Paths.get(directorypath +File.separator + userfilename);
 		 		Files.createFile(filepath);
 			}
 			
 		}
 		else
 		{
 			Paths.get("root");
 	 		Files.createDirectories(directorypath);
 		}
		
		 
	}
	
	public void SortingFile() throws IOException
	{
		  System.out.println("Directory Contains following files");
		  System.out.println("----------------------------------");
		  
		  Arrays.sort(FileArray());
		  
		  if(FileArray().length!=0)
		  {
		   for(File file:FileArray())
		   {
			  System.out.println(file.getName());
			  
		   }
		   System.out.println("\nFiles are sorted successfully");
		  }
		  else
		  {
			  System.out.println("There are no files in it. Please create files to show");
		  }
	}
	
	
	
		
		public void SearchFile(String userfilename) throws IOException
		{
			int count=0;
			Pattern pattern = Pattern.compile(Pattern.quote(userfilename),Pattern.CASE_INSENSITIVE);
					
			for(File file:FileArray())
			{
				String filetostring = file.getName();
				
				Matcher matcher = pattern.matcher(filetostring);
				if(matcher.find())
				{
					System.out.println(filetostring);
				}
				else
				{
					count++;
				}
		
			}
			if(count==FileArray().length)
			  {
				  System.out.println("No files found on this name");
			  }
			
		}
		
		public void DeleteFile(String userfilename) throws IOException
		{
			int count=0;
				  
			  int filescount = FileArray().length;
			
			  File userfile = new File(userfilename);
			
			  for (File file:FileArray() )
		      {
		        
		         String filetostring = file.getName();
		         File stringtofile = new File(filetostring);
		         if(userfile.equals(stringtofile))
		         {
		        	 if(file.delete())
		        	 {
		        		 System.out.println(file.getName()+ " " + "is deleted successfully.");
		        	 }
		         }
		         else
		         {
		             count++;		             
		         }
		       
		      }
			  
			  
			  if(count==filescount)
			  {
				  System.out.println("There are no files exist on this name");
			  }
			 
		
		}	
	
}
