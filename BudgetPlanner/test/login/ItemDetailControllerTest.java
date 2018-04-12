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
public class ItemDetailControllerTest {
    
    public ItemDetailControllerTest() {
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
     * Test of setApp method, of class ItemDetailController.
     */
    @Test
    public void testSetApp() throws Exception {
        System.out.println("setApp");
        Main application = null;
        ItemDetailController instance = new ItemDetailController();
        instance.setApp(application);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initialize method, of class ItemDetailController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        ItemDetailController instance = new ItemDetailController();
        instance.initialize();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of processLogout method, of class ItemDetailController.
     */
    @Test
    public void testProcessLogout() {
        System.out.println("processLogout");
        ActionEvent event = null;
        ItemDetailController instance = new ItemDetailController();
        instance.processLogout(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of processReset method, of class ItemDetailController.
     */
    @Test
    public void testProcessReset() {
        System.out.println("processReset");
        ActionEvent event = null;
        ItemDetailController instance = new ItemDetailController();
        instance.processReset(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of processUpdate method, of class ItemDetailController.
     */
    @Test
    public void testProcessUpdate() {
        System.out.println("processUpdate");
        ActionEvent event = null;
        ItemDetailController instance = new ItemDetailController();
        instance.processUpdate(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWelcome method, of class ItemDetailController.
     */
    @Test
    public void testSetWelcome() {
        System.out.println("setWelcome");
        String value = "";
        ItemDetailController instance = new ItemDetailController();
        instance.setWelcome(value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSuccess method, of class ItemDetailController.
     */
    @Test
    public void testSetSuccess() {
        System.out.println("setSuccess");
        String s = "";
        ItemDetailController instance = new ItemDetailController();
        instance.setSuccess(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPlanId method, of class ItemDetailController.
     */
    @Test
    public void testSetPlanId() {
        System.out.println("setPlanId");
        String s = "";
        ItemDetailController instance = new ItemDetailController();
        instance.setPlanId(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
