/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import javafx.event.ActionEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author melanie
 */
public class LoginControllerTest {
    
    public LoginControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setApp method, of class LoginController.
     */
    @Test
    public void testSetApp() {
        System.out.println("setApp");
        Main application = null;
        LoginController instance = new LoginController();
        instance.setApp(application);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initialize method, of class LoginController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        LoginController instance = new LoginController();
        instance.initialize();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of processLogin method, of class LoginController.
     */
    @Test
    public void testProcessLogin() {
        System.out.println("processLogin");
        ActionEvent event = null;
        LoginController instance = new LoginController();
        instance.processLogin(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
