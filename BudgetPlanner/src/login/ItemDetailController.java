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
import login.model.Item; 
import java.util.Date; 
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.Instant;
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
    public void setApp(Main application){
        System.out.println("in item detail controller");
        type.getItems().addAll(
            "Income",
            "Spends",
            "Saving"
        );
        this.application = application;
        Item listedItem = application.getListItem();
        if(listedItem == null) {
            listedItem = listedItem.of("1");
            application.setListItem(listedItem);
        }else{
            listedItem = listedItem.of( Integer.toString(listedItem.getSize()+1));
        }
        name.setText(listedItem.getName());
        if(listedItem.getDate()!=null)
            date.setValue(listedItem.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        amount.setText(listedItem.getAmount());
        type.getSelectionModel().select(listedItem.getType());
        welcome.setText(listedItem.getId());
        
        if (listedItem.getComment() != null) {
            comment.setText(listedItem.getComment());
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
        if(welcome.getText().equals("Please fill up profile.") && !hasUpdated)
        {
            //remove item
            //System.out.println("remove item" + application.getListItem().remove(name.getText()));
        }
        application.itemLogout();
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
        amount.setText(listedItem.getAmount());
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
        listedItem.setAmount(amount.getText());
        listedItem.setType(type.getSelectionModel().getSelectedIndex());
        //listedItem.setSubscribed(subscribed.isSelected());
        listedItem.setComment(comment.getText());
        //listedItem.setSecurity(security.getText());
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
    //amount.textProperty().addListener(new ChangeListener<String>() {
      //      
    //@Override
            public void onChanged(ActionEvent event) {
                //if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                  //  vehiclePrice_TextField.setText(oldValue);
                //}
            }
        //});
}
