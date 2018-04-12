/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.model;

import javafx.beans.property.StringProperty;
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
public class ItemListTest {
    
    public ItemListTest() {
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
     * Test of idProperty method, of class ItemList.
     */
    @Test
    public void testIdProperty() {
        System.out.println("idProperty");
        ItemList instance = null;
        StringProperty expResult = null;
        StringProperty result = instance.idProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nameProperty method, of class ItemList.
     */
    @Test
    public void testNameProperty() {
        System.out.println("nameProperty");
        ItemList instance = null;
        StringProperty expResult = null;
        StringProperty result = instance.nameProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of typeProperty method, of class ItemList.
     */
    @Test
    public void testTypeProperty() {
        System.out.println("typeProperty");
        ItemList instance = null;
        StringProperty expResult = null;
        StringProperty result = instance.typeProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of amountProperty method, of class ItemList.
     */
    @Test
    public void testAmountProperty() {
        System.out.println("amountProperty");
        ItemList instance = null;
        StringProperty expResult = null;
        StringProperty result = instance.amountProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dateProperty method, of class ItemList.
     */
    @Test
    public void testDateProperty() {
        System.out.println("dateProperty");
        ItemList instance = null;
        StringProperty expResult = null;
        StringProperty result = instance.dateProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of commentProperty method, of class ItemList.
     */
    @Test
    public void testCommentProperty() {
        System.out.println("commentProperty");
        ItemList instance = null;
        StringProperty expResult = null;
        StringProperty result = instance.commentProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
