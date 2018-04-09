package login.security;

import java.util.HashMap;
import java.util.Map;
//import login.model.Plan;
/**
 * Authenticator.
 * 
 * @author Deepak Csac, Quanling Chen, Harika Badugu
 * @version     1.0
 * @since       2018-03-05
 */

public class Authenticator {
    private final String DB_URL = "jdbc:derby:BudgetDB;create=true";
    private final  String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private final  String TABLE_NAME = "students";

    private Map<String, String> USERS = new HashMap<>();
    private Map<String, Integer> Quiz = new HashMap();
    private Map<String, String> Answer = new HashMap<>();
    //private Map<String, Plan> Planlist = new HashMap<>();
    private Map<Integer, String> Quizs = new HashMap();
    
    public  boolean validate(String user, String password){
        String validUserPassword = USERS.get(user);
        return validUserPassword != null && validUserPassword.equals(password);
    }
    public boolean removeUser(String user){
        if (USERS.containsKey(user)) {
            USERS.remove(user);
            return true;
        }
        return false;
    }
    public boolean addUser(String user){
        if (USERS.containsKey(user)) 
            return false;
        USERS.put(user, user);
        return true;
    }
    public boolean isExist(String user){
        
        return USERS.containsKey(user);
    }
    
    public void setPassword(String user, String pw){
        
        if( USERS.containsKey(user)){
            USERS.put(user, pw);
        }
    }
    public int getQuiz(String user){
        int q =1;
        if( Quiz.containsKey(user)) return  Quiz.get(user);
        return q;
    }
    public void setQuiz(String user, int q){
        if( USERS.containsKey(user))   Quiz.put(user,q);
    }
    public void setAnswer(String user, String a){
        if( USERS.containsKey(user))   Answer.put(user,a);
    }
    public String getAnswer(String user){
        String q ="";
        if( Answer.containsKey(user)) return  Answer.get(user);
        return q;
    }
    private static Authenticator instance = null;
   protected Authenticator() {
      //read database for password
      // Exists only to defeat instantiation.
      USERS.put("demo", "demo");
      USERS.put("a", "b");
      Quiz.put("demo",1);
      Quiz.put("a",0);
      Answer.put("a", "b1");
      Answer.put("demo", "demo1");
      Quizs.put(1, "What's your pet's name?");
      Quizs.put(2, "In what city were you born?");
      Quizs.put(3, "What is the name of your first school?");
   }
   public static Authenticator getInstance() {
      if(instance == null) {
         instance = new Authenticator();
      }
      return instance;
   }
}
