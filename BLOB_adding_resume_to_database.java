import java.io.File;
import java.io.FileInputStream;

import java.sql.*;
public class BLOB_adding_resume_to_database{
public static void main (String args[]) throws SQLException
{
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;

String url="jdbc:mysql://localhost:3306/newdb?useSSL=false";
String user="root";
String pass="Rahul2@@@";
try
{
con=DriverManager.getConnection(url,user,pass);
stmt=con.prepareStatement("update employees set resume=? where email='rsradha00@gmail.com'");


File f=new File("cv.pdf");
FileInputStream input_file= new FileInputStream(f);
System.out.println("Path of your file is : "+f.getAbsolutePath());
stmt.setBinaryStream(1,input_file);

int n=stmt.executeUpdate();
if(n==1)
System.out.println("Inserted OK...!!!");
}
catch (Exception exc) {
                        exc.printStackTrace();
                }


}
}

