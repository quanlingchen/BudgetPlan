/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.model;

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
public class PlanTest {
    
    public PlanTest() {
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
     * Test of of method, of class Plan.
     */
    @Test
    public void testOf() {
        System.out.println("of");
        String id = "";
        Plan expResult = null;
        Plan result = Plan.of(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of off method, of class Plan.
     */
    @Test
    public void testOff() {
        System.out.println("off");
        String id = "";
        Plan expResult = null;
        Plan result = Plan.off(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of has method, of class Plan.
     */
    @Test
    public void testHas() {
        System.out.println("has");
        String id = "";
        boolean expResult = false;
        boolean result = Plan.has(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Plan.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Plan instance = null;
        String expResult = "";
        String result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserId method, of class Plan.
     */
    @Test
    public void testGetUserId() {
        System.out.println("getUserId");
        Plan instance = null;
        String expResult = "";
        String result = instance.getUserId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPlan method, of class Plan.
     */
    @Test
    public void testSetPlan() {
        System.out.println("setPlan");
        String id = "";
        String name = "";
        int type = 0;
        String comment = "";
        Plan instance = null;
        instance.setPlan(id, name, type, comment);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserId method, of class Plan.
     */
    @Test
    public void testSetUserId() {
        System.out.println("setUserId");
        String userId = "";
        Plan instance = null;
        instance.setUserId(userId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getType method, of class Plan.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Plan instance = null;
        int expResult = 0;
        int result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setType method, of class Plan.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        int type = 0;
        Plan instance = null;
        instance.setType(type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getComment method, of class Plan.
     */
    @Test
    public void testGetComment() {
        System.out.println("getComment");
        Plan instance = null;
        String expResult = "";
        String result = instance.getComment();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setComment method, of class Plan.
     */
    @Test
    public void testSetComment() {
        System.out.println("setComment");
        String comment = "";
        Plan instance = null;
        instance.setComment(comment);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Plan.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Plan instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Plan.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Plan instance = null;
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSize method, of class Plan.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        Plan instance = null;
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
