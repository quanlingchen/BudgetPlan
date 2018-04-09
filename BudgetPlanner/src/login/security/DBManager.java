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
    private final String DB_URL = "jdbc:derby:BudgetDB;user=abc;password=123;";//create=true
    private final  String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private final  String TABLE_NAME = "users";
    
    private void exe(Statement stmt,String sql) throws Exception {
        //sql="ALTER TABLE type drop id ALTER COLUMN id set data type INT";
         stmt.executeUpdate(sql);
         System.out.println("success: "+sql);
    }
  public void connect() throws Exception
   {
      Connection conn = null  ;
      Statement stmt = null;
      try
      {
        //Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        Class.forName(DRIVER);
        System.out.println("connect loading.");
            //connect1 = DriverManager;         
        // Create a connection to the database.
          conn = DriverManager.getConnection(DB_URL);
         System.out.println("Connection to Accounts.");
          //stmt = conn.createStatement();
         String sql="create table type (id int, type_id int, content CHAR(40) NOT NULL, primary key (id, type_id) )";
         //exe(stmt,sql);
         sql="INSERT INTO type (id, type_id, content) VALUES (0,1,'question' ),(0,2,'plan' ),(0,3,'item' ),(1,1,'What''s your pet''s name?' ),(1,2,'In what city were you born?' ),(1,3,'What is the name of your first school?'" +
            "),(2,1,'weekly' ),(2,2,'biweekly' ),(2,3,'monthly' ),(2,4,'annually' ),(3,1,'income' ),(3,2,'expends' ),(3,3,'saving')";
         exe(stmt,sql);
         sql="create table users(id VARCHAR(6) primary key, email VARCHAR(30), pw VARCHAR(8) not null, quiz int, answer VARCHAR(30))";
          exe(stmt,sql);
          sql="create table plan(user_id varchar(6) references users(id), id varchar(6) primary key, name varchar(30), type int,comment varchar(30))";
          exe(stmt,sql);
          sql="create table item(user_id varchar(6)references users(id),plan_id varchar(6) references plan(id), id varchar(6) primary key, name varchar(30), amount Decimal(5,2),c_date date, type int,comment varchar(30))";
          exe(stmt,sql);
          sql="INSERT INTO users(id, email, pw,quiz,answer)values('a',null,'1',1,'a1')";
         exe(stmt,sql);
         conn.commit();

//  exe(stmt,"ALTER table type drop id");
        //exe(stmt,"ALTER table type ALTER COLUMN id set data type INT");
         //stmt.executeUpdate(sql);
        // System.out.println("success: "+sql);
          /*sql="ALTER TABLE type drop type_id  ALTER COLUMN type_id set data type INT";
         stmt.executeUpdate(sql);
         
         System.out.println("success: "+sql);
         sql="INSERT INTO type (id, type_id, content) VALUES (0,1,'question' ),(0,2,'plan' ),(0,3,'item' ),(1,1,'What''s your pet''s name?' ),(1,2,'In what city were you born?' ),(1,3,'What is the name of your first school?'" +
            "),(2,1,'weekly' ),(2,2,'biweekly' ),(2,3,'monthly' ),(2,4,'annually' ),(3,1,'income' ),(3,2,'expends' ),(3,3,'saving')";
         stmt.executeUpdate(sql);*/
         //stmt.executeUpdate("ALTER TABLE users ADD COLUMN id int UNIQUE " +//primary key
                // "ALTER TABLE users ADD COLUMN quiz int DEFAULT 1" +
                // "ALTER TABLE users ADD COLUMN validation char(1) DEFAULT 'N'" +
                // "ALTER TABLE users ADD COLUMN activation char(1)" +
        //"    ALTER TABLE users DROP COLUMN id " +
        //"    ");
         //System.out.println("success: "+sql);
        // stmt.executeUpdate("create table users(account_number varchar(20) UNIQUE, fname varchar(20), mname varchar(20), lname varchar(20), phone varchar(20), email varchar(50), password varchar(20), birth date, hint varchar(20), gender char(1))");
        sql="select * from users";
        ResultSet results = stmt.executeQuery(sql);
        System.out.println("success: "+sql);
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
                results.getInt(4) + "\t" + results.getString(5) );
            }
            results.close();
            stmt.close();
        conn.commit();
        //System.out.println("retrieve users table."); 
        // Close the connection.
         conn.close();
         //stmt.close();
         System.out.println("Connection closed.");
      }
      catch(Exception ex)
      {
         System.out.println("ERROR: connect " + ex.getMessage());
      }finally{
         if (stmt!=null) stmt.close();
           if (conn!=null)conn.close();
   }
   }
  
  
  
  
    public List<User> getUsers() throws Exception{
        Connection conn = null;
        Statement stmt = null;
        List<User> users = new ArrayList<User>();
        try
        {
            Class.forName(DRIVER);
            System.out.println("loading.");
            conn = DriverManager.getConnection(DB_URL); 
            System.out.println("Connection to Accounts.");
            stmt = conn.createStatement();
            String sql="select id, email, pw,quiz,answer from users";
            ResultSet results = stmt.executeQuery(sql);
            System.out.println("success: " + sql);
            ResultSetMetaData rsmd = results.getMetaData();
           
            while(results.next())
            {
                System.out.println(results.getString(1) + "\t" + results.getString(2) + "\t" + results.getString(3)+ "\t"+
                results.getInt(4) + "\t" + results.getString(5) );
                User u=User.of(results.getString(1) );
                 u.setEmail(results.getString(2));
                 u.setPassword(results.getString(3));
                 u.setQuiz(results.getInt(4));
                  u.setAnswer(results.getString(5));
                users.add( User.of(results.getString(1) ));
            }
            
            results.close();
            stmt.close();
            
         conn.close();
         
         //stmt.close();
         System.out.println("Connection closed.");
         return users;
      } catch(Exception ex) {
         System.out.println("ERROR: getUsers is " + ex.getMessage());
      }finally{
            if (stmt!=null) stmt.close();
            if (conn!=null)conn.close();
        }
        return null;
    }
    
    public Map<Integer,String> getQuizs(int i) throws Exception{
        Connection conn = null;
        Statement stmt = null;
        Map<Integer,String> q = new HashMap<Integer,String>();
        try
        {
            Class.forName(DRIVER);
            System.out.println("loading.");
            conn = DriverManager.getConnection(DB_URL); 
            System.out.println("Connection to Accounts.");
            stmt = conn.createStatement();
            String sql="select * from type where id=" + Integer.toString(i);
            ResultSet results = stmt.executeQuery(sql);
            System.out.println("success: "+sql);
            ResultSetMetaData rsmd = results.getMetaData();
           
            while(results.next())
            {
                System.out.println(results.getInt(1) + "\t" + results.getInt(2) + "\t" + results.getString(3) );
                q.put(results.getInt(2), results.getString(3));
            }
            
            results.close();
            stmt.close();
            
         conn.close();
         
         //stmt.close();
         System.out.println("Connection closed.");
         return q;
      } catch(Exception ex) {
         System.out.println("ERROR: getQuizs" + ex.getMessage());
      }finally{
            if (stmt!=null) stmt.close();
            if (conn!=null)conn.close();
        }
        return null;
    }
   public List getUsers1(){
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
                /*User user = User.of(results.getString(1));
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

   public void createUser(User user){
             Connection conn = null  ;
      Statement stmt = null;
      try
      {
        //Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        Class.forName(DRIVER);
        System.out.println("connect loading.");
            //connect1 = DriverManager;         
        // Create a connection to the database.
          conn = DriverManager.getConnection(DB_URL);
         System.out.println("Connection to Accounts.");
          stmt = conn.createStatement();
         String sql="";
         
          sql="INSERT INTO users(id, email, pw,quiz,answer)values('"+user.getId() +"','"+user.getEmail() +"','"+user.getPassword() +"',"+ user.getQuiz() +",'"+user.getAnswer() +"')";
         exe(stmt,sql);
         conn.commit();//sql="select * from users";
        
            stmt.close();
        conn.commit();
        //System.out.println("retrieve users table."); 
        // Close the connection.
         conn.close();
         //stmt.close();
         System.out.println("Connection closed.");
      }
      catch(Exception ex)
      {
         System.out.println("ERROR: fail to inster user " + ex.getMessage());
      }finally{
          try{
         if (stmt!=null) stmt.close();
           if (conn!=null)conn.close();
          } catch(Exception e){
              System.out.println("ERROR: fail to inster user " + e.getMessage());}
   }
   }
   public void updateUser(User user){
       Connection conn = null  ;
      Statement stmt = null;
      try
      {
        Class.forName(DRIVER);
        System.out.println("connect loading.");
          conn = DriverManager.getConnection(DB_URL);
         System.out.println("Connection to Accounts.");
          stmt = conn.createStatement();
         String sql="";
         
          sql="update users set  email ='"+user.getEmail() +"', pw='"+user.getPassword() +"',quiz ="+ user.getQuiz() +",answer='"+user.getAnswer() +"' where id ='"+user.getId() +"'";
         exe(stmt,sql);
        
            stmt.close();
        conn.commit();
         conn.close();
         System.out.println("Connection closed.");
      }
      catch(Exception ex)
      {
         System.out.println("ERROR: fail to update user " + ex.getMessage());
      }finally{
          try{
         if (stmt!=null) stmt.close();
           if (conn!=null)conn.close();
          } catch(Exception e){
              System.out.println("ERROR: fail to update user " + e.getMessage());}
   }
   }
}
