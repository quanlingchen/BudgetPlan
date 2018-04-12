/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.security;

import java.util.Map;
import login.model.Item;
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
public class ItemmerTest {
    
    public ItemmerTest() {
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
     * Test of getAll method, of class Itemmer.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        Itemmer instance = new Itemmer();
        Map<String, Item> expResult = null;
        Map<String, Item> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeItem method, of class Itemmer.
     */
    @Test
    public void testRemoveItem() {
        System.out.println("removeItem");
        String user = "";
        Itemmer instance = new Itemmer();
        boolean expResult = false;
        boolean result = instance.removeItem(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addItem method, of class Itemmer.
     */
    @Test
    public void testAddItem() {
        System.out.println("addItem");
        String id = "";
        Itemmer instance = new Itemmer();
        boolean expResult = false;
        boolean result = instance.addItem(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isExist method, of class Itemmer.
     */
    @Test
    public void testIsExist() {
        System.out.println("isExist");
        String user = "";
        Itemmer instance = new Itemmer();
        boolean expResult = false;
        boolean result = instance.isExist(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setItem method, of class Itemmer.
     */
    @Test
    public void testSetItem() {
        System.out.println("setItem");
        String id = "";
        Item pl = null;
        Itemmer instance = new Itemmer();
        instance.setItem(id, pl);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInstance method, of class Itemmer.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        Itemmer expResult = null;
        Itemmer result = Itemmer.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
