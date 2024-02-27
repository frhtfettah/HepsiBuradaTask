package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import pages.HomePage;
import pages.LoginPage;
import pages.ShoppingCartPage;
import pages.ShoppingPage;
import util.Driver;

public class PetShopTest {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    ShoppingPage shoppingPage = new ShoppingPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @Before
    public void setUp() {
        Driver.setUp();
    }

    @After
    public void tearDown(){
        shoppingCartPage.emptyCart();
        Driver.tearDown();
    }

    @Given("User is on the HepsiBurada main page")
    public void moveToTheLoginPage(){
        homePage.openLoginPage("https://www.hepsiburada.com/kampanyalar/yurt-disindan-urunler?wt_int=hytop.yurtdisi.kampanya");
    }

    @Given("User is logged in to the system")
    public void userLogin(){
        loginPage.loginAction();
    }

    @When("User clicks Pet Shop from the category menu on the left side")
    public void clickPetShop(){
        shoppingPage.clickPetShop();
    }
    @When("User selects a product from Pet Shop page and adds it to the cart")
    public void addProductToCart(){
        shoppingPage.selectAndAddProduct();
    }
    @When("User navigates to the Shopping Cart page and checks the page")
    public void moveToCart(){
        shoppingPage.goToCart();
    }
    @Then("Shopping Cart page should be displayed without any problems")
    public void checkCartPage(){
        String pageTitle = shoppingCartPage.getCartPageTitle();
        Assert.assertEquals("Sepetim",pageTitle);
    }

    @Then("Product should be added to the cart without any problems")
    public void checkProduct(){
        String productName = shoppingCartPage.checkProductName();
        Assert.assertEquals("Better Life Evcil Hayvanlar Için Pet Sırt Çantası - Gri (Yurt Dışından)", productName);
    }

    @Then("Other necessary buttons and fields that user checked are displayed correctly")
    public void checkCartPageElements(){
        String basketItemCount = shoppingCartPage.checkBasketItemCount();
        String quantity = shoppingCartPage.checkQuantity();
        String productVariant = shoppingCartPage.checkProductVariant();
        Assert.assertEquals("1", basketItemCount);
        Assert.assertEquals("1", quantity);
        Assert.assertEquals("Siyah", productVariant);
    }
}
