import java.sql.*;
public class print_data_from_database_table{
public static void main (String args[]) throws SQLException
{
Connection con=null;
Statement stmt=null;
ResultSet rs=null;

String url="jdbc:mysql://localhost:3306/newdb?useSSL=false";
String user="root";
String pass="Rahul2@@@";
try
{
con=DriverManager.getConnection(url,user,pass);
stmt=con.createStatement();
rs=stmt.executeQuery("select * from employees");
while(rs.next())
{
System.out.println(rs.getString("id")+" "+ rs.getString("first_name")+"  "+rs.getString("last_name") +"  "+rs.getString("email")+" "+ rs.getString("department")+"  "+rs.getString("salary"));
}
}
catch (Exception exc)
{
exc.printStackTrace();
}


}
}
