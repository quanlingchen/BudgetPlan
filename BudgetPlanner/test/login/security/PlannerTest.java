/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.security;

import java.util.Map;
import login.model.Plan;
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
public class PlannerTest {
    
    public PlannerTest() {
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
     * Test of getAll method, of class Planner.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        Planner instance = new Planner();
        Map<String, Plan> expResult = null;
        Map<String, Plan> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removePlan method, of class Planner.
     */
    @Test
    public void testRemovePlan() {
        System.out.println("removePlan");
        String user = "";
        Planner instance = new Planner();
        boolean expResult = false;
        boolean result = instance.removePlan(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPlan method, of class Planner.
     */
    @Test
    public void testAddPlan() {
        System.out.println("addPlan");
        String id = "";
        Planner instance = new Planner();
        boolean expResult = false;
        boolean result = instance.addPlan(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isExist method, of class Planner.
     */
    @Test
    public void testIsExist() {
        System.out.println("isExist");
        String user = "";
        Planner instance = new Planner();
        boolean expResult = false;
        boolean result = instance.isExist(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPlan method, of class Planner.
     */
    @Test
    public void testSetPlan() {
        System.out.println("setPlan");
        String id = "";
        Plan pl = null;
        Planner instance = new Planner();
        instance.setPlan(id, pl);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInstance method, of class Planner.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        Planner expResult = null;
        Planner result = Planner.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
