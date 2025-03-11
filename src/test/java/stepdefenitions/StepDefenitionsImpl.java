package stepdefenitions;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.webautomation.pageobjects.CartPage;
import com.webautomation.pageobjects.ConfirmationPage;
import com.webautomation.pageobjects.LandingPage;
import com.webautomation.pageobjects.OrderPage;
import com.webautomation.pageobjects.ProductListPage;

import components.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefenitionsImpl extends BaseTest {

    public WebDriver driver;
    // String productName = "ZARA COAT 3";
    // String destination = "Indonesia";

    @Given("Buyer landing to ecommerce")
    public void landingPage() throws IOException {
        //Setup Driver
        // System.setProperty("webdriver.chrome.driver", "/Users/bytedance/CourseQAAutomation/Web Automation/chromedriver");
        // driver = new ChromeDriver();
        // driver.get("https://rahulshettyacademy.com/client");
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver=initializeDriver();
    }

    @Given("^Buyer logged to website email (.+) and password (.+)$")
    public void buyerLogin(String email, String password){
        LandingPage landingPage = new LandingPage(driver);
        landingPage.loginApplication(email, password);
     }

    @When("^Buyer add product (.+) to Cart$")
    public void buyerAddProduct(String productName) throws InterruptedException{  
        ProductListPage productListPage = new ProductListPage(driver);
        productListPage.addToCart(productName);
        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
    }

    @And("^Buyer checkout product (.+)$")
    public void buyerCheckoutProduct(String productName){
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.verifyCheckoutProduct(productName));
        cartPage.goToCheckoutPage();
    }

    @And("^Buyer place order (.+)$")
    public void buyerPlaceOrder(String destination){
        OrderPage orderPage = new OrderPage(driver);
        orderPage.selectCountry(destination);
        orderPage.submitOrder();
    }

    @Then("^Buyer will see message is displayed on confirmation page (.+)$")
    public void confirmationPage(String successCheckout){
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        String confirmationText = confirmationPage.getConfirmationPage();
        Assert.assertEquals(confirmationText, successCheckout);
        driver.close();
    }
}
