package online.tekwillacademy;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import online.tekwillacademy.managers.DriverManager;
import online.tekwillacademy.managers.RandomDataManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
                 //DriverManager.getInstance().getDriver().get("https://www.google.com/");
            //DriverManager.getInstance().getDriver().quit();
        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://www.google.com/");
        System.out.println("The driver is on page:" + driver.getCurrentUrl());
        String theNameOfTheFirstTab = driver.getWindowHandle();

        // Open new window and navigate to the DIEZ page
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://tekwillacademy-opencart.online/");
        System.out.println("The driver is on page:" + driver.getCurrentUrl());

        WebElement myAccountDropDownIcon = driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));
        myAccountDropDownIcon.click();

        WebElement registerLink = driver.findElement(By.xpath("//a[@class='dropdown-item'][normalize-space()='Register']"));
        registerLink.click();

        // Print the URL of the new page
        System.out.println("The driver is on page:" + driver.getCurrentUrl());

        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        firstNameInput.sendKeys(RandomDataManager.getRandomFirstName());

        WebElement lastNameInput = driver.findElement(By.id("input-lastname"));
        lastNameInput.sendKeys(RandomDataManager.getRandomLastName());

        WebElement emailInput = driver.findElement(By.id("input-email"));
        String emailData = RandomDataManager.getRandomEmail();
        System.out.println("Email: " + emailData);
        emailInput.sendKeys(emailData);

        WebElement passwordInput = driver.findElement(By.id("input-password"));
        String passwordData = RandomDataManager.getRandomPassword(3, 25, true, true);
        System.out.println("Password: "+passwordData);
        passwordInput.sendKeys(passwordData);

        WebElement privacyToggleBar = driver.findElement(By.name("agree"));
        privacyToggleBar.click();

        WebElement continueButton = driver.findElement(By.cssSelector("button[type='submit']"));
        continueButton.click();
        System.out.println("The driver is on page:" + driver.getCurrentUrl());

        Thread.sleep(2000);

        // Close the current tab
        driver.close();

        driver.switchTo().window(theNameOfTheFirstTab);
        driver.quit();

        DriverManager.getInstance().getDriver().quit();


    }
}