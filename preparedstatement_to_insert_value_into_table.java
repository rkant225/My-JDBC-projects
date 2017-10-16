import java.util.Scanner;
import java.sql.*;
public class preparedstatement_to_insert_value_into_table{
public static void main (String args[]) throws SQLException
{
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;

String url="jdbc:mysql://localhost:3306/newdb?useSSL=false";
String user="root";
String pass="Rahul2@@@";
System.out.println("last_name first_name email department salary");
Scanner sc=new Scanner(System.in);

System.out.println("Enter Last name");
String lastname=sc.next();

System.out.println("Enter Firsr name");
String firstname=sc.next();

System.out.println("Enter E-mail");
String email=sc.next();

System.out.println("Enter Department");
String department=sc.next();

System.out.println("Enter salary of that person");
int salry=sc.nextInt();

try
{
con=DriverManager.getConnection(url,user,pass);
stmt=con.prepareStatement("insert into employees (last_name,first_name,email,department,salary)values(? ,?, ?, ?, ?)");
stmt.setString(1,lastname);
stmt.setString(2,firstname);
stmt.setString(3,email);
stmt.setString(4,department);
stmt.setInt(5,salry);

int done=stmt.executeUpdate();
if (done==1)
{
System.out.println("OK Inserted");
}
}
catch (Exception exc)
{
exc.printStackTrace();
}
}
}
