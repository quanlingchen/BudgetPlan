package login;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import login.model.User;
import login.model.Item;
import login.model.Plan;
import login.security.Authenticator;
import login.security.DBManager;
import login.security.Planner;
import login.security.Itemmer;

/**
 * Main Application. This class handles navigation and user session.
 * 
 * @author Deepak Csac, Quanling Chen, Harika Badugu
 * @version     1.0
 * @since       2018-03-05
 */
public class Main extends Application {

    private Stage stage;
    private User loggedUser;
    private Item listItem = null;
    private Plan listPlan = null;
    private final double MINIMUM_WINDOW_WIDTH = 500.0;
    private final double MINIMUM_WINDOW_HEIGHT = 600.0;
    public Map<String, Integer> countLogin = new HashMap<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
       
        //read user from database
        Authenticator.getInstance();
        DBManager d= new DBManager();
        //d.connect();
      try
      {
          
            for (User temp : d.getUsers()) {
                User.of(temp.getId()).setAnswer(temp.getAnswer());
                User.of(temp.getId()).setQuiz(temp.getQuiz());
                User.of(temp.getId()).setEmail(temp.getEmail());
                 User.of(temp.getId()).setPassword(temp.getPassword());
                //Authenticator.getInstance().addUser(temp.getId());
            }
            
      }catch (Exception ex){
          System.out.println("Fail to load. main");
      }
    Application.launch(Main.class, (java.lang.String[])null);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            stage = primaryStage;
            stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
            stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
            stage.setTitle("Budget Planner for Students");
            gotoLogin();
            primaryStage.show();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public User getLoggedUser() {
        return loggedUser;
    }
    public Item getListItem() {
        return listItem;
    }
    public void setListItem(Item list) {
        this.listItem = list;
    }
    public Plan getListPlan() {
        return listPlan;
    }
    public void setListPlan(Plan list) {
        this.listPlan = list;
    }
     public boolean addPlan(String id){
        if (Planner.getInstance().isExist(id))
            return false;
        if(Planner.getInstance().addPlan(id)){
            listPlan = Plan.of(id);
            gotoProfile(true);
            return true;
        } else return false;
    } 
   
