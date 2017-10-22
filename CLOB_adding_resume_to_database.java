import java.io.File;
import java.io.FileReader;
import java.io.FileInputStream;

import java.sql.*;
public class CLOB_adding_resume_to_database{
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
stmt=con.prepareStatement("update employees set data_file=? where email='rsradha00@gmail.com'");


File f = new File("cv.pdf");
FileReader input= new FileReader(f);
System.out.println("Path of your file is : "+f.getAbsolutePath());
stmt.setCharacterStream(1,input);

int n=stmt.executeUpdate();
if(n==1)
System.out.println("Inserted OK...!!!");
}
catch (Exception exc) {
                        exc.printStackTrace();
                }


}
}


