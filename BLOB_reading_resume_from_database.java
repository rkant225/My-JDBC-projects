import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.sql.*;
public class BLOB_reading_resume_from_database{
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
rs=stmt.executeQuery("select resume from employees where email='rsradha00@gmail.com'");

File f=new File("cv_from_db.pdf");
FileOutputStream fos= new FileOutputStream(f);

while(rs.next())
{

InputStream is=rs.getBinaryStream("resume");
byte[] buffer = new byte[1];
while(is.read(buffer)>0)
{
fos.write(buffer);
}
}


System.out.println("Retrived OK...!!!");
}
catch (Exception exc) {
                        exc.printStackTrace();
                }


}
}


