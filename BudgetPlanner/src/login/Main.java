package login;

import java.io.InputStream;
import java.util.HashMap;
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
import login.security.Authenticator;

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
    private final double MINIMUM_WINDOW_WIDTH = 390.0;
    private final double MINIMUM_WINDOW_HEIGHT = 500.0;
    public Map<String, Integer> countLogin = new HashMap<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
        
    public boolean userLogging(String userId, String password){
        System.out.println("got user id " + userId + " password " + password);
        if (countLogin.containsKey(userId)&& (countLogin.get(userId)>=3)){
               System.out.println("Tried more than 3 times!");
               return false;
           }
        if (Authenticator.getInstance().validate(userId, password)) {
            System.out.println("OK");
            loggedUser = User.of(userId);
            gotoProfile();
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
        loggedUser = null;
        gotoLogin();
    }
    
    private void gotoProfile() {
        try {
            ProfileController profile = (ProfileController) replaceSceneContent("Profile.fxml");
            profile.setApp(this);
            this.stage.setTitle("Profile");
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void gotoLogin() {
        try {
            LoginController login = (LoginController) replaceSceneContent("Login.fxml");
            login.setApp(this);
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
