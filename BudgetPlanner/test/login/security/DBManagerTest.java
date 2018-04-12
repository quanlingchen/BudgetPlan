/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.security;

import java.util.List;
import java.util.Map;
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
public class DBManagerTest {
    
    public DBManagerTest() {
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
     * Test of connect method, of class DBManager.
     */
    @Test
    public void testConnect() throws Exception {
        System.out.println("connect");
        DBManager instance = new DBManager();
        instance.connect();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsers method, of class DBManager.
     */
    @Test
    public void testGetUsers() throws Exception {
        System.out.println("getUsers");
        DBManager instance = new DBManager();
        List<User> expResult = null;
        List<User> result = instance.getUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuizs method, of class DBManager.
     */
    @Test
    public void testGetQuizs() {
        System.out.println("getQuizs");
        int i = 0;
        DBManager instance = new DBManager();
        Map<Integer, String> expResult = null;
        Map<Integer, String> result = instance.getQuizs(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlan method, of class DBManager.
     */
    @Test
    public void testGetPlan() {
        System.out.println("getPlan");
        String userId = "";
        DBManager instance = new DBManager();
        List<Plan> expResult = null;
        List<Plan> result = instance.getPlan(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createUser method, of class DBManager.
     */
    @Test
    public void testCreateUser() {
        System.out.println("createUser");
        User user = null;
        DBManager instance = new DBManager();
        instance.createUser(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateUser method, of class DBManager.
     */
    @Test
    public void testUpdateUser() {
        System.out.println("updateUser");
        User user = null;
        DBManager instance = new DBManager();
        instance.updateUser(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createPlan method, of class DBManager.
     */
    @Test
    public void testCreatePlan() {
        System.out.println("createPlan");
        Plan plan = null;
        DBManager instance = new DBManager();
        instance.createPlan(plan);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updatePlan method, of class DBManager.
     */
    @Test
    public void testUpdatePlan() {
        System.out.println("updatePlan");
        Plan plan = null;
        DBManager instance = new DBManager();
        instance.updatePlan(plan);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delPlan method, of class DBManager.
     */
    @Test
    public void testDelPlan() {
        System.out.println("delPlan");
        Plan plan = null;
        DBManager instance = new DBManager();
        instance.delPlan(plan);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delItem method, of class DBManager.
     */
    @Test
    public void testDelItem() {
        System.out.println("delItem");
        Item item = null;
        DBManager instance = new DBManager();
        instance.delItem(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createItem method, of class DBManager.
     */
    @Test
    public void testCreateItem() {
        System.out.println("createItem");
        Item item = null;
        DBManager instance = new DBManager();
        instance.createItem(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateItem method, of class DBManager.
     */
    @Test
    public void testUpdateItem() {
        System.out.println("updateItem");
        Item item = null;
        DBManager instance = new DBManager();
        instance.updateItem(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItem method, of class DBManager.
     */
    @Test
    public void testGetItem() {
        System.out.println("getItem");
        String userId = "";
        String planId = "";
        DBManager instance = new DBManager();
        List<Item> expResult = null;
        List<Item> result = instance.getItem(userId, planId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
