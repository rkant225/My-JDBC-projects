import java.util.Scanner;
import java.sql.*;
public class transaction_to_update_salary_of_rajesh{
public static void main (String args[]) throws SQLException
{
Connection con=null;
Statement stmt=null;
ResultSet rs=null;

String url="jdbc:mysql://localhost:3306/newdb?useSSL=false";
String user="root";
String pass="Rahul2@@@";

Scanner sc=new Scanner(System.in);




try
{
con=DriverManager.getConnection(url,user,pass);
con.setAutoCommit(false);
stmt=con.createStatement();
stmt.executeUpdate("update employees set salary=21000 where first_name='Rajesh'");

System.out.println("If you want to COMMIT changes enter TRUE or FALSE");
boolean ans = sc.nextBoolean();


if(ans==true)
{
con.commit();
System.out.println("your updation was committed...!!!");
}
else
{
con.rollback();
System.out.println("your updation was DISCARDED...!!!");

}
}
catch (Exception exc) {
                        exc.printStackTrace();
                }


}
}

