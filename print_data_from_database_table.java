import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;
import java.sql.*;
public class print_data_from_database_table{
public static void main (String args[]) throws SQLException
{
Connection con=null;
Statement stmt=null;
ResultSet rs=null;


try
{

Properties props=new Properties();
File f=new File("config_file.properties");
FileInputStream input= new FileInputStream(f);


props.load(input);


String url=props.getProperty("url");
String user=props.getProperty("user");
String pass=props.getProperty("pass");


con=DriverManager.getConnection(url,user,pass);
stmt=con.createStatement();
rs=stmt.executeQuery("select * from employees");
while(rs.next())
{
System.out.println(rs.getString("id")+" "+ rs.getString("first_name")+"  "+rs.getString("last_name") +"  "+rs.getString("email")+" "+ rs.getString("department")+"  "+rs.getInt("salary"));
}
}
catch (Exception exc)
{
exc.printStackTrace();
}


}
}
