package online.tekwillacademy.pageobjects;

import online.tekwillacademy.managers.ExplicitWaitManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {
    public LoginPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(css = "#input-email")
    private WebElement emailInput;

    @FindBy(css = "#input-password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement loginBtn;

    public void completeLoginForm(String email, String password) {
        emailInput.sendKeys(email);
        ExplicitWaitManager.waitTillElementIsVisible(emailInput);
        passwordInput.sendKeys(password);
        ExplicitWaitManager.waitTillElementIsVisible(passwordInput);

    }

    public void clickTheLoginBtn() {
        loginBtn.click();
    }
}
