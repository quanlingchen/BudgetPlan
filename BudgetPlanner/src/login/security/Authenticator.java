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
    private static final Map<String, String> USERS = new HashMap<>();
    static {
        USERS.put("demo", "demo");
        USERS.put("a", "b");
    }
    public static boolean validate(String user, String password){
        String validUserPassword = USERS.get(user);
        return validUserPassword != null && validUserPassword.equals(password);
    }
}
