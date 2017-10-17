
import java.util.Scanner;  
import java.sql.*;
public class procedure_that_return_resultset_IN{
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
stmt=con.prepareCall("{call  get_employees_for_department(?)}");
stmt.setString(1,dept);

stmt.execute();
rs=stmt.getResultSet();
while(rs.next())
{
System.out.println(rs.getString("id")+" "+ rs.getString("first_name")+"  "+rs.getString("last_name") +"  "+rs.getString("email"));
}


}
catch (Exception exc)
{
exc.printStackTrace();
}
}
}
