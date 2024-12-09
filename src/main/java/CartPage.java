import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "[class='inventory_item_price']")
    private WebElement inventoryItemPriceBackpackCost;
    public String saveInventoryItemPriceBackpackCost(){
        return inventoryItemPriceBackpackCost.getText();
    }

    @FindBy(className = "inventory_item_price")
    private List<WebElement> itemsPrices;

    List<String> itemsPricesStringList = new ArrayList<>();

    public List<String> getItemsPrices(){
        for (WebElement itemPrice : itemsPrices) {
            itemsPricesStringList.add(itemPrice.getText());
        }
        return itemsPricesStringList;
    }
}
