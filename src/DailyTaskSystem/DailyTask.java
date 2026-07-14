package DailyTaskSystem;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class DailyTask {
	
	public static void main(String[] args) throws SQLException 
	{
		Scanner sc=new Scanner(System.in);
		
		Connection con=Connectivity.conn();
		
		System.out.println("***Welcome to Daily Task Management System***");
			
		int choice = 0;
		do
		{
			System.out.println();
			System.out.println("==============================");
			System.out.println("|Daily Task Management System|");
			System.out.println("==============================");
			System.out.println("| 1.Add Task.                |");
			System.out.println("| 2.View All Tasks.          |");
			System.out.println("| 3.Search Task.             |");
			System.out.println("| 4.Update Task.             |");
			System.out.println("| 5.Delete Task.             |");
			System.out.println("| 6.Show Pending Tasks.      |");
			System.out.println("| 7.View Progress.           |");
			System.out.println("| 8.Exit.                    |");
			System.out.println("==============================");
			while(true)
			{
				try
				{
					System.out.print("Enter your choice=");
					choice=sc.nextInt();
					sc.nextLine();
					break;
				}
				catch(Exception e)
				{
					System.out.println("Enter Valid Choice(1,2,3,4,5,6,7,8)....");
					sc.nextLine();
					System.out.println();
				}
			}
			System.out.println();
			
			switch(choice)
			{
			case 1:
				CRUDOperations.AddTask(sc, con);
				break;
				
			case 2:
				CRUDOperations.ViewTask(con);
				break;
				
			case 3:
				CRUDOperations.SearchTask(sc,con);
				break;
			
			case 4:
				CRUDOperations.ViewTask(con);
				CRUDOperations.UpdateTask(sc,con);
				break;
				
			case 5:
				CRUDOperations.ViewTask(con);
				CRUDOperations.DeleteTask(sc,con);
				break;
				
				
			case 6:
				CRUDOperations.ShowPendingTask(con);
				break;
				
			case 7:
				CRUDOperations.CheckProgress(sc,con);
				break;
				
			case 8:
				System.out.println("Thanks For Visiting This System.....");
				break;
				
			default:
				System.out.println("Invalid choice...");
			}
		}while(choice!=8);
	}
			

}
