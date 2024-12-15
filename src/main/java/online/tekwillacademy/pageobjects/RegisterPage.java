package online.tekwillacademy.pageobjects;

import online.tekwillacademy.managers.ScrollManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Page {
    private static final Logger logger = LogManager. getLogger(RegisterPage.class);
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-firstname")
    private WebElement firstNameInput;

    @FindBy(id = "input-lastname")
    private WebElement lastNameInput;

    @FindBy(id = "input-email")
    private WebElement emailInput;

    @FindBy(css = "#input-password")
    private WebElement passwordInput;

    @FindBy(name = "agree")
    private WebElement privacyToggleBar;

    @FindBy(css = "button[type='submit']")
    private WebElement continueBtn;

    public void completeTheRegisterForm(String firstName, String lastName, String email, String password) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        logger.log(Level.INFO, "The form was completed for: " + email + " and password: " + password);
    }

    public void enableTheToggleBar() {
        ScrollManager.scrollToElement(privacyToggleBar);
        privacyToggleBar.click();
    }

    public void clickOnTheContinueBtn() {
        continueBtn.click();
    }

}