    public boolean addUser(String userId){
        if (Authenticator.getInstance().isExist(userId))
            return false;
        if(Authenticator.getInstance().addUser(userId)){
            loggedUser = User.of(userId);
            //login as new user clean up plan list
            Planner.getInstance().getAll().clear();
            gotoProfile(true);
            return true;
        } else return false;
    } 
    private void readPlan(){
        listPlan=Plan.of("1");
        Plan pl = listPlan;
        listPlan=pl;
        pl.setComment("regular");
        pl.setName("abc");
        pl.setType(0);
        listPlan = Plan.of("2");
        Plan p2=listPlan;
        listPlan = pl;
        p2.setComment("regular");
        p2.setName("bbc");
        p2.setType(0);
        listPlan=pl;
    }
    //login in with security answer
    public boolean userLoggingA(String userId, String answer){
        
        boolean rtn = !Authenticator.getInstance().getAnswer(userId).equals("")
                && Authenticator.getInstance().getAnswer(userId).equals(answer);
        if(rtn){
            loggedUser = User.of(userId);
            //get database---------------------
            DBManager d= new DBManager();
        //d.connect();
      try
      {
          //init plan list
            for (Plan temp : d.getPlan(userId)) {
                System.out.println("read plan");
                Plan.of(temp.getId()).setPlan(temp.getId(), temp.getName(), temp.getType(), temp.getComment());
                Planner.getInstance().addPlan(temp.getId());
                Planner.getInstance().setPlan(temp.getId(),temp);
            }
            
      }catch (Exception ex){
          System.out.println("Fail to load. main");
      }//------------------read from database
            gotoProfile(true);
        }
        return rtn;
    }
    public void itemDetail(int s, String t, String p) {//
        listItem=null;
        try {
            stage.setTitle(getLoggedUser().getId()+"'s "+ Item.of(t).getName() + " Item detail");
            
            ItemDetailController item = (ItemDetailController) replaceSceneContent("ItemDetail.fxml");
            item.setPlanId(p);
            if(s<0) {
                item.setSuccess("new");
                int c =1;
                
                if (Itemmer.getInstance().getAll()!=null){
                    
                    int siz = Itemmer.getInstance().getAll().size();
                    System.out.println("listItem size: " + siz);
                    while ( Item.has(Integer.toString(c))){
                        c++;
                    }
                }
                if(Itemmer.getInstance().addItem(Integer.toString(c))){
                    listItem = Item.of(Integer.toString(c));
                    System.out.println("New add item" + c);
                }
                else
                    System.out.println("Cannot add item" + c);
                
                this.stage.setTitle(getLoggedUser().getId()+"'s New Item detail");
                //profile.setWelcome("Please fill up profile.");
            }else{
                listItem = Item.of(t);
            }
            item.setApp(this);
            
            //stage.setTitle("Plan detail");
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean userLogging(String userId, String password){
        System.out.println("got user id " + userId + " password " + password);
        if (countLogin.containsKey(userId)&& (countLogin.get(userId)>=3)){
               System.out.println("Tried more than 3 times!");
               return false;
           }
        if (Authenticator.getInstance().validate(userId, password)) {
            System.out.println("OK");
            loggedUser = User.of(userId);
            //get database---------------------
            DBManager d= new DBManager();
        //d.connect();
      try
      {
          //init plan list
            for (Plan temp : d.getPlan(userId)) {
                System.out.println("read plan");
                Plan.of(temp.getId()).setPlan(temp.getId(), temp.getName(), temp.getType(), temp.getComment());
                Planner.getInstance().addPlan(temp.getId());
                Planner.getInstance().setPlan(temp.getId(),temp);
            }
            
      }catch (Exception ex){
          System.out.println("Fail to load. main");
      }//------------------read from database
            gotoProfile(false);
            return true;
        } else {
           
            //add count 3 times fail
            System.out.println("NOT OK");
            if (countLogin.containsKey(userId)){
                 if ((countLogin.get(userId))==1)
                 {
                     countLogin.put(userId,2);
                 }else{
                     countLogin.put(userId,3);
                     System.out.println("Can Not try!");
                 }
            }
            else{
                countLogin.put(userId,1);
            }
            return false;
        }
    }
    
    void userLogout(){
        countLogin = new HashMap<>();
        //loggedUser = null;
        Planner.getInstance().removePlan(loggedUser.getId());
        loggedUser = null;
        
        gotoLogin();
    }
    
    void itemLogout( String t){
        listItem = null;
        gotoPlan(0,t);
    }
    void itemList(int s,String t){
        listItem = null;
        gotoPlan(s,t);
    }
    void planLogout(){
        listPlan = null;
        gotoProfile(false);
    }
    private void gotoProfile(boolean s) {
        try {
            ProfileController profile = (ProfileController) replaceSceneContent("Profile.fxml");
            
            this.stage.setTitle("Profile");
            if(s) {
                this.stage.setTitle("Sign up");
                profile.setWelcome("Please fill up profile.");
            }
            profile.setApp(this);
        } catch (Exception ex) {    
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void gotoItem() {
        try {
            stage.setTitle(getLoggedUser().getId()+ "'s Item detail");
            ItemDetailController item = (ItemDetailController) replaceSceneContent("ItemDetail.fxml");
            item.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void gotoPlan(int s, String t) {//
        try {
            System.out.println("gotoPlan");
            stage.setTitle(getLoggedUser().getId()+"'s "+ Plan.of(t).getName() + " Plan detail");
            
            PlanDetailController plan = (PlanDetailController) replaceSceneContent("PlanDetail.fxml");
            if(s<0) {
                plan.setSuccess("new");
                int c =1;
                
                if (Planner.getInstance().getAll()!=null){
                    
                    int siz = Planner.getInstance().getAll().size();
                    System.out.println("listplan size: " + siz);
                    while ( Plan.has(Integer.toString(c))){
                        c++;
                    }
                }else{
                     Planner.getInstance().addPlan("1");
                }
                if(Planner.getInstance().addPlan(Integer.toString(c)))
                listPlan = Plan.of(Integer.toString(c));
                else
                    System.out.println("Cannot add plan" + c);
                
                this.stage.setTitle(getLoggedUser().getId()+"'s New Plan detail");
                //profile.setWelcome("Please fill up profile.");
            }else{
                listPlan = Plan.of(t);
                //get database---------------------
            DBManager d= new DBManager();
        //d.connect();
      try
      {
          //init plan list
            for (Item temp : d.getItem(this.getLoggedUser().getId(),listPlan.getId())) {
                System.out.println("read plan");
                //Item it=Item.of(temp.getId());
//.setItem(temp.getId(), temp.getName(), temp.getType(), temp.getComment());
                Itemmer.getInstance().addItem(temp.getId());
                Itemmer.getInstance().setItem(temp.getId(),temp);
            }
            
      }catch (Exception ex){
          System.out.println("Fail to load items. main");
      }//------------------read from database
            }
            plan.setApp(this);
            //stage.setTitle("Plan detail");
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void gotoLogin() {
        try {
            LoginController login = (LoginController) replaceSceneContent("Login.fxml");
            login.setApp(this);
            stage.setTitle("Budget Planner for Students");
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Node replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = Main.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(Main.class.getResource(fxml));
        AnchorPane page;
        try {
            page = (AnchorPane) loader.load(in);
        } finally {
            in.close();
        }
        
        // Store the stage width and height in case the user has resized the window
        double stageWidth = stage.getWidth();
        if (!Double.isNaN(stageWidth)) {
            stageWidth -= (stage.getWidth() - stage.getScene().getWidth());
        }
        
        double stageHeight = stage.getHeight();
        if (!Double.isNaN(stageHeight)) {
            stageHeight -= (stage.getHeight() - stage.getScene().getHeight());
        }
        
        Scene scene = new Scene(page);
        if (!Double.isNaN(stageWidth)) {
            page.setPrefWidth(stageWidth);
        }
        if (!Double.isNaN(stageHeight)) {
            page.setPrefHeight(stageHeight);
        }
        
        stage.setScene(scene);
        stage.sizeToScene();
        return (Node) loader.getController();
    }
}
