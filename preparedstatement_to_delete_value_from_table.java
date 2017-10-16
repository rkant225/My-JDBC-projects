import java.util.Scanner;  
import java.sql.*;
public class preparedstatement_to_delete_value_from_table{
public static void main (String args[]) throws SQLException
{
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;

String url="jdbc:mysql://localhost:3306/newdb?useSSL=false";
String user="root";
String pass="Rahul2@@@";

Scanner sc=new Scanner(System.in);
System.out.println("Enter name to delete");
String firstname=sc.next();
System.out.println("Enter salary of that person");
int sal=sc.nextInt();

try
{
con=DriverManager.getConnection(url,user,pass);
stmt=con.prepareStatement("delete from employees where first_name=? and salary=?");
stmt.setString(1,firstname);
stmt.setInt(2,sal);
int done=stmt.executeUpdate();
if (done==1)
{
System.out.println("OK Done");
}
}
catch (Exception exc)
{
exc.printStackTrace();
}


}
}
