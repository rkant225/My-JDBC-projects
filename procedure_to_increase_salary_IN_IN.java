import java.util.Scanner;  
import java.sql.*;
public class procedure_to_increase_salary_IN_IN{
public static void main (String args[]) throws SQLException
{
Connection con=null;
CallableStatement stmt=null;
ResultSet rs=null;

String url="jdbc:mysql://localhost:3306/newdb?useSSL=false";
String user="root";
String pass="Rahul2@@@";

Scanner sc=new Scanner(System.in);

System.out.println("Enter the salary to increase");
int salinc=sc.nextInt();

System.out.println("Enter Department ");
String dept=sc.next();


try
{
con=DriverManager.getConnection(url,user,pass);
stmt=con.prepareCall("{call increase_salary_of_department(?,?)}");
stmt.setString(2,dept);
stmt.setDouble(1,salinc);
stmt.execute();
System.out.println("OK");
}
catch (Exception exc)
{
exc.printStackTrace();
}


}
}

