import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest{

    @Test
    public void successLoginValidDataWithoutPO() throws InterruptedException {
        WebElement userNameInputField = driver.findElement(By.id("user-name"));
        userNameInputField.sendKeys("standard_user");
        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @Test
    public void successLoginValidData() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.inventoryListIsDisplayed();
    }


    @Test
    public void invalidPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("sdysadhsauasi");
        loginPage.clickOnLoginButton();
        loginPage.errorMessageContainsText("Username and password do not match any user in this service");
    }


    @Test
    public void invalidUserName(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserName("asdasfas");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        loginPage.errorMessageContainsText("Username and password do not match any user in this service");
    }

    @Test
    public void emptyUsername()  {
        //1. Empty Username
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.clear();
        //2. Enter "secret_sauce" to the password field
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("secret_sauce");
        //3. Click on the Login button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        //4. Check that error message is displayed
        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
        assertTrue(errorMessage.isDisplayed(), "Error message is not displayed.");
        //5. Check that error message text contains "Username is required"
        assertTrue(errorMessage.getText().contains("Username is required"));
    }


    @Test
    public void emptyPassword(){
        WebElement userNameInputField = driver.findElement(By.id("user-name"));
        userNameInputField.sendKeys("standard_user");
        WebElement buttonLogin = driver.findElement(By.id("login-button"));
        buttonLogin.click();
    //4. Check that error message is displayed
        WebElement errorText = driver.findElement(By.cssSelector("[data-test='error']"));
        assertTrue(errorText.isDisplayed());
    //5. Check that error message text contains "Username is required"
        assertTrue(errorText.getText().contains("Password is required"));
    }

    @Test
    public void emptyCreds(){
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement errorMessage = driver.findElement(By.tagName("h3"));
        assertTrue(errorMessage.getText().contains("Username is required"));
    }

    @Test
    public void allElementsAreDisplayed(){
        //1. Open Login page
        //2. Verify that "Swag Labs" logo is displayed
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logoIsDisplayed();
        //3. Check that login credentials section is displayed
        loginPage.loginSectionIsDisplayed();
        //4. CHeck that password section is displayed
        assertTrue(loginPage.passwordSectionIsDisplayed());
    }

    @Test
    public void logout(){
        //1. Login with valid credentials
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("standard_user", "secret_sauce");
        //2. Click on the burger menu button
        BurgerMenu burgerMenu  = new BurgerMenu(driver);
        burgerMenu.clickBurgerMenu();
        //3. Click on the Logout button
        burgerMenu.clickLogoutButton();
        //4. Check that the user is redirected to the Login page
        assertEquals("https://www.saucedemo.com/", driver.getCurrentUrl());
    }
}
