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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import java.util.Optional;
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
    private TextField pw;
    @FXML
    private TextField conpw;
   
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
    @FXML 
    private Label errorMessage;
    
    private Main application;
    private boolean hasUpdated;
    public void setApp(Main application){
        System.out.println("in profile controller");
        quiz.getItems().addAll(
    "What's your pet's name?",
    "In what city were you born?",
    "What is the name of your first school?"
);
        this.application = application;
        System.out.println("1");
        User loggedUser = application.getLoggedUser();
        loggedUser.setAnswer(Authenticator.getInstance().getAnswer(loggedUser.getId()));
        loggedUser.setQuiz(Authenticator.getInstance().getQuiz(loggedUser.getId()));
        
        System.out.println("2" + loggedUser);
        user.setText(loggedUser.getId());System.out.println("2" + loggedUser.getId());
        email.setText(loggedUser.getEmail());
        answer.setText(loggedUser.getAnswer());
        
        //phone.setText(loggedUser.getPhone());
        
        //security.setText(loggedUser.getSecurity());
        
        //subscribed.setSelected(loggedUser.isSubscribed());
        success.setOpacity(0);
        hasUpdated = false;
        if(welcome.getText().equals("Please fill up profile.") )
        {
            labpw.setText("Password"); 
        }else{
            //pw.setText(loggedUser.getPassword());
        }
        
        quiz.getSelectionModel().select(loggedUser.getQuiz());
        //
       //quiz.getSelectionModel().select( Authenticator.getInstance().getQuiz(loggedUser.getId()));
       //answer.setText(Authenticator.getInstance().getAnswer(loggedUser.getId()));
        
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    }
    public void processPlanList(ActionEvent event) {
        if (application == null){
            return;
        }
        application.itemLogout();//gotoplan
    }
    public void processLogout(ActionEvent event) {
        
        if (application == null){
            return;
        }
        if(isModified()) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Profile modified");
            alert.setContentText("Looks profile had been modified. Are you sure you want to logout?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.CANCEL){
                return;// ... user chose CANCEL or closed the dialog
            }
        }
        if(welcome.getText().equals("Please fill up profile.") && !hasUpdated)
        {
            //remove user from catch
            System.out.println("remove user" + Authenticator.getInstance().removeUser(user.getText()));
        }
        application.userLogout();
    }
    public void processReset(ActionEvent event) {
        if (application == null){
            animateMessage();
            return;
        }
        errorMessage.setText("");
        User loggedUser = application.getLoggedUser();
        user.setText(loggedUser.getId());
        email.setText(loggedUser.getEmail());
        answer.setText(loggedUser.getAnswer());
        quiz.getSelectionModel().select(loggedUser.getQuiz());
        pw.setText("");
        conpw.setText("");
        //security.setText(loggedUser.getSecurity());
        
        //subscribed.setSelected(loggedUser.isSubscribed());
        //animateMessage();
    }
    public void processUpdate(ActionEvent event) {
        errorMessage.setText("");
        if (application == null){
            animateMessage();
            return;
        }
        if(answer.getText().equals("")){
            errorMessage.setText("Please input answer.");
            return;
        }
        //validation
        if(welcome.getText().equals("Please fill up profile.")){
            // must input password
            if(pw.getText().equals("")){
                errorMessage.setText("Please input password.");
                return;
            }
            if(conpw.getText().equals("")){
                errorMessage.setText("Please input password.");
                return;
            }
            // password doesn't match
            if(!pw.getText().equals(conpw.getText())){
                errorMessage.setText("Password is not match.");
                return;
            }
        } else{
            // password doesn't match
            if(!pw.getText().equals(conpw.getText())){
                if(!pw.getText().equals("") ||!conpw.getText().equals("") ){
                    errorMessage.setText("Password is not match.");
                    return;
                }
            }
        
        }
        
        User loggedUser = application.getLoggedUser();
        //loggedUser.set
        loggedUser.setEmail(email.getText());
        loggedUser.setAnswer(answer.getText());
        loggedUser.setQuiz(quiz.getSelectionModel().getSelectedIndex());
        loggedUser.setPassword(pw.getText());
        //may not need these 2 lines when db set up
        Authenticator.getInstance().setPassword(loggedUser.getId(),pw.getText());
        Authenticator.getInstance().setAnswer(loggedUser.getId(),answer.getText());
        Authenticator.getInstance().setQuiz(loggedUser.getId(),quiz.getSelectionModel().getSelectedIndex());
        //loggedUser.setAddress(address.getText());
        //loggedUser.setSecurity(pw.getText());
        pw.setText("");
        conpw.setText("");
        animateMessage();
        hasUpdated = true;
    }
    
    private boolean isModified() {
        boolean rtn = false;
        User loggedUser = application.getLoggedUser();
        rtn = !answer.getText().equals(loggedUser.getAnswer()) ||
                !email.getText().equals(loggedUser.getEmail()) ||
                quiz.getSelectionModel().getSelectedIndex() != loggedUser.getQuiz()||
                (!pw.getText().equals("")&&!pw.getText().equals(loggedUser.getPassword())) || 
                !conpw.getText().equals("")
                //!pw.getText().equals(loggedUser.getPassword())
                ;
        return rtn;
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
