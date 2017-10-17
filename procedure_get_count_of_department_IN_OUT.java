import java.util.Scanner;  
import java.sql.*;
public class procedure_get_count_of_department_IN_OUT{
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
stmt=con.prepareCall("{call  get_count_for_department(?,?)}");
stmt.setString(1,dept);
stmt.registerOutParameter(2,Types.INTEGER);

stmt.execute();
int coun=stmt.getInt(2);
System.out.println("Totan no. of employee are : " + coun);
}
catch (Exception exc)
{
exc.printStackTrace();
}
}
}
