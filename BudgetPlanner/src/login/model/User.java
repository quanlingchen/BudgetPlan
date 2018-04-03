package login.model;

import java.util.HashMap;
import java.util.Map;
/**
 * User Model.
 * 
 * @author Deepak Csac, Quanling Chen, Harika Badugu
 * @version     1.0
 * @since       2018-03-05
 */
public class User {

    private static final Map<String, User> USERS = new HashMap<String, User>();

    public static User of(String id) {
        User user = USERS.get(id);
        if (user == null) {
            user = new User(id);
            USERS.put(id, user);
        }
        return user;
    }
    public static User off(String id) {
        User user = USERS.get(id);
        if (user != null) {
            //user = new User(id);
            USERS.remove(id);
        }
        return user;
    }
    private User(String id) {
        this.id = id;
    }
    private String id;

    public String getId() {
        return id;
    }
    private int quiz = 1;
    private String answer ="";
    private String email = "";
    //private String phone = "";
    //private boolean subscribed;
    //private String address = "";
    private String pw = "";

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the quiz
     */
    public int getQuiz() {
        return quiz;
    }

    /**
     * @param quiz the phone to set
     */
    public void setQuiz(int quiz) {
        this.quiz = quiz;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return pw;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String pw) {
        this.pw = pw;
    }
    /**
     * @return the answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * @param answer the answer to set
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
