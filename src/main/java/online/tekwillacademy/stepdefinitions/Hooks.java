package online.tekwillacademy.stepdefinitions;

import io.cucumber.java.*;
import online.tekwillacademy.managers.DriverManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hooks {

    private static final Logger logger = LogManager.getLogger(Hooks.class);

    @BeforeAll
    public static void beforeAll(){
        logger.log(Level.INFO,"The execution of the test suite started" );
    }

    @Before
    public void executeBeforeEachTest() {
        System.out.println("Test started");
    }

    @After
    public void executeAfterEachTest(){
        logger.log(Level.INFO,"The test is completed");
        DriverManager.getInstance().quitTheDriver();
    }

    @AfterAll
    public static void afterAll(){
        logger.log(Level.INFO,"The test execution finished ");
    }
}
