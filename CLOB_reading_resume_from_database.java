import java.io.InputStream;
import java.io.File;
import java.io.Reader;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.*;
public class CLOB_reading_resume_from_database{
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
rs=stmt.executeQuery("select data_file from employees where email='rsradha00@gmail.com'");
File f=new File("cv_from_db_text_clob.pdf");
FileWriter output = new FileWriter(f);
if(rs.next())
{
Reader input=rs.getCharacterStream("data_file");
int theChar;
while((theChar=input.read())>0)
{
output.write(theChar);
}
}
System.out.println("Retrived OK...!!!");
}
catch (Exception exc) {
                        exc.printStackTrace();
                }}}


