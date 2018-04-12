/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author melanie
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({login.model.ModelSuite.class, login.LoginControllerTest.class, login.MainTest.class, login.ItemDetailControllerTest.class, login.security.SecuritySuite.class, login.PlanDetailControllerTest.class, login.ProfileControllerTest.class})
public class LoginSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
