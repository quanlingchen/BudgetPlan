package login;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import login.model.Item; 
import java.util.Date; 
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.Instant;
import java.util.Map;
import javafx.scene.control.Hyperlink;
import login.security.Itemmer;
import login.security.DBManager;
//import javax.swing.JDialog;
//import javax.swing.JOptionPane;
//import org.jdesktop.swingx.JXDatePicker;


/**
 * Profile Controller.
 * 
 * @author Deepak Csac, Quanling Chen, Harika Badugu
 * @version     1.0
 * @since       2018-03-05
 */
public class ItemDetailController extends AnchorPane {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;
    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    @FXML
    private TextField name;
    @FXML
    private ComboBox type;//TextField phone;
    @FXML
    private TextField amount;
    @FXML
    private DatePicker date;
    //@FXML
  //  private TextField pw;
    @FXML
    private TextArea comment;
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
    //@FXML 
    //private Label labpw;
    
    private Main application;
    private boolean hasUpdated;
    private String planId;
    private boolean isNew;
    public void setApp(Main application)throws Exception{
        System.out.println("in item detail controller");
        isNew = success.getText().equals("new");
       // Quizs = new HashMap();//Map.Entry<String, Plan> entry :
       DBManager d = new DBManager();
             for (Map.Entry<Integer,String> q : d.getQuizs(3).entrySet()) {
                 type.getItems().add(q.getValue());
             }
        /*type.getItems().addAll(
            "Income",
            "Spends",
            "Saving"
        );*/
        System.out.println("item setApp");
        planId = logout.getText();
        logout.setText("Back");
        this.application = application;
        
        Item listedItem = application.getListItem();
        if(listedItem == null) {
            System.out.println("item is null");
            listedItem = listedItem.of("1");
            application.setListItem(listedItem);
        }else{
            System.out.println("listedItem is not null");
            //listedItem = listedItem.of( Integer.toString(listedItem.getSize()+1));
        }
        name.setText(listedItem.getName());
        amount.setText(Double.toString(listedItem.getAmount()));
        type.getSelectionModel().select(listedItem.getType());
        welcome.setText(listedItem.getId());
        if (listedItem.getComment() != null) {
            comment.setText(listedItem.getComment());
        }
        if(listedItem.getDate()!=null){
            System.out.println("try to set date");
            //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
            //date.setValue(listedItem.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            
            date.setValue(Instant.ofEpochMilli(listedItem.getDate().getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
            System.out.println("try to set date success");
        }
        
        
        success.setOpacity(0);
        hasUpdated = false;
        /*if(welcome.getText().equals("Please fill up profile.") )
        {
            labpw.setText("Password"); 
        }else{
            pw.setText(listedItem.getPassword());
        }*/
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    }
    
    public void processLogout(ActionEvent event) {
        
        if (application == null){
            return;
        }
        System.out.println("b4 reset will remove item" );
        //processReset( event);
       
        System.out.println("will remove item" );
        if(isNew )
        {
            System.out.println("in remove item, new process canceled" );
            //remove plan
            if (!hasUpdated){
                System.out.println("remove item" + Itemmer.getInstance().removeItem(welcome.getText()));
            }
            
        }else {
            System.out.println("should not remove item it is not new" );
        }
        
        
        application.itemLogout(planId);//need to fix it later
    }
    public void processReset(ActionEvent event) {
        if (application == null){
            animateMessage();
            return;
        }
        Item listedItem = application.getListItem();
        
        name.setText(listedItem.getName());
  //      Date input = new Date();
//Instant instant = input.toInstant();
//ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
//LocalDate date = zdt.toLocalDate();
    if(listedItem.getDate()!=null)
        date.setValue( listedItem.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
        
        );
        amount.setText(Double.toString(listedItem.getAmount()));
        type.getSelectionModel().select(listedItem.getType());
        if (listedItem.getComment() != null) {
            comment.setText(listedItem.getComment());
        }
        //security.setText(listedItem.getSecurity());
        
        //subscribed.setSelected(listedItem.isSubscribed());
        animateMessage();
    }
    public void processUpdate(ActionEvent event) {
        if (application == null){
            animateMessage();
            return;
        }
        Item listedItem = application.getListItem();
        //listedItem.set
        listedItem.setName(name.getText());
        
        LocalDate localDate = date.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
 
        listedItem.setDate(Date.from(instant));
        listedItem.setAmount(Double.parseDouble(amount.getText()));
        listedItem.setType(type.getSelectionModel().getSelectedIndex());
        //listedItem.setSubscribed(subscribed.isSelected());
        listedItem.setComment(comment.getText());
        listedItem.setPlanId(planId);
        listedItem.setUserId(application.getLoggedUser().getId());
        //update into database
        DBManager d = new DBManager();
        if (isNew)
            d.createItem(listedItem);
        else{
            d.updateItem(listedItem);
        }
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
    
    //amount.textProperty().addListener(new ChangeListener<String>() {
      //      
    private boolean isModified(){
        boolean rtn = false;
        Item listedItem = application.getListItem();
        rtn=         !listedItem.getName().equals(name.getText())||
        //listedPlan.setAnswer(answer.getText());
//        listedPlan.setQuiz(type.getText());
        //listedPlan.setSubscribed(subscribed.isSelected());
        !listedItem.getComment().equals(comment.getText())||
        listedItem.getType()!=type.getSelectionModel().getSelectedIndex()||
        listedItem.getAmount()!= Double.parseDouble(amount.getText());
        System.out.println("modified: " +rtn);
        return rtn;
    }

    void setSuccess(String s){
        success.setText(s);
    }
    void setPlanId(String s){
        logout.setText(s);
    }

}
