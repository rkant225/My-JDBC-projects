import java.sql.*;
public class delete_data_into_table{
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
int inserted=stmt.executeUpdate("delete from employees where first_name='Carl'");
if(inserted==1)
System.out.println("OK Deleted");
}
catch (Exception exc) {
                        exc.printStackTrace();
                }


}
}
