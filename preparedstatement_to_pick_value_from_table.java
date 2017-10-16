import java.util.Scanner;  
import java.sql.*;
public class preparedstatement_to_pick_value_from_table{
public static void main (String args[]) throws SQLException
{
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;

String url="jdbc:mysql://localhost:3306/newdb?useSSL=false";
String user="root";
String pass="Rahul2@@@";

Scanner sc=new Scanner(System.in);
System.out.println("Enter salary to display data");
int sal=sc.nextInt();
try
{
con=DriverManager.getConnection(url,user,pass);
stmt=con.prepareStatement("select * from employees where salary>?");
stmt.setInt(1,sal);
rs=stmt.executeQuery();
while(rs.next())
{
System.out.println(rs.getString("salary") +"  "+rs.getString("id")+" "+ rs.getString("first_name")+"  "+rs.getString("last_name"));
}
}
catch (Exception exc)
{
exc.printStackTrace();
}


}
}

