package root;

import java.io.IOException;
import java.util.Scanner;



public class PresentationLogic {
	public static void main(String[] args) {
		BusinessLogic bl = new BusinessLogic();
		
		Scanner input=new Scanner(System.in);
		int ch=0,ch2=0;
		
		System.out.println("Welcome to the LockedMe.com application");
		System.out.println("Developer: KANDREGULA SAIAJAY KUMAR");
		System.out.println("Version: 1.0 v");
		do
	    {
			System.out.println("\nPlease Select Appropriate Option from the File Menu");
			System.out.println("-----------------------------------------------------");
			System.out.println("1. To print all files in Ascending order");
			System.out.println("2. To Create/Search/Delete a File");
			System.out.println("3. To Exit from the app");
			System.out.println("Please enter your appropriate choice between (1-3)");
				
		try
		{
			ch=Integer.parseInt(input.nextLine());
		}
		catch(NumberFormatException e)
		{
			
		}
		
		switch(ch)
		{
		case 1:
			try {
				bl.SortingFile();
			} catch (IOException e1) {
				
				//e1.printStackTrace();
				System.out.println("Directory doesnot exists");
			}
			break;
			
		case 2:
		   
			do
			{
			 System.out.println("\nPlease Select Appropriate Option from the File Menu");
			 System.out.println("-----------------------------------------------------");
			 System.out.println("4. To Create a File");
			 System.out.println("5. To Search for a File");
			 System.out.println("6. To Delete a File");
			 System.out.println("7. Navigate to Main Menu");
			 System.out.println("Please enter your appropriate choice between (4-7)");
			
			 try
			 {
			 	ch2=Integer.parseInt(input.nextLine());
			 }
			 catch(NumberFormatException e)
			 {
		 		
		     }
			switch(ch2)
			{
			 case 4:
				try {
					bl.CreateFile(bl.Filedetails());
				} catch (IOException e) {
					//e.printStackTrace();
					System.out.println("File already exists");
				}
				break;
				
			 case 5:
				try {
					bl.SearchFile(bl.Filedetails());
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				break;
				
			 case 6:
				try {
					bl.DeleteFile(bl.Filedetails());
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				break;
				
			 case 7:
				 break;
				 
				default:
					break;
			}
			} while(ch2==4 || ch2==5 || ch2==6);
			break;
			
			
		case 3:
			System.out.println("Thank you for using our app");
			break;
			
			default:
				break;
		}
		
	}while(ch!=3);

	}
	
	
}
