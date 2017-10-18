import java.sql.*;
public class metadata_sample{
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
DatabaseMetaData md=con.getMetaData();

System.out.println("Product Name : "+ md.getDatabaseProductName());
System.out.println("Product Version : "+ md.getDatabaseProductVersion());
System.out.println("Driver Name : "+ md.getDriverName());
System.out.println("Driver Version : "+ md.getDriverVersion());

}
catch (Exception exc) {
                        exc.printStackTrace();
                }


}
}


