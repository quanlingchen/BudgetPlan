/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import javafx.stage.Stage;
import login.model.Item;
import login.model.Plan;
import login.model.User;
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
public class MainTest {
    
    public MainTest() {
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
     * Test of main method, of class Main.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        Main.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of start method, of class Main.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        Stage primaryStage = null;
        Main instance = new Main();
        instance.start(primaryStage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLoggedUser method, of class Main.
     */
    @Test
    public void testGetLoggedUser() {
        System.out.println("getLoggedUser");
        Main instance = new Main();
        User expResult = null;
        User result = instance.getLoggedUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListItem method, of class Main.
     */
    @Test
    public void testGetListItem() {
        System.out.println("getListItem");
        Main instance = new Main();
        Item expResult = null;
        Item result = instance.getListItem();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListItem method, of class Main.
     */
    @Test
    public void testSetListItem() {
        System.out.println("setListItem");
        Item list = null;
        Main instance = new Main();
        instance.setListItem(list);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListPlan method, of class Main.
     */
    @Test
    public void testGetListPlan() {
        System.out.println("getListPlan");
        Main instance = new Main();
        Plan expResult = null;
        Plan result = instance.getListPlan();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListPlan method, of class Main.
     */
    @Test
    public void testSetListPlan() {
        System.out.println("setListPlan");
        Plan list = null;
        Main instance = new Main();
        instance.setListPlan(list);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPlan method, of class Main.
     */
    @Test
    public void testAddPlan() {
        System.out.println("addPlan");
        String id = "";
        Main instance = new Main();
        boolean expResult = false;
        boolean result = instance.addPlan(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUser method, of class Main.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        String userId = "";
        Main instance = new Main();
        boolean expResult = false;
        boolean result = instance.addUser(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of userLoggingA method, of class Main.
     */
    @Test
    public void testUserLoggingA() {
        System.out.println("userLoggingA");
        String userId = "";
        String answer = "";
        Main instance = new Main();
        boolean expResult = false;
        boolean result = instance.userLoggingA(userId, answer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of itemDetail method, of class Main.
     */
    @Test
    public void testItemDetail() {
        System.out.println("itemDetail");
        int s = 0;
        String t = "";
        String p = "";
        Main instance = new Main();
        instance.itemDetail(s, t, p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of userLogging method, of class Main.
     */
    @Test
    public void testUserLogging() {
        System.out.println("userLogging");
        String userId = "";
        String password = "";
        Main instance = new Main();
        boolean expResult = false;
        boolean result = instance.userLogging(userId, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of userLogout method, of class Main.
     */
    @Test
    public void testUserLogout() {
        System.out.println("userLogout");
        Main instance = new Main();
        instance.userLogout();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of itemLogout method, of class Main.
     */
    @Test
    public void testItemLogout() {
        System.out.println("itemLogout");
        String t = "";
        Main instance = new Main();
        instance.itemLogout(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of itemList method, of class Main.
     */
    @Test
    public void testItemList() {
        System.out.println("itemList");
        int s = 0;
        String t = "";
        Main instance = new Main();
        instance.itemList(s, t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of planLogout method, of class Main.
     */
    @Test
    public void testPlanLogout() {
        System.out.println("planLogout");
        Main instance = new Main();
        instance.planLogout();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
