import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BurgerMenu {

    WebDriver driver;

    public BurgerMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //WebElement logout
    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerMenu;

    public void clickBurgerMenu(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(burgerMenu));
        burgerMenu.click();
    }

    @FindBy (id = "logout_sidebar_link")
    private  WebElement logoutButton;
    public void clickLogoutButton (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButton.click();
    }

    //Click on Logout
}
