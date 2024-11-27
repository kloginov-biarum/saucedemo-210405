import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InventoryPage {

    WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "inventory_list")
    private WebElement inventoryList;

    @FindBy(className = "inventory_item")
    private List<WebElement> items;

    public void inventoryListIsDisplayed(){
        assertTrue(inventoryList.isDisplayed());
    }

    public int getItemsAmount(){
        return items.size();
    }

    public boolean allItemsAreDisplayed(){
        boolean displayed = true;
        for (WebElement item : items) {
            if (!item.isDisplayed()){
                displayed = false;
            }
        }
        return displayed;
    }
    @FindBy(className = "inventory_item_name") // поиск 6 элементов
    private List<WebElement> itemsNames ;

    public boolean allItemsNamesAreDisplayed() {
        boolean displayed = true;
        for (WebElement itemName : itemsNames) {  //  item.isDisplayed() == false
            if (!itemName.isDisplayed()) {
                displayed = false;
            }
        }
        return displayed;
    }

    public boolean allItemNamesAreNotEmpty() {
        boolean notEmpty = true;
        for (WebElement itemName : itemsNames) {
            if (itemName.getText().isEmpty()) {
                notEmpty = false;
            }
        }
        return notEmpty;
    }
}
