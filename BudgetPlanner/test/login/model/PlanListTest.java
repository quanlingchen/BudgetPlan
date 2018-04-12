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
public class PlanListTest {
    
    public PlanListTest() {
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
     * Test of idProperty method, of class PlanList.
     */
    @Test
    public void testIdProperty() {
        System.out.println("idProperty");
        PlanList instance = null;
        StringProperty expResult = null;
        StringProperty result = instance.idProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nameProperty method, of class PlanList.
     */
    @Test
    public void testNameProperty() {
        System.out.println("nameProperty");
        PlanList instance = null;
        StringProperty expResult = null;
        StringProperty result = instance.nameProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of typeProperty method, of class PlanList.
     */
    @Test
    public void testTypeProperty() {
        System.out.println("typeProperty");
        PlanList instance = null;
        StringProperty expResult = null;
        StringProperty result = instance.typeProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of commentProperty method, of class PlanList.
     */
    @Test
    public void testCommentProperty() {
        System.out.println("commentProperty");
        PlanList instance = null;
        StringProperty expResult = null;
        StringProperty result = instance.commentProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
