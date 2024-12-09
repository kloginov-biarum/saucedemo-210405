import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InventoryTest extends BaseTest{

    @Test
    public void itemsTest(){
        //1. Login with valid data
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("standard_user", "secret_sauce");
        //2. Check that amount of items is 6
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertEquals(6,inventoryPage.getItemsAmount());
        //Check that all items are displayed
       // inventoryPage.allItemsAreDisplayed();
        assertTrue(inventoryPage.allItemsAreDisplayed());
        //check that all items names are displayed
        assertTrue(inventoryPage.allItemsNamesAreDisplayed());
        //check that all item names are not empty
        assertTrue(inventoryPage.allItemNamesAreNotEmpty());
        //Check that all items names start with "Sauce Labs"
        assertTrue(inventoryPage.allItemNamesContainsSauseLabs());
    }


}
