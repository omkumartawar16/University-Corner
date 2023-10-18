package UniversityManagement;

import java.sql.*;
public class Conn {
    Connection c;  //connection String
    Statement s;   // create statement
    Conn(){
        try {   // JDBC Connectivity Step 1: Register the Driver Class
            Class.forName("com.mysql.cj.jdbc.Driver");

             // JDBC Connectivity Step 2 : Creating connecting String
            c = DriverManager.getConnection("jdbc:mysql:///universitymanagementsystem","root","#Omkumar12");

            // JDBC Connectivity Step 3: Creating statement
            s = c.createStatement();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        
    }
}
