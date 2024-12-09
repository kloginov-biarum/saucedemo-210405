import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckoutTest extends BaseTest{


    @Test
    public void successCheckout(){
        //1. Login with valid data (LoginPage)
        //2. Add item "Backpack" to the cart (InventoryPage)
        //3. Click on the cart button (InventoryPage)
        //4. Click on the checkout button (CartPage)
        //5. Enter first name (CheckoutStepOnePage)
        //6. Enter last name (CheckoutStepOnePage)
        //7. Enter zip code   (CheckoutStepOnePage)
        //8. Click on the continue button  (CheckoutStepOne)
        //9. Click on the finish button(CheckoutStepTwo)
        //10. Check that the message "THANK YOU FOR YOUR ORDER" is displayed (CheckoutCompletePage)
    }
}
