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
    Button login;
    @FXML
    Label errorMessage;

    private Main application;
    
    
    public void setApp(Main application){
        this.application = application;
    }
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        errorMessage.setText("");
    }

    public void processLogin(ActionEvent event) {
        //System.out.println("in event");
        if (application == null){
            // We are running in isolated FXML, possibly in Scene Builder.
            // NO-OP.
            errorMessage.setText("Hello " + userId.getText());
        } else {
            if (application.countLogin.containsKey(userId.getText())&& (application.countLogin.get(userId.getText())>=3)){
               errorMessage.setText("User [" + userId.getText()+ "] had try to login more than 3 times");
           }else
            if (!application.userLogging(userId.getText(), password.getText())){
                errorMessage.setText("Unknown user [" + userId.getText()+ "] or wrong password");
            }
        }
    }
}
