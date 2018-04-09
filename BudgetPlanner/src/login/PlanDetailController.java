package login;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import login.model.Plan;
import login.security.Authenticator;
import login.security.Planner;
import login.security.Itemmer;
import javafx.stage.Stage;
import login.model.ItemList;
import login.model.Item;
import java.util.Date;
import java.util.Optional;
//import login.model.PlanList;

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
    private Label id;
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
     @FXML 
    private TableView<ItemList> tableView;
    @FXML private TableColumn<ItemList,String> itemId;
    @FXML private TableColumn<ItemList,String> itemName;
    @FXML private TableColumn<ItemList,String> itemType;
    @FXML private TableColumn<ItemList,String> itemDate;
    
    @FXML private TableColumn<ItemList,String> itemAmount;
    @FXML private TableColumn<ItemList,String> itemComment;
    
    private Main application;
    private boolean hasUpdated;
    private boolean isNew;
    private ObservableList<ItemList> list;
    public void setApp(Main application){
        System.out.println("in plan detail controller");
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        isNew = success.getText().equals("new");
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
            listedPlan = Plan.of("1");
            application.setListPlan(listedPlan);
        }else{
            //listedPlan = listedPlan.of( Integer.toString(listedPlan.getSize()+1));
        }
        System.out.println("2" + listedPlan);
        name.setText(listedPlan.getName());
        type.getSelectionModel().select(listedPlan.getType());
        System.out.println("3  ");
        welcome.setText(listedPlan.getId());
        //email.setText(listedPlan.getEmail());System.out.println("4");
        //answer.setText(listedPlan.getAnswer());System.out.println("5");
        
        //phone.setText(listedPlan.getPhone());
        if (listedPlan.getComment() != null) {
            comment.setText(listedPlan.getComment());
        }
        //read from database
        Item pl=application.getListItem();
        Map<String, Item> p = Itemmer.getInstance().getAll();
        list = FXCollections.observableArrayList();
        //pl.getSize();
        if(p!=null && p.size()>0){
            System.out.println(" plans size: " + p.size());
            for (Map.Entry<String, Item> entry : p.entrySet()) {
		System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
                pl=entry.getValue();
                list.add(new ItemList(pl.getId(),pl.getName(),Integer.toString(pl.getType()),
                        Double.toString(pl.getAmount()),pl.getDate().toString(),pl.getComment()));
            }
        } else{
            System.out.println(" items: " + application.getListItem());
        }
       
        tableView.setItems(list);
        itemId.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        itemName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        itemType.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
        itemAmount.setCellValueFactory(cellData -> cellData.getValue().amountProperty());
        itemDate.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        itemComment.setCellValueFactory(cellData -> cellData.getValue().commentProperty());
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
    void setSuccess(String s){
        success.setText(s);
    }
    public void processBack(ActionEvent event) {
        
        if (application == null){
            return;
        }
        System.out.println("b4 reset will remove plan" );
        processReset( event);
       
        System.out.println("will remove plan" );
        if(isNew )
        {
            System.out.println("in remove plan" );
            //remove plan
            System.out.println("remove plan" + Planner.getInstance().removePlan(welcome.getText()));
            
        }else System.out.println("fail remove plan" );
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
        //application.setListPlan(listedPlan);
        //Planner.getInstance().set(listedPlan.getId());
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
    private boolean isModified(){
        boolean rtn = false;
        Plan listedPlan = application.getListPlan();
        rtn=         !listedPlan.getName().equals(name.getText())||
        //listedPlan.setAnswer(answer.getText());
//        listedPlan.setQuiz(type.getText());
        //listedPlan.setSubscribed(subscribed.isSelected());
        !listedPlan.getComment().equals(comment.getText())||
        listedPlan.getType()!=type.getSelectionModel().getSelectedIndex();
        System.out.println("modified: " +rtn);
        return rtn;
    }
    
    
    
    public void processDelItem(ActionEvent event) {
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
             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Plan: " +tableView.getItems().get(tableView.getFocusModel().getFocusedIndex()).id.getValue());
            alert.setContentText("Are you sure delete plan?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.CANCEL){
                return;// ... user chose CANCEL or closed the dialog
            }
            Itemmer.getInstance().removeItem(Integer.toString(tableView.getFocusModel().getFocusedIndex()));
            //Plan.off(Integer.toString(tableView.getFocusModel().getFocusedIndex()));
            list=tableView.getItems();
            list.remove(tableView.getFocusModel().getFocusedIndex());
            tableView.setItems(list);
            //tableView.getFocusModel().
            //application.setListPlan(Plan.of( tableView.getFocusModel().getFocusedItem().id.getValue() ));
            //application.itemList(tableView.getFocusModel().getFocusedIndex(),tableView.getFocusModel().getFocusedItem().id.getValue());//gotoplan
        }
    }
    public void processEditItem(ActionEvent event) {
        if (application == null){
            return;
        }
        if(isModified()){
            success.setText("Plan detail had been Modified! Please Update first.");
            animateMessage();
        }else{
            
            if (tableView.getFocusModel().getFocusedIndex()<0)
            {
                success.setText("Please select a item on the list.");
                animateMessage();
                return;
            }
            System.out.println("item table view index:"+ tableView.getFocusModel().getFocusedIndex());
            
            //application.setListPlan(Plan.of( tableView.getFocusModel().getFocusedItem().id.getValue() ));
            application.itemDetail(tableView.getFocusModel().getFocusedIndex(),
                    tableView.getFocusModel().getFocusedItem().id.getValue(),this.welcome.getText());//gotoplan
        }
    }
    public void processAddItem(ActionEvent event) {
        if (application == null){
            return;
        }
        if(isModified()){
            success.setText("detail had been Modified! Please Update first.");
            animateMessage();
        }else{
            
            System.out.println("table view index:"+tableView.getFocusModel().getFocusedIndex());
            application.itemDetail(-1,"",this.welcome.getText());//Integer.toString( application.getListPlan().getSize()+1)
        }
    }
}
