import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTest extends BaseTest{

    @Test
    public void backpackCostTest1(){
        //1. Login with valid data
        //2. Remember the cost of the item "Backpack"
        //3. Add item "Backpack" to the cart
        //4. Click on the cart button
        //5. Check that the cost of the item in the cart equals to the cost of the item on the Inventory page
    }
    @Test
    public void backpackCostTest() {
        //1. Login with valid data
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("standard_user", "secret_sauce");
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());

        //2. Remember the cost of the item "Backpack"

        InventoryPage inventoryPage = new InventoryPage(driver);
        String priceItemBackpackCost = inventoryPage.getBackpackPrice();//Remember the cost of the item "Backpack"
        System.out.println(priceItemBackpackCost);

        //3. Add item "Backpack" to the cart

        inventoryPage.clickButtonAddToCartBackpack();
        //4. Click on the cart button
        inventoryPage.clickCartIcon();
        assertEquals("https://www.saucedemo.com/cart.html", driver.getCurrentUrl());

        //5. Check that the cost of the item in the cart equals to the cost of the item on the Inventory page
        CartPage cartPage = new CartPage(driver);
        String priceInventoryItemBackpackCost = cartPage.saveInventoryItemPriceBackpackCost();
        System.out.println(priceInventoryItemBackpackCost);
        assertEquals(priceItemBackpackCost, priceInventoryItemBackpackCost);
    }

    @Test
    public void allItemsCostAreCorrect(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("standard_user", "secret_sauce");
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
        InventoryPage inventoryPage = new InventoryPage(driver);
        List<String> itemsCostFromInventory = new ArrayList<>();
        itemsCostFromInventory.add(inventoryPage.getBackpackPrice());
        itemsCostFromInventory.add(inventoryPage.getBikeLightPrice());
        itemsCostFromInventory.add(inventoryPage.getTShirtPrice());
        for (String itemCost : itemsCostFromInventory) {
            System.out.println(itemCost);
        }
        inventoryPage.clickButtonAddToCartBackpack();
        inventoryPage.clickButtonAddToCartBikeLight();
        inventoryPage.clickButtonAddToCartTShirt();
        inventoryPage.clickCartIcon();
        CartPage cartPage = new CartPage(driver);
        List<String> itemsCostFromCart = cartPage.getItemsPrices();
        assertEquals(itemsCostFromInventory, itemsCostFromCart);
    }

}
