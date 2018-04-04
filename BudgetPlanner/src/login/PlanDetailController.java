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
    private ComboBox type;
   
    @FXML
    private TextArea comment;
    
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
    
    
    private Main application;
    private boolean hasUpdated;
    public void setApp(Main application){
        System.out.println("in plan detail controller");
        type.getItems().addAll(
            "Weekly",
            "Biweekly",
            "monthly",
            "annually"
        );
        this.application = application;
        System.out.println("1");
        Plan listedPlan = application.getListPlan();
        if(listedPlan == null) {
            listedPlan = listedPlan.of("1");
            application.setListPlan(listedPlan);
        }else{
            listedPlan = listedPlan.of( Integer.toString(listedPlan.getSize()+1));
        }
        System.out.println("2" + listedPlan);
        name.setText(listedPlan.getName());
        type.getSelectionModel().select(listedPlan.getType());
        System.out.println("3");
        welcome.setText(listedPlan.getId());
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
        name.setText(listedPlan.getName());
        //email.setText(listedPlan.getEmail());
        //answer.setText(listedPlan.getAnswer());
        //type.setText(listedPlan.getQuiz());
        type.getSelectionModel().select(listedPlan.getType());
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
        listedPlan.setName(name.getText());
        //listedPlan.setAnswer(answer.getText());
//        listedPlan.setQuiz(type.getText());
        //listedPlan.setSubscribed(subscribed.isSelected());
        listedPlan.setComment(comment.getText());
        listedPlan.setType(type.getSelectionModel().getSelectedIndex());
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
