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
import login.model.Plan;
import login.security.Authenticator;

/**
 * Profile Controller.
 * 
 * @author Deepak Csac, Quanling Chen, Harika Badugu
 * @version     1.0
 * @since       2018-03-05
 */
public class PlanDetailController extends AnchorPane {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;
    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    @FXML
    private TextField name;
    @FXML
    private ComboBox type;//TextField phone;
    @FXML
    private TextField answer;
    @FXML
    private TextField email;
    @FXML
    private TextField pw;
    @FXML
    private TextArea comment;
    @FXML
    private CheckBox subscribed;
    @FXML
    private Hyperlink back;
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
        System.out.println("in plan detail controller");
        this.application = application;
        System.out.println("1");
        Plan listedPlan = application.getListPlan();
        System.out.println("2" + listedPlan);
        name.setText(listedPlan.getId());System.out.println("3");
        //email.setText(listedPlan.getEmail());System.out.println("4");
        //answer.setText(listedPlan.getAnswer());System.out.println("5");
        
        //phone.setText(listedPlan.getPhone());
        if (listedPlan.getComment() != null) {
            comment.setText(listedPlan.getComment());
        }
        //security.setText(listedPlan.getSecurity());
        
        //subscribed.setSelected(listedPlan.isSubscribed());
        success.setOpacity(0);
        hasUpdated = false;
        /*if(welcome.getText().equals("Please fill up profile.") )
        {
            labpw.setText("Password"); 
        }else{
            pw.setText(listedPlan.getPassword());
        }*/
        type.getItems().addAll(
    "What's your pet's name?",
    "In what city were you born?",
    "What is the name of your first school?"
);
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    }
    
    public void processBack(ActionEvent event) {
        
        if (application == null){
            return;
        }
        if(welcome.getText().equals("Please fill up profile.") && !hasUpdated)
        {
            //remove plan
            //System.out.println("remove plan" + Authenticator.getInstance().removePlan(name.getText()));
        }
        application.planLogout();
    }
    public void processReset(ActionEvent event) {
        if (application == null){
            animateMessage();
            return;
        }
        Plan listedPlan = application.getListPlan();
        name.setText(listedPlan.getId());
        //email.setText(listedPlan.getEmail());
        //answer.setText(listedPlan.getAnswer());
        //type.setText(listedPlan.getQuiz());
        if (listedPlan.getComment() != null) {
            comment.setText(listedPlan.getComment());
        }
        //security.setText(listedPlan.getSecurity());
        
        //subscribed.setSelected(listedPlan.isSubscribed());
        animateMessage();
    }
    public void processUpdate(ActionEvent event) {
        if (application == null){
            animateMessage();
            return;
        }
        Plan listedPlan = application.getListPlan();
        //listedPlan.set
        //listedPlan.setEmail(email.getText());
        //listedPlan.setAnswer(answer.getText());
//        listedPlan.setQuiz(type.getText());
        //listedPlan.setSubscribed(subscribed.isSelected());
        listedPlan.setComment(comment.getText());
        //listedPlan.setSecurity(security.getText());
        animateMessage();
        hasUpdated = true;
    }
    public void processItemList(ActionEvent event) {
        if (application == null){
            return;
        }
        application.itemList();//gotoplan
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
