package login;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import login.security.Authenticator;

/**
 * Login Controller.
 *
 * @author Deepak Csac, Quanling Chen, Harika Badugu
 * @version     1.0
 * @since       2018-03-05
 */
public class LoginController extends AnchorPane {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;
    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    @FXML
    TextField userId;
    @FXML
    PasswordField password;
    @FXML
    TextField answer;
    @FXML
    Button login;
    @FXML
    Button signup;
    @FXML
    Button forgot;
    @FXML
    Label errorMessage;

    private Main application;
    
    
    public void setApp(Main application){
        this.application = application;
        answer.setVisible(false);
    }
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        errorMessage.setText("");
    }

    public void processLogin(ActionEvent event) {
        //System.out.println("in event");
        System.out.println("event: "+ event.getSource().toString());
        
        if (application == null ){
            // We are running in isolated FXML, possibly in Scene Builder.
            // NO-OP.
            errorMessage.setText("Hello " + userId.getText());
        } else {
            // user name is empty
            if(userId.getText().length()==0 || userId.getText().trim().length()==0){
                    errorMessage.setText("Please input username");
                    answer.setVisible(false);
            }else if(Authenticator.getInstance().isExist(userId.getText())){
                // user is exist
                if(event.getSource().toString().endsWith("'Sign up'")){
                    errorMessage.setText("Username is exist please input another one.");
                    answer.setVisible(false);
                }else if(event.getSource().toString().endsWith("'Forgot password'")){
                    //display secure question and answer input box
                    errorMessage.setText("Security question: " + Authenticator.getInstance().getQuizs (Authenticator.getInstance().getQuiz(userId.getText())));
                    answer.setVisible(true);
                }else if(event.getSource().toString().endsWith("'Login'")){
                    if (application.countLogin.containsKey(userId.getText())&& (application.countLogin.get(userId.getText())>=3)){
                       errorMessage.setText("User [" + userId.getText()+ "] had try to login more than 3 times! will Lock out for login");
                    }else if (!application.userLogging(userId.getText(), password.getText())){
                        //check answer is match or not
                        if (!(answer.visibleProperty().getValue() && 
                                application.userLoggingA(userId.getText(), answer.getText()))
                                ){
                            errorMessage.setText("Unknown user [" + userId.getText()+ "] or wrong password");
                        } 
                        
                    }
                }
                //---------------
            }else{//user is not exist
                if(!event.getSource().toString().endsWith("'Sign up'")){
                    errorMessage.setText("Username is not exist please input another one.");
                    answer.setVisible(false);
                }else{
                    //add a new user in cache
                    application.addUser(userId.getText().trim());
                }
            }
        }
    }
}
