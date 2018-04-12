/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.security;

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
public class AuthenticatorTest {
    
    public AuthenticatorTest() {
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
     * Test of validate method, of class Authenticator.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        String user = "";
        String password = "";
        Authenticator instance = new Authenticator();
        boolean expResult = false;
        boolean result = instance.validate(user, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeUser method, of class Authenticator.
     */
    @Test
    public void testRemoveUser() {
        System.out.println("removeUser");
        String user = "";
        Authenticator instance = new Authenticator();
        boolean expResult = false;
        boolean result = instance.removeUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUser method, of class Authenticator.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        String user = "";
        Authenticator instance = new Authenticator();
        boolean expResult = false;
        boolean result = instance.addUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isExist method, of class Authenticator.
     */
    @Test
    public void testIsExist() {
        System.out.println("isExist");
        String user = "";
        Authenticator instance = new Authenticator();
        boolean expResult = false;
        boolean result = instance.isExist(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class Authenticator.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String user = "";
        String pw = "";
        Authenticator instance = new Authenticator();
        instance.setPassword(user, pw);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuizs method, of class Authenticator.
     */
    @Test
    public void testGetQuizs() {
        System.out.println("getQuizs");
        int q = 0;
        Authenticator instance = new Authenticator();
        String expResult = "";
        String result = instance.getQuizs(q);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuiz method, of class Authenticator.
     */
    @Test
    public void testGetQuiz() {
        System.out.println("getQuiz");
        String user = "";
        Authenticator instance = new Authenticator();
        int expResult = 0;
        int result = instance.getQuiz(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQuiz method, of class Authenticator.
     */
    @Test
    public void testSetQuiz() {
        System.out.println("setQuiz");
        String user = "";
        int q = 0;
        Authenticator instance = new Authenticator();
        instance.setQuiz(user, q);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAnswer method, of class Authenticator.
     */
    @Test
    public void testSetAnswer() {
        System.out.println("setAnswer");
        String user = "";
        String a = "";
        Authenticator instance = new Authenticator();
        instance.setAnswer(user, a);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAnswer method, of class Authenticator.
     */
    @Test
    public void testGetAnswer() {
        System.out.println("getAnswer");
        String user = "";
        Authenticator instance = new Authenticator();
        String expResult = "";
        String result = instance.getAnswer(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInstance method, of class Authenticator.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        Authenticator expResult = null;
        Authenticator result = Authenticator.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
