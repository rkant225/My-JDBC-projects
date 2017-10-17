import java.util.Scanner;  
import java.sql.*;
public class procedure_greet_the_department_INOUT{
public static void main (String args[]) throws SQLException
{
Connection con=null;
CallableStatement stmt=null;
ResultSet rs=null;

String url="jdbc:mysql://localhost:3306/newdb?useSSL=false";
String user="root";
String pass="Rahul2@@@";

Scanner sc=new Scanner(System.in);


System.out.println("Enter Department ");
String dept=sc.next();


try
{
con=DriverManager.getConnection(url,user,pass);
stmt=con.prepareCall("{call greet_the_department(?)}");
stmt.registerOutParameter(1, Types.VARCHAR);
stmt.setString(1,dept);

stmt.execute();
String st=stmt.getString(1);
System.out.println("Result is : " + st);
}
catch (Exception exc)
{
exc.printStackTrace();
}
}
}
