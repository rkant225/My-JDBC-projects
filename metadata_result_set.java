import java.sql.*;
public class metadata_result_set{
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
//rs=stmt.executeQuery("select id,first_name,last_name,salary from employees");
rs=stmt.executeQuery("select * from employees");
ResultSetMetaData rsmd=rs.getMetaData();

int col_cnt=rsmd.getColumnCount();
System.out.println("There are total "+col_cnt+" columns Selected.");


for(int col=1;col<=col_cnt;col++)
{
System.out.println("Column name : "+rsmd.getColumnName(col));
System.out.println("Column type  name : "+rsmd.getColumnTypeName(col));
System.out.println("Is column NULABLE : "+rsmd.isNullable(col));
System.out.println("Is this column is Autoincremented : "+rsmd.isAutoIncrement(col));
}

}
catch (Exception exc) {
                        exc.printStackTrace();
                }}}

