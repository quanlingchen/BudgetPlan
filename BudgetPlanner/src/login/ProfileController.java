package login;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import login.model.User;
import login.security.Authenticator;

/**
 * Profile Controller.
 * 
 * @author Deepak Csac, Quanling Chen, Harika Badugu
 * @version     1.0
 * @since       2018-03-05
 */
public class ProfileController extends AnchorPane {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;
    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    @FXML
    private TextField user;
    @FXML
    private ComboBox quiz;//TextField phone;
    @FXML
    private TextField answer;
    @FXML
    private TextField email;
    @FXML
    private TextField security;
    @FXML
    private TextArea address;
    @FXML
    private CheckBox subscribed;
    @FXML
    private Hyperlink logout;
    @FXML 
    private Button update;
    @FXML 
    private Button reset;
    @FXML 
    private Label success;
    @FXML 
    private Label welcome;
    @FXML 
    private Label labpw;
    
    private Main application;
    private boolean hasUpdated;
    public void setApp(Main application){
        System.out.println("in profile controller");
        this.application = application;
        System.out.println("1");
        User loggedUser = application.getLoggedUser();
        System.out.println("2" + loggedUser);
        user.setText(loggedUser.getId());System.out.println("3");
        email.setText(loggedUser.getEmail());System.out.println("4");
        answer.setText(loggedUser.getAnswer());System.out.println("5");
        //phone.setText(loggedUser.getPhone());
        if (loggedUser.getAddress() != null) {
            address.setText(loggedUser.getAddress());
        }
        //security.setText(loggedUser.getSecurity());
        
        subscribed.setSelected(loggedUser.isSubscribed());
        success.setOpacity(0);
        hasUpdated = false;
        if(welcome.getText().equals("Please fill up profile.") )
        {
            labpw.setText("Password"); 
        }
        quiz.getItems().addAll(
    "What's your pet's name?",
    "In what city were you born?",
    "What is the name of your first school?"
);
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    }
    
    public void processLogout(ActionEvent event) {
        
        if (application == null){
            return;
        }
        if(welcome.getText().equals("Please fill up profile.") && !hasUpdated)
        {
            //remove user
            System.out.println("remove user" + Authenticator.getInstance().removeUser(user.getText()));
        }
        application.userLogout();
    }
    public void processReset(ActionEvent event) {
        if (application == null){
            animateMessage();
            return;
        }
        User loggedUser = application.getLoggedUser();
        user.setText(loggedUser.getId());
        email.setText(loggedUser.getEmail());
        answer.setText(loggedUser.getAnswer());
        //quiz.setText(loggedUser.getQuiz());
        if (loggedUser.getAddress() != null) {
            address.setText(loggedUser.getAddress());
        }
        //security.setText(loggedUser.getSecurity());
        
        subscribed.setSelected(loggedUser.isSubscribed());
        animateMessage();
    }
    public void processUpdate(ActionEvent event) {
        if (application == null){
            animateMessage();
            return;
        }
        User loggedUser = application.getLoggedUser();
        //loggedUser.set
        loggedUser.setEmail(email.getText());
        loggedUser.setAnswer(answer.getText());
//        loggedUser.setQuiz(quiz.getText());
        loggedUser.setSubscribed(subscribed.isSelected());
        loggedUser.setAddress(address.getText());
        //loggedUser.setSecurity(security.getText());
        animateMessage();
        hasUpdated = true;
    }

    private void animateMessage() {
        FadeTransition ft = new FadeTransition(Duration.millis(3000), success);
        ft.setFromValue(0.0);
        ft.setToValue(1);
        ft.play();
    }
    public void setWelcome(String value){
        welcome.setText(value);
    }
    private boolean checkChange(){
        boolean rtn = false;
        return rtn;
    }
}
