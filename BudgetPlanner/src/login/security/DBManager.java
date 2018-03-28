package login.security;

import java.sql.*;   // Needed for JDBC classes
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*; 
import login.model.User;
/**
 * Database Manager.
 * 
 * @author Deepak Csac, Quanling Chen, Harika Badugu
 * @version     1.0
 * @since       2018-03-05
 */
public class DBManager {
    // Create a named constant for the URL.
      // NOTE: This value is specific for Java DB. jdbc:derby:AccountsDB;midterm;user=root;password=password
      final String DB_URL = "jdbc:derby:AccountsDB";//;create=true
       final  String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
      final  String TABLE_NAME = "users";//manufacturer
  public void connect()
   {
      
      try
      {
        //Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Class.forName(DRIVER);
        System.out.println("loading.");
            //connect1 = DriverManager;         
        // Create a connection to the database.
         Connection conn = DriverManager.getConnection(DB_URL);
         System.out.println("Connection to Accounts.");
         Statement stmt = conn.createStatement();
         //stmt.executeUpdate("ALTER TABLE users ADD COLUMN id int UNIQUE " +//primary key
                // "ALTER TABLE users ADD COLUMN quiz int DEFAULT 1" +
                // "ALTER TABLE users ADD COLUMN validation char(1) DEFAULT 'N'" +
                // "ALTER TABLE users ADD COLUMN activation char(1)" +
        //"    ALTER TABLE users DROP COLUMN id " +
        //"    ");
         System.out.println("changed column.");
        // stmt.executeUpdate("create table users(account_number varchar(20) UNIQUE, fname varchar(20), mname varchar(20), lname varchar(20), phone varchar(20), email varchar(50), password varchar(20), birth date, hint varchar(20), gender char(1))");
        ResultSet results = stmt.executeQuery("select * from " + TABLE_NAME);
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i=1; i<=numberCols; i++)
            {
                //print Column Names
                System.out.print(rsmd.getColumnLabel(i)+"\t\t");  
            }

            System.out.println("\n-------------------------------------------------");

            while(results.next())
            {
                System.out.println(results.getString(1) + "\t" + results.getString(2) + "\t" + results.getString(3)+ "\t"+
                results.getString(4) + "\t" + results.getString(5) + "\t" + results.getString(6)+ "\t"+
                results.getDate(7) + "\t" + results.getString(8) + "\t" + results.getString(9)+ "\t"+
                results.getString(10) + "\t" + results.getInt(11) + "\t" + results.getString(12)+ "\t"+
                results.getString(13) + "\t" + results.getInt(14));
            }
            results.close();
            stmt.close();
        
        System.out.println("retrieve users table."); 
        // Close the connection.
         conn.close();
         //stmt.close();
         System.out.println("Connection closed.");
      }
      catch(Exception ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
   }
   public List getUsers(){
       List<User> users= new ArrayList<User>();
   // Create a named constant for the URL.
      // NOTE: This value is specific for Java DB. jdbc:derby:AccountsDB;
      
      try
      {
        
        Class.forName(DRIVER);
        System.out.println("loading.");
        
        // Create a connection to the database.
         Connection conn = DriverManager.getConnection(DB_URL);
         System.out.println("Connection to Accounts.");
         Statement stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("select * from " + TABLE_NAME);
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i=1; i<=numberCols; i++)
            {
                //print Column Names
                System.out.print(rsmd.getColumnLabel(i)+"\t\t");  
            }

            System.out.println("\n-------------------------------------------------");

            while(results.next())
            {
                User user = User.of(results.getString(1));/*
                user.fname = results.getString(1);
                user.mname = results.getString(2);
                user.lname = results.getString(3);
                user.phone = results.getString(4);
                user.email = results.getString(5);
                user.password = results.getString(6);
                user.birth = results.getDate(7);
                user.hint = results.getString(8);
                user.gender = results.getString(9);
                user.account_number = results.getString(10);
                user.quiz=results.getInt(11);
                user.activation= results.getString(12);
                user.validation = results.getString(13);
                user.id=results.getInt(14);
                users.add(user);*/
            }
            results.close();
            stmt.close();
        
        System.out.println("retrieve users table."); 
        // Close the connection.
         conn.close();
         //stmt.close();
         System.out.println("Connection closed.");
      }
      catch(Exception ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
      return users;
   }
   private void mappingUser(){
   
   }
   public void createUser(User user){
   try
      {
        
        Class.forName(DRIVER);
        System.out.println("loading.");
        
        // Create a connection to the database.
         Connection conn = DriverManager.getConnection(DB_URL);
         System.out.println("Connection to Accounts.");
         Statement stmt = conn.createStatement();
         int id=0;
         
         ResultSet results = stmt.executeQuery("select Count(*) from " + TABLE_NAME );
         ResultSetMetaData rsmd = results.getMetaData();
         DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
         while(results.next())
        {
            System.out.println( "count: " + results.getInt(1));
            id=results.getInt(1)+1; 
        }   
            
            
             stmt.executeUpdate("insert into "+ TABLE_NAME +"  (ID, ACCOUNT_NUMBER, FNAME, MNAME, LNAME, PHONE, EMAIL, PASSWORD, BIRTH, QUIZ, HINT, GENDER, activation,validation)values(" 
            + id + ",'"        
            //+ user.account_number+"','"+ user.fname+"','"+ user.mname+"','"+ user.lname+"','"+ user.phone+"','"+ user.email+"','"+ user.password
            //+"',DATE('"+ df.format( user.birth) +"'),"+ user.quiz+",'"+ user.hint+"','"+ String.valueOf(user.gender) +"','"+ user.activation+"','"+ user.validation +"')"
            
            );
             results = stmt.executeQuery("select * from " + TABLE_NAME );
             rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i=1; i<=numberCols; i++)
            {
                //print Column Names
                System.out.print(rsmd.getColumnLabel(i)+"\t\t");  
            }

            System.out.println("\n-------------------------------------------------");

            while(results.next())
            {
                //id = results.getInt(1);
                //String restName = results.getString(2);
                //String cityName = results.getString(3);
                System.out.println(results.getString(1) + "\t" + results.getString(2) + "\t" + results.getString(3)+ "\t"+
                results.getString(4) + "\t" + results.getString(5) + "\t" + results.getString(6)+ "\t"+
                results.getDate(7) + "\t" + results.getString(8) + "\t" + results.getString(9)+ "\t"+
                results.getString(10) + "\t" + results.getInt(11) + "\t" + results.getString(12)+ "\t"+
                results.getString(13) + "\t" + results.getInt(14) 
                );
            }
            results.close();
            stmt.close();
        
        System.out.println("retrieve users table."); 
        // Close the connection.
         conn.close();
         //stmt.close();
         System.out.println("Connection closed.");
      }
      catch(Exception ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
   }
   public void updateUser(User user){
   try
      {
        
        Class.forName(DRIVER);
        System.out.println("loading.");
        
        // Create a connection to the database.
         Connection conn = DriverManager.getConnection(DB_URL);
         System.out.println("Connection to Accounts.");
         Statement stmt = conn.createStatement();
         int id=0;
         
         ResultSet results = stmt.executeQuery("select Count(*) from " + TABLE_NAME );
         ResultSetMetaData rsmd = results.getMetaData();
         DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
         while(results.next())
        {
            System.out.println( "count: " + results.getInt(1));
            id=results.getInt(1)+1; 
        }   
            
        String update= "update "+ TABLE_NAME +" set "/*
            +"ACCOUNT_NUMBER = '"+ user.account_number + "', "
            +"FNAME = '"+ user.fname + "', "
            +"MNAME = '"+ user.mname + "', "
            +"LNAME = '"+ user.lname + "', "
            +"PHONE = '"+ user.phone + "', "
            +"EMAIL = '"+ user.email + "', "
            +"PASSWORD = '"+ user.password + "', "
            +"BIRTH = DATE('"+ df.format( user.birth) + "'), "
            +"QUIZ = '"+ user.quiz + "', "
            +"HINT = '"+ user.email + "', "
            +"GENDER = '"+ String.valueOf(user.gender) + "' "
            +" where ID ="+ user.id*/;    
        stmt.executeUpdate(update);
             results = stmt.executeQuery("select * from " + TABLE_NAME );
             rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i=1; i<=numberCols; i++)
            {
                //print Column Names
                System.out.print(rsmd.getColumnLabel(i)+"\t\t");  
            }

            System.out.println("\n-------------------------------------------------");

            while(results.next())
            {
                //id = results.getInt(1);
                //String restName = results.getString(2);
                //String cityName = results.getString(3);
                System.out.println(results.getString(1) + "\t" + results.getString(2) + "\t" + results.getString(3)+ "\t"+
                results.getString(4) + "\t" + results.getString(5) + "\t" + results.getString(6)+ "\t"+
                results.getDate(7) + "\t" + results.getString(8) + "\t" + results.getString(9)+ "\t"+
                results.getString(10) + "\t" + results.getInt(11) + "\t" + results.getString(12)+ "\t"+
                results.getString(13) + "\t" + results.getInt(14) 
                );
            }
            results.close();
            stmt.close();
        
        System.out.println("retrieve users table."); 
        // Close the connection.
         conn.close();
         //stmt.close();
         System.out.println("Connection closed.");
      }
      catch(Exception ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
   }
   public boolean searchUser(String accountNum){
    boolean find = false;
    if (!accountNum.trim().equals("")){
      try
      {
        
        Class.forName(DRIVER);
        System.out.println("loading.");
        
        // Create a connection to the database.
         Connection conn = DriverManager.getConnection(DB_URL);
         System.out.println("Connection to Accounts.");
         Statement stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("select Count(*) from " + TABLE_NAME +" where account_number ='"+ accountNum + "'");
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i=1; i<=numberCols; i++)
            {
                //print Column Names
                System.out.print(rsmd.getColumnLabel(i)+"\t\t");  
            }

            System.out.println("\n-------------------------------------------------");

            while(results.next())
            {
                //int id = results.getInt(1);
                System.out.println( "count: " + results.getInt(1));
                if (results.getInt(1)>0 ) find = true;
                //String restName = results.getString(2);
                //String cityName = results.getString(3);
                //System.out.println(id + "\t\t" + restName + "\t\t" + cityName);
            }
            results.close();
            stmt.close();
        
        System.out.println("retrieve users table."); 
        // Close the connection.
         conn.close();
         //stmt.close();
         System.out.println("Connection closed.");
      }
      catch(Exception ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
    
    }
    return find;
   }
}
