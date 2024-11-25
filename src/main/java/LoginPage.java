import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    private WebElement usernameInputField;

    @FindBy(id = "password")
    private WebElement passwordInputField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(tagName = "h3")
    private WebElement errorMessageText;




    public void enterUserName(String usernameValue){
        usernameInputField.sendKeys(usernameValue);
    }

    public void enterPassword(String passwordValue){
        passwordInputField.sendKeys(passwordValue);
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }

    public void errorMessageContainsText(String expectedText){
        assertTrue(errorMessageText.getText().contains(expectedText));
    }



}
