package DailyTaskSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class CRUDOperations {
	   
	    static ArrayList<Integer> ids=new ArrayList<>();
	 // Insert Tasks.....
		
	    public static void AddTask(Scanner sc,Connection con) throws SQLException
		{
			
			try
			{
				String name;
				while(true)
				{
			
					System.out.print("Enter Task Name=");
					name=sc.nextLine();
				
					if(name.matches("[a-zA-Z ]+"))
					{
						break;
					}
					else
					{
						System.out.println("Please enter task name using letters only!!!!");
						System.out.println();
					}
				}
				LocalDate date=LocalDate.now();
				LocalTime time=LocalTime.now();
				System.out.print("Enter Task Deadline (yyyy-mm-dd)=");
				String deadlineInput=sc.nextLine();
				LocalDate deadline=LocalDate.parse(deadlineInput);
				
									
				
				PreparedStatement ps=con.prepareStatement("insert into DailyTask(task_name,status,created_date,created_time,deadline) values(?,?,?,?,?)");
				ps.setString(1, name);
				ps.setString(2, "Pending");
				ps.setObject(3, date);
				ps.setObject(4, time);
				ps.setObject(5, deadline);
				int rs=ps.executeUpdate();
				if(rs>0)
				{
					System.out.println("Task Added Successfully");
				}
				else
				{
					System.out.println("Task not added");
				}
				
			}
			catch(Exception e)
			{
				System.out.println("Invalid Input!!!");
			}
		}
		
	
	// Show Tasks.....
		
		public static void ViewTask(Connection con) throws SQLException
		{
			PreparedStatement ps1=con.prepareStatement("select * from DailyTask");
			ResultSet rs1= ps1.executeQuery();
			
			
			int no=1;
			System.out.println("==============Task List==============");
			while(rs1.next())
			{
				ids.add(rs1.getInt("id"));
				System.out.println(no+".");
				System.out.println(" Task Name= " +rs1.getString("task_name"));
				System.out.println(" Status=" +rs1.getString("status"));
				System.out.println(" Task Created Date="+rs1.getString("created_date"));
				System.out.println(" Task Created Time="+rs1.getString("created_time"));
				System.out.println(" Task Deadline="+rs1.getString("deadline"));
				no++;

				System.out.println("-------------------------------------");
			}
		}
		
		
	//Search Task
		public static void SearchTask(Scanner sc,Connection con) throws SQLException
		{
			try
			{
				PreparedStatement ps7=con.prepareStatement("select * from DailyTask where task_name=?");
				System.out.print("Enter Task Name=");
				String name=sc.nextLine();
				ps7.setString(1, name);
				ResultSet rs7= ps7.executeQuery();
	
				
				if(rs7.next())
				{
					System.out.println("Status="+rs7.getString("status"));
					System.out.println("Deadline="+rs7.getString("deadline"));
				}
				else
				{
					System.out.println("Task Not Found!!!!");
				}
			}
			catch(Exception e)
			{
				System.out.println("Enter valid Task Name....");
			}
			
			
		}
		
		
	// Update Task
		
		public static void UpdateTask(Scanner sc,Connection con) throws SQLException
		{
			
			try
			{
				PreparedStatement ps2=con.prepareStatement("update DailyTask set Status=? where id=?");
				System.out.print("Enter Task no to update=");
				int ID=sc.nextInt();
				int actualId=ids.get(ID-1);
				ps2.setString(1, "Completed");
				ps2.setInt(2, actualId);
				
				int rs=ps2.executeUpdate();
				if(rs>0)
				{
					System.out.println("Task Updated.");
				}
				else
				{
					System.out.println("Task not updated.");
				
				}
			}
			catch(Exception e)
			{
				System.out.println("Enter Valid task no.");
			}
			
		}
		
	
	// Delete Task
		
		public static void DeleteTask(Scanner sc,Connection con) throws SQLException
		{
			
			try
			{
				PreparedStatement ps3=con.prepareStatement("delete from DailyTask where id=?");
				System.out.print("Enter task no to delete=");
				int id=sc.nextInt();
				int actualId=ids.get(id-1);
				ps3.setInt(1, actualId);
				
				int rs3=ps3.executeUpdate();
				if(rs3>0)
				{
					System.out.println("Task deleted successfully.");
				}
				else
				{
					System.out.println("Task not deleted.");
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		
	}
		
	//Show Pending Tasks
		public static void ShowPendingTask(Connection con) throws SQLException
		{
			PreparedStatement ps8=con.prepareStatement("select * from DailyTask where status='Pending'");
			ResultSet rs8= ps8.executeQuery();
			System.out.println("===========Pending Tasks===========");
			if(rs8!=null)
			{
			while(rs8.next())
			{
				System.out.println("Task Name= "+rs8.getString("task_name"));
				System.out.println("Status= "+rs8.getString("status"));
				System.out.println("Deadline="+rs8.getString("deadline"));
				
				System.out.println("----------------------------------");
			}
			}
			else
			{
				System.out.println("No Pending Tasks Found.");
			}
		}
		
		
	// View Progress
		public static void CheckProgress(Scanner sc,Connection con) throws SQLException
		{
			PreparedStatement ps=con.prepareStatement("select count(*) from DailyTask");

			ResultSet rs=ps.executeQuery();
			rs.next();
			int total=rs.getInt(1);


			PreparedStatement ps1=con.prepareStatement("select count(*) from DailyTask where Status=?");
			ps1.setString(1,"Completed");

			ResultSet rs1=ps1.executeQuery();
			rs1.next();
			int completed=rs1.getInt(1);//Get integer from COLUMN NUMBER 1



			double progress=((double)completed/total)*100;
			if(progress>=90)
			{
				System.out.println("Progress="+(int)progress+"%");
				System.out.println("🏆🔥 Excellent");
			}
			else if(progress>=60 && progress<=89)
			{
				System.out.println("Progress="+(int)progress+"%");
				System.out.println("😊👍 Good");
			}
			else if(progress>=30 && progress<=59)
			{
				System.out.println("Progress="+(int)progress+"%");
				System.out.println("😐⚡ Keep Going");
			}
			else
			{
				System.out.println("Progress="+(int)progress+"%");
				System.out.println("😴📌 Start Completing Tasks");

			}
			

		}
}
		
		
		

		
		
		
		
	


