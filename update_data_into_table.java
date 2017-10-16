import java.sql.*;
public class update_data_into_table{
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
int inserted=stmt.executeUpdate("update employees set email='mahajan@gmail.com' where first_name='Rajat'");
if(inserted==1)
System.out.println("OK Updated");
}
catch (Exception exc) {
                        exc.printStackTrace();
                }


}
}
