package login;

import java.net.URL;
import java.util.*;
import java.util.List;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import login.model.User;
import login.model.PlanList;
import login.security.Authenticator;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import java.util.Optional;
import login.model.Plan;
import login.security.DBManager;
import login.security.Planner;
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
    private Label id;
    @FXML 
    private Label success;
    @FXML 
    private Label welcome;
    @FXML 
    private Label labpw;
    @FXML 
    private TableView<PlanList> tableView;
    @FXML private TableColumn<PlanList,String> planId;
    @FXML private TableColumn<PlanList,String> planName;
    @FXML private TableColumn<PlanList,String> planType;
    @FXML private TableColumn<PlanList,String> planComment;
private ObservableList<PlanList> list;
    //@FXML 
    //private Label errorMessage;
    
    private Main application;
   // private User loggedUser ;
    private boolean hasUpdated;
    public void setApp(Main application){
        System.out.println("in profile controller");
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        /*quiz.getItems().addAll(
    "What's your pet's name?",
    "In what city were you born?",
    "What is the name of your first school?"
);*/
         DBManager d = new DBManager();
             for (Map.Entry<Integer,String> q : d.getQuizs(1).entrySet()) {
                 quiz.getItems().add(q.getValue());
             }
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
        //List<String> row = new ArrayList<String>();
        
        
        
       System.out.println("reading db");
        //read from database
        
        Plan pl = application.getListPlan();
        Map<String, Plan> p = new HashMap();//Planner.getInstance().getAll();
        for (Plan temp : d.getPlan(loggedUser.getId())) {
            p.put(temp.getId(), temp);
                /*Plan.of(temp.getId()).setPlan(temp.getId(), temp.getName(), temp.getType(), temp.getComment());
                Planner.getInstance().addPlan(temp.getId());
                Planner.getInstance().setPlan(temp.getId(),temp);*/
            }
        list = FXCollections.observableArrayList();
        //pl.getSize();
        if(p!=null && p.size()>0){
            System.out.println(" plans size: " + p.size());
            for (Map.Entry<String, Plan> entry : p.entrySet()) {
		System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
                pl=entry.getValue();
                list.add(new PlanList(pl.getId(),pl.getName(),Integer.toString(pl.getType()),pl.getComment()));
            }
        } else{
            System.out.println(" plans: " + application.getListPlan());
           
        }
       
        tableView.setItems(list);
        planId.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        planName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        planType.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
        planComment.setCellValueFactory(cellData -> cellData.getValue().commentProperty());
        
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    }
    
    public void processDelPlan(ActionEvent event) {
        if (application == null){
            return;
        }
        if(isModified()){
            success.setText("Profile had been Modified! Please Update first.");
            animateMessage();
        }else{
            
            if (tableView.getFocusModel().getFocusedIndex()<0)
            {
                success.setText("Please select a plan on the list.");
                animateMessage();
                return;
            }
            System.out.println("table view index:"+tableView.getFocusModel().getFocusedIndex());
             Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Delete Plan: " + tableView.getItems().get(tableView.getFocusModel().getFocusedIndex()).id.getValue());
            alert.setContentText("Are you sure delete plan?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.CANCEL){
                return;// ... user chose CANCEL or closed the dialog
            }
            Plan p=Plan.of(Integer.toString(tableView.getFocusModel().getFocusedIndex()));
            p.setUserId(application.getLoggedUser().getId());
            Planner.getInstance().removePlan(Integer.toString(tableView.getFocusModel().getFocusedIndex()));
            DBManager d = new DBManager();
            //delete plan from database
            d.delPlan(p);
            list=tableView.getItems();
            list.remove(tableView.getFocusModel().getFocusedIndex());
            tableView.setItems(list);
            
        }
    }
    public void processEditPlan(ActionEvent event) {
        if (application == null){
            return;
        }
        if(isModified()){
            success.setText("Profile had been Modified! Please Update first.");
            animateMessage();
        }else{
            
            if (tableView.getFocusModel().getFocusedIndex()<0)
            {
                success.setText("Please select a plan on the list.");
                animateMessage();
                return;
            }
            System.out.println("table view index:"+tableView.getFocusModel().getFocusedIndex());
            //application.setListPlan(Plan.of( tableView.getFocusModel().getFocusedItem().id.getValue() ));
            application.itemList(tableView.getFocusModel().getFocusedIndex(),
            tableView.getFocusModel().getFocusedItem().id.getValue());//gotoplan
        }
    }
    public void processAddPlan(ActionEvent event) {
        System.out.println("processAddPlan");
        if (application == null){
            return;
        }
        System.out.println("processAddPlan 1");
        if(isModified()){
            success.setText("Profile had been Modified! Please Update first.");
            animateMessage();
        }else{
            System.out.println("processAddPlan 2");
            //System.out.println("table view index:" + tableView.getFocusModel().getFocusedIndex());
            application.itemList(-1,"");//Integer.toString( application.getListPlan().getSize()+1)
        }
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
        success.setText("");
        User loggedUser = this.application.getLoggedUser();
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
        success.setText("");
        if (application == null){
            animateMessage();
            return;
        }
        if(answer.getText().equals("")){
            success.setText("Please input answer.");
            animateMessage();
            return;
        }
        //validation
        if(welcome.getText().equals("Please fill up profile.")){
            // must input password
            if(pw.getText().equals("")){
                success.setText("Please input password.");
                animateMessage();
                return;
            }
            if(conpw.getText().equals("")){
                success.setText("Please input password.");
                animateMessage();
                return;
            }
            // password doesn't match
            if(!pw.getText().equals(conpw.getText())){
                success.setText("Password is not match.");
                animateMessage();
                return;
            }
        } else{
            // password doesn't match
            if(!pw.getText().equals(conpw.getText())){
                if(!pw.getText().equals("") ||!conpw.getText().equals("") ){
                    success.setText("Password is not match.");
                    animateMessage();
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
         DBManager d= new DBManager();
         if(welcome.getText().equals("Please fill up profile."))
            d.createUser(loggedUser);
         else
            d.updateUser(loggedUser);
        success.setText("Profile  successfully updated!");
        animateMessage();
        hasUpdated = true;
    }
    
    private boolean isModified() {
        System.out.println("isModified in");
        boolean rtn = false;
        User loggedUser = application.getLoggedUser();
        System.out.println("isModified 1[" + loggedUser.getAnswer()+"][" +loggedUser.getEmail()+"]["+loggedUser.getQuiz()+"]["+loggedUser.getPassword());
        rtn = !answer.getText().equals(loggedUser.getAnswer()) ||
                (loggedUser.getEmail()!=null && !email.getText().equals(loggedUser.getEmail())) ||
                quiz.getSelectionModel().getSelectedIndex() != loggedUser.getQuiz()||
                (!pw.getText().equals("") &&!pw.getText().equals(loggedUser.getPassword())) || 
                !conpw.getText().equals("")
                //!pw.getText().equals(loggedUser.getPassword())
                ;
        System.out.println("isModified 2");
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
