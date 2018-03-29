package login.security;

import java.util.HashMap;
import java.util.Map;

/**
 * Authenticator.
 * 
 * @author Deepak Csac, Quanling Chen, Harika Badugu
 * @version     1.0
 * @since       2018-03-05
 */

public class Authenticator {
    private final Map<String, String> USERS = new HashMap<>();
    
    public  boolean validate(String user, String password){
        String validUserPassword = USERS.get(user);
        return validUserPassword != null && validUserPassword.equals(password);
    }
    private static Authenticator instance = null;
   protected Authenticator() {
      // Exists only to defeat instantiation.
      USERS.put("demo", "demo");
      USERS.put("a", "b");
   }
   public static Authenticator getInstance() {
      if(instance == null) {
         instance = new Authenticator();
      }
      return instance;
   }
}
