import java.sql.*;
public class insert_data_into_table{
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
int inserted=stmt.executeUpdate("insert into employees(last_name,first_name,email,department,salary)values('singh','Paritosh','pari202@gmail.com','HR',54000)");
if(inserted==1)
System.out.println("OK new entry is added");
}
catch (Exception exc) {
                        exc.printStackTrace();
                }


}
}
