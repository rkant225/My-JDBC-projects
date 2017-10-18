import java.sql.*;
public class metadata_sample2_table_info{
public static void main (String args[]) throws SQLException
{
Connection con=null;
Statement stmt=null;
ResultSet rs=null;

String catalog=null;
String schemaPattern=null;
String columnNamePattern=null;
String[] types=null;

String url="jdbc:mysql://localhost:3306/newdb?useSSL=false";
String user="root";
String pass="Rahul2@@@";
try
{
con=DriverManager.getConnection(url,user,pass);
DatabaseMetaData md=con.getMetaData();

rs=md.getTables(catalog,schemaPattern,columnNamePattern,types);



System.out.println("Table names");
while(rs.next())
{
System.out.println(rs.getString("TABLE_NAME"));
}

rs=md.getColumns(catalog,schemaPattern,"employees", columnNamePattern);


System.out.println("Column names");
while(rs.next())
{
System.out.println(rs.getString("COLUMN_NAME"));
}




}
catch (Exception exc) {
                        exc.printStackTrace();
                }


}
}


