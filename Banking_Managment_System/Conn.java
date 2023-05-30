package Banking_Managment_System;
import java.sql.*;
public class Conn {
  
  // i well make this class as object will use as object

  //Step of connect jdbc
  // 1] Register the Driver
  // 2] Create Connection
  // 3] Create Statement
  // 4] Execute Query
  // 5] Close Connection


  // Step Create Connection

  Connection c;
    Statement s;

  

public Conn(){
    // making global connection 
    
     // use Exception Handling Bcoz My Sql is a external intity so there is been chance to have error soo use try catch
     try{
          // to Register the Driver there is a class
          
          // Connecton create
         c = DriverManager.getConnection("jdbc:mysql:///bankmanagmentsystem", "root","7083093390");
          s = c.createStatement();
     }
     catch(Exception e){
             System.out.println(e);
     }
  }


}
