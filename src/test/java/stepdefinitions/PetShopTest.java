package stepdefinitions;

import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.ShoppingCartPage;
import pages.ShoppingPage;

public class PetShopTest {

    @Given("User is on the HepsiBurada main page via {string}")
    public void moveToTheLoginPage(String arg0) {
        Base.setUp(arg0);
        HomePage homePage = new HomePage();
        homePage.setBrowser(arg0);
        homePage.openLoginPage("https://www.hepsiburada.com/kampanyalar/yurt-disindan-urunler?wt_int=hytop.yurtdisi.kampanya");
    }

    @Given("User is logged in to the system")
    public void userLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginAction();
    }

    @When("User clicks Pet Shop from the category menu on the left side")
    public void clickPetShop() {
        ShoppingPage shoppingPage = new ShoppingPage();
        shoppingPage.clickPetShop();
    }

    @When("User selects a product from Pet Shop page and adds it to the cart")
    public void addProductToCart() {
        ShoppingPage shoppingPage = new ShoppingPage();
        shoppingPage.selectAndAddProduct();
    }

    @When("User navigates to the Shopping Cart page and checks the page")
    public void moveToCart() {
        ShoppingPage shoppingPage = new ShoppingPage();
        shoppingPage.goToCart();
    }

    @Then("Shopping Cart page should be displayed without any problems")
    public void checkCartPage() {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        String pageTitle = shoppingCartPage.getCartPageTitle();
        Assert.assertEquals("Sepetim", pageTitle);
    }

    @Then("Product should be added to the cart without any problems")
    public void checkProduct() {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        String productName = shoppingCartPage.checkProductName();
        Assert.assertEquals("Better Life Evcil Hayvanlar Için Pet Sırt Çantası - Gri (Yurt Dışından)", productName);
    }

    @Then("Other necessary buttons and fields that user checked are displayed correctly")
    public void checkCartPageElements() {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        String basketItemCount = shoppingCartPage.checkBasketItemCount();
        String quantity = shoppingCartPage.checkQuantity();
        String productVariant = shoppingCartPage.checkProductVariant();
        Assert.assertEquals("1", basketItemCount);
        Assert.assertEquals("1", quantity);
        Assert.assertEquals("Siyah", productVariant);
        shoppingCartPage.emptyCart();
    }

    @After
    public static void tearDown() {
        Base.tearDown();
    }
}
