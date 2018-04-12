/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.model;

import java.util.Date;
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
public class ItemTest {
    
    public ItemTest() {
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
     * Test of getSize method, of class Item.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        Item instance = null;
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of of method, of class Item.
     */
    @Test
    public void testOf() {
        System.out.println("of");
        String id = "";
        Item expResult = null;
        Item result = Item.of(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of off method, of class Item.
     */
    @Test
    public void testOff() {
        System.out.println("off");
        String id = "";
        Item expResult = null;
        Item result = Item.off(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Item.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Item instance = null;
        String expResult = "";
        String result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class Item.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Item instance = null;
        Date expResult = null;
        Date result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDate method, of class Item.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        Date date = null;
        Item instance = null;
        instance.setDate(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of has method, of class Item.
     */
    @Test
    public void testHas() {
        System.out.println("has");
        String id = "";
        boolean expResult = false;
        boolean result = Item.has(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getType method, of class Item.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Item instance = null;
        int expResult = 0;
        int result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setType method, of class Item.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        int type = 0;
        Item instance = null;
        instance.setType(type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getComment method, of class Item.
     */
    @Test
    public void testGetComment() {
        System.out.println("getComment");
        Item instance = null;
        String expResult = "";
        String result = instance.getComment();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setComment method, of class Item.
     */
    @Test
    public void testSetComment() {
        System.out.println("setComment");
        String comment = "";
        Item instance = null;
        instance.setComment(comment);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserId method, of class Item.
     */
    @Test
    public void testGetUserId() {
        System.out.println("getUserId");
        Item instance = null;
        String expResult = "";
        String result = instance.getUserId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserId method, of class Item.
     */
    @Test
    public void testSetUserId() {
        System.out.println("setUserId");
        String userId = "";
        Item instance = null;
        instance.setUserId(userId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlanId method, of class Item.
     */
    @Test
    public void testGetPlanId() {
        System.out.println("getPlanId");
        Item instance = null;
        String expResult = "";
        String result = instance.getPlanId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPlanId method, of class Item.
     */
    @Test
    public void testSetPlanId() {
        System.out.println("setPlanId");
        String planId = "";
        Item instance = null;
        instance.setPlanId(planId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAmount method, of class Item.
     */
    @Test
    public void testGetAmount() {
        System.out.println("getAmount");
        Item instance = null;
        double expResult = 0.0;
        double result = instance.getAmount();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAmount method, of class Item.
     */
    @Test
    public void testSetAmount() {
        System.out.println("setAmount");
        double amount = 0.0;
        Item instance = null;
        instance.setAmount(amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Item.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Item instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Item.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Item instance = null;
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setItem method, of class Item.
     */
    @Test
    public void testSetItem() {
        System.out.println("setItem");
        String id = "";
        String name = "";
        int type = 0;
        double Amount = 0.0;
        Date date = null;
        String comment = "";
        Item instance = null;
        instance.setItem(id, name, type, Amount, date, comment);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
