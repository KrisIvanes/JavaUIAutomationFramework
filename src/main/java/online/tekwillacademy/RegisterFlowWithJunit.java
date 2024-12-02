package online.tekwillacademy;

import online.tekwillacademy.managers.DriverManager;
import online.tekwillacademy.managers.RandomDataManager;
import online.tekwillacademy.pageobjects.HomePage;
import online.tekwillacademy.pageobjects.RegisterPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class RegisterFlowWithJunit {

    private WebDriver driver;
    private HomePage homePage;
    private RegisterPage registerPage;

    @BeforeAll
    public static void beforeAllTheTests(){
        System.out.println("This method is running before all the tests from this class");
    }

    @BeforeEach
    public void beforeEachTest(){
        driver = DriverManager.getInstance().getDriver();
        driver.get("https://tekwillacademy-opencart.online/");
        homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();
        registerPage = new RegisterPage(driver);
    }

    @Test
    @DisplayName("User is redirected to the Account page when registering with valid data")
    public void registerFlowWithValidDataRedirectsTheUserToAccountPage() throws InterruptedException {


        RegisterPage registerPage = new RegisterPage(driver);

        // Generate Random Data
        String firstName = RandomDataManager.getRandomFirstName();
        String lastName = RandomDataManager.getRandomLastName();
        String email = RandomDataManager.getRandomEmail();
        String password = RandomDataManager.getRandomPassword();

        // Actions on the Register Page
        registerPage.completeTheRegisterForm(firstName, lastName, email, password);
        registerPage.enableTheToggleBar();
        registerPage.clickOnTheContinueBtn();

        boolean urlContainSuccessKeyWord = driver.getCurrentUrl().contains("success");
        Assertions.assertTrue(urlContainSuccessKeyWord, "The URL of the page contains the success keyword");
    }

    @Test
    @DisplayName("The user remains on the Register page when registering without accepting the Terms and Conditions")
    public void userRemainOnRegisterPageWhenRegisteringWithoutAcceptingPrivacyRules() throws InterruptedException {


        // Generate Random Data
        String firstName = RandomDataManager.getRandomFirstName();
        String lastName = RandomDataManager.getRandomLastName();
        String email = RandomDataManager.getRandomEmail();
        String password = RandomDataManager.getRandomPassword();

        // Actions on the Register Page
        registerPage.completeTheRegisterForm(firstName, lastName, email, password);
        registerPage.clickOnTheContinueBtn();

        Assertions.assertFalse(driver.getCurrentUrl().contains("register"), "The page URL has the keyword register");
    }

    @Test
    @DisplayName("Navigate to the Login page from the Register page")
    public void navigateToLoginPageFromRegister(){
        registerPage.navigateToLoginPage();
        Assertions.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @AfterEach
    public void afterEachTest(){
        DriverManager.getInstance().quitTheDriver();
    }

    @AfterAll
    public static void afterAllTheTests(){
        System.out.println("This method is executed after all the tests");
    }


}
